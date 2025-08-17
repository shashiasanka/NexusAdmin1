package lk.nexus.home.nexusportal.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientregister")
public class Clientregister {

	
	private String fullname_businessname;	
	private String  address1;				
	private String  emailaddress; 		   	
	private String  pickupbranch;          	
	private String  accouttype;          	
	private String  nic_drivinglicence;    	
	private String  contactno;               
	private String  busregno;                
	private String  contactperson;           
	private String  bank_account_holder_name;
	private String  bank_account_no; 		
	private String  bank_account_branch; 	
	private String  bank_account_type; 		
	private String  bank_name; 				
	private String  business_name;			
	private String  system_name; 			
	private String  webstore; 				
	private String  city; 					
	private String  clientreferential;
	@Id
	private String  accountid;				
	private String  smsalert; 				
	private String  payementtype;			
	private String  relationshiptobusiness;	
	private String  contactno2; 				
	private String  ratetype; 				
	private String  contactpersonnic;
	
	public String getFullname_businessname() {
		return fullname_businessname;
	}
	public void setFullname_businessname(String fullname_businessname) {
		this.fullname_businessname = fullname_businessname;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPickupbranch() {
		return pickupbranch;
	}
	public void setPickupbranch(String pickupbranch) {
		this.pickupbranch = pickupbranch;
	}
	public String getAccouttype() {
		return accouttype;
	}
	public void setAccouttype(String accouttype) {
		this.accouttype = accouttype;
	}
	public String getNic_drivinglicence() {
		return nic_drivinglicence;
	}
	public void setNic_drivinglicence(String nic_drivinglicence) {
		this.nic_drivinglicence = nic_drivinglicence;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getBusregno() {
		return busregno;
	}
	public void setBusregno(String busregno) {
		this.busregno = busregno;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getBank_account_holder_name() {
		return bank_account_holder_name;
	}
	public void setBank_account_holder_name(String bank_account_holder_name) {
		this.bank_account_holder_name = bank_account_holder_name;
	}
	public String getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(String bank_account_no) {
		this.bank_account_no = bank_account_no;
	}
	public String getBank_account_branch() {
		return bank_account_branch;
	}
	public void setBank_account_branch(String bank_account_branch) {
		this.bank_account_branch = bank_account_branch;
	}
	public String getBank_account_type() {
		return bank_account_type;
	}
	public void setBank_account_type(String bank_account_type) {
		this.bank_account_type = bank_account_type;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getSystem_name() {
		return system_name;
	}
	public void setSystem_name(String system_name) {
		this.system_name = system_name;
	}
	public String getWebstore() {
		return webstore;
	}
	public void setWebstore(String webstore) {
		this.webstore = webstore;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClientreferential() {
		return clientreferential;
	}
	public void setClientreferential(String clientreferential) {
		this.clientreferential = clientreferential;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getSmsalert() {
		return smsalert;
	}
	public void setSmsalert(String smsalert) {
		this.smsalert = smsalert;
	}
	public String getPayementtype() {
		return payementtype;
	}
	public void setPayementtype(String payementtype) {
		this.payementtype = payementtype;
	}
	public String getRelationshiptobusiness() {
		return relationshiptobusiness;
	}
	public void setRelationshiptobusiness(String relationshiptobusiness) {
		this.relationshiptobusiness = relationshiptobusiness;
	}
	public String getContactno2() {
		return contactno2;
	}
	public void setContactno2(String contactno2) {
		this.contactno2 = contactno2;
	}
	public String getRatetype() {
		return ratetype;
	}
	public void setRatetype(String ratetype) {
		this.ratetype = ratetype;
	}
	public String getContactpersonnic() {
		return contactpersonnic;
	}
	public void setContactpersonnic(String contactpersonnic) {
		this.contactpersonnic = contactpersonnic;
	}
	
	

	
	
}
