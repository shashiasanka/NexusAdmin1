package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branchdemaction")
public class Branchdemaction {

	private String branchcode;
//	@Id
//	private String areacode;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long areacode;
	private String areadescription;
	public String getBranchcode() {
		return branchcode;
	}
	
	
	
	public Long getAreacode() {
		return areacode;
	}



	public void setAreacode(Long areacode) {
		this.areacode = areacode;
	}



	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}



	public String getAreadescription() {
		return areadescription;
	}
	public void setAreadescription(String areadescription) {
		this.areadescription = areadescription;
	}
	@Override
	public String toString() {
		return "Branchdemaction [branchcode=" + branchcode + ", areacode=" + areacode + ", areadescription="
				+ areadescription + "]";
	}
	
	
	
}
