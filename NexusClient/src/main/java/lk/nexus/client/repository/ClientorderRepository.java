package lk.nexus.client.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.nexus.client.dto.Dashboardcount;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Expense;


public interface ClientorderRepository extends CrudRepository<Clientorder, String>{

	
	@Query("SELECT e FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus ")
	public List<Clientorder> listOfClientOrdersByStatus(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus);
	//clientid orderstatus
	
	@Query("SELECT new lk.nexus.client.dto.Dashboardcount(e.orderstatus,COUNT(e.orderstatus)) FROM Clientorder e WHERE e.clientid =:clientid GROUP BY e.orderstatus ")
	public List<Dashboardcount> getOrderDetailstoDashboardDao(@Param("clientid") String clientid);
	
//	
//	@Query("SELECT e FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus and e.orderadddate ")
//	public List<Clientorder> listOfClientOrdersByStatus1date(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus,@Param("orderadddate1") Date orderadddate1,@Param("orderadddate2") Date orderadddate2);	
//	

	//@Query(value = "SELECT e FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus and e.orderadddate between :orderadddate1, :orderadddate2 ", nativeQuery = true)
//	@Query(value = "SELECT e FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus and e.orderadddate between :orderadddate1, :orderadddate2 ", nativeQuery = true)
//	public List<Clientorder> listOfClientOrdersByStatus1date2(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus,@Param("orderadddate1") Date orderadddate1,@Param("orderadddate2") Date orderadddate2);	
//	
	
//	@Query(value = "SELECT * FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus and e.orderadddate BETWEEN STR_TO_DATE('2021-02-20', '%Y/%m/%d') AND STR_TO_DATE('2021-02-23', '%Y/%m/%d') ", nativeQuery = true)
//	public List<Clientorder> listOfClientOrdersByStatus1date2(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus);	
//	
	
	
//	@Query(value = "SELECT * FROM Clientorder e WHERE e.orderadddate BETWEEN STR_TO_DATE('2021-02-20', '%Y/%m/%d') AND STR_TO_DATE('2021-02-23', '%Y/%m/%d') ", nativeQuery = true)
//	public List<Clientorder> listOfClientOrdersByStatus1date2();	

	
	@Query(value = "SELECT * FROM Clientorder e WHERE e.orderadddate between :orderadddate1 and :orderadddate2 ORDER BY e.orderadddate ", nativeQuery = true)
	public List<Clientorder> listOfClientOrdersByStatus1date2(@Param("orderadddate1") String orderadddate1,@Param("orderadddate2") String orderadddate2);	

	@Query(value = "SELECT * FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus and e.orderadddate between :orderadddate1 and :orderadddate2 ORDER BY e.orderadddate ", nativeQuery = true)
	public List<Clientorder> listOfClientOrdersByStatus1date3(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus, @Param("orderadddate1") String orderadddate1,@Param("orderadddate2") String orderadddate2);	

	
	@Query("SELECT e FROM Clientorder e WHERE e.ordertrackingid =:ordertrackingid ")
	public List<Clientorder> listOfClientOrdersByTrackingId(@Param("ordertrackingid") String ordertrackingid);

	
	@Query(value = "SELECT * FROM Clientorder e WHERE e.clientid =:clientid AND e.orderadddate between :orderadddate1 and :orderadddate2 ORDER BY e.orderadddate ", nativeQuery = true)
	public List<Clientorder> listOfClientOrdersByClientIddaterange3(@Param("clientid") String clientid, @Param("orderadddate1") String orderadddate1,@Param("orderadddate2") String orderadddate2);	

	
	
//	@Query(value = "SELECT * FROM Clientorder e WHERE e.clientid =:clientid AND e.orderadddate between :orderadddate1 and :orderadddate2 ORDER BY e.orderadddate ", nativeQuery = true)
	@Transactional
	@Modifying
	@Query(value = "UPDATE Clientorder e SET e.ready_to_send ='1' WHERE e.clientid =:clientid AND e.ordertrackingid =:ordertrackingid ", nativeQuery = true)
	public void readyTosendClientordertoHeadOffice(@Param("clientid") String clientid, @Param("ordertrackingid") String ordertrackingid);	

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Clientorder e SET e.ready_to_send ='0' WHERE e.clientid =:clientid AND e.ordertrackingid =:ordertrackingid ", nativeQuery = true)
	public void dontSendClientordertoHeadOffice(@Param("clientid") String clientid, @Param("ordertrackingid") String ordertrackingid);	

	
	
	@Query("SELECT e FROM Clientorder e WHERE e.ordertrackingid =:ordertrackingid ")
	public Clientorder getOfClientOrdersByTrackingId(@Param("ordertrackingid") String ordertrackingid);

	
	
}


//SELECT *
//FROM x
//WHERE x.wedding BETWEEN TO_DATE('2008-JUN-01', 'YYYY-MON-DD') AND TO_DATE('2008-JUL-01', 'YYYY-MON-DD')
//@Query("SELECT new com.baeldung.aggregation.model.custom.CommentCount(c.year, COUNT(c.year)) "
//		  + "FROM Comment AS c GROUP BY c.year ORDER BY c.year DESC")
//		List<CommentCount> countTotalCommentsByYearClass();

//@Query("select a from Article a where a.creationDateTime <= :creationDateTime")



//SELECT *
//FROM order_details
//WHERE order_date >= TO_DATE('2014/02/01', 'yyyy/mm/dd')
//AND order_date <= TO_DATE('2014/02/28','yyyy/mm/dd');
//List<Article> findAllWithCreationDateTimeBefore(
//  @Param("creationDateTime") Date creationDateTime);