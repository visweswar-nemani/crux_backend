package com.cruxBank.www.Registration.DAO;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupInfoDAO extends CrudRepository<SignupInfo,Integer> {
	
	
	 
	
	@SuppressWarnings("unchecked")
	SignupInfo save (SignupInfo signupInfo);
	
	
	List<SignupInfo> findByEmail(String emailId); 
	
	List<SignupInfo> findByMobileNumber(int mobileNumber); 
	
	
	
	
	
	
	

}
