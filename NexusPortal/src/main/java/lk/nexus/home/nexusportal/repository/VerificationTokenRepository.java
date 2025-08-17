package lk.nexus.home.nexusportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.home.nexusportal.models.VerificationToken;





public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer> {
	
	
	@Query("SELECT e FROM VerificationToken e WHERE e.token =:token ")
	public VerificationToken getTheTokenDetails(@Param("token") String token);


}
