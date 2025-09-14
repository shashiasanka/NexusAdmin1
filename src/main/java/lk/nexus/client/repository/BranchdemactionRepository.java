package lk.nexus.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.client.models.Branchdemaction;


public interface BranchdemactionRepository  extends CrudRepository<Branchdemaction, String>{
	
	
	@Query("SELECT e FROM Branchdemaction e WHERE e.branchcode = :branchcode")
	public List<Branchdemaction> listBranchdemactionByBranchCode(@Param("branchcode") String branchcode);

}
