package com.cruxBank.www.Authentication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruxBank.www.Authentication.DAO.AuthenticationDAO;
import com.cruxBank.www.Authentication.DAO.AuthenticationData;
import com.cruxBank.www.Authentication.api.AuthDetails;
import com.cruxBank.www.Common.BaseResponse;

@Service
public class AuthServiceImplementation implements AuthenticationImplementation{

	@Autowired
	AuthenticationDAO authenticationDAO;
	
	@Override
	public BaseResponse authenticate( AuthDetails authDetails) {
		System.out.println("auth data "+authDetails);
		BaseResponse response = new BaseResponse();
		response.setStatus("FAILURE");
		if(authDetails == null) {			
			response.setErrorDescription("Invalid login data");
			return response;			
		}
		
		AuthenticationData authData = authenticationDAO.findByEmailAndPassword(authDetails.getEmail(), authDetails.getPassword());
		System.out.println("after login db check  :  "+authData);	
		if(authData.getEmail()!=null) {
			response.setStatus("SUCCESS");
			return  response;
		}
		
		return response;
	}
	
	

}
