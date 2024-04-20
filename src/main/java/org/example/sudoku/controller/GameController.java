
package org.example.sudoku.controller;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.example.sudoku.model.player.Player;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    private Player player;
    @FXML
    private GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Generate Sudoku board dynamically
        int size = 9; // 9x9 Sudoku board
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Label cell = new Label(); // You can use TextField as well
                cell.getStyleClass().add("sudoku-cell");
                // Add other styling or properties as needed
                gridPane.add(cell, col, row);
            }
        }
    }
}


public void setPlayer(Player player) {this.player = player;}
