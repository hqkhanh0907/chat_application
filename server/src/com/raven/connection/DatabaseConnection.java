package com.raven.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    public void connectToDatabase() throws SQLException {
        String currentDirectory = System.getProperty("user.dir");
        connection = java.sql.DriverManager.getConnection("jdbc:sqlite:" + currentDirectory + "/db/chat_application.db");
    }

    public Connection getConnection() {
        return connection;
    }
    
    public Statement getStatement() {
        try {
            return connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
