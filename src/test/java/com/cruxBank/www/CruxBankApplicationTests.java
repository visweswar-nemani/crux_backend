package com.cruxBank.www;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruxBank.www.Utils.RegistrationUtils;

import org.junit.jupiter.api.Assertions;

class CruxBankApplicationTests {

	@Test
	void contextLoads() {
	}
	
	public static RegistrationUtils regUtils;
	
	@Test
	void test_generateTxnId_unique() {
		Assertions.assertTrue(regUtils.generateTransactionId()!=regUtils.generateTransactionId(),"Unique transaction ID not generated");
	}
	
	@Test
	void test_generateReferenceId_unique() {
		Assertions.assertTrue(regUtils.generateReferenceId()!=regUtils.generateReferenceId(),"Unique reference ID not generated");
	}
	
	@Test
	void test_generateCheckingAccounId_unique() {
		Assertions.assertTrue(regUtils.generateCheckingId()!=regUtils.generateCheckingId(),"Unique checking account  ID not generated");
	}
	
	@Test
	void test_generateSavingsAccounId_unique() {
		Assertions.assertTrue(regUtils.generateSavingsId()!=regUtils.generateSavingsId(),"Unique savings account ID not generated");
	} 
	
	

}
