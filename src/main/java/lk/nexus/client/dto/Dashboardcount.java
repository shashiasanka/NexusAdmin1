package lk.nexus.client.dto;

public class Dashboardcount {

	private String statuscode;
	private long   ordercount;
	//private String statusdesc;
	  
	

	

	public Dashboardcount(String statuscode, long ordercount) {
		super();
		this.statuscode = statuscode;
		this.ordercount = ordercount;
		//this.statusdesc = statusdesc;
	}



	public Long getOrdercount() {
		return ordercount;
	}



	public void setOrdercount(Long ordercount) {
		this.ordercount = ordercount;
	}



	public String getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	

//	public String getStatusdesc() {
//		return statusdesc;
//	}
//
//	public void setStatusdesc(String statusdesc) {
//		this.statusdesc = statusdesc;
//	}
//
//	@Override
//	public String toString() {
//		return "Dashboardcount [statuscode=" + statuscode + ", statusdesc=" + statusdesc + "]";
//	}
//
//	
	

	  
	  
}
