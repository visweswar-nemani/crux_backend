package com.cruxBank.www.Account.api;

import java.math.BigDecimal;

public class AccountDataResponse {
	
	
	private String account_id;
	private String accountType;
	private String email;
	private BigDecimal balance;
	
	
	
	
	public AccountDataResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDataResponse(String account_id, String accountType, String email, BigDecimal balance) {
		super();
		this.account_id = account_id;
		this.accountType = accountType;
		this.email = email;
		this.balance = balance;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountDataResponse [account_id=" + account_id + ", accountType=" + accountType + ", email=" + email
				+ ", balance=" + balance + "]";
	}
}
