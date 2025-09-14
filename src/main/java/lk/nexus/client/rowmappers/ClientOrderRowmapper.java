package lk.nexus.client.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import lk.nexus.client.dto.ClientOrderDto;


public class ClientOrderRowmapper implements RowMapper<ClientOrderDto> {

	@Override
	public ClientOrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClientOrderDto co = new ClientOrderDto();
		
		co.setCodamount(rs.getDouble("codamount"));
		co.setCreatedDate(rs.getDate("created_date"));
		try {
			co.setOrderstatusdesc(rs.getString("orderstatusdesc"));
			co.setOrdertrackingid(rs.getString("ordertrackingid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		co.setOrderid(rs.getString("orderid"));
		co.setRemarks(rs.getString("remarks"));
		//paymenttype codamount
		String paymenttype = rs.getString("paymenttype");
		if(paymenttype.equals("C")) {
			co.setPaymenttype("Cash");
		}else {
			co.setPaymenttype("Paid");
		}
		
		
		co.setContactno(rs.getString("customerphone"));
		co.setCustomeraddress(rs.getString("customeraddress"));
		co.setCustomername(rs.getString("customername"));
		co.setCustomernearestcity(rs.getString("customernearestcity"));
		co.setCustomerphone(rs.getString("customerphone"));
		
		co.setCustomerphone2(rs.getString("customerphone2"));
		co.setDescription(rs.getString("description"));
//		try {
//			//co.setDistrictdesc(rs.getString("distdesc"));
//			co.setProvincedesc(rs.getString("provdesc")); 
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		co.setWeight(rs.getDouble("weight"));
		
		
		try {
			co.setCharge_nexus_amount(rs.getDouble("charge_nexus_amount"));
			co.setCharge_weight_amount(rs.getDouble("charge_weight_amount"));
			co.setReady_to_send(rs.getString("ready_to_send"));
			
			co.setFrom_name(rs.getString("from_name"));
			co.setFrom_phone(rs.getString("from_phone"));
			co.setFrom_address(rs.getString("from_address"));
			
			co.setTo_branch(rs.getString("to_branch"));
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
//		`clientname` varchar(64) DEFAULT NULL,
//		  `contactno` varchar(16) DEFAULT NULL,
//		  `clientid` varchar(32) DEFAULT NULL,
//		  `orderid` varchar(16) DEFAULT NULL,
//		  `ordertrackingid` varchar(16) NOT NULL,
//		  `paymenttype` varchar(4) DEFAULT NULL,
//		  `codamount` double NOT NULL,
//		  `weight` double NOT NULL,
//		  `remarks` varchar(128) DEFAULT NULL,
//		  `customername` varchar(128) DEFAULT NULL,
//		  `customeraddress` varchar(256) DEFAULT NULL,
//		  `customerphone` varchar(16) DEFAULT NULL,
//		  `province` int(16) DEFAULT NULL,
//		  `district` int(16) DEFAULT NULL,
//		  `customernearestcity` varchar(16) DEFAULT NULL,
//		  `description` varchar(256) DEFAULT NULL,
//		  `orderadddate` date DEFAULT NULL,
//		  `orderstatus` varchar(4) DEFAULT NULL,
//		  `customerphone2` varchar(10) NOT NULL,
//		  `created_date` date DEFAULT NULL
		
		return co;
	}

}
