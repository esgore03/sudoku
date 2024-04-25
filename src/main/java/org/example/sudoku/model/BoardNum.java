/**
 * @author Jose Martínez - Jhorman Gómez - Esteban Gómez
 * @version 1.0
 */
package org.example.sudoku.model;

// Import necessary classes

import javafx.scene.control.TextField;

/**
 * Class representing a cell in the Sudoku board.
 */
public class BoardNum {
    private int row;
    private int column;
    private TextField textField;

    /**
     * Constructor to create a BoardNum object.
     *
     * @param textField The TextField associated with the cell.
     * @param row       The row index of the cell.
     * @param column    The column index of the cell.
     */
    public BoardNum(TextField textField, int row, int column) {
        this.textField = textField;
        this.row = row;
        this.column = column;
    }

    /**
     * Get the TextField associated with the cell.
     *
     * @return The TextField associated with the cell.
     */
    public TextField getTextField() {
        return textField;
    }

    /**
     * Get the row index of the cell.
     *
     * @return The row index of the cell.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column index of the cell.
     *
     * @return The column index of the cell.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Set the TextField associated with the cell.
     *
     * @param textField The TextField to set.
     */
    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    /**
     * Set the row index of the cell.
     *
     * @param "row" The row index to set.
     */
    public void setRow(int xPosition) {
        this.row = xPosition;
    }

    /**
     * Set the column index of the cell.
     *
     * @param "column" The column index to set.
     */
    public void setColumn(int yPosition) {
        this.column = yPosition;
    }
}