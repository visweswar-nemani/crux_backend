package com.cruxBank.www.Utils;


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

}
