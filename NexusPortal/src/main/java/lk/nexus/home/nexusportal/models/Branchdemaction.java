package lk.nexus.home.nexusportal.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branchdemaction {

	
	private String branchcode;
	private String areacode;
	private String areadescription;
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	@Id
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreadescription() {
		return areadescription;
	}
	public void setAreadescription(String areadescription) {
		this.areadescription = areadescription;
	}
	
	
	
}
