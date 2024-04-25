package org.example.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.sudoku.model.BoardNum;
import org.example.sudoku.model.SudokuGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    // FXML elements
    @FXML
    private Button verifyButton;
    @FXML
    private Button resolveButton;
    @FXML
    private GridPane board;
    @FXML
    private Label resultLabel;

    // Sudoku game instance and board representation
    private SudokuGame sudokuGame = new SudokuGame();
    private BoardNum[][] sudokuBoard = new BoardNum[9][9];

    // Initialization method called after FXML elements are loaded
    @FXML
    public void initialize() {
        createSudokuBoard(); // Create Sudoku board
        sudokuGame.setSudokuBoard(sudokuBoard); // Set the Sudoku board for the game
    }

    // Method to create the Sudoku board
    private void createSudokuBoard() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TextField textField = new TextField(); // Create a text field for each cell

                textField.setText(""); // Set default text
                textField.setMinSize(30, 30); // Set minimum size
                textField.setMaxSize(30, 30); // Set maximum size
                GridPane.setHalignment(textField, HPos.CENTER); // Align text to center horizontally
                GridPane.setValignment(textField, VPos.CENTER); // Align text to center vertically

                board.add(textField, column, row); // Add text field to the grid pane

                // Create a BoardNum object to represent the cell
                BoardNum boardNum = new BoardNum(textField, row, column);
                sudokuBoard[row][column] = boardNum; // Store the BoardNum object in the board array
            }
        }
    }

    // Method to open the win stage
    private void openWinStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/win-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("¡Felicidades!"); // Set window title
        stage.show(); // Show the window
    }

    // Method to open the lose stage
    private void openLoseStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/lose-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("¡Has perdido!"); // Set window title
        stage.show(); // Show the window
    }

    // Event handler for verify button click
    @FXML
    void onVerifyButtonClick(ActionEvent actionEvent) throws IOException {
        // Check if the board numbers are correct
        boolean result = sudokuGame.checkBoardNums();

        // Check if text field inputs are valid
        if (sudokuGame.checkTextFieldInputs()) {
            if (result) { // If board numbers are correct
                resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: green;");
                resultLabel.setText("¡Felicidades, tu respuesta es correcta!"); // Set success message
                openWinStage(); // Open win stage

                // Disable all text fields after successful verification
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++) {
                        sudokuBoard[row][column].getTextField().setEditable(false);
                    }
                }
            } else { // If board numbers are incorrect
                resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");
                resultLabel.setText("Has cometido errores..."); // Set error message
                openLoseStage(); // Open lose stage

                // Disable all text fields after failed verification
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++) {
                        sudokuBoard[row][column].getTextField().setEditable(false);
                    }
                }
            }
        } else { // If text field inputs are invalid
            resultLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");
            resultLabel.setText("Hay inputs inválidos en tu respuesta."); // Set error message
        }
    }

    // Event handler for resolve button click
    @FXML
    void onResolveButtonClick(ActionEvent actionEvent) throws IOException {
        //sudokuGame.resolve(); // Implement Sudoku board resolution logic
    }
}
