package org.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SudokuGame {
    private BoardNum[][] sudokuBoard = new BoardNum[9][9];
    private List<String> validInputs = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    public void setSudokuBoard(BoardNum[][] sudokuBoard){
        this.sudokuBoard = sudokuBoard;
    }

    public boolean checkBoard(){
        if(!checkTextFieldInputs() || !checkBoardNums()){
            return false;
        }

        return true;
    }

    public void resolve(){
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                for (String input : validInputs){
                    BoardNum boardNum = sudokuBoard[row][column];
                    TextField textField = boardNum.getTextField();
                    if (textField.getText().isEmpty()){
                        textField.setText(input);
                        if (checkRow(boardNum) && checkColumn(boardNum) && checkSquare(boardNum)){
                            break;
                        }
                        else{
                            textField.setText("");
                        }
                    }
                }
            }
        }
    }

    public void generateInitialNumbers() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int row, column;
            do {
                row = random.nextInt(9);
                column = random.nextInt(9);
            } while (!sudokuBoard[row][column].getTextField().getText().isEmpty());

            int number;
            do {
                number = random.nextInt(9) + 1;
                sudokuBoard[row][column].getTextField().setText(String.valueOf(number));
            } while (!checkRow(sudokuBoard[row][column]) ||
                    !checkColumn(sudokuBoard[row][column]) ||
                    !checkSquare(sudokuBoard[row][column]));
            sudokuBoard[row][column].getTextField().setEditable(false);
        }
    }

    public boolean checkTextFieldInputs(){
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
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(!checkRow(sudokuBoard[row][column]) || !checkColumn(sudokuBoard[row][column]) || !checkSquare(sudokuBoard[row][column])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(BoardNum boardNum){
        int row = boardNum.getRow();
        for (int column = 0; column < 9; column++){
            if (sudokuBoard[row][column] != boardNum && boardNum.getTextField().getText().equals(sudokuBoard[row][column].getTextField().getText())){
                return false;
            }
        }
        return true;
    }
    public boolean checkColumn(BoardNum boardNum){
        int column = boardNum.getColumn();
        for (int row = 0; row < 9; row++){
            if (sudokuBoard[row][column] != boardNum && boardNum.getTextField().getText().equals(sudokuBoard[row][column].getTextField().getText())){
                return false;
            }
        }
        return true;
    }

    public boolean checkSquare(BoardNum boardNum){
        int startingRowSquare = boardNum.getRow() - boardNum.getRow() % 3;
        int startingColumnSquare = boardNum.getColumn() - boardNum.getColumn() % 3;

        for (int row = startingRowSquare; row < startingRowSquare + 3; row++) {
            for (int column = startingColumnSquare; column < startingColumnSquare + 3; column++) {
                if (sudokuBoard[row][column] != boardNum && sudokuBoard[row][column].getTextField().getText().equals(boardNum.getTextField().getText())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setValidInputs(List<String> validInputs) {
        this.validInputs = validInputs;
    }

    public BoardNum[][] getSudokuBoard() {
        return sudokuBoard;
    }

    public List<String> getValidInputs() {
        return validInputs;
    }
}