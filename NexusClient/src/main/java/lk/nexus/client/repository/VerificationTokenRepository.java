package lk.nexus.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.VerificationToken;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer> {
	
	
	@Query("SELECT e FROM VerificationToken e WHERE e.token =:token ")
	public VerificationToken getTheTokenDetails(@Param("token") String token);


}
