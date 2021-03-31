package com.cruxBank.www.Account.Implementation;

import java.util.List;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.api.AccountDataResponse;

public interface AccountImplementation {
	
	
	public List<AccountDataResponse> getAccountData(String email);
	
	

}
