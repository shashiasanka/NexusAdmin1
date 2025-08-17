package lk.nexus.home.nexusportal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankbranchdetails")
public class Bankbranchdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bankcode;
	private String barnchcode;
	private String branchdescription;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getBarnchcode() {
		return barnchcode;
	}
	public void setBarnchcode(String barnchcode) {
		this.barnchcode = barnchcode;
	}
	public String getBranchdescription() {
		return branchdescription;
	}
	public void setBranchdescription(String branchdescription) {
		this.branchdescription = branchdescription;
	}
	
	@Override
	public String toString() {
		return "Bankbranchdetails [id=" + id + ", bankcode=" + bankcode + ", barnchcode=" + barnchcode
				+ ", branchdescription=" + branchdescription + "]";
	}
	
	
	

}