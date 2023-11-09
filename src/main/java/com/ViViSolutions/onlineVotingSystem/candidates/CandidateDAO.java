package com.ViViSolutions.onlineVotingSystem.candidates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
	
	    public static boolean registerCandidate(Candidate candidate) throws ClassNotFoundException {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        boolean registrationSuccess = false;
	        
	        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
	        String username = "root";
	        String password = "Password123#@!";

	        try {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = DriverManager.getConnection(jdbcUrl, username, password);
	        	
	        	//String retrieveElecId=""

	            String sql = "INSERT INTO candidates (election_id,full_name, username, password, email, dob, address, phone_number, " +
	                         "voter_id, candidate_statement, campaign_logo, political_party, election_position, " +
	                         "campaign_links, verification_documents, campaign_slogan, campaign_platform, " +
	                         "candidate_photo, signature) " +
	                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, candidate.getElectionId());
	            stmt.setString(2, candidate.getFullName());
	            stmt.setString(3, candidate.getUsername());
	            stmt.setString(4, candidate.getPassword());
	            stmt.setString(5, candidate.getEmail());
	            stmt.setDate(6, new java.sql.Date(candidate.getDob().getTime()));
	            stmt.setString(7, candidate.getAddress());
	            stmt.setString(8, candidate.getPhoneNumber());
	            stmt.setString(9, candidate.getVoterId());
	            stmt.setString(10, candidate.getCandidateStatement());
	            stmt.setBytes(11, candidate.getCampaignLogo());
	            stmt.setString(12, candidate.getPoliticalParty());
	            stmt.setString(13, candidate.getElectionPosition());
	            stmt.setString(14, candidate.getCampaignLinks());
	            stmt.setBytes(15, candidate.getVerificationDocuments());
	            stmt.setString(16, candidate.getCampaignSlogan());
	            stmt.setString(17, candidate.getCampaignPlatform());
	            stmt.setBytes(18, candidate.getCandidatePhoto());
	            stmt.setBytes(19, candidate.getSignature());
//	            stmt.executeUpdate();
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

	/*****************************************************************/    
	    public List<Candidate> getAllCandidates() throws ClassNotFoundException, SQLException {
	    	
	    	Connection conn = null;
	        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
	        String username = "root";
	        String password = "Password123#@!";

	        try {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = DriverManager.getConnection(jdbcUrl, username, password);
	        List<Candidate> candidates = new ArrayList<>();
	        String sql = "SELECT * FROM candidates";

	        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                Candidate candidate = new Candidate();
	                candidate.setElectionId(resultSet.getString("election_id"));
	                candidate.setFullName(resultSet.getString("full_name"));
	                candidate.setUsername(resultSet.getString("username"));
	                candidate.setPassword(resultSet.getString("password"));
	                candidate.setEmail(resultSet.getString("email"));
	                candidate.setDob(resultSet.getDate("dob"));
	                candidate.setAddress(resultSet.getString("address"));
	                candidate.setPhoneNumber(resultSet.getString("phone_number"));
	                candidate.setVoterId(resultSet.getString("voter_id"));
	                candidate.setCandidateStatement(resultSet.getString("candidate_statement"));
	                candidate.setCampaignLogo(resultSet.getBytes("campaign_logo"));
	                candidate.setPoliticalParty(resultSet.getString("political_party"));
	                candidate.setElectionPosition(resultSet.getString("election_position"));
	                candidate.setCampaignLinks(resultSet.getString("campaign_links"));
	                candidate.setVerificationDocuments(resultSet.getBytes("verification_documents"));
	                candidate.setCampaignSlogan(resultSet.getString("campaign_slogan"));
	                candidate.setCampaignPlatform(resultSet.getString("campaign_platform"));
	                candidate.setCandidatePhoto(resultSet.getBytes("candidate_photo"));
	                candidate.setSignature(resultSet.getBytes("signature"));
	                candidate.setIsVerified(resultSet.getBoolean("isVerified"));

	                candidates.add(candidate);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return candidates;
	    }
	        finally {
	        	
	        }
	


}

	public void updateApprovalStatus(String email, boolean isApproved) throws ClassNotFoundException, SQLException {
		 Connection conn = null;
		    PreparedStatement preparedStatement = null;
		    
		    String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
		    String username = "root";
		    String password = "Password123#@!";
		    
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection(jdbcUrl, username, password);
		        
		        String sql = "UPDATE candidates SET isVerified = ? WHERE email = ?";
		        preparedStatement = conn.prepareStatement(sql);
		        
		      //  preparedStatement.setBoolean(1, isApproved);
		        preparedStatement.setBoolean(0, isApproved);
		        
		        preparedStatement.executeUpdate();
		    } 
		    finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
	}
}
}

