package com.cruxBank.www.Authentication.serviceImpl;

import com.cruxBank.www.Authentication.api.AuthDetails;
import com.cruxBank.www.Authentication.api.PasswordChangeRequest;
import com.cruxBank.www.Common.BaseResponse;

public interface AuthenticationImplementation {
	
	public BaseResponse authenticate(AuthDetails authDetails);
	
	public BaseResponse chanagePassword(PasswordChangeRequest request);
	
	public boolean forceChangePassword(String email);
	
	public BaseResponse forgotPassword(String email);

}
