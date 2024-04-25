package org.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SudokuGame {
    private BoardNum[][] sudokuBoard = new BoardNum[9][9];
    private String[][] boardAux = {
            {"5", "3", "4", "6", "7", "8", "9", "1", "2"},
            {"6", "7", "2", "1", "9", "5", "3", "4", "8"},
            {"1", "9", "8", "3", "4", "2", "5", "6", "7"},
            {"8", "5", "9", "7", "6", "1", "4", "2", "3"},
            {"4", "2", "6", "8", "5", "3", "7", "9", "1"},
            {"7", "1", "3", "9", "2", "4", "8", "5", "6"},
            {"9", "6", "1", "5", "3", "7", "2", "8", "4"},
            {"2", "8", "7", "4", "1", "9", "6", "3", "5"},
            {"3", "4", "5", "2", "8", "6", "1", "7", "9"}
    };
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
        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column ++){
                TextField textField = sudokuBoard[row][column].getTextField();
                if (textField.getText().isEmpty()){
                    textField.setText(boardAux[row][column]);
                }
            }
        }
    }

    public void generateInitialNumbers() {
        // Cuadrante superior izquierdo
        sudokuBoard[0][0].getTextField().setText("5");
        sudokuBoard[0][0].getTextField().setEditable(false);

        sudokuBoard[0][1].getTextField().setText("3");
        sudokuBoard[0][1].getTextField().setEditable(false);

        sudokuBoard[2][0].getTextField().setText("1");
        sudokuBoard[2][0].getTextField().setEditable(false);

        sudokuBoard[2][2].getTextField().setText("8");
        sudokuBoard[2][2].getTextField().setEditable(false);

        // Cuadrante superior central
        sudokuBoard[0][3].getTextField().setText("6");
        sudokuBoard[0][3].getTextField().setEditable(false);

        sudokuBoard[1][5].getTextField().setText("5");
        sudokuBoard[1][5].getTextField().setEditable(false);

        sudokuBoard[2][3].getTextField().setText("3");
        sudokuBoard[2][3].getTextField().setEditable(false);

        sudokuBoard[1][4].getTextField().setText("9");
        sudokuBoard[1][4].getTextField().setEditable(false);

        // Cuadrante superior derecho
        sudokuBoard[0][6].getTextField().setText("9");
        sudokuBoard[0][6].getTextField().setEditable(false);

        sudokuBoard[0][7].getTextField().setText("1");
        sudokuBoard[0][7].getTextField().setEditable(false);

        sudokuBoard[1][6].getTextField().setText("3");
        sudokuBoard[1][6].getTextField().setEditable(false);

        sudokuBoard[2][7].getTextField().setText("6");
        sudokuBoard[2][7].getTextField().setEditable(false);

        // Cuadrante central izquierdo
        sudokuBoard[3][0].getTextField().setText("8");
        sudokuBoard[3][0].getTextField().setEditable(false);

        sudokuBoard[3][1].getTextField().setText("5");
        sudokuBoard[3][1].getTextField().setEditable(false);

        sudokuBoard[5][0].getTextField().setText("7");
        sudokuBoard[5][0].getTextField().setEditable(false);

        sudokuBoard[4][1].getTextField().setText("2");
        sudokuBoard[4][1].getTextField().setEditable(false);


        // Cuadrante central
        sudokuBoard[3][3].getTextField().setText("7");
        sudokuBoard[3][3].getTextField().setEditable(false);

        sudokuBoard[3][4].getTextField().setText("6");
        sudokuBoard[3][4].getTextField().setEditable(false);

        sudokuBoard[4][3].getTextField().setText("8");
        sudokuBoard[4][3].getTextField().setEditable(false);

        sudokuBoard[4][4].getTextField().setText("5");
        sudokuBoard[4][4].getTextField().setEditable(false);


        // Cuadrante central derecho
        sudokuBoard[3][6].getTextField().setText("4");
        sudokuBoard[3][6].getTextField().setEditable(false);

        sudokuBoard[3][8].getTextField().setText("3");
        sudokuBoard[3][8].getTextField().setEditable(false);

        sudokuBoard[4][6].getTextField().setText("7");
        sudokuBoard[4][6].getTextField().setEditable(false);

        sudokuBoard[4][7].getTextField().setText("9");
        sudokuBoard[4][7].getTextField().setEditable(false);


        // Cuadrante inferior izquierdo
        sudokuBoard[6][0].getTextField().setText("9");
        sudokuBoard[6][0].getTextField().setEditable(false);

        sudokuBoard[6][1].getTextField().setText("6");
        sudokuBoard[6][1].getTextField().setEditable(false);

        sudokuBoard[8][0].getTextField().setText("3");
        sudokuBoard[8][0].getTextField().setEditable(false);

        sudokuBoard[7][1].getTextField().setText("8");
        sudokuBoard[7][1].getTextField().setEditable(false);


        // Cuadrante inferior central
        sudokuBoard[8][5].getTextField().setText("6");
        sudokuBoard[8][5].getTextField().setEditable(false);

        sudokuBoard[6][4].getTextField().setText("3");
        sudokuBoard[6][4].getTextField().setEditable(false);

        sudokuBoard[7][3].getTextField().setText("4");
        sudokuBoard[7][3].getTextField().setEditable(false);

        sudokuBoard[7][4].getTextField().setText("1");
        sudokuBoard[7][4].getTextField().setEditable(false);


        // Cuadrante inferior derecho
        sudokuBoard[6][6].getTextField().setText("2");
        sudokuBoard[6][6].getTextField().setEditable(false);

        sudokuBoard[8][7].getTextField().setText("7");
        sudokuBoard[8][7].getTextField().setEditable(false);

        sudokuBoard[7][6].getTextField().setText("6");
        sudokuBoard[7][6].getTextField().setEditable(false);

        sudokuBoard[7][7].getTextField().setText("3");
        sudokuBoard[7][7].getTextField().setEditable(false);

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
