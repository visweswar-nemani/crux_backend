package com.cruxBank.www.Account.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.DAO.AccountDataRepository;
import com.cruxBank.www.Account.DAO.AccountType;
import com.cruxBank.www.Account.DAO.AccountTypeRepository;
import com.cruxBank.www.Account.DAO.ProfileDataMapper;
import com.cruxBank.www.Account.api.AccountDataResponse;
import com.cruxBank.www.Account.api.SignupInfoDto;
import com.cruxBank.www.Authentication.DAO.AuthenticationData;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Registration.DAO.SignupInfo;
import com.cruxBank.www.Registration.DAO.SignupInfoDAO;
import com.cruxBank.www.Utils.RegistrationUtils;

@Service
public class AccountServiceImpl implements AccountImplementation{
	
	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	@Autowired
	AccountDataRepository accountDataRepository;
	
	@Autowired
	SignupInfoDAO signupInfoDao;
	
	@Autowired
	ProfileDataMapper mapper;
	
	@PostConstruct
	public void init() {
		accountTypeRepository.save(new AccountType("SAVINGS","Savings Account"));
		accountTypeRepository.save(new AccountType("CHECKING","Checking Account"));
	}
	


	
	@Override
	public List<AccountDataResponse> getAccountData(String email) {
		System.out.println("fetching accounts for user  : "+ email);
		List<AccountData> userAccounts=null;
		List<AccountDataResponse> response=null;
		if (email== null || email== "") 
			return null;

		userAccounts = accountDataRepository.findByEmail(email);
		System.out.println(" the user accounts are "+userAccounts.toString());
		response = userAccounts.stream().map( e -> new AccountDataResponse(String.valueOf(e.getAccount_id()), e.getAccountType().getName(),e.getEmail(),RegistrationUtils.roundToTwoDigits(e.getBalance()))).collect(Collectors.toList());
		System.out.println("the account data response is "+response);				
		

		
		 return (response.size() > 0) ?  response : null;
	}


	@Override
	public SignupInfo getProfileData(String email) {
		
		System.out.println("fetching profile data of "+email); 
		if(email.isEmpty() || email ==null) {
			return null;
		}
		Optional<SignupInfo> fetchedData =   signupInfoDao.findById(email);
		return fetchedData.isPresent() ? fetchedData.get():null;
	}


	@Override
	public BaseResponse updateProfileData(SignupInfoDto signupInfoDto) {
		
		// TODO Auto-generated method stub
		System.out.println("data received for updating profile "+signupInfoDto);
		BaseResponse response = new BaseResponse();
		try {
			Optional<SignupInfo> signupInfo = signupInfoDao.findById(signupInfoDto.getEmail());
			mapper.updateProfileDatafromDto(signupInfoDto,signupInfo.get());
			signupInfoDao.save(signupInfo.get());	
			response.setStatus("SUCCESS");
		} catch(Exception e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}

		return response;
	}
	

	
	
	

}
