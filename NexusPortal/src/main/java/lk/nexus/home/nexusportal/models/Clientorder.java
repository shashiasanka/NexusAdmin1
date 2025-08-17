package lk.nexus.home.nexusportal.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Clientorder {

	private String clientname;

	private String contactno;

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
	private String province;
	private String district;
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


	
	


	

	public Clientorder(String clientname, String contactno, String clientid, String orderid, String ordertrackingid,
		String paymenttype, double codamount, double weight, String remarks, String customername,
		String customeraddress, String customerphone, String province, String district, String customernearestcity,
		String description, String errorflag, String displayemessage, Date orderadddate, String orderstatus,
		String customeraddress2, String customerphone2) {
	super();
	this.clientname = clientname;
	this.contactno = contactno;
	this.clientid = clientid;
	this.orderid = orderid;
	this.ordertrackingid = ordertrackingid;
	this.paymenttype = paymenttype;
	this.codamount = codamount;
	this.weight = weight;
	this.remarks = remarks;
	this.customername = customername;
	this.customeraddress = customeraddress;
	this.customerphone = customerphone;
	this.province = province;
	this.district = district;
	this.customernearestcity = customernearestcity;
	this.description = description;
	this.errorflag = errorflag;
	this.displayemessage = displayemessage;
	this.orderadddate = orderadddate;
	this.orderstatus = orderstatus;
	this.customeraddress2 = customeraddress2;
	this.customerphone2 = customerphone2;
}




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






	@Override
	public String toString() {
		return "Clientorder [clientname=" + clientname + ", contactno=" + contactno + ", clientid=" + clientid
				+ ", orderid=" + orderid + ", ordertrackingid=" + ordertrackingid + ", paymenttype=" + paymenttype
				+ ", codamount=" + codamount + ", weight=" + weight + ", remarks=" + remarks + ", customername="
				+ customername + ", customeraddress=" + customeraddress + ", customerphone=" + customerphone
				+ ", province=" + province + ", district=" + district + ", customernearestcity=" + customernearestcity
				+ ", description=" + description + ", errorflag=" + errorflag + ", displayemessage=" + displayemessage
				+ ", orderadddate=" + orderadddate + ", orderstatus=" + orderstatus + ", customeraddress2="
				+ customeraddress2 + ", customerphone2=" + customerphone2 + "]";
	}






	

}
