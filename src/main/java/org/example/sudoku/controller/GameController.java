package org.example.sudoku.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
                textField.setMinSize(25,25);
                textField.setMaxSize(25,25);
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
        if (result){
            if(sudokuGame.getErrors().isEmpty()){
                resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: green;");
                resultLabel.setText("¡Felicidades, tu respuesta es correcta!");
            }
            else{
                resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");
                String message = "Has fallado debido a los siguientes errores:";
                for (int error : sudokuGame.getErrors()){
                    if (error == 1){
                        message += "    \ninputs inválidos.";
                    }
                    if (error == 2){
                        message += "    \nceldas en blanco.";
                    }
                    if (error == 3){
                        message += "    \nnúmeros incorrectos.";
                    }
                }
                resultLabel.setText((message));
            }
        }
    }

    @FXML
    void onResolveButtonClick(ActionEvent actionEvent) throws IOException{
        sudokuGame.resolve();
    }
}


