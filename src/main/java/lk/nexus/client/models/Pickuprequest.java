package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Pickuprequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reqid;

	private String clientid;
	
	private String clientname;	
		
	private String vehicletype;
	
	private String pickuptime;
	
	private String contactno;
	
	private String noofpickups;
	
	private Long assignuser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no ", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	 private Register register;
	
	@Transient
	private String ispickuprequestsuccess;
	
	public Pickuprequest() {
		
	}

	public Pickuprequest(Long reqid, String clientid, String clientname, String vehicletype, String pickuptime,
			String contactno, String noofpickups, Long assignuser, Register register, String ispickuprequestsuccess) {
		super();
		this.reqid = reqid;
		this.clientid = clientid;
		this.clientname = clientname;
		this.vehicletype = vehicletype;
		this.pickuptime = pickuptime;
		this.contactno = contactno;
		this.noofpickups = noofpickups;
		this.assignuser = assignuser;
		this.register = register;
		this.ispickuprequestsuccess = ispickuprequestsuccess;
	}


	public Long getReqid() {
		return reqid;
	}

	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getPickuptime() {
		return pickuptime;
	}

	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}



	public String getContactno() {
		return contactno;
	}



	public void setContactno(String contactno) {
		this.contactno = contactno;
	}




	public String getNoofpickups() {
		return noofpickups;
	}




	public void setNoofpickups(String noofpickups) {
		this.noofpickups = noofpickups;
	}


	
	public String getIspickuprequestsuccess() {
		return ispickuprequestsuccess;
	}


	public void setIspickuprequestsuccess(String ispickuprequestsuccess) {
		this.ispickuprequestsuccess = ispickuprequestsuccess;
	}



	public Long getAssignuser() {
		return assignuser;
	}







	public void setAssignuser(Long assignuser) {
		this.assignuser = assignuser;
	}







	@Override
	public String toString() {
		return "Pickuprequest [reqid=" + reqid + ", clientid=" + clientid + ", clientname=" + clientname
				+ ", vehicletype=" + vehicletype + ", pickuptime=" + pickuptime + ", contactno=" + contactno
				+ ", noofpickups=" + noofpickups + ", assignuser=" + assignuser + ", register=" + register
				+ ", ispickuprequestsuccess=" + ispickuprequestsuccess + "]";
	}











	
	
	
	
}
