package com.ViViSolutions.onlineVotingSystem.users;

import java.sql.Date;

public class Users {
	
	
	    private String username;
	    private String password;
	    private String name;
	    private String email;
	    private Date dob;
	    private String address;
	    private String phoneNumber;
	    private String voterId;
	    private String role;
	    private boolean isVerified;
	    private String voteHistory;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getVoterId() {
			return voterId;
		}
		public void setVoterId(String voterId) {
			this.voterId = voterId;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isVerified() {
			return isVerified;
		}
		public void setVerified(boolean isVerified) {
			this.isVerified = isVerified;
		}
		public String getVoteHistory() {
			return voteHistory;
		}
		public void setVoteHistory(String voteHistory) {
			this.voteHistory = voteHistory;
		}
	    
	    
	    

	   
	}

	


