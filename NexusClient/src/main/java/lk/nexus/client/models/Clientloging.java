package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientloging")
public class Clientloging {
	
	
	private String username;
	
	private String password;
	
	private String clientid;
	
	private String clientrole;
	
	private String loginstatus;
	
	private String clientbusinessname;

	public Clientloging() {
		
	}
	
	
	
	@Id
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getClientrole() {
		return clientrole;
	}

	public void setClientrole(String clientrole) {
		this.clientrole = clientrole;
	}

	public String getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}



	public String getClientbusinessname() {
		return clientbusinessname;
	}



	public void setClientbusinessname(String clientbusinessname) {
		this.clientbusinessname = clientbusinessname;
	}



	@Override
	public String toString() {
		return "Clientloging [username=" + username + ", password=" + password + ", clientid=" + clientid
				+ ", clientrole=" + clientrole + ", loginstatus=" + loginstatus + ", clientbusinessname="
				+ clientbusinessname + "]";
	}

	

	
	
	
	

}
