package lk.nexus.home.nexusportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lk.nexus.home.nexusportal.models.Pickuprequest;



public interface PickuprequestRepository extends CrudRepository<Pickuprequest, Long> {
//
//	//@Query("SELECT new lk.nexus.home.joindto.PickupJoinDto(e.fullname_businessname, d.pickuptime) FROM Pickuprequest d INNER JOIN d.register e ")
//	//@Query("SELECT new lk.nexus.home.joindto.PickupJoinDto(d.fullname_businessname, e.pickuptime) FROM Register d INNER JOIN d.picreq e ")
//	public List<PickupJoinDto> getAllPickuprequests();
	
//	@Query("SELECT new lk.nexus.home.joindto.PickupJoinDto(d.fullname_businessname, e.pickuptime) FROM Register d INNER JOIN d.accountid e ")
//	public List<PickupJoinDto> getAllPickuprequests();
}
