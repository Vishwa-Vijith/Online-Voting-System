<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

    <h1>User Registration</h1>
    <form action="UsersRegistration" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address"><br>
        
        <label for="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" name="phone_number"><br>
        
        <label for="voter_id">Voter ID or National ID:</label>
        <input type="text" id="voter_id" name="voter_id" required><br>
        
        <label for="role">User Role:</label>
        <select id="role" name="role">
            <option value="voter">Voter</option>
            
        </select><br>
        
        <input type="submit" value="Register">
    </form>


</body>
</html>