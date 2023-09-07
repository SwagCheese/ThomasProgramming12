package com.thomas.login;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;

/**
 * Controls the login screen and handles user authentication.
 */
public class LoginController {
    @FXML private TextField user;
    @FXML private PasswordField password;
    @FXML private Label loginFailMessage;
    @FXML private Button loginButton;

    public void initialize() {}

    /**
     * Initializes the LoginController with the specified LoginManager.
     * @param loginManager The LoginManager responsible for managing the login process.
     */
    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction(event -> {
            String sessionID = authorize();
            if (sessionID != null) {
                loginFailMessage.setVisible(false);
                loginManager.authenticated(sessionID, user.getText());
            } else {
                loginFailMessage.setVisible(true);
            }
        });
    }

    /**
     * Checks the authorization credentials provided by the user.
     * If the credentials exist in the database, returns a sessionID for the authorized session;
     * otherwise, returns null.
     * @return The sessionID if authorization is successful; otherwise, null.
     */
    private String authorize() {
        try (ResultSet resultSet = DatabaseHandler.getHandler().execQuery("SELECT * FROM " + DatabaseHandler.TABLE_NAME + " WHERE USERNAME='" + user.getText() + "' AND PASSWORD='" + password.getText() + "'")) {
            return (resultSet.next()) ? generateSessionID() : null;
        } catch (Exception e) {
            return null;
        }
    }

    private static int sessionID = 0;

    /**
     * Generates a new sessionID.
     * @return The generated sessionID.
     */
    private String generateSessionID() {
        sessionID++;
        return "session id: " + sessionID;
    }
}
