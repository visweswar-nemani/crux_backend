package com.cruxBank.www.Authentication.DAO;



import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationDAO extends CrudRepository<AuthenticationData, String>  {
	
	
	@SuppressWarnings("unchecked")
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	AuthenticationData save (AuthenticationData authData);
	
	AuthenticationData findByEmailAndPassword (String email, String password);
	
	Optional<AuthenticationData> findById (String email);
	
	@Query("select a.isPasswordTemporary from AuthenticationData a where a.email=?1")
	Boolean isForceChangePasswordNeeded (String email);
	

}
