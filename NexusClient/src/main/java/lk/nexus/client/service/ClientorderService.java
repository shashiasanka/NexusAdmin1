package lk.nexus.client.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lk.nexus.client.dao.ClientOrderDAOImpl;
import lk.nexus.client.dto.ClientOrderDto;
import lk.nexus.client.dto.DashboardCount2;
import lk.nexus.client.dto.DashboardResults;
import lk.nexus.client.dto.OrderSearch;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Clientregister;
import lk.nexus.client.models.Districts;
import lk.nexus.client.models.Nexusitem;
import lk.nexus.client.models.Nexusmaincat;
import lk.nexus.client.models.Nexussubcat;
import lk.nexus.client.models.Province;
import lk.nexus.client.models.Ratecode;
import lk.nexus.client.repository.ClientorderRepository;
import lk.nexus.client.repository.ClientregisterRepository;
import lk.nexus.client.repository.DistrictRepository;
import lk.nexus.client.repository.ProvinceRepository;
import lk.nexus.client.rowmappers.ClientDashboardRowmapper;
import lk.nexus.client.rowmappers.ClientOrderRowmapper;
import lk.nexus.client.util.ClientOrderStatus;


@Service
@Transactional
public class ClientorderService {

	private static final Logger logger = LogManager.getLogger(ClientorderService.class);
	//NexussubcatRepository  NexusmaincatRepository NexusitemRepository
	@Autowired
	private ClientorderRepository repo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProvinceRepository provincerepo;
	
	@Autowired
	DistrictRepository districtrepo;
	
	@Autowired
	ClientOrderDAOImpl clientOrderDao;

    @Autowired
    ClientregisterRepository clientregisterRepo;
	
	public Clientorder createClientOrder(Clientorder order) {

		boolean isexsist = false;
		try {
			
			System.out.println("order.getOrdertrackingid()"+order.getOrdertrackingid());
			isexsist = repo.existsById(order.getOrdertrackingid());

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!isexsist) {
			try {
				order.setOrderstatus(ClientOrderStatus.newOrder);
				
				order.setCustomeraddress(order.getCustomeraddress()+ order.getCustomeraddress2());
				
				Calendar calendar = Calendar.getInstance();				 
				 order.setCreatedDate(new Date(calendar.getTime().getTime()));
				 
				 if(order.getPaymenttype().equals("P")) {
					 
					 order.setCodamount(0); 
				 }
				 // add order
				
				repo.save(order);
				order = new Clientorder();
				order.setErrorflag("N");
				order.setDisplayemessage("Order Added Sucessfully ....");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			order.setErrorflag("Y");
			order.setDisplayemessage( order.getOrdertrackingid() +"Tracking ID already available ....");
		}

		return order;
	}

	
	public Clientorder addClientOrder(Clientorder order,String pickupBr,List<Ratecode> ratelist) {

		boolean isexsist = false;
		try {
			
			System.out.println("order.getOrdertrackingid()"+order.getOrdertrackingid());
			isexsist = repo.existsById(order.getOrdertrackingid());

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!isexsist) {
			try {
				order.setOrderstatus(ClientOrderStatus.newOrder);
				order.setReady_to_send("0");
				//order.setCustomeraddress(order.getCustomeraddress()+ order.getCustomeraddress2());
				order.setCustomeraddress(order.getCustomeraddress());
				
				Calendar calendar = Calendar.getInstance();				 
				 order.setCreatedDate(new Date(calendar.getTime().getTime()));
				 
				 if(order.getPaymenttype().equals("P")) {
					 
					 order.setCodamount(0); 
				 }
				 
				System.out.println("r.getTobarnch() "+order.getTo_branch());
				 
				 for(Ratecode r :ratelist) {
					 if(r.getTobarnchcode().equals(order.getTo_branch())) {						 
						 order.setCharge_nexus_amount(r.getChargeprice());
					 }		 
				 }
				 
				 if(order.getWeight() > 1) {
					 
					 order.setCharge_weight_amount((order.getWeight()-1) * 50);
				 }else {
					 
					 order.setCharge_weight_amount(0); 
				 }
				 System.out.println("********getCustomeraddress************ "+order.getCustomeraddress());
				 //order.setCharge_cust_amount(order.getCodamount()+order.getCharge_nexus_amount()+order.getCharge_weight_amount());
				
				repo.save(order);
				order = new Clientorder();
				order.setErrorflag("N");
				order.setDisplayemessage("Order Added Sucessfully ....");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			order.setErrorflag("Y");
			order.setDisplayemessage( order.getOrdertrackingid() +"Tracking ID already available ....");
		}

		return order;
	}

	
	
	public ArrayList<String> createClientOrderList(ArrayList<Clientorder> orderList) {

		ArrayList<String> msgList = new ArrayList<String>();
		for(Clientorder  order : orderList ) {
			
			
			boolean isexsist = false;
			
			try {
				
				isexsist = repo.existsById(order.getOrdertrackingid());

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!isexsist) {
				try {
					order.setOrderstatus(ClientOrderStatus.newOrder);
					
					order.setCustomeraddress(order.getCustomeraddress()+ order.getCustomeraddress2());
					
					Calendar calendar = Calendar.getInstance();				 
					 order.setCreatedDate(new Date(calendar.getTime().getTime()));
					 
					 if(order.getPaymenttype().equals("P")) {
						 
						 order.setCodamount(0); 
					 }
					 
					
					repo.save(order);
					order = new Clientorder();
					order.setErrorflag("N");
					order.setDisplayemessage("Order Added Sucessfully ....");
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {

				order.setErrorflag("Y");
				order.setDisplayemessage("Tracking ID already available ....");
				
				msgList.add(order.getOrdertrackingid() + "Tracking ID already available ....");
				
			}
			
		}
		

		return msgList;
	}
	
	
	public List<Clientorder> listOfClientOrdersByStatus(String clientid, String orderstatus) {

		
		
		return repo.listOfClientOrdersByStatus(clientid, orderstatus);
	}

	public boolean checkisTrackingIdAvailable(Clientorder order) {

		boolean isexsist = false;
		try {
			isexsist = repo.existsById(order.getOrdertrackingid());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isexsist;
	}

	public ClientOrderDto getOrderDetailsbyTrackingId(String orderTrackingId) {
		ClientOrderDto clientOrder = null;
		//clientOrder = repo.findById(orderTrackingId).get();
		
		//ClientOrderDAOImpl
		clientOrder = clientOrderDao.getClientorderbyTrackingId(orderTrackingId);
		
		return clientOrder;

	}
	
	public DashboardResults getOrderDetailstoDashboardService(String clientid) {
		DashboardResults dasboard = null;
		
		System.out.println("--------------------------Abc-----------"+clientid);
		try {
			dasboard = new DashboardResults();
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT count(co.orderstatus) as ordercount, os.statusdescription, os.statuscode ");
			sb.append("FROM orderstatus os LEFT JOIN clientorder co ON os.statuscode = co.orderstatus ");
			sb.append("where co.clientid = ? GROUP by os.statuscode ");
//			
//			//jdbcTemplate.queryForObject(sb.toString(), new Object[] { clientid }, new ClientDashboardRowmapper());
		List<DashboardCount2> dassres =	jdbcTemplate.query(sb.toString(), new Object[] { clientid }, new ClientDashboardRowmapper());
//			
		for(DashboardCount2 x : dassres) {
			
			System.out.println("#######DashboardResults");
			System.out.println(x.toString());
			
			
			switch (x.getStatuscode()) {
			case ClientOrderStatus.newOrder:
				dasboard.setNewOrderval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.receiveToWearhouse:
				dasboard.setReceiveToWearhouseval(Integer.toString(x.getOrdercount()));
	
				break;
			case ClientOrderStatus.dispatchFromWearhouse:
				dasboard.setDispatchFromWearhouseval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.receiveToBranch:
				dasboard.setReceiveToBranchval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.dispatchFromBranch:
				dasboard.setDispatchFromBranchval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.orderCompleted:
				dasboard.setOrderCompletedval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.orderFailed:
				dasboard.setOrderFailedval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.returnToBranch:
				dasboard.setReturnToBranchval(Integer.toString(x.getOrdercount()));
				break;
			case ClientOrderStatus.returnToWearhouse:
				dasboard.setReturnToWearhouseval(Integer.toString(x.getOrdercount()));
				break;

			default:
				break;
			}
			
			
		}
		
		//	dasboard = repojdbc.getDashboardResultofaClientRepo(clientid);
			
//			
//			
//			
//			List<Dashboardcount> dd= repo.getOrderDetailstoDashboardDao(clientid);
//			
//			for(Dashboardcount C : dd) {
//				System.out.println(C.getOrdercount() + "|"+ C.getStatuscode());
//				
//				String key = C.getStatuscode();
//				
//				logger.info(":::: DashboardResultsRowmapper point 2 key :::::  " + key);
//				switch (key) {
//				case ClientOrderStatus.newOrder:
//					dasboard.setNewOrderval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.receiveToWearhouse:
//					dasboard.setReceiveToWearhouseval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.dispatchFromWearhouse:
//					dasboard.setDispatchFromWearhouseval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.receiveToBranch:
//					dasboard.setReceiveToBranchval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.dispatchFromBranch:
//					dasboard.setDispatchFromBranchval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.orderCompleted:
//					dasboard.setOrderCompletedval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.orderFailed:
//					dasboard.setOrderFailedval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.returnToBranch:
//					dasboard.setReturnToBranchval(C.getOrdercount().toString());
//					break;
//				case ClientOrderStatus.returnToWearhouse:
//					dasboard.setReturnToWearhouseval(C.getOrdercount().toString());
//					break;
//
//				default:
//					break;
//				}
				
//			}
			
			
			
		} catch (Exception e) {
			
			logger.error( clientid + ":Error getOrderDetailstoDashboardService " ,e);
		}
		
		System.out.println("-------------------------------------");
		
		return dasboard;
	}
	
	
	

	
	public void getdaterange() {
		
		
		System.out.println("getdaterange============================");
		//String sDate1="20-02-2021"; 
		String sDate1="2021-02-20 05:30:00"; 
		//2021-02-20 05:30:00
	    Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			System.out.println("AA"+date1);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			//dateFormat.form

			System.out.println(cal.getTime());
			//List<Clientorder> a=	repo.listOfClientOrdersByStatus1date2("100106001720", "NEWO", "2021-01-11 00:00:00", "2021-05-11 00:00:00");
			
			//List<Clientorder> a=	repo.listOfClientOrdersByStatus1date2("100106001720", "NEWO");
			
			//List<Clientorder> a=	repo.listOfClientOrdersByStatus1date2("2021-02-21 00:00:00","2021-02-21 23:59:00");
			
			List<Clientorder> a=	repo.listOfClientOrdersByStatus1date3("100106001720", "NEWO","2021-02-21 00:00:00","2021-02-21 23:59:00");
			
			
			System.out.println("List<Clientorder>::::"+a.size());
			
			for(Clientorder c : a) {
				
				System.out.println("******"+c.getCustomername());
			}
		//	public List<Clientorder> listOfClientOrdersByStatus1date(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus,@Param("orderadddate1") Date orderadddate1,@Param("orderadddate2") Date orderadddate2);	
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
public List<Clientorder> searchClientOrdersByTrackingId(OrderSearch order) {
	List<Clientorder> clientOrderList = null;
	System.out.println("searchClientOrdersByTrackingId:::::"+order.toString());
	
	if(!order.getTrackid().isEmpty()) {
		 clientOrderList =repo.listOfClientOrdersByTrackingId(order.getTrackid());		
		
	}else {
		
		if(( (!order.getFromdate().isEmpty()) && (!order.getTodate().isEmpty()))) {
			System.out.println("########(!order.getFromdate().isEmpty()) && (!order.getTodate().isEmpty())");
			
			clientOrderList = repo.listOfClientOrdersByClientIddaterange3(order.getClientid(),order.getFromdate() +" 00:00:00",order.getTodate()+" 23:59:00");
		}
		
	}

	 //clientOrderList = repo.listOfClientOrdersByClientIddaterange3(order.getClientid(),"2021-02-21 00:00:00","2021-02-21 23:59:00");
	
	
//	@Query(value = "SELECT * FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus and e.orderadddate between :orderadddate1 and :orderadddate2 ORDER BY e.orderadddate ", nativeQuery = true)
//	public List<Clientorder> listOfClientOrdersByStatus1date3(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus, @Param("orderadddate1") String orderadddate1,@Param("orderadddate2") String orderadddate2);	

		
		return clientOrderList;
	}


public void readyTosendHO(String clientid, String ordertrackingid) {
	
	try {
		repo.readyTosendClientordertoHeadOffice(clientid, ordertrackingid);
	} catch (Exception e) {
		System.out.println("readyTosend ERROR "+e.getMessage());
		e.printStackTrace();
	}
	
	
}

public void removeTosend(String clientid, String ordertrackingid) {
	
	try {
		repo.dontSendClientordertoHeadOffice(clientid, ordertrackingid);
	} catch (Exception e) {
		System.out.println("readyTosend ERROR "+e.getMessage());
		e.printStackTrace();
	}
	
	
}




public String getClientPickupBranch(String clientId) {
	
	String pickup ="";
	Clientregister client = clientregisterRepo.findById(clientId).get();
	
	pickup = client.getPickupbranch();
	
	return pickup;
}



public Clientorder updateClientOrder(Clientorder order,String pickupBr,List<Ratecode> ratelist) {

		
			try {
				order.setOrderstatus(ClientOrderStatus.newOrder);
				order.setReady_to_send("0");
				//order.setCustomeraddress(order.getCustomeraddress()+ order.getCustomeraddress2());
				order.setCustomeraddress(order.getCustomeraddress());
				
				Calendar calendar = Calendar.getInstance();				 
				 order.setCreatedDate(new Date(calendar.getTime().getTime()));
				 
				 if(order.getPaymenttype().equals("P")) {
					 
					 order.setCodamount(0); 
				 }
				 
				System.out.println("r.getTobarnch() "+order.getTo_branch());
				 
				 for(Ratecode r :ratelist) {
					 if(r.getTobarnchcode().equals(order.getTo_branch())) {						 
						 order.setCharge_nexus_amount(r.getChargeprice());
					 }		 
				 }
				 
				 if(order.getWeight() > 1) {
					 
					 order.setCharge_weight_amount((order.getWeight()-1) * 50);
				 }else {
					 
					 order.setCharge_weight_amount(0); 
				 }
				 System.out.println("********getCustomeraddress************ "+order.getCustomeraddress());
				 //order.setCharge_cust_amount(order.getCodamount()+order.getCharge_nexus_amount()+order.getCharge_weight_amount());
				
				repo.save(order);
				order = new Clientorder();
				order.setErrorflag("N");
				order.setDisplayemessage("Order Added Sucessfully ....");
			} catch (Exception e) {
				e.printStackTrace();
			}

		

	return order;
}

public List<Nexusmaincat> getMainCatgoryList() {
	
	List<Nexusmaincat> maincatlist = new ArrayList<Nexusmaincat>();
	
	Nexusmaincat maincat1 = new Nexusmaincat();
	maincat1.setNexusmaincatdesc("maincat1");
	maincat1.setNexusmaincatdesc("Electronic Devices & Accessories");
	
	Nexusmaincat maincat2 = new Nexusmaincat();
	maincat2.setNexusmaincatdesc("maincat2");
	maincat2.setNexusmaincatdesc("TV & Home Appliances");
	
	
	Nexusmaincat maincat3 = new Nexusmaincat();
	maincat3.setNexusmaincatdesc("maincat3");
	maincat3.setNexusmaincatdesc("Health & Beauty");
	
	maincatlist.add(maincat1); 	maincatlist.add(maincat2); 	maincatlist.add(maincat3);
	return maincatlist;
}


public List<Province> getProvincelist() {
	
	
List<Province>	provinceList = (List<Province>) provincerepo.findAll();

return provinceList;
}

public List<Districts> listOfDistrictsoFaProvinceService(String province_id){
	
	
	List<Districts> districtList = districtrepo.listOfDistrictsoFaProvince(province_id);
	
	return districtList;
}




public ArrayList<String> getOrderTrackingList() { 
	
	ArrayList<String> numberlist = new ArrayList<String>();
	for(int i=0; i<=100; i++) {
		int aNumber = 0;
//		//aNumber = (int)((Math.random() * 9000000)+1000000);
		aNumber = (int)((Math.random() * 90000000)+10000000);
		System.out.println((aNumber));
		numberlist.add(Integer.toString(aNumber));
		System.out.println("======");
//		
	}
	
	
	return numberlist;
}








public List<Nexussubcat> getSubMainCatgoryList() {
	
	List<Nexussubcat> subcatlist = new ArrayList<Nexussubcat>();
	
	Nexussubcat subcat1 = new Nexussubcat();
	subcat1.setNexusmaincatid("maincat1");
	subcat1.setNexussubcatid("maincat1s1");
	subcat1.setNexussubcatdesc("Mobile Phones");
	
	subcatlist.add(subcat1);
	
	Nexussubcat subcat2 = new Nexussubcat();
	subcat2.setNexusmaincatid("maincat1");
	subcat2.setNexussubcatid("maincat1s2");
	subcat2.setNexussubcatdesc("Android Phones");
	subcatlist.add(subcat2);
	
	Nexussubcat subcat3 = new Nexussubcat();
	subcat3.setNexusmaincatid("maincat2");
	subcat3.setNexussubcatid("maincat2s1");
	subcat3.setNexussubcatdesc("TV & Video Devices");
	subcatlist.add(subcat3);
	
	Nexussubcat subcat4 = new Nexussubcat();
	subcat4.setNexusmaincatid("maincat2");
	subcat4.setNexussubcatid("maincat2s2");
	subcat4.setNexussubcatdesc("TV Accessories");
	subcatlist.add(subcat4);
	
	Nexussubcat subcat5 = new Nexussubcat();
	subcat5.setNexusmaincatid("maincat3");
	subcat5.setNexussubcatid("maincat3s1");
	subcat5.setNexussubcatdesc("Bath & Body");
	subcatlist.add(subcat5);
	
	Nexussubcat subcat6 = new Nexussubcat();
	subcat6.setNexusmaincatid("maincat3");
	subcat6.setNexussubcatid("maincat3s2");
	subcat6.setNexussubcatdesc("Beauty Tools");
	subcatlist.add(subcat6);
	
	return subcatlist;
}


public List<Nexusitem> getItemList() {
	
	List<Nexusitem> nexusitemList = new ArrayList<Nexusitem>();
	
	Nexusitem nexItem1 = new Nexusitem();
	nexItem1.setNexusitemid(1);
	nexItem1.setNexusmaincatid("maincat1");
	nexItem1.setNexussubcatid("maincat1s1");
	nexItem1.setNexusitemdesc("Samsung Mobiles");
	
	nexusitemList.add(nexItem1);
	
	Nexusitem nexItem2 = new Nexusitem();
	nexItem2.setNexusitemid(2);
	nexItem2.setNexusmaincatid("maincat1");
	nexItem2.setNexussubcatid("maincat1s1");
	nexItem2.setNexusitemdesc("Huawei Phones");
	nexusitemList.add(nexItem2);
	
	Nexusitem nexItem3 = new Nexusitem();
	nexItem3.setNexusitemid(3);
	nexItem3.setNexusmaincatid("maincat1");
	nexItem3.setNexussubcatid("maincat1s2");
	nexItem3.setNexusitemdesc("Xiaomi Phones");
	
	
	nexusitemList.add(nexItem3);
	Nexusitem nexItem4 = new Nexusitem();
	nexItem4.setNexusitemid(4);
	nexItem4.setNexusmaincatid("maincat1");
	nexItem4.setNexussubcatid("maincat1s2");
	nexItem4.setNexusitemdesc("Vivo Phones");
	nexusitemList.add(nexItem4);
	
	//=========================
	
	
	
	Nexusitem nexItem5 = new Nexusitem();
	nexItem5.setNexusitemid(5);
	nexItem5.setNexusmaincatid("maincat2");
	nexItem5.setNexussubcatid("maincat2s1");
	nexItem5.setNexusitemdesc("Projectors");
	
	nexusitemList.add(nexItem5);
	
	Nexusitem nexItem6 = new Nexusitem();
	nexItem6.setNexusitemid(6);
	nexItem6.setNexusmaincatid("maincat2");
	nexItem6.setNexussubcatid("maincat2s1");
	nexItem6.setNexusitemdesc("LED Televisions");
	
	nexusitemList.add(nexItem6);
	
	
	Nexusitem nexItem7 = new Nexusitem();
	nexItem7.setNexusitemid(7);
	nexItem7.setNexusmaincatid("maincat2");
	nexItem7.setNexussubcatid("maincat2s2");
	nexItem7.setNexusitemdesc("Soundbars");
	
	nexusitemList.add(nexItem7);
	
	Nexusitem nexItem8 = new Nexusitem();
	nexItem8.setNexusitemid(8);
	nexItem8.setNexusmaincatid("maincat2");
	nexItem8.setNexussubcatid("maincat2s2");
	nexItem8.setNexusitemdesc("Home Entertainment");
	
	nexusitemList.add(nexItem8);
	//=========================
		
	Nexusitem nexItem9 = new Nexusitem();
	nexItem9.setNexusitemid(9);
	nexItem9.setNexusmaincatid("maincat3");
	nexItem9.setNexussubcatid("maincat3s1");
	nexItem9.setNexusitemdesc("Body & Massage Oils");
	
	nexusitemList.add(nexItem9);
	
	Nexusitem nexItem10 = new Nexusitem();
	nexItem10.setNexusitemid(10);
	nexItem10.setNexusmaincatid("maincat3");
	nexItem10.setNexussubcatid("maincat3s1");
	nexItem10.setNexusitemdesc("Body Soaps & Shower Gels");
	
	nexusitemList.add(nexItem10);
	
	
	
	Nexusitem nexItem11 = new Nexusitem();
	nexItem11.setNexusitemid(11);
	nexItem11.setNexusmaincatid("maincat3");
	nexItem11.setNexussubcatid("maincat3s2");
	nexItem11.setNexusitemdesc("Curling Irons & Wands");
	nexusitemList.add(nexItem11);
	
	Nexusitem nexItem12 = new Nexusitem();
	nexItem12.setNexusitemid(12);
	nexItem12.setNexusmaincatid("maincat3");
	nexItem12.setNexussubcatid("maincat3s2");
	nexItem12.setNexusitemdesc("Flat Irons");
	
	nexusitemList.add(nexItem12);
	
	return nexusitemList;
	
}



public Clientorder getClientOrderByClientId(String ordertrackingid) {	
	
	return repo.getOfClientOrdersByTrackingId(ordertrackingid);
	
}

}
