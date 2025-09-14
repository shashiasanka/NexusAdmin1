package lk.nexus.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lk.nexus.client.dto.ClientlogingDto;
import lk.nexus.client.dto.NexusUserLogingDto;
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Nexususers;
import lk.nexus.client.service.ClientLogingService;
import lk.nexus.client.service.ClientorderService;
import lk.nexus.client.service.NexususerService;





@Controller
public class LogingController {
	
	private static final Logger logger = LogManager.getLogger(LogingController.class);
	@Autowired
	private ClientLogingService logingservice;
	
	@Autowired
	private ClientorderService clientorderservice;
	
	@Autowired
	private NexususerService nexrepo;
	
	@GetMapping("/clientloging")
	public String loadLogingPage(Model model,HttpSession session) {
		
		model.addAttribute("logingData", new Clientloging());
		
		Clientorder c = new Clientorder();
		c.setClientid("100106001729");
		//c.setClientname("12331");
		c.setWeight(10.5);
		c.setCodamount(3000.25);
		c.setOrdertrackingid("23434234");
		//clientorderservice.createClientOrder(c);
		
		//logger.debug("Hello from Log4j 2 - num : {}", c.toString());
		
		//return "logingpage";
		return "loginpage2";
	}

	@PostMapping("/Loging")
	  public String getLoging(@ModelAttribute NexusUserLogingDto logingdata, Model model,HttpServletRequest request) {
		String retuenpage ="";
		 model.addAttribute("logingData", new NexusUserLogingDto());
	    System.out.println("-----------------------"+logingdata.toString());
	  
	    //Clientloging c =  logingservice.getUserloging(logingdata.getUsername(), logingdata.getPassword());
	    Nexususers nexuser = nexrepo.authenticateNexusHomeUser(logingdata.getUsername(),logingdata.getPassword());
	
	    if(nexuser == null) {
	    	model.addAttribute("logingData", new NexusUserLogingDto());			
	    	retuenpage= "logingpage";
	    }
	  //System.out.println(dashboardServ.getOrderDetailstoDashboard().toString());  
//	  model.addAttribute("dashboard",dashboardServ.getOrderDetailstoDashboard());
//	    dashboardServ.getOrderDetailstoDashboard();
	    model.addAttribute("loggeduser", nexuser);
	    
	   // retuenpage = "nexususer/dashboard_pickup_monitor_exe";
	   // retuenpage = "nexususer/client_dashboard";
	    retuenpage ="nexusportal_dashboard";
	    return retuenpage;
	  }
}
