package lk.nexus.client.models;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "nexussubcat")
public class Nexussubcat {
	

	private String nexusmaincatid;
	//@Id
	private String nexussubcatid;
	private String nexussubcatdesc;
	
	public String getNexusmaincatid() {
		return nexusmaincatid;
	}
	public void setNexusmaincatid(String nexusmaincatid) {
		this.nexusmaincatid = nexusmaincatid;
	}
	public String getNexussubcatid() {
		return nexussubcatid;
	}
	public void setNexussubcatid(String nexussubcatid) {
		this.nexussubcatid = nexussubcatid;
	}
	public String getNexussubcatdesc() {
		return nexussubcatdesc;
	}
	public void setNexussubcatdesc(String nexussubcatdesc) {
		this.nexussubcatdesc = nexussubcatdesc;
	}
	@Override
	public String toString() {
		return "Nexussubcat [nexusmaincatid=" + nexusmaincatid + ", nexussubcatid=" + nexussubcatid
				+ ", nexussubcatdesc=" + nexussubcatdesc + "]";
	}
	
	

}
