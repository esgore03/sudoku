/**
 * @author Jose Martínez - Jhorman Gómez - Esteban Gómez
 * @version 1.0
 */
package org.example.sudoku.view;

// Import necessary classes

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class representing the stage displayed when the player wins the Sudoku game.
 */
public class WinStage extends Stage {

    /**
     * Constructor to create a new WinStage.
     *
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public WinStage () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/win-view.fxml"));
        Parent root = loader.load();
        setTitle("Sudoku");
        Scene scene = new Scene(root);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/sudoku/images/favicon.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }

    /**
     * Holder class for lazy initialization of the singleton instance.
     */
    private static class WinStageHolder {
        private static WinStage INSTANCE;
    }

    /**
     * Get the singleton instance of WinStage.
     *
     * @return The singleton instance of WinStage.
     * @throws IOException If an error occurs while creating the instance.
     */
    public static WinStage getInstance() throws IOException{
        return WinStageHolder.INSTANCE = new WinStage();
    }

}

