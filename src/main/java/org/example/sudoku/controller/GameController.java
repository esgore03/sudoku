/**
 * @author Jose Martínez - Jhorman Gómez - Esteban Gómez
 * @version 1.0
 */
package org.example.sudoku.controller;

// Import necessary classes
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.sudoku.model.BoardNum;
import org.example.sudoku.model.SudokuGame;
import org.example.sudoku.view.LoseStage;
import org.example.sudoku.view.WinStage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Controller class for the Sudoku game.
 */
public class GameController{
    @FXML
    private Button verifyButton;
    @FXML
    private Button resolveButton;
    @FXML
    private GridPane board;
    @FXML
    private Label resultLabel;

    // List of valid inputs for Sudoku
    private List<String> validInputs = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    // Instance of the class handling the game logic
    private SudokuGame sudokuGame = new SudokuGame();

    // Matrix to represent the Sudoku board
    private BoardNum[][] sudokuBoard = new BoardNum[9][9];

    /**
     * Initializes the Sudoku game.
     * Sets up the Sudoku board and generates initial numbers.
     */
    @FXML
    public void initialize() {
        createSudokuBoard();
        sudokuGame.setSudokuBoard(sudokuBoard);
        sudokuGame.generateInitialNumbers();
    }

    /**
     * Creates the Sudoku board and configures its elements.
     */
    private void createSudokuBoard() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TextField textField = new TextField();

                textField.setMinSize(30,30);
                textField.setMaxSize(30,30);
                textField.setStyle("-fx-alignment: center;");
                textField.setOnKeyTyped(event -> {
                    String input = event.getCharacter();
                    if (!input.isEmpty() && !Character.isDigit(input.charAt(0))) {
                        // Si el carácter ingresado no es un dígito, consumir el evento para evitar que se ingrese
                        textField.clear();
                        resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: red;");
                        resultLabel.setText("Input no válido.");
                    } else if (!validInputs.contains(input)) {
                        // Si el carácter ingresado no está en la lista de números válidos, borrar el texto
                        textField.clear();
                        resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: red;");
                        resultLabel.setText("Input no válido.");
                    }
                });
                GridPane.setHalignment(textField, HPos.CENTER);
                GridPane.setValignment(textField, VPos.CENTER);

                board.add(textField, column, row);

                BoardNum boardNum = new BoardNum(textField, row, column);
                sudokuBoard[row][column] = boardNum;
            }
        }
    }

    /**
     * Handles the action when the verify button is clicked.
     * Checks if the solution is correct and displays the result.
     * Closes the current window and shows a victory or defeat window accordingly.
     *
     * @param actionEvent The event triggered by clicking the verify button.
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    void onVerifyButtonClick(ActionEvent actionEvent) throws IOException{
        boolean result = sudokuGame.checkBoardNums();
        Stage stage = (Stage) resultLabel.getScene().getWindow();
        if(sudokuGame.checkTextFieldInputs()) {
            if (result) {
                resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: green;");
                resultLabel.setText("¡Felicidades, tu respuesta es correcta!");
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++){
                        sudokuBoard[row][column].getTextField().setEditable(false);
                    }
                }
                WinStage winStage = new WinStage();
                winStage.show();
                stage.close();
            } else {
                resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: red;");
                resultLabel.setText("Has cometido errores...");
                LoseStage loseStage = new LoseStage();
                loseStage.show();
                stage.close();
            }
        }
        else{
            resultLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: red;");
            resultLabel.setText("Hay inputs inválidos en tu respuesta.");
        }
    }

    /**
     * Handles the action when the resolve button is clicked.
     * Automatically resolves the Sudoku.
     *
     * @param actionEvent The event triggered by clicking the resolve button.
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    void onResolveButtonClick(ActionEvent actionEvent) throws IOException{
        sudokuGame.resolve();
    }
}