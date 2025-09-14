package lk.nexus.client.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.client.models.Pickuprequest;
import lk.nexus.client.repository.PickuprequestRepository;

@Service
@Transactional
public class PickuprequestService {

	@Autowired
	private PickuprequestRepository repo;
	
	public void sendPickupRequest(Pickuprequest picreq) {
		
		repo.save(picreq);
	}
	
	
}
