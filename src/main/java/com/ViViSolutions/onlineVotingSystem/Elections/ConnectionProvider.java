package com.ViViSolutions.onlineVotingSystem.Elections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String URL = "jdbc:mysql://localhost:3306/onlinevoting";
    private static final String USER = "root";
    private static final String PASSWORD = "Password123#@!";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.");
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
