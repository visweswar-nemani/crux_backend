package com.cruxBank.www.Registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Registration.Impl.RegistrationImpl;
import com.cruxBank.www.Registration.api.RegistrationRequest;


@RestController
public class RegistrationController {
	
	@Autowired
	RegistrationImpl registrationImpl;
	
	@CrossOrigin
	@PostMapping("/register")
	public BaseResponse register(@RequestBody RegistrationRequest registrationRequest) {
		
		System.out.println("Request received:"+registrationRequest.toString());
		return registrationImpl.register(registrationRequest) ;
	}

}
