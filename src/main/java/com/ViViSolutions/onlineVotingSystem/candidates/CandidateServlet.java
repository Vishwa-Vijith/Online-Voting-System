package com.ViViSolutions.onlineVotingSystem.candidates;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/CandidateRegistrationServlet")
@MultipartConfig
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String electionId = request.getParameter("electionId");
		String fullName = request.getParameter("full_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        String email = request.getParameter("email");
        String dobStr = request.getParameter("dob");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        String voterId = request.getParameter("voter_id");
        String candidateStatement = request.getParameter("candidate_statement");
        InputStream campaignLogoInputStream = request.getPart("campaign_logo").getInputStream();
        String politicalParty = request.getParameter("political_party");
        String electionPosition = request.getParameter("election_position");
        String campaignLinks = request.getParameter("campaign_links");
        InputStream verificationDocumentsInputStream = request.getPart("verification_documents").getInputStream();
        String campaignSlogan = request.getParameter("campaign_slogan");
        String campaignPlatform = request.getParameter("campaign_platform");
        InputStream candidatePhotoInputStream = request.getPart("candidate_photo").getInputStream();
        InputStream signatureInputStream = request.getPart("signature").getInputStream();
	
        java.util.Date dob = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dob = sdf.parse(dobStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        byte[] campaignLogo = toByteArray(campaignLogoInputStream);
        byte[] verificationDocuments = toByteArray(verificationDocumentsInputStream);
        byte[] candidatePhoto = toByteArray(candidatePhotoInputStream);
        byte[] signature = toByteArray(signatureInputStream);

        Candidate candidate = new Candidate();
        candidate.setElectionId(electionId);
        candidate.setFullName(fullName);
        candidate.setUsername(username);
        candidate.setPassword(password); 
        candidate.setEmail(email);
        candidate.setDob(dob);
        candidate.setAddress(address);
        candidate.setPhoneNumber(phoneNumber);
        candidate.setVoterId(voterId);
        candidate.setCandidateStatement(candidateStatement);
        candidate.setCampaignLogo(campaignLogo);
        candidate.setPoliticalParty(politicalParty);
        candidate.setElectionPosition(electionPosition);
        candidate.setCampaignLinks(campaignLinks);
        candidate.setVerificationDocuments(verificationDocuments);
        candidate.setCampaignSlogan(campaignSlogan);
        candidate.setCampaignPlatform(campaignPlatform);
        candidate.setCandidatePhoto(candidatePhoto);
        candidate.setSignature(signature);

        boolean registrationSuccess = false;
		try {
			registrationSuccess = CandidateDAO.registerCandidate(candidate);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        if (registrationSuccess) {
            response.sendRedirect("candidateRegistrationSuccess.jsp");
        } else {
            response.sendRedirect("candidateRegistrationError.jsp");
        }
    
	}
    private byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        return byteArrayOutputStream.toByteArray();
    }
	

}
