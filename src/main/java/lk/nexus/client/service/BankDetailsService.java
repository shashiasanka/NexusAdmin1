package lk.nexus.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.client.models.Bankbranchdetails;
import lk.nexus.client.models.Bankdetails;
import lk.nexus.client.repository.BankbranchdetailsRepository;
import lk.nexus.client.repository.BankdetailsRepository;

@Service
@Transactional
public class BankDetailsService {

	@Autowired
	BankbranchdetailsRepository bankBranchRepo;
	
	@Autowired
	BankdetailsRepository bankRepo;
	
	
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
	
//	public List<Bankdetails> getBankListService(){
//		
//		
//		return bankRepo.findAll();
//	}
	
	
}
