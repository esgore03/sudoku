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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;



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
    }

    private void createSudokuBoard() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TextField textField = new TextField();

                textField.setText("");
                textField.setMinSize(30,30);
                textField.setMaxSize(30,30);
                GridPane.setHalignment(textField, HPos.CENTER);
                GridPane.setValignment(textField, VPos.CENTER);

                board.add(textField, column, row);

                BoardNum boardNum = new BoardNum(textField, row, column);
                sudokuBoard[row][column] = boardNum;
            }
        }
    }

    private void openWinStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/win-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("¡Felicidades!");
        stage.show();
    }

    private void openLoseStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/lose-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("¡Has perdido!");
        stage.show();
    }
    @FXML
    void onVerifyButtonClick(ActionEvent actionEvent) throws IOException{
        boolean result = sudokuGame.checkBoardNums();
        if(sudokuGame.checkTextFieldInputs()) {
            if (result) {
                resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: green;");
                resultLabel.setText("¡Felicidades, tu respuesta es correcta!");
                openWinStage();
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++){
                        sudokuBoard[row][column].getTextField().setEditable(false);
                    }
                }
            } else {
                resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");
                resultLabel.setText("Has cometido errores...");
                openLoseStage();
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++) {
                        sudokuBoard[row][column].getTextField().setEditable(false);
                    }
                }
            }
        }
        else{
            resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");
            resultLabel.setText("Hay inputs inválidos en tu respuesta.");
        }
    }

    @FXML
    void onResolveButtonClick(ActionEvent actionEvent) throws IOException{
        //sudokuGame.resolve();
    }
}