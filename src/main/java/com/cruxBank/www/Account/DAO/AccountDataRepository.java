package com.cruxBank.www.Account.DAO;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends CrudRepository<AccountData, Long> {
	
	@SuppressWarnings("unchecked")
	AccountData save (AccountData accountData);
	
	List<AccountData> findByEmail(String email); 
	
	Optional<AccountData> findById(Long id);
	
	@Transactional
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query("UPDATE AccountData a set a.balance=a.balance-:balance,a.updateTime=:updateTime Where a.account_id=:account_id")
	public void debitAmount(@Param(value = "account_id")Long account_id,@Param(value = "balance")BigDecimal balance,@Param(value = "updateTime")Timestamp updateTime);
	
	@Transactional
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query("UPDATE AccountData a set a.balance=a.balance+:balance,a.updateTime=:updateTime Where a.account_id=:account_id")
	public void creditAmount(@Param(value = "account_id")Long account_id,@Param(value = "balance")BigDecimal balance,@Param(value = "updateTime")Timestamp updateTime);
	
	
	
	

}
