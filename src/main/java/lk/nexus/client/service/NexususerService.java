package lk.nexus.client.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.client.models.Nexususerlogin;
import lk.nexus.client.models.Nexususers;
import lk.nexus.client.repository.NexususerloginRepository;
import lk.nexus.client.repository.NexususersRepository;



@Service
@Transactional
public class NexususerService {

	@Autowired
	NexususerloginRepository nexLogRepo;

	@Autowired
	NexususersRepository nexRepo;

	public Nexususers authenticateNexusHomeUser(String username, String password) {

		Nexususerlogin nexusLogin = nexLogRepo.getUser(username);
		Nexususers nexuser= null;
		if(nexusLogin != null) {
		System.out.println("-----getNexusUser----------");
		if(nexusLogin.getPassword().equals(password)) {
			
			nexuser = nexRepo.findById(nexusLogin.getId()).get();
		}
		}
		return nexuser;
		
	}

	
}
