package com.ViViSolutions.onlineVotingSystem.candidates;

import java.util.*;

public class Candidate {
	
		private String electionId;
	    private String fullName;
	    private String username;
	    private String password;
	    private String email;
	    private Date dob;
	    private String address;
	    private String phoneNumber;
	    private String voterId;
	    private String candidateStatement;
	    private byte[] campaignLogo; 
	    private String politicalParty;
	    private String electionPosition;
	    private String campaignLinks;
	    private byte[] verificationDocuments;
	    private String campaignSlogan;
	    private String campaignPlatform;
	    private byte[] candidatePhoto;
	    private byte[] signature;
	    private boolean isVerified;
	    
	    
	    
		
		
		public String getElectionId() {
			return electionId;
		}
		public void setElectionId(String i) {
			this.electionId = i;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
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
		public String getCandidateStatement() {
			return candidateStatement;
		}
		public void setCandidateStatement(String candidateStatement) {
			this.candidateStatement = candidateStatement;
		}
		public byte[] getCampaignLogo() {
			return campaignLogo;
		}
		public void setCampaignLogo(byte[] campaignLogo) {
			this.campaignLogo = campaignLogo;
		}
		public String getPoliticalParty() {
			return politicalParty;
		}
		public void setPoliticalParty(String politicalParty) {
			this.politicalParty = politicalParty;
		}
		public String getElectionPosition() {
			return electionPosition;
		}
		public void setElectionPosition(String electionPosition) {
			this.electionPosition = electionPosition;
		}
		public String getCampaignLinks() {
			return campaignLinks;
		}
		public void setCampaignLinks(String campaignLinks) {
			this.campaignLinks = campaignLinks;
		}
		public byte[] getVerificationDocuments() {
			return verificationDocuments;
		}
		public void setVerificationDocuments(byte[] verificationDocuments) {
			this.verificationDocuments = verificationDocuments;
		}
		public String getCampaignSlogan() {
			return campaignSlogan;
		}
		public void setCampaignSlogan(String campaignSlogan) {
			this.campaignSlogan = campaignSlogan;
		}
		public String getCampaignPlatform() {
			return campaignPlatform;
		}
		public void setCampaignPlatform(String campaignPlatform) {
			this.campaignPlatform = campaignPlatform;
		}
		public byte[] getCandidatePhoto() {
			return candidatePhoto;
		}
		public void setCandidatePhoto(byte[] candidatePhoto) {
			this.candidatePhoto = candidatePhoto;
		}
		public byte[] getSignature() {
			return signature;
		}
		public void setSignature(byte[] signature) {
			this.signature = signature;
		}
		public boolean isIsVerified() {
		    return isVerified;
		}
		public void setIsVerified(boolean isVerified) {
		    this.isVerified = isVerified;
		}
		@Override
		public String toString() {
			return "Candidate [electionId=" + electionId + ",\n fullName=" + fullName + ",\n username=" + username
					+ ",\n password=" + password + ",\n email=" + email + ",\n dob=" + dob + ", address=" + address
					+ ", \nphoneNumber=" + phoneNumber + ",\n voterId=" + voterId + ",\n candidateStatement="
					+ candidateStatement + ",\n campaignLogo=" + Arrays.toString(campaignLogo) + ",\n politicalParty="
					+ politicalParty + ", \nelectionPosition=" + electionPosition + ", campaignLinks=" + campaignLinks
					+ ", verificationDocuments=" + Arrays.toString(verificationDocuments) + ", campaignSlogan="
					+ campaignSlogan + ", campaignPlatform=" + campaignPlatform + ", candidatePhoto="
					+ Arrays.toString(candidatePhoto) + ", signature=" + Arrays.toString(signature) + ", isVerified="
					+ isVerified + "]";
		}
	    
		
}
