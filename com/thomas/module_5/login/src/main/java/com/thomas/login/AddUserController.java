package com.thomas.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controls the user addition screen and handles the addition of new users.
 */
public class AddUserController {
    @FXML
    public TextField user;
    @FXML
    public Label usernameExistsMessage;
    @FXML
    public PasswordField password;
    @FXML
    public Button closeButton;

    /**
     * Adds a new user with the provided username and password.
     * If the user is added successfully to the database, closes the window;
     * otherwise, displays a message indicating that the username already exists.
     * @param event The ActionEvent triggered by the Add User button.
     */
    @FXML
    public void AddUser(ActionEvent event) {
        if (DatabaseHandler.getHandler().execAction("INSERT INTO " + DatabaseHandler.TABLE_NAME + " (USERNAME, PASSWORD) VALUES ('" + user.getText() + "', '" + password.getText() + "')")) {
            close(event);
        } else {
            usernameExistsMessage.setVisible(true);
        }
    }

    /**
     * Closes the current window.
     * @param event The ActionEvent triggered by the Close button.
     */
    @FXML
    public void close(ActionEvent event) {
        // See https://stackoverflow.com/questions/13567019/close-fxml-window-by-code-javafx
        ((Stage) closeButton.getScene().getWindow()).close();
    }
}
