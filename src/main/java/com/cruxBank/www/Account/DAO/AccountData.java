package com.cruxBank.www.Account.DAO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class AccountData {
	
	@Id
	private Long account_id;
	@ManyToOne()
	private AccountType accountType;
	@Column(nullable = false,length=250)
	private String email;
	@Column(nullable = false,scale = 2 )
	private BigDecimal balance;
	@Column(nullable = false)
	private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
	@Column(nullable = false)
	private Timestamp createdTime= new Timestamp(System.currentTimeMillis());
	@Column(nullable = false,length = 250)
	private String updatedBy;
	
	
	
	
	
	public AccountData() {
		super();
	}





	public AccountData(Long account_id, AccountType accountType, String email, BigDecimal balance, Timestamp updateTime,
			Timestamp createdTime, String updatedBy) {
		super();
		this.account_id = account_id;
		this.accountType = accountType;
		this.email = email;
		this.balance = balance;
		this.updateTime = updateTime;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
	}





	public Long getAccount_id() {
		return account_id;
	}





	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}





	public AccountType getAccountType() {
		return accountType;
	}





	public void setAccountType(AccountType accountType) {
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





	public Timestamp getUpdateTime() {
		return updateTime;
	}





	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}





	public Timestamp getCreatedTime() {
		return createdTime;
	}





	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}





	public String getUpdatedBy() {
		return updatedBy;
	}





	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}





	@Override
	public String toString() {
		return "AccountData [account_id=" + account_id + ", accountType=" + accountType + ", email=" + email
				+ ", balance=" + balance + ", updateTime=" + updateTime + ", createdTime=" + createdTime
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	
	


}
