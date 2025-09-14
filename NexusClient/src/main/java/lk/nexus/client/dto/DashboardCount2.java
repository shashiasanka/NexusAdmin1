package lk.nexus.client.dto;

public class DashboardCount2 {

	private String statuscode;
	private int   ordercount;
	private String statusdesc;
	
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	public String getStatusdesc() {
		return statusdesc;
	}
	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}
	@Override
	public String toString() {
		return "DashboardCount2 [statuscode=" + statuscode + ", ordercount=" + ordercount + ", statusdesc=" + statusdesc
				+ "]";
	}
	
	
	
	  
}
