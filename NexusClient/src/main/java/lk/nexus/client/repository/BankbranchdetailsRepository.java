package lk.nexus.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.client.models.Bankbranchdetails;
import lk.nexus.client.models.Expense;



public interface BankbranchdetailsRepository extends CrudRepository<Bankbranchdetails, Long>{

	@Query("SELECT e FROM Bankbranchdetails e WHERE e.bankcode = :bankcode")
	public List<Bankbranchdetails> listBankbranchdetailsByBankCode(@Param("bankcode") String bankcode);
	
	
}
