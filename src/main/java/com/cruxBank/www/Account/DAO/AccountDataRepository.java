package com.cruxBank.www.Account.DAO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends CrudRepository<AccountData, Long> {
	
	@SuppressWarnings("unchecked")
	AccountData save (AccountData accountData);
	

}
