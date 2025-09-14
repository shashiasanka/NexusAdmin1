package lk.nexus.client.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import lk.nexus.client.dto.ClientlogingDto;
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientregister;
import lk.nexus.client.models.VerificationToken;
import lk.nexus.client.repository.ClientlogingRepository;
import lk.nexus.client.repository.ClientregisterRepository;
import lk.nexus.client.repository.VerificationTokenRepository;

@Service
@Transactional
public class ClientLogingService {

	@Autowired
	private ClientlogingRepository repo;
	
	@Autowired
	VerificationTokenRepository verfRepoService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
    ClientregisterRepository clientregisterRepo;
	
	public ClientlogingDto getUserloging(String username,String password) {
		Clientloging client = null;
		ClientlogingDto clientdto = null;
		try {
			 client = (Clientloging) repo.findById(username).get();
			 
			 if(client.getPassword().equals(password)) {
				 clientdto = new ClientlogingDto();
				 
				 clientdto.setClientbusinessname(client.getClientbusinessname()); 
				 clientdto.setClientid(client.getClientid());
				 clientdto.setClientrole(client.getClientrole());
				 clientdto.setLoginstatus(client.getLoginstatus());
				 clientdto.setUsername(client.getUsername());
				 
				 Clientregister cliRegister = (Clientregister) clientregisterRepo.findById(client.getClientid()).get();
				 
				 clientdto.setPickupbranch(cliRegister.getPickupbranch());
				 
				 
				 
			 }else {
				 client = null; 
				 
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return clientdto;
	}
	
	
	public void createClientLogingService( String username, String password, String passwordconf,String vtoken) {
		
		
		VerificationToken v  =verfRepoService.getTheTokenDetails(vtoken);	
		
		v.getRegseq();
	}
	
	
	
	
}
