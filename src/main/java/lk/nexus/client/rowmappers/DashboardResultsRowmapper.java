package lk.nexus.client.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;


import lk.nexus.client.dto.DashboardResults;
import lk.nexus.client.util.ClientOrderStatus;


public class DashboardResultsRowmapper implements RowMapper<DashboardResults> {

	private static final Logger logger = LogManager.getLogger(DashboardResultsRowmapper.class);
	@Override
	public DashboardResults mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.info(":::: DashboardResultsRowmapper :::::  " + rs.getFetchSize());
		DashboardResults dashRes = new DashboardResults();
		while(rs.next()) {
			//abc statusdescription os.statuscode ordercount
			
			//String key = rs.getString("statuscode");
			String key = rs.getString("orderstatus");
			
			logger.info(":::: DashboardResultsRowmapper point 2 key :::::  " + key);
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
