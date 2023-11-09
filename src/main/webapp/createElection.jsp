<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Election</title>
</head>
<body>

	<h1>Create the Election</h1>
    <form action="ElectionController" method="post">
    
        <label for="electionId">Election ID:</label>
        <input type="text" id="electionId" name="electionId" required><br>

        <label for="electionName">Election Name:</label>
        <input type="text" id="electionName" name="electionName" required><br>
        
        <label for="electionDescription">Election Description:</label>
        <textarea id="electionDescription" name="electionDescription" rows="4" cols="50" 
        required></textarea><br>

        <label for="regStartDate">Registration Start Date:</label>
        <input type="date" id="regStartDate" name="regStartDate" required><br>

        <label for="regEndDate">Registration End Date:</label>
        <input type="date" id="regEndDate" name="regEndDate" required><br>
     
     	<label for="regStartTime">Registration Start Time:</label>
        <input type="time" id="regStartTime" name="regStartTime" step="1"required><br> 

        <label for="regEndTime">Registration End Time:</label>
        <input type="time" id="regEndTime" name="regEndTime" step="1" required><br>

        <label for="voteStartDate">Voting Start Date:</label>
        <input type="date" id="voteStartDate" name="voteStartDate" required><br>

        <label for="voteEndDate">Voting End Date:</label>
        <input type="date" id="voteEndDate" name="voteEndDate" required><br>

        <label for="voteStartTime">Voting Start Time:</label>
        <input type="time" id="voteStartTime" name="voteStartTime" step="1" required><br>

        <label for="voteEndTime">Voting End Time:</label>
        <input type="time" id="voteEndTime" name="voteEndTime" step="1" required><br>
 
        <input type="submit" value="Create Election">
    </form>

</body>
</html>