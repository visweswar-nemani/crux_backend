package com.cruxBank.www.Registration.Impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.DAO.AccountDataRepository;
import com.cruxBank.www.Account.DAO.AccountTypeRepository;
import com.cruxBank.www.Authentication.DAO.AuthenticationDAO;
import com.cruxBank.www.Authentication.DAO.AuthenticationData;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Messaging.MessagingImplementation;
import com.cruxBank.www.Messaging.api.MailRequest;
import com.cruxBank.www.Registration.DAO.SignupInfo;
import com.cruxBank.www.Registration.DAO.SignupInfoDAO;
import com.cruxBank.www.Registration.api.RegistrationRequest;
import com.cruxBank.www.Utils.RegistrationUtils;



@Service
public class RegistrationServiceImpl implements RegistrationImpl {
	
	@Autowired
	SignupInfoDAO signupInfoDAO;
	
	@Autowired
	AuthenticationDAO authenticationDAO;
	
	@Autowired
	MessagingImplementation messagingImplementation;
	
	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	@Autowired
	AccountDataRepository accountDataRepository;
	
	@PostConstruct
	public void init() {
		authenticationDAO.save(new AuthenticationData("visweswar.nemani93@gmail.com","qwerty",false));
		accountDataRepository.save( new AccountData(RegistrationUtils.generateSavingsId(),accountTypeRepository.findById("SAVINGS").get(),"visweswar.nemani93@gmail.com", new BigDecimal(10),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"System" ));
		accountDataRepository.save( new AccountData(RegistrationUtils.generateCheckingId(),accountTypeRepository.findById("CHECKING").get(),"visweswar.nemani93@gmail.com",new BigDecimal(5),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"System" ));
		
		
	}

	@Override
	public BaseResponse register(RegistrationRequest registrationRequest) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus("Failure");
		
		List<SignupInfo> isEmailExisted = signupInfoDAO.findByEmail(registrationRequest.getEmail());
		List<SignupInfo> isMobileNumberExisted = signupInfoDAO.findByMobileNumber(registrationRequest.getMobileNumber());
		if( isEmailExisted.size() >0 ) {			
			baseResponse.setErrorDescription("Email already Exists");
			return baseResponse;
		} 		
		if( isMobileNumberExisted.size() >0 ) {
			baseResponse.setErrorDescription("MobileNumber already Exists");
			return baseResponse;			
		}		
		SignupInfo result = signupInfoDAO.save(generateSignupInfoRequest(registrationRequest));
		System.out.println("New user Saved  :"+result);		
		AuthenticationData authData = new AuthenticationData(registrationRequest.getEmail(),RegistrationUtils.generateOneTimePassword(),true);
		authData = authenticationDAO.save(authData);
		if(!createSavingsAccount(registrationRequest) || !createCheckingAccount(registrationRequest)) {
			baseResponse.setErrorDescription("Error while creating account");
			return baseResponse;
		}		
		System.out.println("Before sending email : "+LocalDateTime.now().toString());
		//Need to implement AMQ for sending email . 
		//need to handle if mail was not sent
		sendTemporaryPasswordToUser(authData.getEmail(),authData.getPassword());
		System.out.println("After sending email : "+LocalDateTime.now().toString());
		baseResponse.setStatus("Success");		
		return baseResponse;
	}
	
	public SignupInfo generateSignupInfoRequest(RegistrationRequest request) {
		SignupInfo signupInfo = new SignupInfo();
		signupInfo.setFirstName(request.getFirstName());
		signupInfo.setLastName(request.getLastName());
		signupInfo.setEmail(request.getEmail());
		signupInfo.setAddress_1(request.getAddress_1());
		signupInfo.setAddress_2(request.getAddress_2());
		signupInfo.setCity(request.getCity());
		signupInfo.setMobileNumber(request.getMobileNumber());
		signupInfo.setState(request.getState());
		signupInfo.setZip(request.getZip());
		System.out.println("signupinfo  "+signupInfo);
		return signupInfo;
	}
	
	public void sendTemporaryPasswordToUser(String email, String password ) {
		MailRequest mailRequest  = new MailRequest();
		mailRequest.setMailTo(email);		
		mailRequest.setSubject("Welcome to Crux Bank ");
		mailRequest.setBody("Please use this temporary password to login. \n One Time Password: "+password +"\n"+" You might need to change your password once logged in.");
		messagingImplementation.sendMail(mailRequest);		
	}
	
	public boolean createSavingsAccount(RegistrationRequest registrationRequest) {
		
		try {
			System.out.println("the account type is "+accountTypeRepository.findById("SAVINGS").get().getName());
			//System.out.println("the account data is "+data.toString());
			accountDataRepository.save( new AccountData(RegistrationUtils.generateSavingsId(),accountTypeRepository.findById("SAVINGS").get(),registrationRequest.getEmail(), new BigDecimal(10),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"System" ));
			return true;
		} catch(Exception e ) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean createCheckingAccount(RegistrationRequest registrationRequest) {
		try {			
			accountDataRepository.save( new AccountData(RegistrationUtils.generateCheckingId(),accountTypeRepository.findById("CHECKING").get(),registrationRequest.getEmail(),new BigDecimal(10),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"System" ));
			return true;
			
		}catch(Exception e ) {
			e.printStackTrace();
			return false;
		}

		
	}
	
}
