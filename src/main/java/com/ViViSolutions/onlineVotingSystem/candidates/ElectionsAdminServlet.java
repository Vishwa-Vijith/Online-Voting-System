package com.ViViSolutions.onlineVotingSystem.candidates;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ViViSolutions.onlineVotingSystem.Elections.Elections;

@WebServlet("/ElectionsAdminServlet")
public class ElectionsAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        Connection connection = null;
        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
        String username = "root";
        String password = "Password123#@!";
        List<Elections> elections = new ArrayList<>();
        String sql="select election_id,election_name,registration_start_date,voting_end_date from elections";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
          ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Elections election = new Elections();
                election.setElectionId(resultSet.getString("election_id"));
                election.setElectionName(resultSet.getString("election_name"));
                election.setRegistrationStartDate(resultSet.getDate("registration_start_date"));
                election.setVotingEndDate(resultSet.getDate("voting_end_date"));
                elections.add(election);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("elections", elections);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Elections_Admin.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String electionId = request.getParameter("electionId");
    	String createTableSQL = "CREATE TABLE IF NOT EXISTS election_votes ("
                + "election_id INT, "
                + "candidate_email VARCHAR(255), "
                + "no_of_votes INT, "
                + "FOREIGN KEY (election_id) REFERENCES elections(election_id), "
                + "FOREIGN KEY (candidate_email) REFERENCES candidates(email)"
                + ")";

        // Database connection variables
        Connection connection = null;
        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
        String username = "root";
        String password = "Password123#@!";

        try {
            // Establish a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create the table
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle database errors here
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Get the elections list from the session
        HttpSession session = request.getSession();
        List<Elections> elections = (List<Elections>) session.getAttribute("elections");

        // Mark the election as "buttonClicked" in the list
        for (Elections election : elections) {
            if (election.getElectionId().equals(electionId)) {
                election.setButtonClicked(true);
                break;
            }
        }

        // Set the updated elections list back in the session
        session.setAttribute("elections", elections);

        // Redirect back to the JSP page to update the view
        response.sendRedirect(request.getContextPath() + "/Elections_Admin.jsp");
    }
    	}

    

