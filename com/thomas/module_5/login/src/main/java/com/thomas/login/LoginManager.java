package com.thomas.login;

import java.io.IOException;
import java.util.logging.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

/**
 * Manages the control flow for logins and transitions between different screens.
 */
public class LoginManager {
    private final Scene scene;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Displays the main application screen.
     * @param sessionID The ID of the authenticated session.
     */
    public void authenticated(String sessionID, String username) {
        showWelcomeView(sessionID, username);
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Displays the login application screen.
     */
    public void logout() {
        showLoginScreen();
    }

    /**
     * Shows the login application screen by loading the corresponding FXML file.
     */
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            scene.setRoot(loader.load());
            LoginController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Shows the welcome screen of the main application by loading the corresponding FXML file.
     * @param sessionID The ID of the authenticated session.
     */
    private void showWelcomeView(String sessionID, String username) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcome.fxml"));
            scene.setRoot(loader.load());
            WelcomeController controller = loader.getController();
            controller.initSessionID(this, sessionID, username);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
