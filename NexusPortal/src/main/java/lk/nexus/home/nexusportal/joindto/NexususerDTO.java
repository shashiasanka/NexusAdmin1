package lk.nexus.home.nexusportal.joindto;

public class NexususerDTO {

	private String empid;

	private String role;
	
	private String branch;

	private String username;

	private String password;

	private String employeename;

	private String user_nic;
	
	private String nexusstatus;
	
	private String branchCode;
	
	private String roleCode;
	
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

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

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getUser_nic() {
		return user_nic;
	}

	public void setUser_nic(String user_nic) {
		this.user_nic = user_nic;
	}

	public String getNexusstatus() {
		return nexusstatus;
	}

	public void setNexusstatus(String nexusstatus) {
		this.nexusstatus = nexusstatus;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "NexususerDTO [empid=" + empid + ", role=" + role + ", branch=" + branch + ", username=" + username
				+ ", password=" + password + ", employeename=" + employeename + ", user_nic=" + user_nic
				+ ", nexusstatus=" + nexusstatus + ", branchCode=" + branchCode + ", roleCode=" + roleCode + "]";
	}

	
	
	
	
	

}
