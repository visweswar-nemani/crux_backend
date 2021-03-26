package com.cruxBank.www.Account.Implementation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruxBank.www.Account.DAO.AccountType;
import com.cruxBank.www.Account.DAO.AccountTypeRepository;

@Service
public class AccountServiceImpl {
	
	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	@PostConstruct
	public void init() {
		accountTypeRepository.save(new AccountType("SAVINGS","Savings Account"));
		accountTypeRepository.save(new AccountType("CHECKING","Checking Account"));
	}
	
	

}
