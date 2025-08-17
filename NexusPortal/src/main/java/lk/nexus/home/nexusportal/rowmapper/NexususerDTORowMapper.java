package lk.nexus.home.nexusportal.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lk.nexus.home.nexusportal.joindto.NexususerDTO;

public class NexususerDTORowMapper implements RowMapper<NexususerDTO>{

	@Override
	public NexususerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		NexususerDTO obj = new NexususerDTO();
		  
		  obj.setBranch(rs.getString("branchDesc"));
		  obj.setEmpid(rs.getString("empid"));
		  obj.setEmployeename(rs.getString("employeename"));
		  obj.setRole(rs.getString("roleDesc"));
		  obj.setUser_nic(rs.getString("user_nic"));
		  //obj.setUsername(rs.getString("username"));
		 // obj.setNexusstatus(rs.getString("nexusstatus")); 
		  obj.setBranchCode(rs.getString("branch"));
		  obj.setRoleCode(rs.getString("role"));
		
		
		return obj;
	}

}
