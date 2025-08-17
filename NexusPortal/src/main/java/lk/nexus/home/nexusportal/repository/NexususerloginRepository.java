package lk.nexus.home.nexusportal.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.home.nexusportal.models.Nexususerlogin;




public interface NexususerloginRepository extends CrudRepository<Nexususerlogin, Long>{
	
	@Query("SELECT l FROM Nexususerlogin l WHERE l.username = :username")
	public Nexususerlogin getUser(@Param("username") String username);
	/*
	@Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
	public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);*/

}
