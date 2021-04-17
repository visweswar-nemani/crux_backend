package com.cruxBank.www;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.math3.random.MersenneTwister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cruxBank.www.Authentication.DAO.AuthenticationDAO;
import com.cruxBank.www.Authentication.DAO.AuthenticationData;
import com.cruxBank.www.Utils.RegistrationUtils;

@EnableAutoConfiguration
@SpringBootApplication
public class CruxBankApplication {
	

	
	
	public static void main(String[] args) {
		
	
		SpringApplication.run(CruxBankApplication.class, args);
		
		RegistrationUtils.generateSavingsId();
		RegistrationUtils.generateCheckingId();
		
		//System.out.println("testing uuid "+UUID.randomUUID());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssS");
		
		MersenneTwister mt = new MersenneTwister();
		
		System.out.println(LocalDateTime.now().format(formatter)+String.valueOf((int)(100+mt.nextDouble()*100)));
		
		DecimalFormat  df = new DecimalFormat("0.00");
		double d =12.345;
		System.out.println("the roundup value is "+df.format(d));
		
		
		System.out.println("Big decimalvalue is "+new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		
		
		
	}

}
