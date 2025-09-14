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
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.service.ClientLogingService;
import lk.nexus.client.service.ClientorderService;


@Controller
public class LogingController {
	
	private static final Logger logger = LogManager.getLogger(LogingController.class);
	@Autowired
	private ClientLogingService logingservice;
	
	@Autowired
	private ClientorderService clientorderservice;
	
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
	  public String getLoging(@ModelAttribute Clientloging logingdata, Model model,HttpServletRequest request) {
		try {
			
			 model.addAttribute("logingData", new Clientloging());
			    System.out.println("-----------------------"+logingdata.toString());

			    ClientlogingDto c =  logingservice.getUserloging(logingdata.getUsername(), logingdata.getPassword());

			    if(c == null) {
			    	model.addAttribute("logingData", new Clientloging());
					
					return "logingpage";
			    }else {
			    	HttpSession session = request.getSession(true);
			    	
			    	model.addAttribute("clientorderlist", clientorderservice.listOfClientOrdersByStatus(c.getClientid(), "NEWO"));
			    	
			    	clientorderservice.getdaterange();
			    	//clientorderservice.getOrderDetailstoDashboard(c.getClientid());	    	
			    	model.addAttribute("dashboard", clientorderservice.getOrderDetailstoDashboardService(c.getClientid()));
			 	    session.setAttribute("loggeduser", c);
			 	    model.addAttribute("loggeduser", c);
			 	    
			    	//return "client_dashboard";
			    	return "xclient_dashboard";
			    }
			    
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(logingdata.toString() + "Logging Error ", e);
			
			return "logingpage";
		}
		
	    
	  }
}
