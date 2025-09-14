package lk.nexus.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.client.models.Branchdemaction;
import lk.nexus.client.models.Branchdetails;
import lk.nexus.client.repository.BranchdemactionRepository;
import lk.nexus.client.repository.BranchdetailsRepository;

@Service
@Transactional
public class BranchdetailsService {

	@Autowired
	private BranchdetailsRepository branchRepo;
	
	@Autowired
	private BranchdemactionRepository branchDemacationRepo;
	
	public List<Branchdetails> getBranchList(){		
		
		return (List<Branchdetails>) branchRepo.findAll();
	}
	
	
	
public List<Branchdemaction> getNearestCityList(String branchcode){
		
	List<Branchdemaction> branchDemacationList = null;
	
	branchDemacationList = branchDemacationRepo.listBranchdemactionByBranchCode(branchcode);
		
	return branchDemacationList;
		
	}
	
	
}
