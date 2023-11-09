package com.ViViSolutions.onlineVotingSystem.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	
	 private Connection conn;

	    public AdminDAO(Connection conn) {
	        this.conn = conn;
	      }

	    public AdminModell getAdmin(String username) {
	        AdminModell admin = null;
	        String query = "SELECT * FROM admins WHERE username=?";
	        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	            preparedStatement.setString(1, username);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                String dbUsername = resultSet.getString("username");
	                String dbPassword = resultSet.getString("password");
	                admin = new AdminModell(dbUsername, dbPassword);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return admin;
//		
		
	    
	      
	    }
}
	


