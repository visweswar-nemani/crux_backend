package com.cruxBank.www.Account.DAO;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;


@Entity
public class AccountType {
	
	@Id
	private String name;
	@Column(nullable = false,length = 250)
	private String description;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "accountType")
	private Set<AccountData> accountData;
	
	public AccountType() {
		super();
	}
	
		
	public AccountType(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<AccountData> getAccountData() {
		return accountData;
	}
	public void setAccountData(Set<AccountData> accountData) {
		this.accountData = accountData;
	}




}
