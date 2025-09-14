package lk.nexus.client.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lk.nexus.client.controller.LogingController;
import lk.nexus.client.dto.DashboardResults;
import lk.nexus.client.rowmappers.DashboardResultsRowmapper;

@Repository
public class ClientOrderJdbcRepository {

	private static final Logger logger = LogManager.getLogger(ClientOrderJdbcRepository.class);
	@Autowired
	JdbcTemplate template;

	public DashboardResults getDashboardResultofaClientRepo(String clientid) {
		DashboardResults dashboard = null;
		logger.info(" ::::: getDashboardResultofaClientRepo Start ::::: "+clientid);
		try {
			
			/*
			 * SELECT count(co.orderstatus), os.statusdescription, os.statuscode FROM orderstatus os LEFT JOIN clientorder co ON os.statuscode = co.orderstatus GROUP by os.statuscode;
			 * 
			 * 
			 * */
			
			
//			dashboard = (DashboardResults) template.queryForObject(
//					"SELECT count(os.statuscode) as ordercount ,os.statusdescription, os.statuscode FROM clientorder co, orderstatus os WHERE os.statuscode = co.orderstatus and co.clientid = ? GROUP by os.statuscode",
//					new Object[] { clientid }, new DashboardResultsRowmapper());

//			dashboard = (DashboardResults) template.queryForObject(
//			"SELECT count(co.orderstatus) as ordercount,co.orderstatus FROM clientorder co WHERE co.clientid = ? GROUP by co.orderstatus",
//			new Object[] { clientid }, new DashboardResultsRowmapper());
	
			
//			dashboard = (DashboardResults) template.queryForObject(
//			"SELECT count(co.orderstatus) as ordercount,co.orderstatus FROM clientorder co WHERE co.clientid = ? GROUP by co.orderstatus",
//			new Object[] { clientid }, BeanPropertyRowMapper<T>.newInstance(mappedClass));
	
			
			
//			dashboard = (DashboardResults) template.query(
//					"SELECT count(co.orderstatus) as ordercount,co.orderstatus FROM clientorder co WHERE co.clientid = ? GROUP by co.orderstatus",
//					new Object[] { clientid },new RowMapper<DashboardResults>() {
//
//						@Override
//						public DashboardResults mapRow(ResultSet rs, int rowNum) throws SQLException {
//							// TODO Auto-generated method stub
//							System.out.println("@@@@@"+rowNum);
//							DashboardResults d = new DashboardResults();
//							//DashboardResults dashRes = new DashboardResults();
//							while(rs.next()) {
//								//abc statusdescription os.statuscode ordercount
//								
//								//String key = rs.getString("statuscode");
//								String key = rs.getString("orderstatus");
//								System.out.println("@@@@@"+key);
//							}
//							
//							return d;
//						}});
			
			template.query(
					"SELECT count(co.orderstatus) as ordercount,co.orderstatus FROM clientorder co GROUP by co.orderstatus",
					new RowMapper<DashboardResults>() {

						@Override
						public DashboardResults mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							System.out.println("@@@@@"+rowNum);
							DashboardResults d = new DashboardResults();
							//DashboardResults dashRes = new DashboardResults();
							while(rs.next()) {
								//abc statusdescription os.statuscode ordercount
								
								//String key = rs.getString("statuscode");
								String key = rs.getString("orderstatus");
								System.out.println("@@@@@"+key);
							}
							
							return d;
						}});
			
					
			
			
//			dashboard = (DashboardResults)template.query("SELECT count(os.statuscode) as ordercount ,os.statusdescription, os.statuscode FROM clientorder co, orderstatus os WHERE os.statuscode = co.orderstatus and co.clientid = ? GROUP by os.statuscode",
//					new Object[] { clientid }, new DashboardResultsRowmapper());
			
		
		//logger.info(" ::::: getDashboardResultofaClientRepo ::::: "+dashboard.toString());
		
		
		} catch (Exception e) {

			dashboard = new DashboardResults();
			dashboard.setDispatchFromBranchval("0");
			dashboard.setDispatchFromWearhouseval("0");
			dashboard.setNewOrderval("0");
			dashboard.setOrderCompletedval("0");
			dashboard.setOrderFailedval("0");
			dashboard.setReceiveToBranchval("0");
			dashboard.setReceiveToWearhouseval("0");
			dashboard.setReturnToBranchval("0");
			dashboard.setReturnToWearhouseval("0");

			logger.error(clientid + ":Error getDashboardResultofaClientRepo:", e);

		}

//		 DashboardResults dashboard = (DashboardResults) template.query("SELECT count(os.statuscode) as abc ,os.statusdescription FROM clientorder co, orderstatus os WHERE os.statuscode = co.orderstatus and co.clientid = ? GROUP by os.statuscode",  
//		 		 new Object[] {clientid},
//		 		new DashboardResultsRowmapper()); 

		return dashboard;
	}
	
	
	public DashboardResults getDashboardResultofaClientRepo2(String clientid) {
		DashboardResults dashboard = null;
		
		
		return dashboard;
		
	}

}
