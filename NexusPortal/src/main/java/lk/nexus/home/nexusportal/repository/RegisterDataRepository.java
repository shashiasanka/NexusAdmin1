package lk.nexus.home.nexusportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import lk.nexus.home.nexusportal.models.Register;



public interface RegisterDataRepository extends CrudRepository<Register, Long>{

	@Transactional
	@Modifying
	@Query("update Register r set r.isregistersuccess =:isregistersuccess where r.accountid =:accountid ")
	public void updateCustomerRegisterStatus(@Param("isregistersuccess") String isregistersuccess,@Param("accountid") String accountid);

	@Query("Select r From Register r where r.isregistersuccess =:isregistersuccess ")
	public List<Register> listPendingRegisterrequest(@Param("isregistersuccess") String isregistersuccess);

	@Query("Select r From Register r where r.id =:id ")
	public Register getRegisterDetailsDao(@Param("id")Long id);
	
	
	@Transactional
	@Modifying
	@Query("update Register r set r.ratetype =:ratetype where r.id =:id ")
	public void updateCustomerRateTypeDao(@Param("ratetype") String isregistersuccess,@Param("id") Long id);
	
	
	@Transactional
	@Modifying
	@Query("update Register r set r.isregistersuccess =:isregistersuccess where r.id =:id ")
	public void updatePendingRegsterDetailsDao(@Param("isregistersuccess") String isregistersuccess,@Param("id") Long id);


}
