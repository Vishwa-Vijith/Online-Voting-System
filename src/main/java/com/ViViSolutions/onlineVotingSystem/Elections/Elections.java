package com.ViViSolutions.onlineVotingSystem.Elections;

import java.sql.Date;
import java.sql.Time;

public class Elections {
	

	
	    private String electionId;
	    private String electionName;
	    private String electionDescription;
	    private Date registrationStartDate;
	    private Date registrationEndDate;
	    private Time registrationStartTime;
	    private Time registrationEndTime;
	    private Date votingStartDate;
	    private Date votingEndDate;
	    private Time votingStartTime;
	    private Time votingEndTime;
	    private boolean buttonClicked;


	   
	    public Elections() {
	      
	    }

	    public Elections(
	        String electionId,
	        String electionName,
	        String electionDescription,
	        Date registrationStartDate,
	        Date registrationEndDate,
	        Time registrationStartTime,
	        Time registrationEndTime,
	        Date votingStartDate,
	        Date votingEndDate,
	        Time votingStartTime,
	        Time votingEndTime
	    ) {
	        this.electionId = electionId;
	        this.electionName = electionName;
	        this.electionDescription=electionDescription;
	        this.registrationStartDate = registrationStartDate;
	        this.registrationEndDate = registrationEndDate;
	        this.registrationStartTime = registrationStartTime;
	        this.registrationEndTime = registrationEndTime;
	        this.votingStartDate = votingStartDate;
	        this.votingEndDate = votingEndDate;
	        this.votingStartTime = votingStartTime;
	        this.votingEndTime = votingEndTime;
	    }

	    public String getElectionId() {
	        return electionId;
	    }

	    public void setElectionId(String electionId) {
	        this.electionId = electionId;
	    }

	    public String getElectionName() {
	        return electionName;
	    }

	    public void setElectionName(String electionName) {
	        this.electionName = electionName;
	    }

	    public String getElectionDescription() {
			return electionDescription;
		}

		public void setElectionDescription(String electionDescription) {
			this.electionDescription = electionDescription;
		}

		public Date getRegistrationStartDate() {
	        return registrationStartDate;
	    }

	    public void setRegistrationStartDate(Date registrationStartDate) {
	        this.registrationStartDate = registrationStartDate;
	    }

	    public Date getRegistrationEndDate() {
	        return registrationEndDate;
	    }

	    public void setRegistrationEndDate(Date registrationEndDate) {
	        this.registrationEndDate = registrationEndDate;
	    }

	    public Time getRegistrationStartTime() {
	        return registrationStartTime;
	    }

	    public void setRegistrationStartTime(Time registrationStartTime) {
	        this.registrationStartTime = registrationStartTime;
	    }

	    public Time getRegistrationEndTime() {
	        return registrationEndTime;
	    }

	    public void setRegistrationEndTime(Time registrationEndTime) {
	        this.registrationEndTime = registrationEndTime;
	    }

	    public Date getVotingStartDate() {
	        return votingStartDate;
	    }

	    public void setVotingStartDate(Date votingStartDate) {
	        this.votingStartDate = votingStartDate;
	    }

	    public Date getVotingEndDate() {
	        return votingEndDate;
	    }

	    public void setVotingEndDate(Date votingEndDate) {
	        this.votingEndDate = votingEndDate;
	    }

	    public Time getVotingStartTime() {
	        return votingStartTime;
	    }

	    public void setVotingStartTime(Time votingStartTime) {
	        this.votingStartTime = votingStartTime;
	    }

	    public Time getVotingEndTime() {
	        return votingEndTime;
	    }

	    public void setVotingEndTime(Time votingEndTime) {
	        this.votingEndTime = votingEndTime;
	    }

		public boolean isButtonClicked() {
			return buttonClicked;
		}

		public void setButtonClicked(boolean buttonClicked) {
			this.buttonClicked = buttonClicked;
		}
	
	    
}
