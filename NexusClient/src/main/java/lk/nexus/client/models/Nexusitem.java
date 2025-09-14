package lk.nexus.client.models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "nexusitem")
public class Nexusitem {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nexusitemid;
	
	private String nexusmaincatid;
	private String nexussubcatid;
	private String nexusitemdesc;
	
	public int getNexusitemid() {
		return nexusitemid;
	}
	public void setNexusitemid(int nexusitemid) {
		this.nexusitemid = nexusitemid;
	}
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
	public String getNexusitemdesc() {
		return nexusitemdesc;
	}
	public void setNexusitemdesc(String nexusitemdesc) {
		this.nexusitemdesc = nexusitemdesc;
	}
	
	@Override
	public String toString() {
		return "Nexusitem [nexusitemid=" + nexusitemid + ", nexusmaincatid=" + nexusmaincatid + ", nexussubcatid="
				+ nexussubcatid + ", nexusitemdesc=" + nexusitemdesc + "]";
	}
	
	


}
