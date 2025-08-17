package lk.nexus.home.nexusportal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lk.nexus.home.nexusportal.dto.DashboardResults;
import lk.nexus.home.nexusportal.rowmapper.DashboardResultsRowmapper;



@Repository
public class DashboardRepository {

	 @Autowired
	 JdbcTemplate template;
	 
	 public DashboardResults getDashboardResultofaClient(){
		 
		 
		 DashboardResults dashboard = (DashboardResults) template.queryForObject("SELECT count(os.statuscode) as ordercount ,os.statusdescription, os.statuscode FROM clientorder co, orderstatus os WHERE os.statuscode = co.orderstatus GROUP by os.statuscode", 
			 		new DashboardResultsRowmapper());
		 
		 
	
	 return dashboard;    
	 } 
}
