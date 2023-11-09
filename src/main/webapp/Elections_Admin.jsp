<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ViViSolutions.onlineVotingSystem.Elections.Elections" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Elections-Admin</title>
</head>
<body>
    <h1>Election List</h1>
    <form action="ElectionsAdminServlet" method="get">
        <input type="submit" value="Get the Values">
    </form>
    <table border="1">
        <thead>
            <tr>
            	<th>Election ID</th>
                <th>Election Name</th>
                <th>Registration Start Date</th>
                <th>Voting End Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="election" items="${elections}">
                <tr>
                	<td>${election.electionId}
                    <td>${election.electionName}</td>
                    <td>${election.registrationStartDate}</td>
                    <td>${election.votingEndDate}</td>
                    <td>
                        <c:choose>
                    <c:when test="${!election.buttonClicked}">
                        <form action="ElectionsAdminServlet" method="post">
                            <input type="hidden" name="electionId" value="${election.electionId}">
                            <input type="submit" value="Create Table">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <p>Table Created</p>
                    </c:otherwise>
                </c:choose>>
                    </td>
                </tr>
            </c:forEach>
         </tbody>
    </table>
</body>
</html>
