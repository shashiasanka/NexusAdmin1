package lk.nexus.home.nexusportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lk.nexus.home.nexusportal.dao.NexusUserDao;
import lk.nexus.home.nexusportal.dto.NexusUserLogingDto;
import lk.nexus.home.nexusportal.joindto.NexususerDTO;
import lk.nexus.home.nexusportal.models.Nexususerlogin;
import lk.nexus.home.nexusportal.models.Nexususers;
import lk.nexus.home.nexusportal.service.BranchdetailsService;
import lk.nexus.home.nexusportal.service.NexususerService;
import lk.nexus.home.nexusportal.util.NexusPortalUtil;

@Controller
public class NexusUserController {

	@Autowired
	BranchdetailsService branchService;
	
	@Autowired
	NexususerService nexusUserService;
	
	@Autowired
	NexusPortalUtil portalUtil;
	
	
	
	@GetMapping("/nexuuser")
	public String loadNexusUserPage(Model model,HttpSession session) {
		
	
		 model.addAttribute("nexususer", new NexususerDTO());
		 model.addAttribute("branchlist", branchService.getBranchList());
		 //model.addAttribute("nexususerlist",nexusUserService.getNexususersList());
		 model.addAttribute("nexususerlist",nexusUserService.getNexususersList());
		return "createuser";
	}
	
	
	@PostMapping("/nexuuser")
	  public String registreUser(@ModelAttribute NexususerDTO nexusUserData, Model model,HttpServletRequest request) {
		
		//System.out.println("NexususerDTO:::::"+nexusUserData.toString());
		System.out.println(":::::::::::::::::::::::=====NexususerDTO===========:::::");
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		//Nexususers nexusUser = modelMapper.map(nexusUserData, Nexususers.class);
		Nexususers nexusUser =portalUtil.convertNexususersdtoToNexususers(nexusUserData);
		
		
		System.out.println("NexususerDTO:::::"+nexusUser.toString());
		nexusUserService.registerUser(nexusUser);

		System.out.println(":::::::::::::::::::::::=====NexususerDTO LIST===========:::::"+nexusUserService.getNexususersList().toString());
		 model.addAttribute("nexususer", new NexususerDTO());
		 model.addAttribute("nexususerlist",nexusUserService.getNexususersList());
		 model.addAttribute("branchlist", branchService.getBranchList());
		return "createuser";
	}
	
	@GetMapping("/loginguser")
	public String loadNexusLogingUser(Model model,HttpSession session) {
		
	
		 model.addAttribute("nexususer", new NexususerDTO());
		 model.addAttribute("branchlist", branchService.getBranchList());
		 model.addAttribute("nexususerloginlist",nexusUserService.getNexusLogingUsersService());
		return "create_user_login";
	}
	
	
	
	@PostMapping("/loaduserforedit")
	  public String loadUserForEdit(@RequestParam("empid") String empid, Model model,HttpServletRequest request) {
		
		//System.out.println("NexususerDTO:::::"+nexusUserData.toString());
		System.out.println(":::::::::::::::::::::::=====NexususerDTO===========:::::"+empid);
		ModelMapper modelMapper = new ModelMapper();
		
		//System.out.println(":::::::::::::::::::::::=====NexususerDTO LIST===========:::::"+nexusUserService.getNexususersList().toString());
		 //model.addAttribute("nexususer", new NexususerDTO());
		
		 //model.addAttribute("nexususerloginlist",nexusUserService.getNexusLogingUsersbyEmpIdService(empid));
		 model.addAttribute("nexususer2edit",nexusUserService.getNexusLogingUsersbyEmpIdService(empid));
		 model.addAttribute("nexususrolelist",nexusUserService.getNexusUserRoleListService());
		 model.addAttribute("branchlist", branchService.getBranchList());
		 
			
		 return "create_user_login";
	}
	
	
	
	 @PostMapping("/loadtocreatelogin")
	  public String loadUserForCreateLoging(@RequestParam("empid") String empid, Model model,HttpServletRequest request) {
		
		//System.out.println("NexususerDTO:::::"+nexusUserData.toString());
		System.out.println(":::::::::::::::::::::::=====NexususerDTOempid===========:::::"+empid);
		NexususerDTO nexuser =	new NexususerDTO();
		nexuser.setEmpid(empid);
		
	   model.addAttribute("nexususer", nexuser); 
	
			return "create_user_login2";
	}
	 
	 
	 
@PostMapping("/creatuserloging")
public String createNexusUser(@ModelAttribute NexususerDTO nexusUserData, Model model,HttpServletRequest request) {
			
			//System.out.println("NexususerDTO:::::"+nexusUserData.toString());
			System.out.println(":::::::::::::::::::::::=====creatuserloging===========:::::" + nexusUserData.toString());
			ModelMapper modelMapper = new ModelMapper();
			// user here is a prepopulated User instance
			//Nexususers nexusUser = modelMapper.map(nexusUserData, Nexususers.class);
			//Nexususers nexusUser =portalUtil.convertNexususersdtoToNexususers(nexusUserData);
			
		
			//System.out.println(":::::::::::::::::::::::=====NexususerDTO LIST===========:::::"+nexusUserService.getNexususersList().toString());
			 model.addAttribute("nexususer", new NexususerDTO());
			 nexusUserService.createNexusUserService(nexusUserData);
			 
			// model.addAttribute("nexususerlist",nexusUserDao.getNexusUsers());
			// model.addAttribute("branchlist", branchService.getBranchList());
			// model.addAttribute("nexususerloginlist",nexusUserDao.getNexusLogingUsersbyEmpId(empid));
			 model.addAttribute("nexususerloginlist",nexusUserService.getNexusLogingUsersService());
				return "create_user_login";
		}
	
}
