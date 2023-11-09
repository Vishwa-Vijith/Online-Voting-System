package com.ViViSolutions.onlineVotingSystem.candidates;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;


@WebServlet("/CandidateApproveServlet")
public class CandidateApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CandidateApproveServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
        String dbUser = "root";
        String dbPassword = "Password123#@!";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            String sql = "SELECT election_id, full_name, email, dob, address, phone_number, "+"voter_id, campaign_logo, political_party, " +" verification_documents, " +        "candidate_photo,  isVerified " + "FROM candidates";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Candidate> candidates = new ArrayList<>();

            while (resultSet.next()) {
            	Candidate candidate = new Candidate();
            	candidate.setElectionId(resultSet.getString("election_id"));
            	candidate.setFullName(resultSet.getString("full_name"));
            	candidate.setEmail(resultSet.getString("email"));
            	candidate.setDob(resultSet.getDate("dob"));
            	candidate.setAddress(resultSet.getString("address"));
            	candidate.setPhoneNumber(resultSet.getString("phone_number"));
            	candidate.setVoterId(resultSet.getString("voter_id"));
            	candidate.setCampaignLogo(resultSet.getBytes("campaign_logo"));
            	candidate.setPoliticalParty(resultSet.getString("political_party"));
            	candidate.setVerificationDocuments(resultSet.getBytes("verification_documents"));
            	candidate.setCandidatePhoto(resultSet.getBytes("candidate_photo"));
            	candidate.setIsVerified(resultSet.getBoolean("isVerified"));
                candidates.add(candidate);
                System.out.println(candidates);
            }
            connection.close();
            request.setAttribute("candidates", candidates);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/candidateApproval.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
        String dbUser = "root";
        String dbPassword = "Password123#@!";
		 String email = request.getParameter("email");
	        boolean isVerified = true; 
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
	            String updateQuery = "UPDATE candidates SET isVerified = ? WHERE email = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	            preparedStatement.setBoolean(1, isVerified);
	            preparedStatement.setString(2, email);

	            int rowsUpdated = preparedStatement.executeUpdate();
	            if (rowsUpdated > 0) {
	                Candidate candidate = new Candidate();
	                candidate.setEmail(email);
	                candidate.setIsVerified(isVerified);
	                request.setAttribute("candidate", candidate);
	                request.getRequestDispatcher("candidateApproval.jsp").forward(request, response);
	            } else {
	                response.sendRedirect("candidateApproval.jsp?updateFailed=true");
	            }
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("candidateApproval.jsp?updateFailed=true");
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

}
