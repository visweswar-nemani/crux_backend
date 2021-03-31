package com.cruxBank.www.Account.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.DAO.AccountDataRepository;
import com.cruxBank.www.Account.DAO.AccountType;
import com.cruxBank.www.Account.DAO.AccountTypeRepository;
import com.cruxBank.www.Account.api.AccountDataResponse;

@Service
public class AccountServiceImpl implements AccountImplementation{
	
	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	@Autowired
	AccountDataRepository accountDataRepository;
	
	@PostConstruct
	public void init() {
		accountTypeRepository.save(new AccountType("SAVINGS","Savings Account"));
		accountTypeRepository.save(new AccountType("CHECKING","Checking Account"));
	}

	
	@Override
	public List<AccountDataResponse> getAccountData(String email) {
		System.out.println("fetching accounts for user  : "+ email);
		List<AccountData> userAccounts=null;
		List<AccountDataResponse> response=null;
		if (email== null || email== "") 
			return null;

		userAccounts = accountDataRepository.findByEmail(email);
		System.out.println(" the user accounts are "+userAccounts.toString());
		response = userAccounts.stream().map( e -> new AccountDataResponse(e.getAccount_id(), e.getAccountType().getName(),e.getEmail(),e.getBalance())).collect(Collectors.toList());
		System.out.println("the account data response is "+response);				
		

		
		 return (response.size() > 0) ?  response : null;
	}
	

	
	
	

}
