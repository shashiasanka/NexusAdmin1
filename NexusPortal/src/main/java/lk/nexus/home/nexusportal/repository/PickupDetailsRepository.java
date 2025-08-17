package lk.nexus.home.nexusportal.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lk.nexus.home.nexusportal.joindto.PickupJoinDto;



@Repository
public class PickupDetailsRepository {

	 @Autowired
	 JdbcTemplate template;
	 
	 public List<PickupJoinDto> getAllItems(){
		 
		 List<PickupJoinDto> items = template.query("select a.clientname,a.clientid, (select vehdesc from vehichiledetails where vehcode = a.vehicletype) as vehicletype,a.pickuptime,a.noofpickups from pickuprequest a "  
		 		,(result,rowNum)->new PickupJoinDto(result.getString("clientname"),
	                result.getString("pickuptime"),result.getString("vehicletype"),result.getString("noofpickups"))); 
	
	 return items;
	 } 
	 //String clientname, String pickuptime, String vehicleType, String noofpickups
}
