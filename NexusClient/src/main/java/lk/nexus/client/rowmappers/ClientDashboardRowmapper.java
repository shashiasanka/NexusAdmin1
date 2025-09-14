package lk.nexus.client.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lk.nexus.client.dto.DashboardCount2;



public class ClientDashboardRowmapper implements RowMapper<DashboardCount2> {

	@Override
	public DashboardCount2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub ordercount, os.statusdescription, os.statuscode
		DashboardCount2 dsh = new DashboardCount2();
		
		dsh.setOrdercount(rs.getInt("ordercount"));
		dsh.setStatuscode(rs.getString("statuscode"));
		dsh.setStatusdesc(rs.getString("statusdescription"));
		
		return dsh;
	}

}
