package com.cruxBank.www.Account.Implementation;

import java.util.List;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.api.AccountDataResponse;
import com.cruxBank.www.Account.api.SignupInfoDto;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Registration.DAO.SignupInfo;

public interface AccountImplementation {
	
	
	public List<AccountDataResponse> getAccountData(String email);
	
	public SignupInfo getProfileData(String email);
	
	public BaseResponse updateProfileData(SignupInfoDto signupInfoDto);
	
	
	

}
