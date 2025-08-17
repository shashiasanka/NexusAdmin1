package lk.nexus.home.nexusportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.joindto.PickupJoinDto;
import lk.nexus.home.nexusportal.models.Pickuprequest;
import lk.nexus.home.nexusportal.repository.PickupDetailsRepository;
import lk.nexus.home.nexusportal.repository.PickuprequestRepository;


@Service
@Transactional
public class PickuprequestService {

	@Autowired
	private PickuprequestRepository repo;

	@Autowired
	private PickupDetailsRepository picdetrepo;

	public void sendPickupRequest(Pickuprequest picreq) {

		repo.save(picreq);
	}

	// @Query("SELECT new
	// lk.nexus.home.joindto.PickupJoinDto(e.fullname_businessname, d.pickuptime)
	// FROM Pickuprequest d INNER JOIN p.register e ")
	public List<PickupJoinDto> getAllPickuprequests() {

		List<PickupJoinDto> l = picdetrepo.getAllItems();
		
		System.out.println("::"+l.toString());
		return l;
	}
//	

}
