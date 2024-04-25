/**
 * @author Jose Martínez - Jhorman Gómez - Esteban Gómez
 * @version 1.0
 */
package org.example.sudoku;

// Import necessary classes
import javafx.application.Application;
import javafx.stage.Stage;
import org.example.sudoku.view.GameStage;

import java.io.IOException;

/**
 * Main class to launch the Sudoku game application.
 */
public class Main extends Application  {

    /**
     * Main method to start the application.
     **/
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method to initialize the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     * @throws IOException If an error occurs during stage initialization.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        GameStage.getInstance();
    }
}

