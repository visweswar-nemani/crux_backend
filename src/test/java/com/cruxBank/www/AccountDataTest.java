package com.cruxBank.www;



import static org.mockito.Mockito.when;


import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cruxBank.www.Account.Controller.AccountController;
import com.cruxBank.www.Account.Implementation.AccountImplementation;



//@SpringBootTest(webEnvironment = WebEnvironment.MOCK,classes = AccountController.class)
@WebMvcTest(AccountController.class)
//@AutoConfigureMockMvc
public class AccountDataTest {
	
	
	@MockBean
	AccountImplementation accountserviceImpl;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void getAccountData() throws Exception {
		when(accountserviceImpl.getAccountData(ArgumentMatchers.anyString())).thenReturn(Collections.emptyList());
		 MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getAccountData").accept(MediaType.APPLICATION_JSON).queryParam("email","visweswar.nemani93@hotmail.com")).andReturn();
		 System.out.println(" the accountData result is  "+result);		 
		 Mockito.verify(accountserviceImpl).getAccountData("visweswar.nemani93@hotmail.com");
	}
	
	
	

}
