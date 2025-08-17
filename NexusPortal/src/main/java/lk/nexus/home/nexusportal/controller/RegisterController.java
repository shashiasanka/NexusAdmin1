package lk.nexus.home.nexusportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import lk.nexus.home.nexusportal.dto.PaymentTypeDto;
import lk.nexus.home.nexusportal.dto.RegisterDto;
import lk.nexus.home.nexusportal.dto.SmsAlertDto;
import lk.nexus.home.nexusportal.models.Clientloging;
import lk.nexus.home.nexusportal.models.Register;
import lk.nexus.home.nexusportal.repository.RegisterDataRepository;
import lk.nexus.home.nexusportal.service.BankDetailsService;
import lk.nexus.home.nexusportal.service.BranchdetailsService;
import lk.nexus.home.nexusportal.service.RegisterService;
import lk.nexus.home.nexusportal.util.NexusPortalUtil;


@Controller
public class RegisterController {
	@Autowired
	RegisterDataRepository registerRepo;
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	BranchdetailsService branchService;

	@Autowired
	BankDetailsService bankDetailsService;

	
	@GetMapping("/register")
public String greetingForm(Model model,HttpSession session) {
	    model.addAttribute("registerData", new Register());
	   //return "registerpage1";
	  //  repository.save(new Expense("breakfast", 5));
		//repository.save(new Expense("coffee", 2));
		//repository.save(new Expense("New SSD drive", 200));
		//repository.save(new Expense("Tution for baby", 350));
		//repository.save(new Expense("Some apples", 5));
	    return "registerpage";
	 //  return "reg";
	  }
	
	
	@PostMapping("/registerdetails")
	  public String greetingSubmit(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
	    model.addAttribute("registerData", registerData);
	    HttpSession session = request.getSession(true);
	    session.setAttribute("registerData", registerData);
	    
	    System.out.println("-----------registerdetails==="+registerData.toString());
	    
	    //return "registerpage";
	   // return "regiter/register_businesstypes";
	    return "regiter/register_account";
	  }
	
	
	@PostMapping("/registerdetails2")
	  public String greetingSubmit2(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
	    model.addAttribute("registerData", registerData);
	
	    if(registerData.getAccouttype().equals("I")) {
	    	HttpSession session = request.getSession(false);
	    	Register registerDatases = (Register)session.getAttribute("registerData");
	    	registerDatases.setSystemname(registerData.getSystemname());
	    	registerDatases.setNic_drivinglicence(registerData.getNic_drivinglicence());
	    	registerDatases.setContactno(registerData.getContactno());
	    	
	    	session.setAttribute("registerData", registerDatases);
	    	System.out.println("registerData222:::"+registerDatases.toString());
	    	//systemName nic_drivinglicence contactno
	    }else if(registerData.getAccouttype().equals("B")) {
	    	
	    	//contactno=,0718362670, brno=jhjhjhkjkjkkkjll, contactperson=CCCCCCCC, businessName=bbbbbbbb]
	    	HttpSession session = request.getSession(false);
	    	Register registerDatases = (Register)session.getAttribute("registerData");
	    	
	    	registerDatases.setContactno(registerData.getContactno());
	    	registerDatases.setBrno(registerData.getBrno());
	    	registerDatases.setBusinessname(registerData.getBusinessname());
	    	registerDatases.setContactperson(registerData.getContactperson());   	
	    	
	    	session.setAttribute("registerData", registerDatases);
	    	
	    	System.out.println("registerData222:::"+registerData.toString());
	    }
	    
	    
	    System.out.println("----------------------------------------------------");
	    System.out.println("----------------------------------------------------"+registerData.toString());
	    
	    //return "registerpage";
	    return "regiter/register_account";
	  }
	
	
	
	@PostMapping("/registerdetails3")
	  public String greetingSubmit3(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
	    model.addAttribute("registerData", registerData);
	
	    HttpSession session = request.getSession(false);
  	Register registerDatases = (Register)session.getAttribute("registerData");
  	
  	registerDatases.setBankname(registerData.getBankname());
  	registerDatases.setAccountholdername(registerData.getAccountholdername());
  	registerDatases.setBankaccounttype(registerData.getBankaccounttype());
  	registerDatases.setBankaccountbranch(registerData.getBankaccountbranch());
  	//registerDatases.setAccountNo(registerData.getAccountNo());
  	
  	//Customer c= new Customer("asdsa", "werwer");
  //	reg.save(c);
  	session.setAttribute("registerData", registerDatases);
  	 System.out.println("====="+registerDatases.toString());
  	//registerRepo.save(registerDatases);
	    System.out.println("----------------------------------------------------");
	   
	    
	    //return "registerpage";
	    return "regiter/register_loging";
	  }
	
	
	
	@PostMapping("/registerdetails4")
	  public String greetingSubmit4(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
	    //model.addAttribute("registerData", registerData);
	
	    HttpSession session = request.getSession(false);
	Register registerDatases = (Register)session.getAttribute("registerData");
	Clientloging log= new Clientloging();
	//log.setClientid(registerDatases.getAccountNo());
//	log.setUsername(registerData.getUsername());
//	log.setPassword(registerData.getPassword());
//	log.setLoginstatus("A"); log.setClientrole("B");
//	log.setClientbusinessname(registerDatases.getFullname_businessname());
//	//registerDatases.setUsername(registerData.getUsername());
//	registerDatases.setPassword("");
//	registerDatases.setConfirmpassword("");
	//registerDatases.setClientloging(log);
	 System.out.println("====="+registerDatases.toString());
	//registerRepo.save(registerDatases);
	 registerService.registerClient(registerDatases);
	    System.out.println("----------------------------------------------------");
	    Register reg= new Register();
	    reg.setIsregistersuccess("Y");
	    model.addAttribute("registerData", reg);
		
	   return "registerpage";
	 //   return "regiter/register_account";
	  }

	
	@GetMapping("/pendigregister")
public String loadprendingregister(Model model,HttpSession session) {
	    model.addAttribute("registerData", new Register());
	    model.addAttribute("pendingregister", registerService.listPendingRegisterrequestService());
	    ;
	   // return "registerlist";
	    return "nexusportal_pendingrequest_list";
	    
	 //  return "reg";
	  }
	
	
	@PostMapping("/pendigregisterdetails")
	public String loadprendingregisterDetails(Model model,HttpSession session, @RequestParam("id") Long id) {
			
		RegisterDto r = registerService.getRegisterDetails(id);
	
		System.out.println("pendigregisterdetails:::"+r.toString());
	model.addAttribute("registerData",r);
	
	if(registerService.isExsistAccountId(r.getAccountid())) {
		model.addAttribute("alreadyexsist","Y");
	}else {
		model.addAttribute("alreadyexsist","N");
	}
	//return "pendingregisterdetails_p";
	
		
	try {
		System.out.println("Bank Code :"+r.getBankName());
		System.out.println("Bank BR Code :"+r.getBankAccountBranch());
		
		model.addAttribute("branchlist", branchService.getBranchList());
		model.addAttribute("banklist", bankDetailsService.getBankList());
		model.addAttribute("bankbranchlist", bankDetailsService.getBranchListbyBankId(r.getBankName()));
		model.addAttribute("paymenttypelist", getPaymentTypeList());
		model.addAttribute("smstypelist", getSMSTypeList());
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "nexusportal_pendingrequest";
		 //  return "reg";
		  }
	
	@GetMapping("/updateRateType")
	public String wwwww(Model model,HttpSession session, @RequestParam("ratetype") String ratetype,  @RequestParam("regid") Long regid) {
		
	registerService.updateRateTypeService(ratetype, regid);
		    return "qqq";
		 //  return "reg";
		  }
	
	
	@PostMapping("/SentLoggingRequest")
	public String sentLoggingRequest(Model model,HttpSession session, @RequestParam("regid") Long regid) {
			registerService.sentLoggingRequestService(regid);
	   // model.addAttribute("registerData", new Register());
	    model.addAttribute("pendingregister", registerService.listPendingRegisterrequestService());
	    ;
	    return "registerlist";
		    //return "pendingregisterdetails_p";
		 //  return "reg";
		  }


	@PostMapping("/SentLoggingRequestX")
	public String sentLoggingRequest1(@ModelAttribute RegisterDto registerData,Model model,HttpSession session, @RequestParam("regid") Long regid,
			@RequestParam(value = "action", required = false) String action
			) {
			//registerService.sentLoggingRequestService(regid);
		System.out.println("***********************SentLoggingRequestX**ACTION "+action);
		System.out.println("***********************registerData: "+registerData.toString());
		//String retPage = "registerlist";
		String retPage = "nexusportal_pendingrequest_list";
		try {
			
			
			System.out.println("****SentLoggingRequestX ***************************************************");
			ArrayList<String> err= new ArrayList<String>();
			 err = validateRegister(registerData);
			System.out.println("ERR SIZE"+err.size());
			if(err.size() == 0) {
								
				registerService.sentLoggingRequestServiceWithData(registerData);
				
				
				Register r = new Register();
				model.addAttribute("registerstatus", "Y");
				r.setIsregistersuccess("Y");
				
				model.addAttribute("registerData", r);
				
				 model.addAttribute("registerData", new Register());
				    model.addAttribute("pendingregister", registerService.listPendingRegisterrequestService());
				    ;
				   // return "registerlist";
				    //return "nexusportal_pendingrequest_list";
				
				
			}else {					
				
				registerData.setIsregistersuccess("N");
				registerData.setErrormessage(err.toString());
				
				model.addAttribute("branchlist", branchService.getBranchList());
				model.addAttribute("banklist", bankDetailsService.getBankList());
				model.addAttribute("bankbranchlist", bankDetailsService.getBranchListbyBankId(registerData.getBankName()));
				model.addAttribute("paymenttypelist", getPaymentTypeList());
				model.addAttribute("smstypelist", getSMSTypeList());
				model.addAttribute("registerData", registerData);
				
				System.out.println("ERROR LIST "+err.toString());
				retPage ="nexusportal_pendingrequest";
				
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	   // model.addAttribute("registerData", new Register());
	   // model.addAttribute("pendingregister", registerService.listPendingRegisterrequestService());
	    
	    
	    System.out.println("SentLoggingRequestX:"+retPage);
	    
	   // return "registerlist";
		return retPage;
		    //return "pendingregisterdetails_p";
		 //  return "reg";
		  }
	private List<PaymentTypeDto> getPaymentTypeList(){
		
		ArrayList<PaymentTypeDto> paymenttypeList = new ArrayList<PaymentTypeDto>();
		
		PaymentTypeDto days3 = new PaymentTypeDto();
		days3.setPaymentTypeCode("3");
		days3.setPaymentTypeDesc("with in 3 days - additional 3% charge");
		
		PaymentTypeDto days7 = new PaymentTypeDto();
		days7.setPaymentTypeCode("7");
		days7.setPaymentTypeDesc("with in one week");
		
		PaymentTypeDto days14 = new PaymentTypeDto();
		days14.setPaymentTypeCode("14");
		days14.setPaymentTypeDesc("with in 2 week");
		
		PaymentTypeDto days31 = new PaymentTypeDto();
		days31.setPaymentTypeCode("31");
		days31.setPaymentTypeDesc("with in one month");
		
		paymenttypeList.add(days3);
		paymenttypeList.add(days7);
		paymenttypeList.add(days14);
		paymenttypeList.add(days31);
		return paymenttypeList;
	}
	
	
	private List<SmsAlertDto> getSMSTypeList(){
		
		ArrayList<SmsAlertDto> smstypeList = new ArrayList<SmsAlertDto>();
		
		SmsAlertDto smsType1 = new SmsAlertDto(); 
		smsType1.setSmsTypeCode("1");
		smsType1.setSmsTypeDesc("ON RECEVIED BY PICKUP BRANCH");
		
		SmsAlertDto smsType2 = new SmsAlertDto(); 
		smsType2.setSmsTypeCode("2");
		smsType2.setSmsTypeDesc("ON RECEIVED BY  HEAD OFFICE");
		
		SmsAlertDto smsType3 = new SmsAlertDto(); 
		smsType3.setSmsTypeCode("3");
		smsType3.setSmsTypeDesc("ON DISPATCH TO DESTINATION BRANCH");
		
		SmsAlertDto smsType4 = new SmsAlertDto(); 
		smsType4.setSmsTypeCode("4");
		smsType4.setSmsTypeDesc("ON RECEIVED AT DESTINATION BRANCH");
		
		SmsAlertDto smsType5 = new SmsAlertDto(); 
		smsType5.setSmsTypeCode("5");
		smsType5.setSmsTypeDesc("ON OUT FOR DELIVERY");
		
		SmsAlertDto smsType6 = new SmsAlertDto(); 
		smsType6.setSmsTypeCode("6");
		smsType6.setSmsTypeDesc("ON RESCHDULED AT 1ST ATTEMPT");
		
		SmsAlertDto smsType7 = new SmsAlertDto(); 
		smsType7.setSmsTypeCode("7");
		smsType7.setSmsTypeDesc("ON RESCHDULED AT 2ND ATTEMPT");
		
		SmsAlertDto smsType8 = new SmsAlertDto(); 
		smsType8.setSmsTypeCode("8");
		smsType8.setSmsTypeDesc("ON RESCHDULED AT 3RD ATTEMPT");
		
		SmsAlertDto smsType9 = new SmsAlertDto(); 
		smsType9.setSmsTypeCode("9");
		smsType9.setSmsTypeDesc("ON RETURNED");
		
		SmsAlertDto smsType10 = new SmsAlertDto(); 
		smsType10.setSmsTypeCode("10");
		smsType10.setSmsTypeDesc("ON DELIVERED");
		
		smstypeList.add(smsType1);		
		smstypeList.add(smsType2);
		smstypeList.add(smsType3);
		smstypeList.add(smsType4);		
		smstypeList.add(smsType5);
		smstypeList.add(smsType6);
		smstypeList.add(smsType7);		
		smstypeList.add(smsType8);
		smstypeList.add(smsType9);
		smstypeList.add(smsType10);
		
		return smstypeList;
	}
	
	
	
	private ArrayList<String> validateRegister(RegisterDto register) {
		ArrayList<String> err = new ArrayList<String>();

		if (register.getAccouttype().equals("s")) {

			err.add("please select account type \\\\n");
		}

		if (register.getAccouttype().equals("p")) {
//			accouttype nic_drivinglicence webstore address1 emailaddress
			if (NexusPortalUtil.isNullOrEmpty(register.getFullname_businessname())) {
				err.add("Name in Full cannot be empty \\\\n ");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getNic_drivinglicence())) {
				err.add("NIC cannot be empty \\\n");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getWebstore())) {
				err.add("Web store be empty \\\n");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getAddress1())) {
				err.add("Address cannot be empty \\\n");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getEmailaddress())) {
				err.add("Email cannot be empty \\\n");
			}
//			 pickupbranchp contactno contactno2 bankName bankAccountBranch accountHolderName
//				bankAccountType	accountid payementtype smsalert

			if (register.getPickupbranch().equals("X")) {

				err.add("Please select Pickup branch");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getContactno())) {
				err.add("Contact No cannot be empty \\\n");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getContactno2())) {
				err.add("Land Line phone No cannot be empty \\\n");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getAccountid())) {
				err.add("Account No cannot be empty ");
			}
			
			if (register.getBankName().equals("X")) {
				err.add(" Please select a Bank ");
			}
			
			if (register.getBankAccountType().equals("X")) {
				err.add(" Please select a Bank Account Type ");
			}
			if (register.getBankAccountBranch().equals("X")) {
				err.add(" Please select a Account Branch Name ");
			}
			if (NexusPortalUtil.isNullOrEmpty(register.getSmsalert())) {
				err.add("SMS Alert Cannot be empty ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getAccountHolderName())) {
				err.add("Account Holder Name Cannot be empty ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getRatetype())) {
				err.add("Please select Rate Type ");
			}
			
			
			System.out.println("****************NexusPortalUtil**************************************");
			System.out.println(register.getPayementtype());
			System.out.println(register.getSmsalert());
			if (NexusPortalUtil.isNullOrEmpty(register.getRatetype())) {
				err.add("Please select Rate Type ");
			}
//			if (NexusPortalUtil.isNullOrEmpty(register.getBankName())) {
//				err.add(" Bank Name Cannot be empty");
//			}
			// contactno contactno2

		}else {
			
			//fullname_businessname address1 emailaddress pickupbranch brno 
			
			if (NexusPortalUtil.isNullOrEmpty(register.getFullname_businessname())) {
				err.add("Name in Full cannot be empty \\\\n ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getAddress1())) {
				err.add("Address cannot be empty \\\n");
			}

			if (NexusPortalUtil.isNullOrEmpty(register.getEmailaddress())) {
				err.add("Email cannot be empty \\\n");
			}
			
			if (register.getPickupbranch().equals("X")) {

				err.add("Please select Pickup branch");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getBrno())) {
				err.add("Business Registration No Cannot be empty ");
			}
			
			//relationshiptobusiness contactperson contactpersonnic contactno
			
			if (NexusPortalUtil.isNullOrEmpty(register.getRelationshiptobusiness())) {
				err.add("Relationship to Business Cannot be empty ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getContactperson())) {
				err.add("Contact person Cannot be empty ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getContactpersonnic())) {
				err.add("Contact person Nic Cannot be empty ");
			}
			if (NexusPortalUtil.isNullOrEmpty(register.getContactno())) {
				err.add("Contact No cannot be empty ");
			}
			
			//bankName contactno2 bankAccountBranch accountHolderName bankAccountType 
			
			if (NexusPortalUtil.isNullOrEmpty(register.getContactno2())) {
				err.add("Land Line phone No cannot be empty \\\n");
			}
			
			if (register.getBankName().equals("X")) {
				err.add(" Please select a Bank ");
			}
			
			if (register.getBankAccountType().equals("X")) {
				err.add(" Please select a Bank Account Type ");
			}
			if (register.getBankAccountBranch().equals("X")) {
				err.add(" Please select a Account Branch Name ");
			}
			if (NexusPortalUtil.isNullOrEmpty(register.getAccountHolderName())) {
				err.add("Account Holder Name Cannot be empty ");
			}
			
			//accountid payementtype smsalert
			if (NexusPortalUtil.isNullOrEmpty(register.getSmsalert())) {
				err.add("SMS Alert Cannot be empty ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getAccountid())) {
				err.add("Account No cannot be empty ");
			}
			
			if (NexusPortalUtil.isNullOrEmpty(register.getRatetype())) {
				err.add("Please select Rate Type ");
			}
		}

		// fullname_businessname nic_drivinglicence address1 emailaddress pickupbranch

		return err;

//		private String fullname_businessname;
//		private String systemName;
//		private String address1;
//		private String address2;
//		private String emailaddress;
//		private String pickupbranch;
//		private String accouttype;
//		private String nic_drivinglicence;

	}
	
	
}



