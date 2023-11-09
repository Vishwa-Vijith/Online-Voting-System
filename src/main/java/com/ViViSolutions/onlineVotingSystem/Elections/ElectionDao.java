package com.ViViSolutions.onlineVotingSystem.Elections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ElectionDao {
	 private Connection connection;

	    public ElectionDao(Connection connection) {
	        this.connection = connection;
	    }

	    public boolean insertElection(Elections election) throws SQLException {
	        PreparedStatement preparedStatement = null;
	        boolean success = false;

	        try {
	            
	            String insertQuery = "INSERT INTO elections " +
	                    "(election_id, election_name, election_description, registration_start_date, registration_end_date, " +
	                    "registration_start_time, registration_end_time, voting_start_date, voting_end_date, " +
	                    "voting_start_time, voting_end_time) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            preparedStatement = connection.prepareStatement(insertQuery);
	    
	            preparedStatement.setString(1, election.getElectionId());
	            preparedStatement.setString(2, election.getElectionName());
	            preparedStatement.setString(3, election.getElectionDescription());
	            preparedStatement.setDate(4, election.getRegistrationStartDate());
	            preparedStatement.setDate(5, election.getRegistrationEndDate());
	            preparedStatement.setTime(6, election.getRegistrationStartTime());
	            preparedStatement.setTime(7, election.getRegistrationEndTime());
	            preparedStatement.setDate(8, election.getVotingStartDate());
	            preparedStatement.setDate(9, election.getVotingEndDate());
	            preparedStatement.setTime(10, election.getVotingStartTime());
	            preparedStatement.setTime(11, election.getVotingEndTime());

	            int rowsInserted = preparedStatement.executeUpdate();

	            if (rowsInserted > 0) {
	                success = true;
	                return success;
	            }
	        } finally {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        }

	        return success;
	    }

}
