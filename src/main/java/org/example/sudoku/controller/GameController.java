package org.example.sudoku.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.sudoku.model.BoardNum;
import org.example.sudoku.model.SudokuGame;

import java.io.IOException;

public class GameController{
    @FXML
    private Button verifyButton;
    @FXML
    private Button resolveButton;
    @FXML
    private GridPane board;
    @FXML
    private Label resultLabel;
    private SudokuGame sudokuGame = new SudokuGame();
    private BoardNum[][] sudokuBoard = new BoardNum[9][9];

    @FXML
    public void initialize() {
        createSudokuBoard();
        sudokuGame.setSudokuBoard(sudokuBoard);
        sudokuGame.generateInitialNumbers();
    }

    private void createSudokuBoard() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TextField textField = new TextField();

                textField.setText("");
                textField.setMinSize(30,30);
                textField.setMaxSize(30,30);
                textField.setStyle("-fx-alignment: center;");
                GridPane.setHalignment(textField, HPos.CENTER);
                GridPane.setValignment(textField, VPos.CENTER);

                board.add(textField, column, row);

                BoardNum boardNum = new BoardNum(textField, row, column);
                sudokuBoard[row][column] = boardNum;
            }
        }
    }
    @FXML
    void onVerifyButtonClick(ActionEvent actionEvent) throws IOException{
        boolean result = sudokuGame.checkBoardNums();
        Stage stage = (Stage) resultLabel.getScene().getWindow();
        if(sudokuGame.checkTextFieldInputs()) {
            if (result) {
                resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: green;");
                resultLabel.setText("¡Felicidades, tu respuesta es correcta!");
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++){
                        sudokuBoard[row][column].getTextField().setEditable(false);
                    }
                }
                WinStage winStage = new WinStage();
                winStage.show();
                stage.close();
            } else {
                resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: red;");
                resultLabel.setText("Has cometido errores...");
                 LoseStage loseStage = new LoseStage();
                LoseStage.show();
                stage.close();
            }
        }
        else{
            resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: red;");
            resultLabel.setText("Hay inputs inválidos en tu respuesta.");
        }
    }

    @FXML
    void onResolveButtonClick(ActionEvent actionEvent) throws IOException{
        sudokuGame.resolve();
    }
}
