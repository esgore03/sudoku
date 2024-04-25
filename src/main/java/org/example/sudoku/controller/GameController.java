package org.example.sudoku.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
    BoardNum[][] sudokuBoard = new BoardNum[9][9];
    public void initialize() {
        createSudokuBoard();
        sudokuGame.setSudokuBoard(sudokuBoard);
    }

    private void createSudokuBoard() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TextField textField = new TextField();
                textField.setMinWidth(25);
                textField.setMinHeight(25);
                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                rectangle.setWidth(50);
                rectangle.setHeight(50);
                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(rectangle, textField);
                textField.setText("");
                board.add(stackPane, column, row);
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



