package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "branchdetails")
public class Branchdetails {
	
	@Id
	private String branchcode;
	private String branchdescription;
	
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public String getBranchdescription() {
		return branchdescription;
	}
	public void setBranchdescription(String branchdescription) {
		this.branchdescription = branchdescription;
	}
	@Override
	public String toString() {
		return "Branchdetails [branchcode=" + branchcode + ", branchdescription=" + branchdescription + "]";
	}
	
	
	
	
}
