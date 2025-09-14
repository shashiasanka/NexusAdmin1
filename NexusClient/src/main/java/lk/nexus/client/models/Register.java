package lk.nexus.client.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity
@Table(name = "register")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullname_businessname;
	private String systemname;
	private String address1;
	private String address2;
	private String emailaddress;
	private String pickupbranch;
	private String accouttype;
	private String nic_drivinglicence;

	private String contactno;
	private String brno;
	
	private String contactperson;
	private String businessname;
	
	private String bankname;	
	private String accountholdername;
	private String bankaccounttype;
	private String bankaccountbranch;
	//private String accountNo;
	
	private String webstore;
	private String city;
	private String clientreferential;
//	private String username;
//	private String password;
//	private String confirmpassword;
	//isregistersuccess
	private String accountid;
	
	private String isregistersuccess;
	
	//@Transient
	private String smsalert;
	
	//@Transient
	private String payementtype;
	
	//@Transient
	private String relationshiptobusiness;
	
	//@Transient
	private String contactno2;
	
	//@Transient
	private String ratetype;
	
	//@Transient
	private String contactpersonnic;
	
	@Transient
	private String errormessage;
	//private Clientloging clientloging;
	
	//@OneToMany(targetEntity = Pickuprequest.class, mappedBy = "clientid", orphanRemoval = false, fetch = FetchType.LAZY)
	
//	@OneToMany(targetEntity = Pickuprequest.class, mappedBy = "clientid", orphanRemoval = false, fetch = FetchType.EAGER)	
//	@JoinTable(name = "pickuprequest", joinColumns = { @JoinColumn(name = "accountid") }, inverseJoinColumns = { @JoinColumn(name = "clientid") })	  
//	private Set<Pickuprequest> employees;
	//@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	  
	public Register() {
		
	}
	
	


	


//
//
//	public Register(String fullname_businessname, String systemName, String address1, String address2,
//			String emailaddress, String pickupbranch, String accouttype, String nic_drivinglicence, String contactno,
//			String brno, String contactperson, String businessName, String bankName, String accountHolderName,
//			String bankAccountType, String bankAccountBranch, String webstore, String city, String clientreferential,
//			String username, String password, String confirmpassword, String accountid, String isregistersuccess,
//			Clientloging clientloging) {
//		super();
//		this.fullname_businessname = fullname_businessname;
//		this.systemName = systemName;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.emailaddress = emailaddress;
//		this.pickupbranch = pickupbranch;
//		this.accouttype = accouttype;
//		this.nic_drivinglicence = nic_drivinglicence;
//		this.contactno = contactno;
//		this.brno = brno;
//		this.contactperson = contactperson;
//		this.businessName = businessName;
//		this.bankName = bankName;
//		this.accountHolderName = accountHolderName;
//		this.bankAccountType = bankAccountType;
//		this.bankAccountBranch = bankAccountBranch;
//		this.webstore = webstore;
//		this.city = city;
//		this.clientreferential = clientreferential;
//		this.username = username;
//		this.password = password;
//		this.confirmpassword = confirmpassword;
//		this.accountid = accountid;
//		this.isregistersuccess = isregistersuccess;
//		this.clientloging = clientloging;
//	}

//
//	public Register(Long id, String fullname_businessname, String systemName, String address1, String address2,
//			String emailaddress, String pickupbranch, String accouttype, String nic_drivinglicence, String contactno,
//			String brno, String contactperson, String businessName, String bankName, String accountHolderName,
//			String bankAccountType, String bankAccountBranch, String webstore, String city, String clientreferential,
//			String username, String password, String confirmpassword, String accountid, String isregistersuccess,
//			Clientloging clientloging) {
//			//Clientloging clientloging) {
//		super();
//		this.id = id;
//		this.fullname_businessname = fullname_businessname;
//		this.systemName = systemName;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.emailaddress = emailaddress;
//		this.pickupbranch = pickupbranch;
//		this.accouttype = accouttype;
//		this.nic_drivinglicence = nic_drivinglicence;
//		this.contactno = contactno;
//		this.brno = brno;
//		this.contactperson = contactperson;
//		this.businessName = businessName;
//		this.bankName = bankName;
//		this.accountHolderName = accountHolderName;
//		this.bankAccountType = bankAccountType;
//		this.bankAccountBranch = bankAccountBranch;
//		this.webstore = webstore;
//		this.city = city;
//		this.clientreferential = clientreferential;
//		this.username = username;
//		this.password = password;
//		this.confirmpassword = confirmpassword;
//		this.accountid = accountid;
//		this.isregistersuccess = isregistersuccess;
//		//this.clientloging = clientloging;
//	}







	public String getFullname_businessname() {
		return fullname_businessname;
	}
	



	public void setFullname_businessname(String fullname_businessname) {
		this.fullname_businessname = fullname_businessname;
	}
	
	
	
	public String getSystemname() {
		return systemname;
	}







	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}







	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	public String getBrno() {
		return brno;
	}
	public void setBrno(String brno) {
		this.brno = brno;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	
	
	
//	public String getAccountNo() {
//		return accountNo;
//	}
//	public void setAccountNo(String accountNo) {
//		this.accountNo = accountNo;
//	}
	
	
	
	
	
	
	public String getBusinessname() {
		return businessname;
	}







	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}







	public String getWebstore() {
		return webstore;
	}


	public String getBankname() {
		return bankname;
	}







	public void setBankname(String bankname) {
		this.bankname = bankname;
	}







	public String getAccountholdername() {
		return accountholdername;
	}







	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}







	public String getBankaccounttype() {
		return bankaccounttype;
	}







	public void setBankaccounttype(String bankaccounttype) {
		this.bankaccounttype = bankaccounttype;
	}







	public String getBankaccountbranch() {
		return bankaccountbranch;
	}







	public void setBankaccountbranch(String bankaccountbranch) {
		this.bankaccountbranch = bankaccountbranch;
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

//
//	public String getUsername() {
//		return username;
//	}
//

//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//
//	public String getPassword() {
//		return password;
//	}
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//	public String getConfirmpassword() {
//		return confirmpassword;
//	}
//
//
//
//
//	public void setConfirmpassword(String confirmpassword) {
//		this.confirmpassword = confirmpassword;
//	}




//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "accountid", referencedColumnName = "clientid")
//	public Clientloging getClientloging() {
//		return clientloging;
//	}

//	public void setClientloging(Clientloging clientloging) {
//		this.clientloging = clientloging;
//	}




	public String getIsregistersuccess() {
		return isregistersuccess;
	}




	public void setIsregistersuccess(String isregistersuccess) {
		this.isregistersuccess = isregistersuccess;
	}



	
	public String getAccountid() {
		return accountid;
	}




	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}








	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
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







	public String getErrormessage() {
		return errormessage;
	}







	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}


	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
		
	
	
	
}
