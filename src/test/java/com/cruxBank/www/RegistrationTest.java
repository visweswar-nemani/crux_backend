package com.cruxBank.www;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Registration.Impl.RegistrationImpl;
import com.cruxBank.www.Registration.api.RegistrationRequest;

@SpringBootTest
public class RegistrationTest {

	@Autowired
	RegistrationImpl  registrationTestImpl;	
	

	
	
	@Test
	public void registerTest() {
		
		RegistrationRequest request = new RegistrationRequest("Ravi", "Nemani", "visweswar250@gmail.com",
										"vijayawada", "Andhra Pradesh",9494497503L, "add1", null, 520003);
		BaseResponse response = registrationTestImpl.register(request);
		System.out.println("registration Response "+ response);
		Assertions.assertTrue(response.getStatus().equals("Success"),"Registration Failed");
	}
	
	

}
