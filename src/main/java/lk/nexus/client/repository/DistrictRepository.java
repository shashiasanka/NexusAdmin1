package lk.nexus.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import lk.nexus.client.models.Districts;



public interface DistrictRepository extends CrudRepository<Districts, Long> {

	
	@Query("SELECT e FROM Districts e WHERE e.province_id =:province_id ")
	public List<Districts> listOfDistrictsoFaProvince(@Param("province_id") String province_id);
	
}
