package lk.nexus.home.nexusportal.dto;

import javax.persistence.Transient;

public class RegisterDto {

	private Long id;
	private String fullname_businessname;
	private String systemName;
	private String address1;
	private String address2;
	private String emailaddress;
	private String pickupbranchDesc;
	private String pickupbranch;
	private String accouttype;
	private String nic_drivinglicence;

	private String contactno;
	private String brno;
	
	private String contactperson;
	private String businessName;
	
	private String bankNameDesc;
	private String bankName;
	private String accountHolderName;
	private String bankAccountType;
	private String bankAccountBranchDesc;
	private String bankAccountBranch;
	//private String accountNo;
	
	private String webstore;
	private String city;
	private String clientreferential;
	private String username;
	private String password;
	private String confirmpassword;
	//isregistersuccess
	private String accountid;
	
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
	
		private String accouttypedesc;
		
		private String sms_recv_pic_br;
		private String sms_recv_ho;
		private String sms_disp_dest_br;
		private String sms_recv_dest_br;
		private String sms_out_dele;
		private String sms_rech_1;
		private String sms_rech_2;
		private String sms_rech_3;
		private String sms_returned; 
		private String sms_delivered;
		
		private String isregistersuccess;
		
		private String ratecode;
	
	public String getFullname_businessname() {
		return fullname_businessname;
	}
	public void setFullname_businessname(String fullname_businessname) {
		this.fullname_businessname = fullname_businessname;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
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
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankAccountType() {
		return bankAccountType;
	}
	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
	public String getBankAccountBranch() {
		return bankAccountBranch;
	}
	public void setBankAccountBranch(String bankAccountBranch) {
		this.bankAccountBranch = bankAccountBranch;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccouttypedesc() {
		return accouttypedesc;
	}
	public void setAccouttypedesc(String accouttypedesc) {
		this.accouttypedesc = accouttypedesc;
	}
	public String getPickupbranchDesc() {
		return pickupbranchDesc;
	}
	public void setPickupbranchDesc(String pickupbranchDesc) {
		this.pickupbranchDesc = pickupbranchDesc;
	}
	public String getBankNameDesc() {
		return bankNameDesc;
	}
	public void setBankNameDesc(String bankNameDesc) {
		this.bankNameDesc = bankNameDesc;
	}
	public String getBankAccountBranchDesc() {
		return bankAccountBranchDesc;
	}
	public void setBankAccountBranchDesc(String bankAccountBranchDesc) {
		this.bankAccountBranchDesc = bankAccountBranchDesc;
	}
	public String getSms_recv_pic_br() {
		return sms_recv_pic_br;
	}
	public void setSms_recv_pic_br(String sms_recv_pic_br) {
		this.sms_recv_pic_br = sms_recv_pic_br;
	}
	public String getSms_recv_ho() {
		return sms_recv_ho;
	}
	public void setSms_recv_ho(String sms_recv_ho) {
		this.sms_recv_ho = sms_recv_ho;
	}
	public String getSms_disp_dest_br() {
		return sms_disp_dest_br;
	}
	public void setSms_disp_dest_br(String sms_disp_dest_br) {
		this.sms_disp_dest_br = sms_disp_dest_br;
	}
	public String getSms_recv_dest_br() {
		return sms_recv_dest_br;
	}
	public void setSms_recv_dest_br(String sms_recv_dest_br) {
		this.sms_recv_dest_br = sms_recv_dest_br;
	}
	public String getSms_out_dele() {
		return sms_out_dele;
	}
	public void setSms_out_dele(String sms_out_dele) {
		this.sms_out_dele = sms_out_dele;
	}
	public String getSms_rech_1() {
		return sms_rech_1;
	}
	public void setSms_rech_1(String sms_rech_1) {
		this.sms_rech_1 = sms_rech_1;
	}
	public String getSms_rech_2() {
		return sms_rech_2;
	}
	public void setSms_rech_2(String sms_rech_2) {
		this.sms_rech_2 = sms_rech_2;
	}
	public String getSms_rech_3() {
		return sms_rech_3;
	}
	public void setSms_rech_3(String sms_rech_3) {
		this.sms_rech_3 = sms_rech_3;
	}
	public String getSms_returned() {
		return sms_returned;
	}
	public void setSms_returned(String sms_returned) {
		this.sms_returned = sms_returned;
	}
	public String getSms_delivered() {
		return sms_delivered;
	}
	public void setSms_delivered(String sms_delivered) {
		this.sms_delivered = sms_delivered;
	}
	public String getIsregistersuccess() {
		return isregistersuccess;
	}
	public void setIsregistersuccess(String isregistersuccess) {
		this.isregistersuccess = isregistersuccess;
	}
	public String getRatecode() {
		return ratecode;
	}
	public void setRatecode(String ratecode) {
		this.ratecode = ratecode;
	}
	@Override
	public String toString() {
		return "RegisterDto [id=" + id + ", fullname_businessname=" + fullname_businessname + ", systemName="
				+ systemName + ", address1=" + address1 + ", address2=" + address2 + ", emailaddress=" + emailaddress
				+ ", pickupbranchDesc=" + pickupbranchDesc + ", pickupbranch=" + pickupbranch + ", accouttype="
				+ accouttype + ", nic_drivinglicence=" + nic_drivinglicence + ", contactno=" + contactno + ", brno="
				+ brno + ", contactperson=" + contactperson + ", businessName=" + businessName + ", bankNameDesc="
				+ bankNameDesc + ", bankName=" + bankName + ", accountHolderName=" + accountHolderName
				+ ", bankAccountType=" + bankAccountType + ", bankAccountBranchDesc=" + bankAccountBranchDesc
				+ ", bankAccountBranch=" + bankAccountBranch + ", webstore=" + webstore + ", city=" + city
				+ ", clientreferential=" + clientreferential + ", username=" + username + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", accountid=" + accountid + ", smsalert=" + smsalert
				+ ", payementtype=" + payementtype + ", relationshiptobusiness=" + relationshiptobusiness
				+ ", contactno2=" + contactno2 + ", ratetype=" + ratetype + ", contactpersonnic=" + contactpersonnic
				+ ", errormessage=" + errormessage + ", accouttypedesc=" + accouttypedesc + ", sms_recv_pic_br="
				+ sms_recv_pic_br + ", sms_recv_ho=" + sms_recv_ho + ", sms_disp_dest_br=" + sms_disp_dest_br
				+ ", sms_recv_dest_br=" + sms_recv_dest_br + ", sms_out_dele=" + sms_out_dele + ", sms_rech_1="
				+ sms_rech_1 + ", sms_rech_2=" + sms_rech_2 + ", sms_rech_3=" + sms_rech_3 + ", sms_returned="
				+ sms_returned + ", sms_delivered=" + sms_delivered + ", isregistersuccess=" + isregistersuccess
				+ ", ratecode=" + ratecode + "]";
	}
	
	
	
	
	
	
	
	
	
}
