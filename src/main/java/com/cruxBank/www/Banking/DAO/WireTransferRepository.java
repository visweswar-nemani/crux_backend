package com.cruxBank.www.Banking.DAO;

import java.sql.Timestamp;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface WireTransferRepository extends JpaRepository<WireTransfer, Long> {
	
	
	@SuppressWarnings("unchecked")
	WireTransfer save(WireTransfer request);
	
   @Override
   Optional<WireTransfer> findById(Long id) ;


	
	@Transactional
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query("update WireTransfer wt set wt.status=:status,wt.updatedTime=:updatedTime where wt.referenceId=:referenceId ")
	void updateTransferStatus(@Param(value="referenceId")Long referenceId,@Param(value="status")String status,@Param(value="updatedTime")Timestamp updatedTime);
	
		

}
