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
 * Class representing the stage displayed when the player loses the Sudoku game.
 */
public class LoseStage extends Stage {

    /**
     * Constructor to create a new LoseStage.
     *
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public LoseStage () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/lose-view.fxml"));
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
    private static class LoseStageHolder {
        private static LoseStage INSTANCE;
    }

    /**
     * Get the singleton instance of LoseStage.
     *
     * @return The singleton instance of LoseStage.
     * @throws IOException If an error occurs while creating the instance.
     */
    public static LoseStage getInstance() throws IOException{
        return LoseStageHolder.INSTANCE = new LoseStage();
    }

}

