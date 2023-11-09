<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page import="com.ViViSolutions.onlineVotingSystem.candidates.Candidate" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Approval</title>
 <style>
        body {
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        img {
            max-width: 100px;
            max-height: 100px;
            display: block;
            margin: 0 auto;
        }

        form {
            text-align: center;
        }
    </style>
</head>
<body>
<form action ="CandidateApproveServlet">
<input type="submit">
</form>

	 <h1>Candidate Details</h1>
    <table border="1">
        <tr>
           
            <th>Election ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Voter ID</th>
            <th>Campaign Logo</th>
            <th>Political Party</th>
            <th>Verification Documents</th>
            <th>Candidate Photo</th>
            <th>Is Verified</th> 
            <th>Action</th>
        </tr>

		 <c:forEach var="candidate" items="${candidates}">

            <tr>
                
                <td>${candidate.electionId}</td>
                <td>${candidate.fullName}</td>
                <td>${candidate.email}</td>
                <td>${candidate.dob}</td>
                <td>${candidate.address}</td>
                <td>${candidate.phoneNumber}</td>
                <td>${candidate.voterId}</td>
                <td>
                    <img src="data:image/jpeg;base64,${candidate.campaignLogo}" alt="Campaign Logo" width="100">

                </td>
                <td>${candidate.politicalParty}</td>
                <td>
                    <a href="data:application/pdf;base64,${candidate.verificationDocuments}" target="_blank">View Document</a>
                </td>
                <td>
                    <img src="data:image/jpeg;base64,${candidate.candidatePhoto}" alt="Candidate Photo" width="100">
                </td>
                <td>${candidate.isVerified}</td> 
               <td>
       		   <form action="CandidateApproveServlet" method="post">
            	 <input type="hidden" name="email" value="${candidate.email}">
            	 <input type="submit" value="Approve">
        	   </form>
   			   </td>
            </tr>
        </c:forEach>
    </table>
 
</body>
</html>