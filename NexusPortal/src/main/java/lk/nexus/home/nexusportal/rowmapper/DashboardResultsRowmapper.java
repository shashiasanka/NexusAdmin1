package lk.nexus.home.nexusportal.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lk.nexus.home.nexusportal.dto.DashboardResults;
import lk.nexus.home.nexusportal.util.ClientOrderStatus;




public class DashboardResultsRowmapper implements RowMapper<DashboardResults> {

	@Override
	public DashboardResults mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DashboardResults dashRes = new DashboardResults(); 
		while(rs.next()) {
			//abc statusdescription os.statuscode ordercount
			String key = rs.getString("statuscode");
			switch (key) {
			case ClientOrderStatus.newOrder:
				dashRes.setNewOrderval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.receiveToWearhouse:
				dashRes.setReceiveToWearhouseval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.dispatchFromWearhouse:
				dashRes.setDispatchFromWearhouseval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.receiveToBranch:
				dashRes.setReceiveToBranchval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.dispatchFromBranch:
				dashRes.setDispatchFromBranchval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.orderCompleted:
				dashRes.setOrderCompletedval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.orderFailed:
				dashRes.setOrderFailedval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.returnToBranch:
				dashRes.setReturnToBranchval(rs.getString("ordercount"));
				break;
			case ClientOrderStatus.returnToWearhouse:
				dashRes.setReturnToWearhouseval(rs.getString("ordercount"));
				break;

			default:
				break;
			}
			
		}
		
		return dashRes;
	}
	

}
