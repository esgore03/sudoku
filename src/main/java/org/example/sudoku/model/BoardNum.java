package org.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class BoardNum {
    private int row;
    private int column;
    private TextField textField;

    public BoardNum(TextField textField, int row, int column) {
        this.textField = textField;
        this.row = row;
        this.column = column;
    }
    public TextField getTextField() {
        return textField;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void setRow(int xPosition) {
        this.row = xPosition;
    }

    public void setColumn(int yPosition) {
        this.column = yPosition;
    }
}