package lk.nexus.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import lk.nexus.client.models.Ratecode;

public interface RatecodeRepository extends CrudRepository<Ratecode, Long>{
	
	
	@Query("SELECT e FROM Ratecode e WHERE e.pickup_barnchcode =:pickup_barnchcode and e.ratetype =:ratetype ")
	public List<Ratecode> listratecode(@Param("pickup_barnchcode") String pickup_barnchcode,@Param("ratetype") String ratetype );

}
