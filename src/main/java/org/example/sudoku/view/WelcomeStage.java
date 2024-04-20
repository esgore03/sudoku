package org.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeStage extends Stage {

    public WelcomeStage () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/org/example/sudoku/welcome-view.fxml"));
        Parent root = loader.load();
        setTitle("Sudoku");
        Scene scene = new Scene(root);
        getIcons().add(
                new Image(
                String.valueOf(getClass().getResource("/org/example/sudoku/images/favicon.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }

    public static WelcomeStage getInstance() throws IOException{
        return WelcomeStageHolder.INSTANCE = new WelcomeStage();
    }

    private static class WelcomeStageHolder {
        private static WelcomeStage INSTANCE;
    }
}
