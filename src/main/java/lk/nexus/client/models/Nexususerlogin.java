package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;



@Entity
public class Nexususerlogin {

	@Id
	private Long id;
	private String username;
	private String password;
	private String empid;
	private String nexusstatus;
	

//	private String role;	
//	private String branch;	
//	private String employeename;
	

	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Nexususers nexususer;
		
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

	
	
	public Nexususers getNexususer() {
		return nexususer;
	}
	public void setNexususer(Nexususers nexususer) {
		this.nexususer = nexususer;
	}
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
//	
//	@Transient
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
//	
//	@Transient
//	public String getBranch() {
//		return branch;
//	}
//	public void setBranch(String branch) {
//		this.branch = branch;
//	}
//	@Transient
//	public String getEmployeename() {
//		return employeename;
//	}
//	public void setEmployeename(String employeename) {
//		this.employeename = employeename;
//	}
	@Override
	public String toString() {
		return "Nexususerlogin [id=" + id + ", username=" + username + ", password=" + password + ", empid=" + empid
				+ ", nexusstatus=" + nexusstatus + ", nexususer=" + nexususer + "]";
	}
	
	
	
}
