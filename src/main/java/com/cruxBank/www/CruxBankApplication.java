package com.cruxBank.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cruxBank.www.Utils.RegistrationUtils;

@SpringBootApplication
public class CruxBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruxBankApplication.class, args);
		
		RegistrationUtils.generateSavingsId();
		RegistrationUtils.generateCheckingId();
	}

}
