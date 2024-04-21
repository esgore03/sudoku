
package org.example.sudoku.controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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

    }



    public void setPlayer(Player player) {
        this.player = player;
    }
}



