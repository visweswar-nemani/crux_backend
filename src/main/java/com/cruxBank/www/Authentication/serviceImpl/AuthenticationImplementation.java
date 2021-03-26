package com.cruxBank.www.Authentication.serviceImpl;

import com.cruxBank.www.Authentication.api.AuthDetails;
import com.cruxBank.www.Common.BaseResponse;

public interface AuthenticationImplementation {
	
	public BaseResponse authenticate(AuthDetails authDetails);

}
