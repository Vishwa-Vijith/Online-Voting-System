package com.ViViSolutions.onlineVotingSystem.Elections;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;



@WebServlet("/ElectionController")
public class ElectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        String electionId = request.getParameter("electionId");
		        
//		        request.setAttribute("electionId", electionId);
//		        request.getRequestDispatcher("CandidateRegistration.jsp").forward(request, response);
		        
		        String electionName = request.getParameter("electionName");
		        String electionDescription = request.getParameter("electionDescription");
		        Date registrationStartDate = Date.valueOf(request.getParameter("regStartDate"));
		        Date registrationEndDate = Date.valueOf(request.getParameter("regEndDate"));
		        Time registrationStartTime=null;//Time.valueOf(request.getParameter("regStartTime"));
		        Time registrationEndTime = null;
		        try {
		            registrationStartTime = parseTime(request.getParameter("regStartTime"));
		        } catch (IllegalArgumentException e) {
		            e.printStackTrace(); // For debugging purposes
		        }
//		        Time tm=parseTime(request.getParameter("timeInput"));
//		        System.out.println(request.getParameter("timeInput"));
//System.out.println("hhjhsdjhsdfjk>>>"+tm);

		        try{
		        	registrationEndTime = parseTime(request.getParameter("regEndTime"));
		        }
		        catch (IllegalArgumentException e) {
		            e.printStackTrace(); // For debugging purposes
		        }
		        Date votingStartDate = Date.valueOf(request.getParameter("voteStartDate"));
		        Date votingEndDate = Date.valueOf(request.getParameter("voteEndDate"));
		        
		        Time votingStartTime = null;
		        Time votingEndTime = null;
		        try{
		        	votingStartTime = parseTime(request.getParameter("voteStartTime"));
		        }
		        catch (IllegalArgumentException e) {
		            e.printStackTrace(); // For debugging purposes
		        }
		        try{
		        	votingEndTime = parseTime(request.getParameter("voteEndTime"));
		        }
		        catch (IllegalArgumentException e) {
		            e.printStackTrace(); // For debugging purposes
		        }

		        
				Elections election = new Elections(electionId, electionName, electionDescription,
						registrationStartDate, registrationEndDate,
		                registrationStartTime,
		               registrationEndTime, votingStartDate, votingEndDate, votingStartTime,
		                votingEndTime);

		        Connection connection = null;
				try {
					connection = ConnectionProvider.getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        ElectionDao electionDAO = new ElectionDao(connection);

		        try {
		            boolean success = electionDAO.insertElection(election);

		            if (success) {
		                response.sendRedirect("success.jsp");
		            } else {
		                response.sendRedirect("error.jsp");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            response.sendRedirect("error.jsp");
		        } finally {
		            try {
		                if (connection != null) {
		                    connection.close();
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    
	}
	private Time parseTime(String timeString) {
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	    try {
	        java.util.Date parsedTime = timeFormat.parse(timeString);
	        // Create a java.sql.Time object from the parsed time
	        return new Time(parsedTime.getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null; // Handle parsing error as needed
	    }
	}

}
