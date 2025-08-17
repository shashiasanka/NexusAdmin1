package lk.nexus.home.nexusportal.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nexusubranches {
	
	private String branchcode;
	private String branchname;
	
	
	public Nexusubranches() {}
	
	
	public Nexusubranches(String branchcode, String branchname) {
		super();
		this.branchcode = branchcode;
		this.branchname = branchname;
	}
	@Id
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	
	
	

}
