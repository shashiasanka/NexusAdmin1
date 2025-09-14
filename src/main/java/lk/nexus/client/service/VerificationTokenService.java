package lk.nexus.client.service;

import java.util.Calendar;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lk.nexus.client.models.VerificationToken;
import lk.nexus.client.repository.RegisterDataRepository;
import lk.nexus.client.repository.VerificationTokenRepository;

@Service
@Transactional
public class VerificationTokenService {

	@Autowired
	VerificationTokenRepository verfRepoService;
	
	@Autowired
	RegisterDataRepository regrepoService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public VerificationToken createVerificationTokenforUser(String username, String toEmailaddress, String accountid) {
		
		String token = UUID.randomUUID().toString();
		//VerificationToken v = new VerificationToken(token, username,accountid);
		
		VerificationToken v = new VerificationToken(token, toEmailaddress,accountid);
		
		 SimpleMailMessage msg = new SimpleMailMessage();   
		
		 verfRepoService.save(v);
		
		return v;
	}
	
public VerificationToken createVerificationTokenforUser1(String token) {
		
//		String token = UUID.randomUUID().toString();
//		VerificationToken v = new VerificationToken(token, username);
//		
		// SimpleMailMessage msg = new SimpleMailMessage();
	    
		
		//.sa
	System.out.println("*******"+token);
	
	VerificationToken v = null;
	try {
		 v =verfRepoService.getTheTokenDetails(token);		
		
		Calendar calendar = Calendar.getInstance();
		if((v.getExpiryDate().getTime()-calendar.getTime().getTime())<=0) {
			
			System.out.println("EXPIRED"+v.getAccountid());
			//regrepoService.updateCustomerRegisterStatus("Y", v.getAccountid());
			v.setIsexpired("Y");
		}else {
			//regrepoService.findById("");
			System.out.println("NOT EXPIRED"+v.getAccountid());
			//regrepoService.updateCustomerRegisterStatus("Y", v.getAccountid());
			v.setIsexpired("N");
		}
		
		System.out.println("###"+v.toString());
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return v;
		
	}
	
	
	
	
	
	
}
