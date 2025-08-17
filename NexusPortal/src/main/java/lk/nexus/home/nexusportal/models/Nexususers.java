package lk.nexus.home.nexusportal.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
public class Nexususers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String empid;
	
	private String role;	
	private String branch;
	
	//private String username;
	
	//private String password;	
	
	private String employeename;
	
	private String user_nic;
	//private Nexususerlogin userloging;
	
	public Nexususers() {
		
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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


	@Override
	public String toString() {
		return "Nexususers [id=" + id + ", empid=" + empid + ", role=" + role + ", branch=" + branch + ", employeename="
				+ employeename + ", user_nic=" + user_nic + "]";
	}

	

//	@Transient
//	public String getUsername() {
//		return username;
//	}
//
//
//
//
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//
//
//
//	@Transient
//	public String getPassword() {
//		return password;
//	}
//
//
//
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//



//	@OneToOne(cascade = CascadeType.ALL)
//    //@JoinColumn(name = "id", referencedColumnName = "id")
//	@PrimaryKeyJoinColumn
//	public Nexususerlogin getUserloging() {
//		return userloging;
//	}








//	public void setUserloging(Nexususerlogin userloging) {
//		this.userloging = userloging;
//	}










	
	
	
	
}
