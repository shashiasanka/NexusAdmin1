package lk.nexus.client.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.client.repository.ClientorderRepository;

@Service
@Transactional
public class TrackingIdService {

	@Autowired
	private ClientorderRepository repo;
	
	public String getTrackingId() {
		
		
		boolean isexsist = false;
		try {
			
			System.out.println("order.getOrdertrackingid()"+"");
			isexsist = repo.existsById("");
			
			while(!isexsist) {
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
}
