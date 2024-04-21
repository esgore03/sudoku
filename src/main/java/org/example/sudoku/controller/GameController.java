package org.example.sudoku.controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.sudoku.model.BoardNum;
import org.example.sudoku.model.SudokuGame;

public class GameController{
    @FXML
    private GridPane gridPane;
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
                textField.setText("");
                gridPane.add(textField, column, row);
                BoardNum boardNum = new BoardNum(textField, row, column);
                sudokuBoard[row][column] = boardNum;
            }
        }
    }

}



