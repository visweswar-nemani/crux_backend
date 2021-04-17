package com.cruxBank.www.Banking.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDataRepository extends JpaRepository<TransactionData, Long>{
	
	@SuppressWarnings("unchecked")
	TransactionData save (TransactionData request);

}
