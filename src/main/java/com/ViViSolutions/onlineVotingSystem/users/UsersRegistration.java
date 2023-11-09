package com.ViViSolutions.onlineVotingSystem.users;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UsersRegistration")

public class UsersRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        String voterId = request.getParameter("voter_id");
        String role = request.getParameter("role");

        // Create a User object with the collected data
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password); // Remember to hash and salt the password
        user.setName(name);
        user.setEmail(email);
        user.setDob(dob);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setVoterId(voterId);
        user.setRole(role);
        user.setVerified(false); // You can set this to false by default
        user.setVoteHistory(""); // You can set this to an empty string by default

        // Register the user using the UserDAO
        boolean registrationSuccess = UsersDAO.registerUser(user);

        if (registrationSuccess) {
            // Registration successful, redirect to a success page
            response.sendRedirect("UserRegistrationSuccess.jsp");
        } else {
            // Registration failed, display an error message
            response.sendRedirect("registration_error.jsp");
        }
	}
	
	

}
