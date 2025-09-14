package lk.nexus.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientregister;
import lk.nexus.client.models.Ratecode;
import lk.nexus.client.models.Register;
import lk.nexus.client.models.VerificationToken;
import lk.nexus.client.repository.ClientlogingRepository;
import lk.nexus.client.repository.ClientregisterRepository;
import lk.nexus.client.repository.RatecodeRepository;
import lk.nexus.client.repository.RegisterDataRepository;
import lk.nexus.client.repository.VerificationTokenRepository;

@Service
@Transactional
public class RegisterService {

	@Autowired
	private RegisterDataRepository registerRepo;
	
	@Autowired
	private ClientlogingRepository logingRepo;
	
	  @Autowired
	  private JavaMailSender javaMailSender;
	  
	  @Autowired
	  private RatecodeRepository raterepo;
	  
	  @Autowired
		VerificationTokenRepository verfRepoService;
	  
	@Autowired
	ClientregisterRepository clientRegisterRepo;
	
	public void registerClient(Register registerData,Clientloging log) {
		
		registerRepo.save(registerData);
		logingRepo.save(log);
		System.out.println("RegisterService"+registerData.getEmailaddress());
		sendEmail(registerData.getEmailaddress());
		
		
	}
	
public void registerClientdetails(Register registerData) {
		
	try {
		//System.out.println("getBankAccountBranch"+registerData.getBankAccountBranch());
		registerRepo.save(registerData);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
		//logingRepo.save(log);
		//System.out.println("RegisterService"+registerData.getEmailaddress());
	try {
		sendEmail(registerData.getEmailaddress());
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
		
	}
	 void sendEmail(String emailaddress) {
		 System.out.println("sendEmail:::::"+emailaddress);
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(emailaddress);

	        msg.setSubject("Testing from Spring Boot");
	        msg.setText("Hello World \n Spring Boot Email");

	        javaMailSender.send(msg);

	    }
	
	 
	 
	 public List<Ratecode> getRatecodeList(String branchcode, String ratetype){
		 
		 List<Ratecode> ratelist = null;
		 try {
			 ratelist = raterepo.listratecode(branchcode, ratetype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return ratelist; 
	 }
	 
	
	 
	 public void registerConfirmantionService(String username,String password, String token) {
			
			
		 //boolean x =isExsistUsername(username);
		 System.out.println("*******registerConfirmantionService*****************");
		 VerificationToken v = verfRepoService.getTheTokenDetails(token);
			 
		   Register r = registerRepo.findById(v.getRegseq()).get();
			System.out.println(r.toString());
			
			Clientregister clientdetails = getClientregisterDetails(r);
			
			clientRegisterRepo.save(clientdetails);
			
			Clientloging clLoging = new Clientloging();
			clLoging.setClientbusinessname(clientdetails.getFullname_businessname());
			clLoging.setClientid(clientdetails.getAccountid());
			clLoging.setClientrole("R");
			clLoging.setLoginstatus("A");
			clLoging.setPassword(password);
			clLoging.setUsername(username);
			
			
			logingRepo.save(clLoging);
			//Clientloging
			
			System.out.println("*******registerConfirmantionService2222*****************");
		}
	 
	 
	 
	 
	 public boolean isExsistUsername(String username) {
		 boolean retFlag = false;
			Clientloging client = null;

			try {
				client = (Clientloging) logingRepo.findById(username).get();
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			 
			
			 
			 if(client == null) {
			
				
				 
			 }else {
				 retFlag = true;
				
			 }
		return retFlag;
		 
		 
	 }
	
	 
	 private Clientregister getClientregisterDetails(Register r) {
		 
		 Clientregister c = new Clientregister();
		 c.setAccountid(r.getAccountid());	
		 c.setAccouttype(r.getAccouttype());
		 c.setAddress1(r.getAddress1());
		 
		 c.setBank_account_branch(r.getBankaccountbranch());
		 c.setBank_account_holder_name(r.getAccountholdername());
		 c.setBank_account_no(r.getAccountid());
		 
		 c.setBank_account_type(r.getAccouttype());
		 c.setBank_name(r.getBankname());
		
		 
		 
		 c.setCity(r.getCity());
		 c.setClientreferential(r.getClientreferential());
		 c.setContactno(r.getContactno());
		 c.setContactno2(r.getContactno2());
		 
		 c.setEmailaddress(r.getEmailaddress());
		 c.setFullname_businessname(r.getFullname_businessname());
		 c.setNic_drivinglicence(r.getNic_drivinglicence());
		 c.setPayementtype(r.getPayementtype());
		 c.setPickupbranch(r.getPickupbranch());
		 c.setRatetype(r.getRatetype());
		 c.setSmsalert(r.getSmsalert());
		// c.setSystem_name(r.getSystemName());
		 c.setWebstore(r.getWebstore());
		 if(r.getAccouttype().equals("b")) {
			 
			 //c.setBusiness_name(r.get);
			 c.setBusregno(r.getBrno());
			 c.setContactperson(r.getContactperson());
			 c.setContactpersonnic(r.getContactpersonnic());
			 
			 c.setFullname_businessname(r.getBusinessname());
			 c.setNic_drivinglicence(r.getContactpersonnic());
			 c.setRelationshiptobusiness(r.getRelationshiptobusiness());
		 }
		 
		 
		 
	return c;	 
	 }
	 
	 
	 
	 
	 public boolean isExsistAccountId(String accountId) {
		 boolean retFlag = false;
		 Clientregister client = null;

			try {
				client = (Clientregister) clientRegisterRepo.findById(accountId).get();
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			 
			 if(client == null) {
			
				
				 
			 }else {
				 retFlag = true;
				
			 }
		return retFlag;
		 
		 
	 }
	
	 
}
