package lk.nexus.client.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "verification_token")
public class VerificationToken {

	

	
	
	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="token")
	private String token;



	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="expiry_date")
	private Date expiryDate;

	@Column(name="username")
	 private String username;
	
	@Column(name="accountid")
	private String accountid;
	
	@Column(name="regseq")
	private Long regseq;
	
	@Transient
	private String isexpired;
	
	
	public VerificationToken() {
		super();
	}

	public VerificationToken(final String token) {
		super();

		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public VerificationToken(final String token, final String username ,final String accountid) {
		super();
		Calendar calendar = Calendar.getInstance();
		System.out.println("sdsfdfdfd");
		this.token = token;
		this.username = username;
		this.createdDate = new Date(calendar.getTime().getTime());
		this.expiryDate = calculateExpiryDate(EXPIRATION);
		this.accountid = accountid;
		
		//this.clientid = user.getAccountid();
	}
	
	
	

	public VerificationToken(final String token, final String username ,final String accountid,	Long regseq) {
		super();
		Calendar calendar = Calendar.getInstance();
		this.id = id;
		this.token = token;
		this.username = username;
		this.createdDate = new Date(calendar.getTime().getTime());
		this.expiryDate = calculateExpiryDate(EXPIRATION);
		this.accountid = accountid;
		this.regseq = regseq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}	
		

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Timestamp(calendar.getTime().getTime()));
		// calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		// calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(calendar.getTime().getTime());
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Long getRegseq() {
		return regseq;
	}

	public void setRegseq(Long regseq) {
		this.regseq = regseq;
	}

	public String getIsexpired() {
		return isexpired;
	}

	public void setIsexpired(String isexpired) {
		this.isexpired = isexpired;
	}

	
	
	
}
