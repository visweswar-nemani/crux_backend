package com.cruxBank.www.Authentication.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthenticationData {
	
	@Id
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isPasswordTemporary;
	
	
	public AuthenticationData() {
		super();
	}
	
	
	
	
	public AuthenticationData(String email, String password, boolean isPasswordTemporary) {
		super();
		this.email = email;
		this.password = password;
		this.isPasswordTemporary = isPasswordTemporary;
	}




	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPasswordTemporary() {
		return isPasswordTemporary;
	}
	public void setPasswordTemporary(boolean isPasswordTemporary) {
		this.isPasswordTemporary = isPasswordTemporary;
	}


	@Override
	public String toString() {
		return "AuthenticationData [email=" + email + ", isPasswordTemporary=" + isPasswordTemporary + "]";
	}

}
