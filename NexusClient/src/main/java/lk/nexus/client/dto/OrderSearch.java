package lk.nexus.client.dto;

public class OrderSearch {
	//trackid fromdate todate
	private String trackid;
	
	private String fromdate;
	
	private String todate;	
	
	private String clientid;
	
	private String orderstatus;
	
	
	public String getTrackid() {
		return trackid;
	}




	public void setTrackid(String trackid) {
		this.trackid = trackid;
	}




	public String getFromdate() {
		return fromdate;
	}




	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}




	public String getTodate() {
		return todate;
	}




	public void setTodate(String todate) {
		this.todate = todate;
	}




	public String getClientid() {
		return clientid;
	}




	public void setClientid(String clientid) {
		this.clientid = clientid;
	}




	public String getOrderstatus() {
		return orderstatus;
	}




	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}




	@Override
	public String toString() {
		return "OrderSearch [trackid=" + trackid + ", fromdate=" + fromdate + ", todate=" + todate + ", clientid="
				+ clientid + ", orderstatus=" + orderstatus + "]";
	}


	


	
	
}
