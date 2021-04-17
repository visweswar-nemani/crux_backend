package com.cruxBank.www.Authentication.DAO;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationDAO extends CrudRepository<AuthenticationData, String>  {
	
	
	@SuppressWarnings("unchecked")
	AuthenticationData save (AuthenticationData authData);
	
	AuthenticationData findByEmailAndPassword (String email, String password);
	
	@Query("select a.isPasswordTemporary from AuthenticationData a where a.email=?1")
	Boolean isForceChangePasswordNeeded (String email);
	

}
