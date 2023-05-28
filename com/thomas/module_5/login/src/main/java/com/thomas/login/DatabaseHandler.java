package com.thomas.login;

import java.sql.*;
import java.util.logging.Logger;

/**
 A class that represents a database handler for Chess960 games.
 */
public class DatabaseHandler {

    /**
     The name of the table in the database.
     */
    public static final String TABLE_NAME = "USERS";

    /**
     The URL of the database.
     */
    private static final String DB_url = "jdbc:derby:database/forum;create=true";

    /**
     The connection to the database.
     */
    private static Connection connection = null;

    /**
     The statement used to execute SQL queries on the database.
     */
    private static Statement statement = null;

    /**
     The instance of the DatabaseHandler class.
     */
    private static DatabaseHandler handler;

    /**
     Constructs a new DatabaseHandler object and creates a connection to the database and a table for Chess960 games.
     */
    public DatabaseHandler() {
        createConnection();
        createTable();
    }

    /**
     Returns the instance of the DatabaseHandler class, creating it if it doesn't already exist.

     @return The instance of the DatabaseHandler class.
     */
    public static DatabaseHandler getHandler() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }

        return handler;
    }

    /**
     Creates a table for Chess960 games in the database if it doesn't already exist.
     */
    private void createTable() {
        try {
            statement = connection.createStatement();
            DatabaseMetaData dmn = connection.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " exists");
            } else {
                String statement = "CREATE TABLE " + TABLE_NAME + " ("
                        + "USERNAME VARCHAR(32672) PRIMARY KEY,"
                        + "PASSWORD VARCHAR(32672))";

                System.out.println("Executing statement to create table: " + statement);
                DatabaseHandler.statement.execute(statement);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**

     Creates a connection to the database.
     */
    private void createConnection() {
        try {
            connection = DriverManager.getConnection(DB_url);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     Returns the connection to the database.

     @return The connection to the database.
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     Executes an SQL query on the database and returns whether it succeeded.

     @param query The SQL query to execute.
     @return The ResultSet produced by executing the SQL query.
     */
    public boolean execAction(String query) {
        try {
            statement = connection.createStatement();
            statement.execute(query);
            return true;

        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
            System.out.println("Did not enter data");
        }

        return false;
    }

    /**
     Executes an SQL query on the database and returns the ResultSet.

     @param query The SQL query to execute.
     @return The ResultSet produced by executing the SQL query.
     */
    public ResultSet execQuery(String query) {
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
        return resultSet;
    }
}