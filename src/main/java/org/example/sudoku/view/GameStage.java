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
import org.example.sudoku.controller.GameController;

import java.io.IOException;

/**
 * Class representing the main stage of the Sudoku game.
 */
public class GameStage extends Stage {
    private GameController gameController;

    /**
     * Constructor to create a new GameStage.
     *
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/game-view.fxml"));
        Parent root = loader.load();
        gameController = loader.getController();
        setTitle("Ventana Sudoku");
        Scene scene = new Scene(root, 600, 600);
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/org/example/sudoku/images/favicon.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }

    /**
     * Get the GameController associated with this GameStage.
     *
     * @return The GameController associated with this GameStage.
     */
    public GameController getGameController(){
        return gameController;
    }

    /**
     * Get the singleton instance of GameStage.
     *
     * @return The singleton instance of GameStage.
     * @throws IOException If an error occurs while creating the instance.
     */
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE = new GameStage();
    }

    /**
     * Holder class for lazy initialization of the singleton instance.
     */
    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
}