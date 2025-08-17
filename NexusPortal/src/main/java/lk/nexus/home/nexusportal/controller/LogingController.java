package lk.nexus.home.nexusportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lk.nexus.home.nexusportal.conf.AbcConf;
import lk.nexus.home.nexusportal.dto.NexusUserLogingDto;
import lk.nexus.home.nexusportal.models.Nexususers;
import lk.nexus.home.nexusportal.service.ClientLogingService;
import lk.nexus.home.nexusportal.service.DashboardService;
import lk.nexus.home.nexusportal.service.NexususerService;
import lk.nexus.home.nexusportal.service.PickuprequestService;




@Controller
public class LogingController {
	
	@Autowired
	private ClientLogingService logingservice;
	
	@Autowired
	private NexususerService nexrepo;
	
	@Autowired
	PickuprequestService pic;
	
	@Autowired
	DashboardService dashboardServ;
	
	@Autowired
	AbcConf abc;
	
	@GetMapping("/clientloging")
	public String loadLogingPage(Model model,HttpSession session) {
		
		model.addAttribute("logingData", new NexusUserLogingDto());
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		//picrepo.getAllPickuprequests();
		//pic.getAllPickuprequests();
		System.out.println("ABC"+abc.getAaa());
		
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
	//	Clientorder c = new Clientorder();
		//c.setClientid("100106001729");c.setClientname("12331");
		//c.setWeight(10.5);
		//c.setCodamount(3000.25);
		//c.setOrdertrackingid("23434234");
		//clientorderservice.createClientOrder(c);
//		Nexususers n = new Nexususers();
//		n.setRole("sdd");
//		n.setBranch("we");
//		//n.setUsername("abc");
//		
//		Nexususerlogin ab = new Nexususerlogin();
//		//ab.setId(n.getId());
//		ab.setUsername("abc");
//		ab.setNexusstatus("A");
//		ab.setEmpid("001");
//		ab.setPassword("abc");
//		ab.setNexususer(n);
		//n.setUserloging(ab);
		
		/*
		Nexususers put = new Nexususers();
		put.setRole("PUT");
		put.setBranch("we");		
		Nexususerlogin putab = new Nexususerlogin();
		putab.setUsername("PUT");
		putab.setNexusstatus("A");
		putab.setEmpid("001");
		putab.setPassword("abc");
		putab.setNexususer(put);
		
		nexrepo.nexLogUser(putab);	
		Nexususers nar = new Nexususers();
		nar.setRole("NAR");
		nar.setBranch("we");		
		Nexususerlogin narab = new Nexususerlogin();
		narab.setUsername("NAR");
		narab.setNexusstatus("A");
		narab.setEmpid("001");
		narab.setPassword("abc");
		narab.setNexususer(nar);
		
		nexrepo.nexLogUser(narab);	
		Nexususers nac = new Nexususers();
		nac.setRole("NAC");
		nac.setBranch("we");		
		Nexususerlogin nacab = new Nexususerlogin();
		nacab.setUsername("NAC");
		nacab.setNexusstatus("A");
		nacab.setEmpid("001");
		nacab.setPassword("abc");
		nacab.setNexususer(nac);
		nexrepo.nexLogUser(nacab);	
		Nexususers rid = new Nexususers();
		rid.setRole("RID");
		rid.setBranch("we");		
		Nexususerlogin ridab = new Nexususerlogin();
		ridab.setUsername("RID");
		ridab.setNexusstatus("A");
		ridab.setEmpid("001");
		ridab.setPassword("abc");
		ridab.setNexususer(rid);
		nexrepo.nexLogUser(ridab);	
		
		Nexususers brh = new Nexususers();
		brh.setRole("BRH");
		brh.setBranch("we");		
		Nexususerlogin brhab = new Nexususerlogin();
		brhab.setUsername("PMC");
		brhab.setNexusstatus("A");
		brhab.setEmpid("001");
		brhab.setPassword("abc");
		brhab.setNexususer(brh);
		nexrepo.nexLogUser(brhab);	
		

Nexususers bpa = new Nexususers();
		bpa.setRole("BPA");
		bpa.setBranch("we");		
		Nexususerlogin bpaab = new Nexususerlogin();
		bpaab.setUsername("BPA");
		bpaab.setNexusstatus("A");
		bpaab.setEmpid("001");
		bpaab.setPassword("abc");
		bpaab.setNexususer(bpa);
		nexrepo.nexLogUser(bpaab);
		Nexususers pmc = new Nexususers();
		pmc.setRole("PMC");
		pmc.setBranch("we");		
		Nexususerlogin pmcab = new Nexususerlogin();
		pmcab.setUsername("PMC");
		pmcab.setNexusstatus("A");
		pmcab.setEmpid("001");
		pmcab.setPassword("abc");
		pmcab.setNexususer(pmc);
		
		nexrepo.nexLogUser(pmcab);
		
		Nexususers cse = new Nexususers();
		cse.setRole("CSE");
		cse.setBranch("we");		
		Nexususerlogin cseab = new Nexususerlogin();
		cseab.setUsername("CSE");
		cseab.setNexusstatus("A");
		cseab.setEmpid("001");
		cseab.setPassword("abc");
		cseab.setNexususer(cse);
		
		nexrepo.nexLogUser(cseab);
		Nexususers nic = new Nexususers();
		nic.setRole("NIC");
		nic.setBranch("we");
		
		
		Nexususerlogin nicab = new Nexususerlogin();
		nicab.setUsername("NIC");
		nicab.setNexusstatus("A");
		nicab.setEmpid("001");
		nicab.setPassword("abc");
		nicab.setNexususer(nic);
		
		nexrepo.nexLogUser(nicab);
		Nexususers dic = new Nexususers();
		dic.setRole("DIC");
		dic.setBranch("we");
		
		
		Nexususerlogin dicab = new Nexususerlogin();
		dicab.setUsername("DIC");
		dicab.setNexusstatus("A");
		dicab.setEmpid("001");
		dicab.setPassword("abc");
		dicab.setNexususer(dic);
		nexrepo.nexLogUser(dicab);
		
		Nexususers hoon = new Nexususers();
		hoon.setRole("HOO");
		hoon.setBranch("we");
		
		
		Nexususerlogin hoonab = new Nexususerlogin();
		hoonab.setUsername("HOO");
		hoonab.setNexusstatus("A");
		hoonab.setEmpid("001");
		hoonab.setPassword("abc");
		hoonab.setNexususer (hoon);
		
		nexrepo.nexLogUser(hoonab);
	//nexrepo.nexLogUser(putab);
		*/
		return "logingpage";
		//return "nexusportal_dashboard";
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
	  model.addAttribute("dashboard",dashboardServ.getOrderDetailstoDashboard());
	    dashboardServ.getOrderDetailstoDashboard();
	    model.addAttribute("loggeduser", nexuser);
	    
	   // retuenpage = "nexususer/dashboard_pickup_monitor_exe";
	   // retuenpage = "nexususer/client_dashboard";
	    retuenpage ="nexusportal_dashboard";
	    return retuenpage;
	
	}
	    
	    //else {
//	    	 HttpSession session = request.getSession(true);
//	 	     session.setAttribute("loggeduser", c);
//	 	    model.addAttribute("loggeduser", c);
	    
	  //  	return "client_dashboard";
	    //}
	    
	    
	 // }
}
