package com.cruxBank.www.Registration.DAO;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupInfoDAO extends CrudRepository<SignupInfo,Integer> {
	
	
	 
	
	@SuppressWarnings("unchecked")
	SignupInfo save (SignupInfo signupInfo);
	
	//SignupInfo update(SignupInfo signupInfo);
	
	List<SignupInfo> findByMobileNumber(Long mobileNumber);

	List<SignupInfo> findByEmail(String email); 
	
	
	
	
	
	
	

}
