package com.thomas.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The entry point of the application that sets up the login screen.
 */
public class Main extends Application {

    public static void main(String[] args) {
        DatabaseHandler databaseHandler = DatabaseHandler.getHandler(); // Initialize the database

        System.out.println("Attempting to add the default username and password to the database. A warning is normal here.");
        databaseHandler.execAction("INSERT INTO " + DatabaseHandler.TABLE_NAME + " (USERNAME, PASSWORD) VALUES ('username', 'password')");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Pane()); // Placeholder pane

        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }
}
