package lk.nexus.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Register;

public interface RegisterDataRepository extends CrudRepository<Register, Long>{
	
//	@Query("SELECT e FROM Clientorder e WHERE e.clientid =:clientid AND e.orderstatus =:orderstatus ")
//	public List<Clientorder> updateCustomerRegisterStatus(@Param("clientid") String clientid,@Param("orderstatus") String orderstatus);
//
	@Transactional
	@Modifying
	@Query("update Register r set r.isregistersuccess =:isregistersuccess where r.accountid =:accountid ")
	public void updateCustomerRegisterStatus(@Param("isregistersuccess") String isregistersuccess,@Param("accountid") String accountid);

	
//	@Query("update RssFeedEntry feedEntry set feedEntry.read =:isRead where feedEntry.id =:entryId")
//	void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);
//	﻿
	
}
