package lk.nexus.home.nexusportal.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import lk.nexus.home.nexusportal.dao.NexusUserDao;
import lk.nexus.home.nexusportal.joindto.NexususerDTO;
import lk.nexus.home.nexusportal.models.Nexususerlogin;
import lk.nexus.home.nexusportal.models.Nexususerroles;
import lk.nexus.home.nexusportal.models.Nexususers;
import lk.nexus.home.nexusportal.repository.NexususerloginRepository;
import lk.nexus.home.nexusportal.repository.NexususersRepository;
import lk.nexus.home.nexusportal.util.NexusPortalUtil;



@Service
@Transactional
public class NexususerService {

	@Autowired
	NexususersRepository nexRepo;

	@Autowired
	NexususerloginRepository nexLogRepo;

	@Autowired
	NexusPortalUtil portalUtil;
	
	@Autowired
	NexusUserDao nexusUserDao;
	
	public void registerUser(Nexususers nexuser) {

		nexRepo.save(nexuser);
	}

	public void nexLogUser(Nexususerlogin nexuser) {

		nexLogRepo.save(nexuser);
	}
	
	
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
	
	public List<NexususerDTO> getNexususersList(){
		    
		List<NexususerDTO> nexususerDTOList =null;
		try {
			List<Nexususers>  nexuUserList =	(List<Nexususers>) nexRepo.findAll();			
			nexususerDTOList = portalUtil.convertNexususerToNexususersDTOList(nexuUserList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nexususerDTOList;
		
	} 
	
	
	public List<NexususerDTO> getNexususersLogingList(){
	    
		List<NexususerDTO> nexususerDTOList =null;
		try {
			List<Nexususerlogin>  nexuUserList =	(List<Nexususerlogin>) nexLogRepo.findAll();			
			nexususerDTOList = portalUtil.convertNexususerloginToNexususersDTOList(nexuUserList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nexususerDTOList;
		
	} 
	
	
	
	public List<NexususerDTO> getNexusLogingUsersService(){
		
		List<NexususerDTO> nexususerDTOList = nexusUserDao.getNexusLogingUsers1();
		
		return nexususerDTOList;
		
	}
	
	
	
public List<NexususerDTO> getNexusUsersService() {
		
		List<NexususerDTO> nexususerDTOList = nexusUserDao.getNexusUsers1();
		
		return nexususerDTOList;
}


public NexususerDTO getNexusLogingUsersbyEmpIdService(String empid) {
	
	//List<NexususerDTO> nexususerDTOList = nexusUserDao.getNexusLogingUsersbyEmpId1(empid);
	NexususerDTO nexususerDTO = nexusUserDao.getNexusUsersbyEmpId(empid);
	System.out.println("getNexusLogingUsersbyEmpIdService********"+nexususerDTO.toString());
	
	return nexususerDTO;
}


public void createNexusUserService( NexususerDTO nexusUserData) {
	
	 NexusPortalUtil npu = new NexusPortalUtil();
	 System.out.println("+++++++++++createNexusUserService START++++++++++++++");
	 Nexususerlogin nexuslogingUser = npu.convertNexususersdtoToNexususerlogin(nexusUserData);
	 nexuslogingUser.setNexusstatus("A");
	 nexLogRepo.save(nexuslogingUser);
	 System.out.println("+++++++++++createNexusUserService END++++++++++++++");
}

public ArrayList<Nexususerroles> getNexusUserRoleListService() {
	
	
	return nexusUserDao.getNexusUserRoleList();
	
}



}
