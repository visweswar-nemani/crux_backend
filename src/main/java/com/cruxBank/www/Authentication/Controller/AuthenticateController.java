package com.cruxBank.www.Authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cruxBank.www.Authentication.api.AuthDetails;
import com.cruxBank.www.Authentication.serviceImpl.AuthenticationImplementation;
import com.cruxBank.www.Common.BaseResponse;

@RestController
public class AuthenticateController {
	
	@Autowired
	AuthenticationImplementation authenticationImplementation;
	
	@CrossOrigin
	@PostMapping("/authenticate")
	public BaseResponse authenticate(@RequestBody AuthDetails authDetails) {
		
		return authenticationImplementation.authenticate(authDetails);
		
	}
	
	

}
