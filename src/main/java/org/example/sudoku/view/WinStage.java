package org.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WinStage extends Stage {

    public WinStage () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/win-view.fxml"));
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

    private static class WinStageHolder {
        private static WinStage INSTANCE;
    }

    public static WinStage getInstance() throws IOException{
        return WinStageHolder.INSTANCE = new WinStage();
    }

}