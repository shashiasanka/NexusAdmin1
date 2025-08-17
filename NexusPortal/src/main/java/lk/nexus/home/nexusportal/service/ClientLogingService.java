package lk.nexus.home.nexusportal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.models.Clientloging;
import lk.nexus.home.nexusportal.repository.ClientlogingRepository;


@Service
@Transactional
public class ClientLogingService {

	@Autowired
	private ClientlogingRepository repo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public Clientloging getUserloging(String username,String password) {
		Clientloging client = null;
		try {
			 client = (Clientloging) repo.findById(username).get();
			 
			 if(client.getPassword().equals(password)) {
				 
				 
			 }else {
				 client = null; 
				 
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return client;
	}
	
}
