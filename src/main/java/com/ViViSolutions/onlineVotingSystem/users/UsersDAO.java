package com.ViViSolutions.onlineVotingSystem.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {
	

	    public static boolean registerUser(Users user) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        boolean registrationSuccess = false;
	        
	        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
	        String username = "root";
	        String password = "Password123#@!";

	        try {
	        	conn = DriverManager.getConnection(jdbcUrl, username, password);


	            String sql = "INSERT INTO users (username, password, name, email, dob, address, phone_number, voter_id, role, is_verified, vote_history) " +
	                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getName());
	            stmt.setString(4, user.getEmail());
	            stmt.setDate(5, new java.sql.Date(user.getDob().getTime()));
	            stmt.setString(6, user.getAddress());
	            stmt.setString(7, user.getPhoneNumber());
	            stmt.setString(8, user.getVoterId());
	            stmt.setString(9, user.getRole());
	            stmt.setBoolean(10, user.isVerified());
	            stmt.setString(11, user.getVoteHistory());

	            int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                registrationSuccess = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return registrationSuccess;
	    }
	}



