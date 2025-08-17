package lk.nexus.home.nexusportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.models.Branchdetails;
import lk.nexus.home.nexusportal.repository.BranchdetailsRepository;



@Service
@Transactional
public class BranchdetailsService {

	@Autowired
	private BranchdetailsRepository branchRepo;

public List<Branchdetails> getBranchList(){		
		
		return (List<Branchdetails>) branchRepo.findAll();
	}
	
	
}
