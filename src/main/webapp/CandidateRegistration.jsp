<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Registration</title>
 <style>
       .warning-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #f44336; /* Red background color for warning */
            color: white;
            padding: 10px;
            z-index: 999;
            display: flex;
            align-items: center; /* Vertically center the content */
        }

        /* Style for the warning emoji */
        .warning-emoji {
            font-size: 20px; /* Adjust the font size as needed */
            margin-right: 10px; /* Add spacing between emoji and text */
        }

        /* Style for the warning message text */
        .warning-text {
            font-weight: bold; /* Make the text bold for emphasis */
        }

        /* Style for the content below the warning message */
        .content {
            padding: 20px;
            margin-top: 40px; /* Add margin to create space below the warning */
        }
    </style>
</head>
<body>
	 <div class="warning-container">
        <span class="warning-emoji">⚠️</span> <!-- Warning emoji -->
        <span class="warning-text">The Candidate must be the user of this Platform, then only this Form will be validated, Otherwise it will get Rejected.</span>
    </div>
	 
	  <div class="notification">
        
    </div>
    
    <div class="content">
    <h1>Candidate Registration</h1>
    <form action="CandidateRegistrationServlet" method="post" enctype="multipart/form-data">
        
        <label for="electionId">Election ID:</label>
        <input type="text" id="electionId" name="electionId" required><br>
        
        <label for="full_name">Full Name:</label>
        <input type="text" id="full_name" name="full_name" required><br>
        
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br>
        
        <label for="address">Residential Address:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" name="phone_number" required><br>
        
        <label for="voter_id">Voter ID or National ID:</label>
        <input type="text" id="voter_id" name="voter_id" required><br>
        
        <label for="candidate_statement">Candidate Statement:</label>
        <textarea id="candidate_statement" name="candidate_statement" rows="4" cols="50" required></textarea><br>
        
        <label for="campaign_logo">Campaign Logo or Image:</label>
        <input type="file" id="campaign_logo" name="campaign_logo"><br>
        
        <label for="political_party">Political Party Affiliation:</label>
        <input type="text" id="political_party" name="political_party"><br>
        
        <label for="election_position">Election/Position Applying For:</label>
        <input type="text" id="election_position" name="election_position" required><br>
        
        <label for="campaign_links">Campaign Website/Social Media Links:</label>
        <input type="text" id="campaign_links" name="campaign_links"><br>
        
        <label for="verification_documents">Verification Documents:</label>
        <input type="file" id="verification_documents" name="verification_documents"><br>
        
        <label for="campaign_slogan">Campaign Slogan:</label>
        <input type="text" id="campaign_slogan" name="campaign_slogan"><br>
        
        <label for="campaign_platform">Campaign Platform/Agenda:</label>
        <textarea id="campaign_platform" name="campaign_platform" rows="4" cols="50"></textarea><br>
        
        <label for="candidate_photo">Candidate Photo:</label>
        <input type="file" id="candidate_photo" name="candidate_photo"><br>
        
        <label for="signature">Signature:</label>
        <input type="file" id="signature" name="signature"><br>
        
        <input type="submit" value="Register">
    </form>
    </div>

</body>
</html>