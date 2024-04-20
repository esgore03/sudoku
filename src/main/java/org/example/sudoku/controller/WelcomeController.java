package org.example.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.sudoku.model.Player;
import org.example.sudoku.view.GameStage;
import java.io.IOException;


public class WelcomeController {
    @FXML
    private TextField nicknameTextField;

    @FXML
    void onHandleButtonPlay(ActionEvent event) throws IOException {
        String nickname = nicknameTextField.getText();

        Player player = new Player(1, nickname);
        GameStage.getInstance().getGameController().setPlayer(player);
        Stage stage = (Stage) nicknameTextField.getScene().getWindow();
        stage.close();

    }

}
