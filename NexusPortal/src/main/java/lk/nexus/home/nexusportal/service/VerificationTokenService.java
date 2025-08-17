package lk.nexus.home.nexusportal.service;

import java.util.Calendar;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.models.VerificationToken;
import lk.nexus.home.nexusportal.repository.RegisterDataRepository;
import lk.nexus.home.nexusportal.repository.VerificationTokenRepository;


@Service
@Transactional
public class VerificationTokenService {

	@Autowired
	VerificationTokenRepository verfRepoService;
	
	@Autowired
	RegisterDataRepository regrepoService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public VerificationToken createVerificationTokenforUser(String username, String toEmailaddress, String accountid, Long id) {
		
		String token = UUID.randomUUID().toString();
		VerificationToken v = new VerificationToken(token, username,accountid,id);
		
		 SimpleMailMessage msg = new SimpleMailMessage();
	    
		
		 verfRepoService.save(v);
		
		return v;
	}
	
public void createVerificationTokenforUser1(String token) {
		

	System.out.println("*******"+token);
	try {
		VerificationToken v =verfRepoService.getTheTokenDetails(token);
		
		Calendar calendar = Calendar.getInstance();
		if((v.getExpiryDate().getTime()-calendar.getTime().getTime())<=0) {
			
			System.out.println("EXPIRED"+v.getAccountid());
			regrepoService.updateCustomerRegisterStatus("Y", v.getAccountid());
		}else {
			//regrepoService.findById("");
			System.out.println("NOT EXPIRED"+v.getAccountid());
			regrepoService.updateCustomerRegisterStatus("Y", v.getAccountid());
		}
		
		System.out.println("###"+v.toString());
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
		
	}
	
	
	
	
	
	
}
