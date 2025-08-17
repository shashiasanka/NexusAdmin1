package lk.nexus.home.nexusportal.joindto;

public class PickupJoinDto {
	
	private String clientname;	
	private String pickuptime;
	private String vehicleType;
	private String noofpickups;

	
	
	


	public PickupJoinDto(String clientname, String pickuptime, String vehicleType, String noofpickups) {
		super();
		this.clientname = clientname;
		this.pickuptime = pickuptime;
		this.vehicleType = vehicleType;
		this.noofpickups = noofpickups;
	}


	public String getClientname() {
		return clientname;
	}


	public void setClientname(String clientname) {
		this.clientname = clientname;
	}


	public String getPickuptime() {
		return pickuptime;
	}


	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getNoofpickups() {
		return noofpickups;
	}


	public void setNoofpickups(String noofpickups) {
		this.noofpickups = noofpickups;
	}


	@Override
	public String toString() {
		return "PickupJoinDto [clientname=" + clientname + ", pickuptime=" + pickuptime + ", vehicleType=" + vehicleType
				+ ", noofpickups=" + noofpickups + "]";
	}
	
	
	
	
	
	
}
