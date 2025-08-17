package lk.nexus.home.nexusportal.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankdetails")
public class Bankdetails {
	
	@Id
	private String bankcode;
	private String bankdescription;
	
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getBankdescription() {
		return bankdescription;
	}
	public void setBankdescription(String bankdescription) {
		this.bankdescription = bankdescription;
	}
	@Override
	public String toString() {
		return "Bankdetails [bankcode=" + bankcode + ", bankdescription=" + bankdescription + "]";
	}
	
	
	
}
