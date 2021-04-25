package com.cruxBank.www.Banking.DAO;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDataRepository extends PagingAndSortingRepository<TransactionData, Long>{
	
	@SuppressWarnings("unchecked")
	TransactionData save (TransactionData request);
	
	
	List<TransactionData> findByUserAccountId(Long userAccountId);
	
	@Query("Select td from TransactionData td where td.userAccountId=:userAccountId and td.transactionTime between :startTime and :endTime")
	List<TransactionData> getTransactionData(Long userAccountId , Timestamp startTime, Timestamp endTime);

}
