package com.cruxBank.www.Account.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, String>{
	
	@SuppressWarnings("unchecked")
	AccountType save (AccountType accountType);
	
	Optional<AccountType> findById (String name);

}
