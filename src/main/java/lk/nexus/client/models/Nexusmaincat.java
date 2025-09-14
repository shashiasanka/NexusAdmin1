package lk.nexus.client.models;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "nexusmaincat") 
public class Nexusmaincat {

	//@Id
	private String nexusmaincatid;
	private String nexusmaincatdesc;
	
	public String getNexusmaincatid() {
		return nexusmaincatid;
	}
	public void setNexusmaincatid(String nexusmaincatid) {
		this.nexusmaincatid = nexusmaincatid;
	}
	public String getNexusmaincatdesc() {
		return nexusmaincatdesc;
	}
	public void setNexusmaincatdesc(String nexusmaincatdesc) {
		this.nexusmaincatdesc = nexusmaincatdesc;
	}
	@Override
	public String toString() {
		return "Nexusmaincat [nexusmaincatid=" + nexusmaincatid + ", nexusmaincatdesc=" + nexusmaincatdesc + "]";
	}
	
	
	

}
