package com.cruxBank.www.Banking.DAO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionData {
	
	@Id
	private Long transactionId;
	@Column(nullable = false)
	private Long userAccountId;
	@Column(nullable = false)
	private String referenceId;
	@Column(nullable = false)
	private String operationType;
	@Column(nullable = false)
	private String txnDescription;
	@Column(nullable = false)
	private String txnCurrency;
	@Column(nullable = false,scale=2)
	private BigDecimal previousBalance;
	@Column(nullable = false,scale=2)
	private BigDecimal transactionAmount;
	@Column(nullable = false,scale=2)
	private BigDecimal currentBalance;
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp transactionTime;
	private String createdBy;
	
	
	
	
	public TransactionData() {
		super();
	}

	
	

	public TransactionData(Long transactionId, Long userAccountId, String referenceId, String operationType,
			String txnDescription, String txnCurrency, BigDecimal previousBalance, BigDecimal transactionAmount,
			BigDecimal currentBalance, Timestamp transactionTime, String createdBy) {
		super();
		this.transactionId = transactionId;
		this.userAccountId = userAccountId;
		this.referenceId = referenceId;
		this.operationType = operationType;
		this.txnDescription = txnDescription;
		this.txnCurrency = txnCurrency;
		this.previousBalance = previousBalance;
		this.transactionAmount = transactionAmount;
		this.currentBalance = currentBalance;
		this.transactionTime = transactionTime;
		this.createdBy = createdBy;
	}




	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public Long getUserAccountId() {
		return userAccountId;
	}


	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}


	public String getReferenceId() {
		return referenceId;
	}


	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}


	public String getOperationType() {
		return operationType;
	}


	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}


	public String getTxnDescription() {
		return txnDescription;
	}


	public void setTxnDescription(String txnDescription) {
		this.txnDescription = txnDescription;
	}


	public BigDecimal getPreviousBalance() {
		return previousBalance;
	}


	public void setPreviousBalance(BigDecimal previousBalance) {
		this.previousBalance = previousBalance;
	}


	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}


	public String getTxnCurrency() {
		return txnCurrency;
	}


	public void setTxnCurrency(String txnCurrency) {
		this.txnCurrency = txnCurrency;
	}


	public Timestamp getTransactionTime() {
		return transactionTime;
	}


	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}




	@Override
	public String toString() {
		return "TransactionData [transactionId=" + transactionId + ", userAccountId=" + userAccountId + ", referenceId="
				+ referenceId + ", operationType=" + operationType + ", txnDescription=" + txnDescription
				+ ", txnCurrency=" + txnCurrency + ", previousBalance=" + previousBalance + ", transactionAmount="
				+ transactionAmount + ", currentBalance=" + currentBalance + ", transactionTime=" + transactionTime
				+ ", createdBy=" + createdBy + "]";
	}
	
	
	


	
}
