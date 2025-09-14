package lk.nexus.client.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;

import lk.nexus.client.dto.ClientOrderDto;
import lk.nexus.client.dto.ClientlogingDto;
import lk.nexus.client.dto.OrderSearch;
import lk.nexus.client.models.Branchdetails;
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Pickuprequest;
import lk.nexus.client.service.BranchdetailsService;
import lk.nexus.client.service.ClientorderService;
import lk.nexus.client.service.SearchService;

@Controller
public class SearcController {

	@Autowired
	ClientorderService orderService;
	// searchClientOrdersByTrackingId

	@Autowired
	SearchService searchservice;
	
	@Autowired
	BranchdetailsService branchService;

	/**
	 * loadSearchpage
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping("/search")
	public String loadSearchpage(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		model.addAttribute("loggeduser", client);
		model.addAttribute("ordersearch", new OrderSearch());

		System.out.println("SEARCHHHHH" + client.getClientid());
		model.addAttribute("orderlist", searchservice.getClientOrderList(client.getClientid()));
		// return "client_search";
		return "xclient_search";
	}

	@PostMapping("/SearchOrder")
	// @RequestMapping(value="/Addorder", method=RequestMethod.POST,
	// params="action=AddOrder")
	public String searchOrder(@ModelAttribute OrderSearch ordersearch, Model model, HttpServletRequest request) {

		System.out.println("##########SearchOrder################");

		HttpSession session = request.getSession(false);

		if (ordersearch.getFromdate().isEmpty() && ordersearch.getFromdate().isEmpty()) {

		} else {

		}
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		ordersearch.setClientid(client.getClientid());
		List<Clientorder> searcResult = orderService.searchClientOrdersByTrackingId(ordersearch);
		// orderService.getOrderDetailsbyTrackingId("");
		if (searcResult == null) {
			model.addAttribute("ordersearch", ordersearch);
			model.addAttribute("clientorderlist", searcResult);
		} else {
			model.addAttribute("ordersearch", new OrderSearch());
			model.addAttribute("clientorderlist", searcResult);
		}

		model.addAttribute("ordersearch", new OrderSearch());

		model.addAttribute("loggeduser", client);

		return "client_search";
	}

	// @RequestParam("id") Long id

	@PostMapping("/ViewOrder")
	public String searchOrderbyTrackingId(Model model, HttpServletRequest request,
			@RequestParam("trackingid") String trackingid) {

		System.out.println("##########LoadOrder################" + trackingid);

		HttpSession session = request.getSession(false);
		ClientOrderDto clientOrder = orderService.getOrderDetailsbyTrackingId(trackingid);		
		
		System.out.println("##########clientOrder.getTo_branch()################|" + clientOrder.getTo_branch()+"|");
		model.addAttribute("clientorder", clientOrder);
		model.addAttribute("maincategorylist", orderService.getMainCatgoryList());
		
		List<Branchdetails> brList = branchService.getBranchList();
		
//		List<Branchdetails> brListTop = new ArrayList<Branchdetails>();
//		List<Branchdetails> brListOther = new ArrayList<Branchdetails>();
//		for(Branchdetails br : brList) {
//			
//			if(br.getBranchcode() == clientOrder.getTo_branch()) {
//				
//				brListTop.add(br);
//				
//			}else {
//				
//				brListOther.add(br);
//			}
//			
//		}
//	for(Branchdetails br : brListOther) {
//		
//		brListTop.add(br);
//	}
		model.addAttribute("branchlist", brList);
		// return "client_search";
		return "xclient_vieworder";
	}

	// @PostMapping("/ViewOrderData")
	@RequestMapping(value = "/ViewOrderData", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ClientOrderDto searchOrderbyTrackingIdData(
			@RequestParam("ordertrackingid") String ordertrackingid) {

		System.out.println("##########searchOrderbyTrackingIdDataLoadOrder################" + ordertrackingid);

		// return "client_search";
		ClientOrderDto c = orderService.getOrderDetailsbyTrackingId(ordertrackingid);
		System.out.println("##########searchOrderbyTrackingIdDataLoadOrder:" + c.toString());
		return c;
	}

	//@GetMapping("/ViewOrderDataGet/{ordertrackingid}")
	@RequestMapping(value = "/ViewOrderDataGet", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ClientOrderDto searchOrderbyTrackingIdDataGET(Model model, HttpServletRequest request,@RequestParam("ordertrackingid") String ordertrackingid) {
	
		System.out.println("##########searchOrderbyTrackingIdDataLoadOrder################" + ordertrackingid);

		// return "client_search";
		ClientOrderDto c = orderService.getOrderDetailsbyTrackingId(ordertrackingid);
		System.out.println("##########searchOrderbyTrackingIdDataLoadOrder:" + c.toString());
		return c;
	}

}
