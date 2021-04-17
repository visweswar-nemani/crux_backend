package com.cruxBank.www.Utils;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.MersenneTwister;

public class RegistrationUtils {
	
	private static  double LowRangeSavingsAccountNumber= Math.pow(10, 4);
	private static double HighRangeSavingsAccountNumber= (Math.pow(10, 5)-1);
	private static double SavingsAccountNumberRange=HighRangeSavingsAccountNumber-LowRangeSavingsAccountNumber;
	
	public static Long generateSavingsId() {
		
		MersenneTwister  mt = new MersenneTwister();
		
		String savingsId = String.valueOf((int)(LowRangeSavingsAccountNumber + (mt.nextDouble()*SavingsAccountNumberRange)))+(String.valueOf(System.currentTimeMillis()));
		
		System.out.println(savingsId);
		
		return Long.valueOf(savingsId);
	}
	
	public static Long generateCheckingId() {
		
		MersenneTwister  mt = new MersenneTwister();
		String checkingId = String.valueOf((int)(LowRangeSavingsAccountNumber + (mt.nextDouble()*SavingsAccountNumberRange)))+(String.valueOf(System.currentTimeMillis()));
		System.out.println(checkingId);
		
		return Long.valueOf(checkingId);
	}
	
	public  static String generateOneTimePassword() {
		return RandomStringUtils.randomAlphanumeric(7);
	}
	
	
	public static Long generateTransactionId() {
		MersenneTwister  mt = new MersenneTwister();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssS");
		//adding 3 digit random value to the timestamp 
		String transactionId= LocalDateTime.now().format(formatter)+String.valueOf((int)(1000+mt.nextDouble()*1000));
		return Long.valueOf(transactionId);
	}
	
	public static Long generateReferenceId() {
		MersenneTwister  mt = new MersenneTwister();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssS");
		//adding 3 digit random value to the timestamp 
		String transactionId= LocalDateTime.now().format(formatter)+String.valueOf((int)(100+mt.nextDouble()*100));
		return Long.valueOf(transactionId);
	}
	
	public static BigDecimal roundToTwoDigits(BigDecimal d) {		
		return d.setScale(2,RoundingMode.HALF_EVEN);		
	}
	
	public static BigDecimal roundToTwoDigits(double d) {			
		return new BigDecimal(d).setScale(2,RoundingMode.HALF_EVEN);			
	}
	
	public static double convertToDouble(BigDecimal value) {
		return  value.doubleValue();
	}
	
	
	

}
