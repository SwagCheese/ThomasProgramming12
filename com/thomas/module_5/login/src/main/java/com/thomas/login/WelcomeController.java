package com.thomas.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controls the welcome screen after successful login and handles user interactions on that screen.
 */
public class WelcomeController {
    @FXML private Button logoutButton;
    @FXML private Label sessionLabel;

    public void initialize() {}

    /**
     * Initializes the WelcomeController with the specified LoginManager and session ID.
     * @param loginManager The LoginManager responsible for managing the login process.
     * @param sessionID The ID of the current session.
     */
    public void initSessionID(final LoginManager loginManager, String sessionID) {
        sessionLabel.setText(sessionID);
        logoutButton.setOnAction(event -> loginManager.logout());
    }

    /**
     * Opens the Add User popup window when the Add User button is clicked.
     * Loads the FXML file for the popup window and displays it in a new Stage.
     * @param event The ActionEvent triggered by the Add User button.
     */
    @FXML
    public void openAddUserPopup(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addUserPopup.fxml"));
            Stage popup = new Stage();
            Scene scene = new Scene(loader.load());

            popup.setScene(scene);
            popup.setTitle("Add User");
            popup.show();
        } catch (IOException e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
