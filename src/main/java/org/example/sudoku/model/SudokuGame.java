package org.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public void generateInitialNumbers() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int row, column;
            do {
                row = random.nextInt(9); // Genera una fila aleatoria entre 0 y 8
                column = random.nextInt(9); // Genera una columna aleatoria entre 0 y 8
            } while (!sudokuBoard[row][column].getTextField().getText().isEmpty()); // Repite si la celda no está vacía

            int number;
            do {
                number = random.nextInt(9) + 1; // Genera un número aleatorio entre 1 y 9
                sudokuBoard[row][column].getTextField().setText(String.valueOf(number));
            } while (!checkRow(sudokuBoard[row][column]) ||
                    !checkColumn(sudokuBoard[row][column]) ||
                    !checkSquare(sudokuBoard[row][column]));
        }
    }


}