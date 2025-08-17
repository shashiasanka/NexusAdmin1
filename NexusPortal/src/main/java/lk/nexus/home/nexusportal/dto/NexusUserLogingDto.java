package lk.nexus.home.nexusportal.dto;

public class NexusUserLogingDto {
	
	private String username;
	
	private String password;
	
	private String empid;
	
	private String nexusstatus;

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

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getNexusstatus() {
		return nexusstatus;
	}

	public void setNexusstatus(String nexusstatus) {
		this.nexusstatus = nexusstatus;
	}

	@Override
	public String toString() {
		return "NexusUserLogingDto [username=" + username + ", password=" + password + ", empid=" + empid
				+ ", nexusstatus=" + nexusstatus + "]";
	}

	
	
	
	

}
