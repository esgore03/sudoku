package org.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuGame {
    private BoardNum[][] sudokuBoard = new BoardNum[9][9];
    public void setSudokuBoard(BoardNum[][] sudokuBoard){
        this.sudokuBoard = sudokuBoard;
    }

    public boolean checkBoard(){
        if(!checkTextFieldInputs() || !checkBoardNums()){
            return false;
        }

        return true;
    }

    public boolean checkTextFieldInputs(){
        List<String> validInputs = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if ((!validInputs.contains(sudokuBoard[row][column].getTextField().getText()))){
                    return false;
                }
                if (sudokuBoard[row][column].getTextField().getText().length() > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBoardNums(){
        boolean validBoardNums = true;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(!checkRow(sudokuBoard[row][column])){
                    return false;
                }
                if(!checkColumn(sudokuBoard[row][column])){
                    return false;
                }
                if(!checkSquare(sudokuBoard[row][column])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(BoardNum boardNum){
        int row = boardNum.getRow();
        for (int column = 0; column < 9; column++){
            if (boardNum.getTextField().getText().equals(sudokuBoard[row][column].getTextField().getText())){
                return false;
            }
        }
        return true;
    }
    public boolean checkColumn(BoardNum boardNum){
        int column = boardNum.getColumn();
        for (int row = 0; row < 9; row++){
            if (boardNum.getTextField().getText().equals(sudokuBoard[row][column].getTextField().getText())){
                return false;
            }
        }
        return true;
    }

    public boolean checkSquare(BoardNum boardNum){
        int startingRowSquare = boardNum.getRow() - boardNum.getRow() % 3;
        int startingColumnSquare = boardNum.getColumn() - boardNum.getColumn() % 3;

        for (int row = startingRowSquare; row < startingRowSquare + 3; row++) {
            for (int Column = startingColumnSquare; Column < startingColumnSquare + 3; Column++) {
                if (sudokuBoard[row][Column].getTextField().getText().equals(boardNum.getTextField().getText())) {
                    return false;
                }
            }
        }
        return true;
    }
}