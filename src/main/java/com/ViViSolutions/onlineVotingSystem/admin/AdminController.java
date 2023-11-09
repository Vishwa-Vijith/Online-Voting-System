package com.ViViSolutions.onlineVotingSystem.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AdminLoginController")
public class AdminController extends HttpServlet {

	    private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
	        String dbUser = "root";
	        String dbPassword = "Password123#@!";
	        
	        try {
	        	

	        	Class.forName("com.mysql.cj.jdbc.Driver");

	        	Connection conn = DriverManager.getConnection(jdbcUrl,dbUser,dbPassword);
	        
	        	
	        	AdminDAO adminDAO = new AdminDAO(conn);
	            AdminModell admin = adminDAO.getAdmin(username);

	            if (admin!=null && admin.getPassword().equals(password)) {
	                
	                response.sendRedirect("adminWorkspace.jsp");
	            } else {
	                
	                response.sendRedirect("adminLogin.jsp");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	     
	    }
	}

