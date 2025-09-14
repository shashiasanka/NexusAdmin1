package lk.nexus.client.dto;

import java.util.Date;

import javax.persistence.Column;



public class ClientOrderDto {
	
	private String clientname;

	private String contactno;

	private String clientid;

	private String orderid;

	
	private String ordertrackingid;

	private String paymenttype;

	private double codamount;

	private double weight;

	private String remarks;

	private String customername;

	private String customeraddress;

	private String customerphone;
	private String province;
	private String district;
	
	private String provincedesc;
	private String districtdesc;
	private String customernearestcity;

	private String description;
	
	
	private String errorflag;
	

	private String displayemessage;
	
	
	private String orderstatus;
	
	
	private String customeraddress2;
	

	private String customerphone2;
	

	private String maincatcode;
	

	private Date createdDate;


	private String orderstatusdesc;
	
	private String paymenttypedesc;
	

	
	private double charge_weight_amount;
	

	private double charge_nexus_amount;
	
	private String ready_to_send;
	
    private String from_phone;
	
	private String from_name;
	
	private String from_address;
	
	private String to_branch;
	
	public String getClientname() {
		return clientname;
	}


	public void setClientname(String clientname) {
		this.clientname = clientname;
	}


	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


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


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
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


	public String getOrderstatusdesc() {
		return orderstatusdesc;
	}


	public void setOrderstatusdesc(String orderstatusdesc) {
		this.orderstatusdesc = orderstatusdesc;
	}


	public String getProvincedesc() {
		return provincedesc;
	}


	public void setProvincedesc(String provincedesc) {
		this.provincedesc = provincedesc;
	}


	public String getDistrictdesc() {
		return districtdesc;
	}


	public void setDistrictdesc(String districtdesc) {
		this.districtdesc = districtdesc;
	}


	public String getPaymenttypedesc() {
		return paymenttypedesc;
	}


	public void setPaymenttypedesc(String paymenttypedesc) {
		this.paymenttypedesc = paymenttypedesc;
	}


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


	public String getTo_branch() {
		return to_branch;
	}


	public void setTo_branch(String to_branch) {
		this.to_branch = to_branch;
	}


	@Override
	public String toString() {
		return "ClientOrderDto [clientname=" + clientname + ", contactno=" + contactno + ", clientid=" + clientid
				+ ", orderid=" + orderid + ", ordertrackingid=" + ordertrackingid + ", paymenttype=" + paymenttype
				+ ", codamount=" + codamount + ", weight=" + weight + ", remarks=" + remarks + ", customername="
				+ customername + ", customeraddress=" + customeraddress + ", customerphone=" + customerphone
				+ ", province=" + province + ", district=" + district + ", provincedesc=" + provincedesc
				+ ", districtdesc=" + districtdesc + ", customernearestcity=" + customernearestcity + ", description="
				+ description + ", errorflag=" + errorflag + ", displayemessage=" + displayemessage + ", orderstatus="
				+ orderstatus + ", customeraddress2=" + customeraddress2 + ", customerphone2=" + customerphone2
				+ ", maincatcode=" + maincatcode + ", createdDate=" + createdDate + ", orderstatusdesc="
				+ orderstatusdesc + ", paymenttypedesc=" + paymenttypedesc + ", charge_weight_amount="
				+ charge_weight_amount + ", charge_nexus_amount=" + charge_nexus_amount + ", ready_to_send="
				+ ready_to_send + ", from_phone=" + from_phone + ", from_name=" + from_name + ", from_address="
				+ from_address + ", to_branch=" + to_branch + "]";
	}


	

	


	

	
	

}
