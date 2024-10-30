package com.java_db_example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String url = "jdbc:mysql://localhost:3306/java_db";
    private final static String username = "root";
    private final static String password = "mlpzaq987";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Failed to connect...");
            e.printStackTrace();
            throw new SQLException("Connection error", e);
        }
    }
}
