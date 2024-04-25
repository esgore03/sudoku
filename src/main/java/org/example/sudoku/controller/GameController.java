package org.example.sudoku.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
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
    }

    @FXML
    void onResolveButtonClick(ActionEvent actionEvent) throws IOException{
    }
}


