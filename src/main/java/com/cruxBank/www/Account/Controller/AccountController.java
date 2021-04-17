package com.cruxBank.www.Account.Controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.Implementation.AccountServiceImpl;
import com.cruxBank.www.Account.api.AccountDataResponse;
import com.cruxBank.www.Account.api.SignupInfoDto;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Registration.DAO.SignupInfo;

@RestController
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@CrossOrigin
	@GetMapping("/getAccountData" )
	public List<AccountDataResponse> getAccountData(@RequestParam String email){
		return accountServiceImpl.getAccountData(email);
	}
	
	@CrossOrigin
	@GetMapping("/getProfileData")
	public SignupInfo getProfile(@RequestParam String email) {
		return accountServiceImpl.getProfileData(email);
	}
	
	@CrossOrigin
	@PostMapping("/setProfileData")
	public BaseResponse getProfile(@RequestBody SignupInfoDto signupInfoDto) {
		return accountServiceImpl.updateProfileData(signupInfoDto);
	}
	


}
