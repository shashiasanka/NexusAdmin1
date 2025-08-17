package lk.nexus.home.nexusportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.models.Bankbranchdetails;
import lk.nexus.home.nexusportal.models.Bankdetails;
import lk.nexus.home.nexusportal.repository.BankbranchdetailsRepository;
import lk.nexus.home.nexusportal.repository.BankdetailsRepository;



@Service
@Transactional
public class BankDetailsService {

	@Autowired
	BankdetailsRepository bankRepo;
	
	@Autowired
	BankbranchdetailsRepository bankBranchRepo;
	
public List<Bankdetails> getBankList(){
		
		
		return (List<Bankdetails>) bankRepo.findAll();
	}
	

public List<Bankbranchdetails> getBranchListbyBankId(String bankcode){
	List<Bankbranchdetails> lst = null;
	try {
		lst = bankBranchRepo.listBankbranchdetailsByBankCode(bankcode);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return lst;
}

public List<Bankbranchdetails> getBankBranchList(){
	List<Bankbranchdetails> lst = null;
	try {
		lst = (List<Bankbranchdetails>) bankBranchRepo.findAll();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return lst;
}
	
	
}
