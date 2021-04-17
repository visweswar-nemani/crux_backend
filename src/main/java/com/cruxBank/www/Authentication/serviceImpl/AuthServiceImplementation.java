package com.cruxBank.www.Authentication.serviceImpl;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruxBank.www.Account.DAO.AccountType;
import com.cruxBank.www.Authentication.DAO.AuthenticationDAO;
import com.cruxBank.www.Authentication.DAO.AuthenticationData;
import com.cruxBank.www.Authentication.api.AuthDetails;
import com.cruxBank.www.Authentication.api.PasswordChangeRequest;
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
		if(authDetails == null || authDetails.getEmail().isEmpty() ||authDetails.getPassword().isEmpty()) {			
			response.setErrorDescription("Invalid login data");
			return response;			
		}
		
		AuthenticationData authData = authenticationDAO.findByEmailAndPassword(authDetails.getEmail(), authDetails.getPassword());
		System.out.println("after login db check  :  "+authData);	
		if(authData!=null && authData.getEmail()!=null) {
			response.setStatus("SUCCESS");
			return  response;
		}
		
		return response;
	}


	@Override
	public BaseResponse chanagePassword(PasswordChangeRequest request) {
		// TODO Auto-generated method stub
		BaseResponse response = new BaseResponse();
		response.setStatus("FAILURE");
		System.out.println(" request received for password update "+request);
		
		if(!request.getNewPassword().equals(request.getConfirmPassword())  ) {
			
			response.setErrorDescription("New  and Conifrm password doesnt match");			
		}
		if(request.getNewPassword().isEmpty() ||request.getCurrentPassword().isEmpty() ||request.getConfirmPassword().isEmpty()) {
			response.setErrorDescription("passwords can not be empty");
		}
		if(request.getConfirmPassword()== null ||request.getCurrentPassword()== null || request.getNewPassword()==null || request.getEmail()==null) {
			response.setErrorDescription("fields cant be null");
		}
		if(request.getEmail().isEmpty()) {
			response.setErrorDescription("Error is setting password");
		}
		
		try {
			Optional<AuthenticationData> authData= authenticationDAO.findById(request.getEmail());
			authData.get().setPassword(request.getNewPassword());
			authData.get().setPasswordTemporary(false);
			authenticationDAO.save(authData.get());
			response.setStatus("SUCCESS");
		}catch(Exception e ) {
			e.printStackTrace();
			response.setErrorDescription("error occured while updating password");
		}		
		return response;
	}


	@Override
	public boolean forceChangePassword(String email) {
		// TODO Auto-generated method stub
		if(authenticationDAO.isForceChangePasswordNeeded(email)) {
			return true;
		}	
		return false;
	}

	


	

}
