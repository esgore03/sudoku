
package org.example.sudoku.controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.sudoku.model.Player;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;


public class GameController{
    private Player player;
    @FXML
    private GridPane gridPane;

    public void initialize() {
        int size = 9;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                TextField textField = new TextField();
                gridPane.add(textField, col, row);
            }
        }
    }
    public void setPlayer(Player player) {this.player = player;}
}



