
package org.example.sudoku.controller;
import javafx.fxml.FXML;
import org.example.sudoku.model.Player;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Border;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private Player player;
    @FXML
    private GridPane gridPane;

    @FXML
    private GridPane sudokuGridPane;

    private final int SIZE = 9;
    private final int BOX_SIZE = 3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createSudokuBoard();
        addBordersToBoxes();
    }

    private void addBordersToBoxes() {
        for (int i = 0; i < SIZE; i += BOX_SIZE) {
            for (int j = 0; j < SIZE; j += BOX_SIZE) {
                addBorderToBox(i, j);
            }
        }
    }

    private void addBorderToBox(int startRow, int startCol) {
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        for (int row = startRow; row < startRow + BOX_SIZE; row++) {
            for (int col = startCol; col < startCol + BOX_SIZE; col++) {
                Rectangle cell = new Rectangle(50, 50);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
                Pane pane = new Pane(cell);
                borderPane.setCenter(pane);
            }
        }

        gridPane.add(borderPane, startCol, startRow);
    }

    private void createSudokuBoard() {
        double cellSize = 50;
        double boxSize = cellSize * BOX_SIZE; // Tamaño del grupo 3x3

        for (int row = 0; row < SIZE; row += BOX_SIZE) {
            for (int col = 0; col < SIZE; col += BOX_SIZE) {
                GridPane boxPane = new GridPane();
                boxPane.setPadding(new Insets(2)); // Espaciado entre los rectángulos en el grupo

                for (int i = 0; i < BOX_SIZE; i++) {
                    for (int j = 0; j < BOX_SIZE; j++) {
                        Rectangle cell = new Rectangle(cellSize, cellSize);
                        cell.setFill(Color.WHITE);
                        cell.setStroke(Color.BLACK);
                        boxPane.add(cell, j, i);
                    }
                }

                sudokuGridPane.add(boxPane, col, row);
            }
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}



