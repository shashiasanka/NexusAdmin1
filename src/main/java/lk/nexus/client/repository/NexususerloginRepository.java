package lk.nexus.client.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.client.models.Nexususerlogin;



public interface NexususerloginRepository extends CrudRepository<Nexususerlogin, Long>{


	@Query("SELECT l FROM Nexususerlogin l WHERE l.username = :username")
	public Nexususerlogin getUser(@Param("username") String username);
	
	
	
}
