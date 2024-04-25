/**
 * @author Jose Martínez - Jhorman Gómez - Esteban Gómez
 * @version 1.0
 */
package org.example.sudoku.model;

// Import necessary classes

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing the Sudoku game logic and matrix.
 */
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

    /**
     * Sets the Sudoku board.
     *
     * @param sudokuBoard The Sudoku board to set.
     */
    public void setSudokuBoard(BoardNum[][] sudokuBoard){
        this.sudokuBoard = sudokuBoard;
    }

    /**
     * Resolves the Sudoku game by filling in all the numbers.
     */
    public void resolve(){
        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column ++){
                sudokuBoard[row][column].getTextField().setText(boardAux[row][column]);
            }
        }
    }

    /**
     * Generates initial numbers for the Sudoku game.
     */
    public void generateInitialNumbers() {
        // Logic to generate initial numbers for the Sudoku game
        Random random = new Random();
        List<String> positions = new ArrayList<>();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(3);
                int column = random.nextInt(3);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(3);
                int column = random.nextInt(3, 6);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(3);
                int column = random.nextInt(6, 9);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(3, 6);
                int column = random.nextInt(3);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(3, 6);
                int column = random.nextInt(3, 6);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(3, 6);
                int column = random.nextInt(6, 9);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(6, 9);
                int column = random.nextInt(3);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(6, 9);
                int column = random.nextInt(3, 6);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
        positions.clear();
        for (int num = 0; num < 4; num++) {
            while (positions.size() < 4) {
                int row = random.nextInt(6, 9);
                int column = random.nextInt(6, 9);
                String position = row + ", " + column;
                if (!positions.contains((position))) {
                    positions.add(position);
                    TextField textField = sudokuBoard[row][column].getTextField();
                    textField.setText(boardAux[row][column]);
                    textField.setEditable(false);
                }
            }
        }
    }

    /**
     * Checks if all text fields in the Sudoku board contain valid inputs.
     *
     * @return True if all text fields contain valid inputs, false otherwise.
     */
    public boolean checkTextFieldInputs(){
        // Logic to check if all text fields contain valid inputs
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (sudokuBoard[row][column].getTextField().getText().isEmpty()){
                    return false;
                }
                if (sudokuBoard[row][column].getTextField().getText().length() > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the Sudoku board numbers are correct according to the rules of Sudoku.
     *
     * @return True if the Sudoku board numbers are correct, false otherwise.
     */
    public boolean checkBoardNums(){
        // Logic to check if the Sudoku board numbers are correct
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(!checkRow(sudokuBoard[row][column]) || !checkColumn(sudokuBoard[row][column]) || !checkSquare(sudokuBoard[row][column])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if a BoardNum object's value is unique within its row.
     *
     * @param boardNum The BoardNum object to check.
     * @return True if the value is unique within its row, false otherwise.
     */
    public boolean checkRow(BoardNum boardNum){
        int row = boardNum.getRow();
        for (int column = 0; column < 9; column++){
            if (sudokuBoard[row][column] != boardNum && boardNum.getTextField().getText().equals(sudokuBoard[row][column].getTextField().getText())){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a BoardNum object's value is unique within its column.
     *
     * @param boardNum The BoardNum object to check.
     * @return True if the value is unique within its column, false otherwise.
     */
    public boolean checkColumn(BoardNum boardNum){
        int column = boardNum.getColumn();
        for (int row = 0; row < 9; row++){
            if (sudokuBoard[row][column] != boardNum && boardNum.getTextField().getText().equals(sudokuBoard[row][column].getTextField().getText())){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a BoardNum object's value is unique within its square.
     *
     * @param boardNum The BoardNum object to check.
     * @return True if the value is unique within its square, false otherwise.
     */
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

    /**
     * Gets the Sudoku board.
     *
     * @return The Sudoku board.
     */
    public BoardNum[][] getSudokuBoard() {
        return sudokuBoard;
    }
}