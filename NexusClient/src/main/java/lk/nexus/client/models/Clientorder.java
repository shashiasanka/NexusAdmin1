package lk.nexus.client.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "clientorder")
public class Clientorder {

	//private String clientname;

	//private String contactno;

	private String clientid;

	private String orderid;

	@Id
	private String ordertrackingid;

	private String paymenttype;

	private double codamount;

	private double weight;

	private String remarks;

	private String customername;

	private String customeraddress;

	private String customerphone;
	private int province;
	private int district;
	private String customernearestcity;

	private String description;
	
	@Transient	
	private String errorflag;
	
	@Transient
	private String displayemessage;
	
	@Temporal(TemporalType.DATE)
	private Date orderadddate= new Date();
	
	private String orderstatus;
	
	@Transient
	private String customeraddress2;
	

	private String customerphone2;
	
	@Transient
	private String maincatcode;
	
	@Column(name="created_date")
	private Date createdDate;
	
//	@Column(name="charge_cust_amount")
//	private double charge_cust_amount;
	
	@Column(name="charge_weight_amount")
	private double charge_weight_amount;
	
	@Column(name="charge_nexus_amount")
	private double charge_nexus_amount;
	
	@Column(name="to_branch")
	private String to_branch;
	
	@Column(name="ready_to_send")
	private String ready_to_send;

	@Transient
	private String rowErrorMsg;
	
	private String from_phone;
	
	private String from_name;
	
	private String from_address;
	
	public Clientorder() {

	}






//	public Clientorder(String clientname, String contactno, String clientid, String orderid, String ordertrackingid,
//			String paymenttype, double codamount, double weight, String remarks, String customername,
//			String customeraddress, String customerphone, String province, String district, String customernearestcity,
//			String description, String errorflag, String displayemessage, Date orderadddate, String orderstatus) {
//		super();
//		this.clientname = clientname;
//		this.contactno = contactno;
//		this.clientid = clientid;
//		this.orderid = orderid;
//		this.ordertrackingid = ordertrackingid;
//		this.paymenttype = paymenttype;
//		this.codamount = codamount;
//		this.weight = weight;
//		this.remarks = remarks;
//		this.customername = customername;
//		this.customeraddress = customeraddress;
//		this.customerphone = customerphone;
//		this.province = province;
//		this.district = district;
//		this.customernearestcity = customernearestcity;
//		this.description = description;
//		this.errorflag = errorflag;
//		this.displayemessage = displayemessage;
//		this.orderadddate = orderadddate;
//		this.orderstatus = orderstatus;
//	}

//
//	public String getClientname() {
//		return clientname;
//	}


//	public Clientorder(String clientname, String contactno, String clientid, String orderid, String ordertrackingid,
//		String paymenttype, double codamount, double weight, String remarks, String customername,
//		String customeraddress, String customerphone, String province, String district, String customernearestcity,
//		String description, String errorflag, String displayemessage, Date orderadddate, String orderstatus,
//		String customeraddress2, String customerphone2, String maincatcode) {
//	super();
//	this.clientname = clientname;
//	this.contactno = contactno;
//	this.clientid = clientid;
//	this.orderid = orderid;
//	this.ordertrackingid = ordertrackingid;
//	this.paymenttype = paymenttype;
//	this.codamount = codamount;
//	this.weight = weight;
//	this.remarks = remarks;
//	this.customername = customername;
//	this.customeraddress = customeraddress;
//	this.customerphone = customerphone;
//	this.province = province;
//	this.district = district;
//	this.customernearestcity = customernearestcity;
//	this.description = description;
//	this.errorflag = errorflag;
//	this.displayemessage = displayemessage;
//	this.orderadddate = orderadddate;
//	this.orderstatus = orderstatus;
//	this.customeraddress2 = customeraddress2;
//	this.customerphone2 = customerphone2;
//	this.maincatcode = maincatcode;
//}






//	public void setClientname(String clientname) {
//		this.clientname = clientname;
//	}

//	public String getContactno() {
//		return contactno;
//	}
//
//	public void setContactno(String contactno) {
//		this.contactno = contactno;
//	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrdertrackingid() {
		return ordertrackingid;
	}

	public void setOrdertrackingid(String ordertrackingid) {
		this.ordertrackingid = ordertrackingid;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public double getCodamount() {
		return codamount;
	}

	public void setCodamount(double codamount) {
		this.codamount = codamount;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomerphone() {
		return customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	

	public int getProvince() {
		return province;
	}






	public void setProvince(int province) {
		this.province = province;
	}






	public int getDistrict() {
		return district;
	}






	public void setDistrict(int district) {
		this.district = district;
	}






	public String getCustomernearestcity() {
		return customernearestcity;
	}

	public void setCustomernearestcity(String customernearestcity) {
		this.customernearestcity = customernearestcity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getErrorflag() {
		return errorflag;
	}




	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}



	
	public String getDisplayemessage() {
		return displayemessage;
	}






	public void setDisplayemessage(String displayemessage) {
		this.displayemessage = displayemessage;
	}






	public Date getOrderadddate() {
		return orderadddate;
	}






	public void setOrderadddate(Date orderadddate) {
		this.orderadddate = orderadddate;
	}






	public String getOrderstatus() {
		return orderstatus;
	}






	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}






	public String getCustomeraddress2() {
		return customeraddress2;
	}






	public void setCustomeraddress2(String customeraddress2) {
		this.customeraddress2 = customeraddress2;
	}






	public String getCustomerphone2() {
		return customerphone2;
	}






	public void setCustomerphone2(String customerphone2) {
		this.customerphone2 = customerphone2;
	}






	






	public String getMaincatcode() {
		return maincatcode;
	}






	public void setMaincatcode(String maincatcode) {
		this.maincatcode = maincatcode;
	}






	public Date getCreatedDate() {
		return createdDate;
	}






	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}






	public String getRowErrorMsg() {
		return rowErrorMsg;
	}






	public void setRowErrorMsg(String rowErrorMsg) {
		this.rowErrorMsg = rowErrorMsg;
	}






//	public double getCharge_cust_amount() {
//		return charge_cust_amount;
//	}
//
//
//
//
//
//
//	public void setCharge_cust_amount(double charge_cust_amount) {
//		this.charge_cust_amount = charge_cust_amount;
//	}






	public double getCharge_weight_amount() {
		return charge_weight_amount;
	}






	public void setCharge_weight_amount(double charge_weight_amount) {
		this.charge_weight_amount = charge_weight_amount;
	}






	public double getCharge_nexus_amount() {
		return charge_nexus_amount;
	}






	public void setCharge_nexus_amount(double charge_nexus_amount) {
		this.charge_nexus_amount = charge_nexus_amount;
	}






	public String getTo_branch() {
		return to_branch;
	}






	public void setTo_branch(String to_branch) {
		this.to_branch = to_branch;
	}






	public String getReady_to_send() {
		return ready_to_send;
	}






	public void setReady_to_send(String ready_to_send) {
		this.ready_to_send = ready_to_send;
	}






	public String getFrom_phone() {
		return from_phone;
	}






	public void setFrom_phone(String from_phone) {
		this.from_phone = from_phone;
	}






	public String getFrom_name() {
		return from_name;
	}






	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}






	public String getFrom_address() {
		return from_address;
	}






	public void setFrom_address(String from_address) {
		this.from_address = from_address;
	}


	







	

}
