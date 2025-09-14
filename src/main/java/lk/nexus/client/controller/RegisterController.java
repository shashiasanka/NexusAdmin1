package lk.nexus.client.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import lk.nexus.client.dto.TrackingId;
import lk.nexus.client.events.OnRegistrationSuccessEvent;
import lk.nexus.client.models.Bankbranchdetails;
import lk.nexus.client.models.Branchdemaction;
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Ratecode;
import lk.nexus.client.models.Register;
import lk.nexus.client.models.VerificationToken;
import lk.nexus.client.repository.RegisterDataRepository;
import lk.nexus.client.service.BankDetailsService;
import lk.nexus.client.service.BranchdetailsService;
import lk.nexus.client.service.RegisterService;
import lk.nexus.client.service.VerificationTokenService;
import lk.nexus.client.util.NexusClientUtil;

@Controller
public class RegisterController {
	@Autowired
	RegisterDataRepository registerRepo;

	@Autowired
	RegisterService registerService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	VerificationTokenService verifyService;

	@Autowired
	BranchdetailsService branchService;

	@Autowired
	BankDetailsService bankDetailsService;

	@GetMapping("/register")
	public String greetingForm(Model model, HttpSession session) {
		model.addAttribute("registerData", new Register());

		try {
			model.addAttribute("branchlist", branchService.getBranchList());
			model.addAttribute("banklist", bankDetailsService.getBankList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return "registerpage1";
		// repository.save(new Expense("breakfast", 5));
		// repository.save(new Expense("coffee", 2));
		// repository.save(new Expense("New SSD drive", 200));
		// repository.save(new Expense("Tution for baby", 350));
		// repository.save(new Expense("Some apples", 5));
		// return "registerpage";
		// return "registerpage011";
		return "registerpage2603";
		// return "reg";
	}

	@PostMapping("/registerdetails")
	public String greetingSubmit(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
		model.addAttribute("registerData", registerData);
		HttpSession session = request.getSession(true);
		session.setAttribute("registerData", registerData);

		System.out.println("-----------registerdetails===" + registerData.toString());

		// return "registerpage";
		// return "regiter/register_businesstypes";
		return "regiter/register_account";
	}

	/*
	 * @PostMapping("/registerdetails2") public String
	 * greetingSubmit2(@ModelAttribute Register registerData, Model model,
	 * HttpServletRequest request) { model.addAttribute("registerData",
	 * registerData);
	 * 
	 * if(registerData.getAccouttype().equals("I")) { HttpSession session =
	 * request.getSession(false); Register registerDatases =
	 * (Register)session.getAttribute("registerData");
	 * registerDatases.setSystemName(registerData.getSystemName());
	 * registerDatases.setNic_drivinglicence(registerData.getNic_drivinglicence());
	 * registerDatases.setContactno(registerData.getContactno());
	 * 
	 * session.setAttribute("registerData", registerDatases);
	 * System.out.println("registerData222:::"+registerDatases.toString());
	 * //systemName nic_drivinglicence contactno }else
	 * if(registerData.getAccouttype().equals("B")) {
	 * 
	 * //contactno=,0718362670, brno=jhjhjhkjkjkkkjll, contactperson=CCCCCCCC,
	 * businessName=bbbbbbbb] HttpSession session = request.getSession(false);
	 * Register registerDatases = (Register)session.getAttribute("registerData");
	 * 
	 * registerDatases.setContactno(registerData.getContactno());
	 * registerDatases.setBrno(registerData.getBrno());
	 * registerDatases.setBusinessName(registerData.getBusinessName());
	 * registerDatases.setContactperson(registerData.getContactperson());
	 * 
	 * session.setAttribute("registerData", registerDatases);
	 * 
	 * System.out.println("registerData222:::"+registerData.toString()); }
	 * 
	 * 
	 * System.out.println("----------------------------------------------------");
	 * System.out.println("----------------------------------------------------"+
	 * registerData.toString());
	 * 
	 * //return "registerpage"; return "regiter/register_account"; }
	 * 
	 * 
	 * 
	 * @PostMapping("/registerdetails3") public String
	 * greetingSubmit3(@ModelAttribute Register registerData, Model model,
	 * HttpServletRequest request) { model.addAttribute("registerData",
	 * registerData);
	 * 
	 * HttpSession session = request.getSession(false); Register registerDatases =
	 * (Register)session.getAttribute("registerData");
	 * 
	 * registerDatases.setBankName(registerData.getBankName());
	 * registerDatases.setAccountHolderName(registerData.getAccountHolderName());
	 * registerDatases.setBankAccountType(registerData.getAccouttype());
	 * registerDatases.setBankAccountBranch(registerData.getBankAccountBranch());
	 * registerDatases.setAccountid(registerData.getAccountid());
	 * 
	 * //Customer c= new Customer("asdsa", "werwer"); // reg.save(c);
	 * session.setAttribute("registerData", registerDatases);
	 * System.out.println("====="+registerDatases.toString());
	 * //registerRepo.save(registerDatases);
	 * System.out.println("----------------------------------------------------");
	 * 
	 * 
	 * //return "registerpage"; return "regiter/register_loging"; }
	 * 
	 * 
	 * 
	 * @PostMapping("/registerdetails4") public String
	 * greetingSubmit4(@ModelAttribute Register registerData, Model model,
	 * HttpServletRequest request) { //model.addAttribute("registerData",
	 * registerData);
	 * 
	 * HttpSession session = request.getSession(false); Register registerDatases =
	 * (Register)session.getAttribute("registerData"); Clientloging log= new
	 * Clientloging(); log.setClientid(registerDatases.getAccountid());
	 * log.setUsername(registerData.getUsername());
	 * log.setPassword(registerData.getPassword()); log.setLoginstatus("A");
	 * log.setClientrole("B");
	 * log.setClientbusinessname(registerDatases.getFullname_businessname());
	 * //registerDatases.setUsername(registerData.getUsername());
	 * registerDatases.setPassword(""); registerDatases.setConfirmpassword("");
	 * //registerDatases.setClientloging(log);
	 * System.out.println("====="+registerDatases.toString());
	 * //registerRepo.save(registerDatases);
	 * registerService.registerClient(registerDatases,log);
	 * System.out.println("----------------------------------------------------");
	 * Register reg= new Register(); reg.setIsregistersuccess("Y");
	 * 
	 * // registerDatases model.addAttribute("registerData", reg);
	 * 
	 * try { String appUrl = request.getContextPath();
	 * eventPublisher.publishEvent(new OnRegistrationSuccessEvent(registerDatases,
	 * request.getLocale(),appUrl)); }catch(Exception re) { re.printStackTrace(); //
	 * throw new Exception("Error while sending confirmation email"); } return
	 * "registerpage"; // return "regiter/register_account"; }
	 * 
	 * 
	 * 
	 * @PostMapping("/registercustomer") public String
	 * registerCustomer(@ModelAttribute Register registerData, Model model,
	 * HttpServletRequest request) { //model.addAttribute("registerData",
	 * registerData);
	 * 
	 * HttpSession session = request.getSession(false);
	 * 
	 * Clientloging log= new Clientloging();
	 * log.setClientid(registerData.getAccountid());
	 * log.setUsername(registerData.getUsername());
	 * log.setPassword(registerData.getPassword()); log.setLoginstatus("A");
	 * log.setClientrole("B");
	 * log.setClientbusinessname(registerData.getFullname_businessname());
	 * //registerDatases.setUsername(registerData.getUsername());
	 * registerData.setPassword(""); registerData.setConfirmpassword("");
	 * //registerData.setClientloging(log); //
	 * System.out.println("====="+registerDatases.toString());
	 * //registerRepo.save(registerDatases);
	 * registerService.registerClient(registerData,log);
	 * System.out.println("----------------------------------------------------");
	 * Register reg= new Register(); reg.setIsregistersuccess("Y");
	 * 
	 * // registerDatases model.addAttribute("registerData", reg);
	 * 
	 * try { String appUrl = request.getContextPath();
	 * eventPublisher.publishEvent(new OnRegistrationSuccessEvent(registerData,
	 * request.getLocale(),appUrl)); }catch(Exception re) { re.printStackTrace(); //
	 * throw new Exception("Error while sending confirmation email"); } // return
	 * "registerpage"; return "registerpage01"; // return
	 * "regiter/register_account"; }
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping("/confirmRegistration") public String
	 * confirmRegistration(WebRequest request, Model model,@RequestParam("token")
	 * String token) { // Locale locale=request.getLocale(); // VerificationToken
	 * verificationToken = service.getVerificationToken(token); //
	 * if(verificationToken == null) { // String message =
	 * messages.getMessage("auth.message.invalidToken", null, locale); //
	 * model.addAttribute("message", message); // return "redirect:access-denied";
	 * // } // User user = verificationToken.getUser(); // Calendar calendar =
	 * Calendar.getInstance(); //
	 * if((verificationToken.getExpiryDate().getTime()-calendar.getTime().getTime())
	 * <=0) { // String message = messages.getMessage("auth.message.expired", null,
	 * locale); // model.addAttribute("message", message); // return
	 * "redirect:access-denied"; // } // // user.setEnabled(true); //
	 * service.enableRegisteredUser(user); // return null;.
	 * verifyService.createVerificationTokenforUser1(token.replace("\"", ""));
	 * model.addAttribute("abc", "Y"); return "registerconfirmation"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * /**
	 * 
	 * @param model
	 * 
	 * @param request
	 * 
	 * @param branchId
	 * 
	 * @return
	 */

	@RequestMapping(value = "/nearestcity", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Branchdemaction> loadNearestCity(Model model, HttpServletRequest request,
			@RequestParam("branchId") String branchId) {

		List<Branchdemaction> cityList = null;

		cityList = branchService.getNearestCityList(branchId);
		// Clientloging client= new Clientloging();
		// ReturObjectJson returJsonObject = new ReturObjectJson();
		return cityList;
		// return "client_pickuprequest";
	}

	@RequestMapping(value = "/branclist", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Bankbranchdetails> loadbranchList(Model model, HttpServletRequest request,
			@RequestParam("bankcode") String bankcode) {

		List<Bankbranchdetails> branchList = null;
		// model.addAttribute("banklist", bankDetailsService.getBranchList());
		branchList = bankDetailsService.getBranchListbyBankId(bankcode);

		return branchList;
		// return "client_pickuprequest";
	}

	@RequestMapping(value = "/defaultrate", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Ratecode> loadratecode(Model model, HttpServletRequest request,
			@RequestParam("branchId") String branchId) {

		List<Ratecode> ratelist = null;

		ratelist = registerService.getRatecodeList(branchId, "d");
		return ratelist;

	}

	@RequestMapping(value = "/fixedrate", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Ratecode> loadfixedrate(Model model, HttpServletRequest request,
			@RequestParam("branchId") String branchId) {

		List<Ratecode> ratelist = null;

		ratelist = registerService.getRatecodeList(branchId, "F");
		return ratelist;

	}

	@PostMapping("/viewagreement")
	public String viewagreement(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
		// System.out.println("****viewagreement
		// ***************************************************"+registerData.toString());
		//model.addAttribute("registerData", registerData);

	if(	registerService.isExsistAccountId(registerData.getAccountid())) {
		
		model.addAttribute("registerData", registerData);
		model.addAttribute("accexsist", "Y");
		
		try {
			model.addAttribute("branchlist", branchService.getBranchList());
			model.addAttribute("banklist", bankDetailsService.getBankList());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}else {
		try {
			System.out.println("****viewagreement ***************************************************");
			ArrayList<String> err= new ArrayList<String>();
			 err = validateRegister(registerData);
			System.out.println();
			if(err.size() == 0) {
				//${registerData.errormessage}
				registerData.setIsregistersuccess("P");
				System.out.println("****viewagreement 2222222***************************************************");

				registerService.registerClientdetails(registerData);
				// System.out.println("registerData::"+registerData.toString());
				
				Register r = new Register();
				model.addAttribute("registerstatus", "Y");
				r.setIsregistersuccess("Y");
				
				model.addAttribute("registerData", r);
				
			}else {					
				
				registerData.setIsregistersuccess("N");
				registerData.setErrormessage(err.toString());
				model.addAttribute("registerData", registerData);
				
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			model.addAttribute("branchlist", branchService.getBranchList());
			model.addAttribute("banklist", bankDetailsService.getBankList());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		// return "registerpage02";
		return "registerpage2603";

	} // viewratesheet

	@PostMapping("/loaddetailspage")
	public String loadDetailsPage(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {

		System.out.println("**************loaddetailspage***************************************************");
		String returnpage = "";
		model.addAttribute("registerData", registerData);

		HttpSession session = request.getSession(true);

		session.setAttribute("registerData", registerData);

		/*
		 * <option th:value="s">Please select Account Type</option> <option
		 * th:value="p">Personal</option> <option th:value="b">Business </option>
		 */

		if (registerData.getAccouttype().equals("s")) {
			returnpage = "registerpage011";

		} else if (registerData.getAccouttype().equals("p")) {
			try {
				model.addAttribute("branchlist", branchService.getBranchList());
				model.addAttribute("banklist", bankDetailsService.getBankList());

			} catch (Exception e) {
				e.printStackTrace();
			}
			returnpage = "registerpage_personal";
		} else {
			try {
				model.addAttribute("branchlist", branchService.getBranchList());
				model.addAttribute("banklist", bankDetailsService.getBankList());

			} catch (Exception e) {
				e.printStackTrace();
			}

			returnpage = "registerpage_business";
		}

		System.out.println("***********************loaddetailspage*******************************************");
//	    	registerData.setErrormessage(sb.toString());
		model.addAttribute("registerData", registerData);
		// return "registerpage01";
		return returnpage;
//	    }

	}

	@PostMapping("/viewratesheet")
	public String viewratesheetp(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {

		System.out.println("*******************sendregisterrequest*****************************");

		HttpSession session = request.getSession(true);

		model.addAttribute("registerData", registerData);
		session.removeAttribute("registerData");
		session.setAttribute("registerData", registerData);

		List<Ratecode> defaultratelist = null;
		List<Ratecode> fixedratelist = null;

		defaultratelist = registerService.getRatecodeList(registerData.getPickupbranch(), "d");
		fixedratelist = registerService.getRatecodeList(registerData.getPickupbranch(), "F");

		model.addAttribute("defaultratelist", defaultratelist);
		model.addAttribute("fixedratelist", fixedratelist);

		System.out.println("registerData123###::" + registerData.toString());
		// System.out.println("registerDatases::"+registerDatases.toString());
		System.out.println("*********************sendregisterrequest*******************************");
		return "registerpage03";
		// return "registerpage02";
	}
//	@PostMapping("/viewratesheetb")
//	  public String viewratesheeb(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
//		
//		
//		System.out.println("*******************sendregisterrequest*****************************");
//	    
//	    HttpSession session = request.getSession(true);
//
//	    model.addAttribute("registerData", registerData);
//	    session.removeAttribute("registerData");
//	    session.setAttribute("registerData", registerData);
//	    
//	    List<Ratecode> defaultratelist = null;
//	    List<Ratecode> fixedratelist = null;
//		
//	    
//	    defaultratelist = registerService.getRatecodeList(registerData.getPickupbranch(), "d");
//	    fixedratelist = registerService.getRatecodeList(registerData.getPickupbranch(), "F");
//	   
//	    model.addAttribute("defaultratelist", defaultratelist);
//	    model.addAttribute("fixedratelist", fixedratelist);
//	    
//	    System.out.println("registerData123###::"+registerData.toString());
//	   // System.out.println("registerDatases::"+registerDatases.toString());
//	    System.out.println("*********************sendregisterrequest*******************************");
//	    return "registerpage03";
//	    //return "registerpage02";
//	  }

	@PostMapping("/sendregisterrequest")
	public String sendregisterrequest(@ModelAttribute Register registerData, Model model, HttpServletRequest request) {
		System.out.println("****sendregisterrequest *************************************");

		HttpSession session = request.getSession(false);

		Register registerDatases = (Register) session.getAttribute("registerData");
		model.addAttribute("registerData", registerData);
		session.setAttribute("registerData", registerData);

		List<Ratecode> defaultratelist = null;
		List<Ratecode> fixedratelist = null;
		// System.out.println("RRRR::"+registerDatases.getPickupbranch());

		defaultratelist = registerService.getRatecodeList(registerDatases.getPickupbranch(), "d");
		fixedratelist = registerService.getRatecodeList(registerDatases.getPickupbranch(), "F");

		model.addAttribute("defaultratelist", defaultratelist);
		model.addAttribute("fixedratelist", fixedratelist);
		// registerDatases.setRatetype(registerData.getRatetype());
		registerDatases.setIsregistersuccess("P");

		registerService.registerClientdetails(registerDatases);
		// System.out.println("registerData::"+registerData.toString());
		Register r = new Register();
		r.setIsregistersuccess("Y");
		model.addAttribute("registerData", r);

		try {
			model.addAttribute("branchlist", branchService.getBranchList());
			model.addAttribute("banklist", bankDetailsService.getBankList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return "registerpage011";
		return "registerpage2603";
	}

	private ArrayList<String> validateRegister(Register register) {
		ArrayList<String> err = new ArrayList<String>();

		if (register.getAccouttype().equals("s")) {

			err.add("please select account type \\\\n");
		}

		if (register.getAccouttype().equals("p")) {
//			accouttype nic_drivinglicence webstore address1 emailaddress
			if (NexusClientUtil.isNullOrEmpty(register.getFullname_businessname())) {
				err.add("Name in Full cannot be empty \\\\n ");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getNic_drivinglicence())) {
				err.add("NIC cannot be empty \\\n");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getWebstore())) {
				err.add("Web store be empty \\\n");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getAddress1())) {
				err.add("Address cannot be empty \\\n");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getEmailaddress())) {
				err.add("Email cannot be empty \\\n");
			}
//			 pickupbranchp contactno contactno2 bankName bankAccountBranch accountHolderName
//				bankAccountType	accountid payementtype smsalert

			if (register.getPickupbranch().equals("X")) {

				err.add("Please select Pickup branch");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getContactno())) {
				err.add("Contact No cannot be empty \\\n");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getContactno2())) {
				err.add("Land Line phone No cannot be empty \\\n");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getAccountid())) {
				err.add("Account No cannot be empty ");
			}
			
			if (register.getBankname().equals("X")) {
				err.add(" Please select a Bank ");
			}
			
			if (register.getBankaccounttype().equals("X")) {
				err.add(" Please select a Bank Account Type ");
			}
			if (register.getBankaccountbranch().equals("X")) {
				err.add(" Please select a Account Branch Name ");
			}
			if (NexusClientUtil.isNullOrEmpty(register.getSmsalert())) {
				err.add("SMS Alert Cannot be empty ");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getAccountholdername())) {
				err.add("Account Holder Name Cannot be empty ");
			}
			
			
			
			System.out.println("****************NexusClientUtil**************************************");
			System.out.println(register.getPayementtype());
			System.out.println(register.getSmsalert());
//			if (NexusClientUtil.isNullOrEmpty(register.getBankName())) {
//				err.add(" Bank Name Cannot be empty");
//			}
			// contactno contactno2

		}else {
			
			//fullname_businessname address1 emailaddress pickupbranch brno 
			
			if (NexusClientUtil.isNullOrEmpty(register.getFullname_businessname())) {
				err.add("Name in Full cannot be empty \\\\n ");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getAddress1())) {
				err.add("Address cannot be empty \\\n");
			}

			if (NexusClientUtil.isNullOrEmpty(register.getEmailaddress())) {
				err.add("Email cannot be empty \\\n");
			}
			
			if (register.getPickupbranch().equals("X")) {

				err.add("Please select Pickup branch");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getBrno())) {
				err.add("Business Registration No Cannot be empty ");
			}
			
			//relationshiptobusiness contactperson contactpersonnic contactno
			
			if (NexusClientUtil.isNullOrEmpty(register.getRelationshiptobusiness())) {
				err.add("Relationship to Business Cannot be empty ");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getContactperson())) {
				err.add("Contact person Cannot be empty ");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getContactpersonnic())) {
				err.add("Contact person Nic Cannot be empty ");
			}
			if (NexusClientUtil.isNullOrEmpty(register.getContactno())) {
				err.add("Contact No cannot be empty ");
			}
			
			//bankName contactno2 bankAccountBranch accountHolderName bankAccountType 
			
			if (NexusClientUtil.isNullOrEmpty(register.getContactno2())) {
				err.add("Land Line phone No cannot be empty \\\n");
			}
			
			if (register.getBankname().equals("X")) {
				err.add(" Please select a Bank ");
			}
			
			if (register.getBankaccounttype().equals("X")) {
				err.add(" Please select a Bank Account Type ");
			}
			if (register.getBankaccountbranch().equals("X")) {
				err.add(" Please select a Account Branch Name ");
			}
			if (NexusClientUtil.isNullOrEmpty(register.getAccountholdername())) {
				err.add("Account Holder Name Cannot be empty ");
			}
			
			//accountid payementtype smsalert
			if (NexusClientUtil.isNullOrEmpty(register.getSmsalert())) {
				err.add("SMS Alert Cannot be empty ");
			}
			
			if (NexusClientUtil.isNullOrEmpty(register.getAccountid())) {
				err.add("Account No cannot be empty ");
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

	@GetMapping("/confirmRegistration")
	public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {
//		Locale locale=request.getLocale();
//		VerificationToken verificationToken = service.getVerificationToken(token);
//		if(verificationToken == null) {
//			String message = messages.getMessage("auth.message.invalidToken", null, locale);
//			model.addAttribute("message", message);
//			return "redirect:access-denied";
//		}
//		User user = verificationToken.getUser();
//		Calendar calendar = Calendar.getInstance();
//		if((verificationToken.getExpiryDate().getTime()-calendar.getTime().getTime())<=0) {
//			String message = messages.getMessage("auth.message.expired", null, locale);
//			model.addAttribute("message", message);
//			return "redirect:access-denied";
//		}
//		
//		user.setEnabled(true);
//		service.enableRegisteredUser(user);
//		return null;.
		VerificationToken v = verifyService.createVerificationTokenforUser1(token.replace("\"", ""));

		model.addAttribute("expflag", v.getIsexpired());
		model.addAttribute("vtoken", v.getToken());
		// model.addAttribute("clientlogging", new Clientloging());

		return "registerconfirmation";
	}

	@PostMapping("/createclientloging")
	public String loadprendingregisterDetails(Model model, HttpSession session,
			@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("passwordconf") String passwordconf, @RequestParam("vtoken") String vtoken) {
		String returnPage = "";
		// username password passwordconf
		System.out.println(username + "|" + password + "|" + passwordconf + "|" + vtoken);
		validatePassword(password, passwordconf);
		if (registerService.isExsistUsername(username)) {

			model.addAttribute("expflag", "N");
			model.addAttribute("usenameexsist", "Y");
			model.addAttribute("vtoken", vtoken);

			returnPage = "registerconfirmation";
		} else {
			// String username,String password, String token
			registerService.registerConfirmantionService(username, password, vtoken);
			model.addAttribute("expflag", "N");
			returnPage = "registerconfirmation";

		}

		return returnPage;
		// return "reg";
	}

	private String validatePassword(String password, String paswordconf) {

		String retMsg = "";

		if (!password.equals(paswordconf)) {

			retMsg = "password and confirmation password should be eqaul";
		}

		if (password.length() > 15 || password.length() < 8) {
			retMsg = "Password must be less than 20 and more than 8 characters in length.";
			// isValid = false;
		}
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			retMsg = "Password must have atleast one uppercase character";
			// isValid = false;
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			retMsg = "Password must have atleast one lowercase character";
			// isValid = false;
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			retMsg = "Password must have atleast one number";
			// isValid = false;
		}

		String specialChars = "(.*[@,#,$,%].*$)";
		if (!password.matches(specialChars)) {
			retMsg = "Password must have atleast one special character among @#$%";
			// isValid = false;
		}

		return retMsg;
	}

}

//@{/sendregisterrequest}
