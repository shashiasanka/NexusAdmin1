package lk.nexus.home.nexusportal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.models.Clientorder;
import lk.nexus.home.nexusportal.repository.ClientorderRepository;


@Service
@Transactional
public class ClientorderService {

	@Autowired
	private ClientorderRepository repo;
	

	public void createClientOrder(Clientorder order) {
		
		try {
			repo.save(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
