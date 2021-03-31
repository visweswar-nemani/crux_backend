package com.cruxBank.www.Account.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.Implementation.AccountServiceImpl;
import com.cruxBank.www.Account.api.AccountDataResponse;

@RestController
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@CrossOrigin
	@GetMapping("/getAccountData" )
	public List<AccountDataResponse> getAccountData(@RequestParam String email){
		return accountServiceImpl.getAccountData(email);
	}

}
