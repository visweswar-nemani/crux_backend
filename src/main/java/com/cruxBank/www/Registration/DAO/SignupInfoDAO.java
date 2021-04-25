package com.cruxBank.www.Registration.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupInfoDAO extends CrudRepository<SignupInfo,String> {
	
	
	 
	
	@SuppressWarnings("unchecked")
	SignupInfo save (SignupInfo signupInfo);
	
	//SignupInfo update(SignupInfo signupInfo);
	
	List<SignupInfo> findByMobileNumber(Long mobileNumber);

	List<SignupInfo> findByEmail(String email); 
	
	@Query("Select Info  from SignupInfo Info where Info.email=:emailId")
	SignupInfo getProfileDatabyEmail (String emailId);
	
	
	
	
	
	
	
	
	

}
