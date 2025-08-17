package lk.nexus.home.nexusportal.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nexususerroles {

	private String rolecode;
	private String rolename;
	
	
	public Nexususerroles() {}
	
	public Nexususerroles(String rolecode, String rolename) {
		super();
		this.rolecode = rolecode;
		this.rolename = rolename;
	}
	@Id
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
