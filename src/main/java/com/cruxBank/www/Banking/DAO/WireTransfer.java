package com.cruxBank.www.Banking.DAO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WireTransfer {
	
	@Id
	private Long referenceId;
	@Column(nullable = false)
	private Long senderAccountId;
	@Column(nullable = false)
	private Long beneficairyAccountId;
	@Column(nullable = false)
	private Long routingNumber;
	@Column(nullable = false)
	private double amount;
	@Column(nullable = false)
	private String txnCurrency;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private Timestamp createdTime;
	@Column(nullable = false)
	private Timestamp updatedTime;
	
	
	public WireTransfer() {
		super();
	}

	

	public WireTransfer(Long referenceId, Long senderAccountId, Long beneficairyAccountId, Long routingNumber,
			double amount, String txnCurrency, String status, Timestamp createdTime, Timestamp updatedTime) {
		super();
		this.referenceId = referenceId;
		this.senderAccountId = senderAccountId;
		this.beneficairyAccountId = beneficairyAccountId;
		this.routingNumber = routingNumber;
		this.amount = amount;
		this.txnCurrency = txnCurrency;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}



	public Long getReferenceId() {
		return referenceId;
	}


	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}


	public Long getSenderAccountId() {
		return senderAccountId;
	}


	public void setSenderAccountId(Long senderAccountId) {
		this.senderAccountId = senderAccountId;
	}


	public Long getBeneficairyAccountId() {
		return beneficairyAccountId;
	}


	public void setBeneficairyAccountId(Long beneficairyAccountId) {
		this.beneficairyAccountId = beneficairyAccountId;
	}


	public Long getRoutingNumber() {
		return routingNumber;
	}


	public void setRoutingNumber(Long routingNumber) {
		this.routingNumber = routingNumber;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getTxnCurrency() {
		return txnCurrency;
	}


	public void setTxnCurrency(String txnCurrency) {
		this.txnCurrency = txnCurrency;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Timestamp getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}


	public Timestamp getUpdatedTime() {
		return updatedTime;
	}


	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}



	@Override
	public String toString() {
		return "WireTransfer [referenceId=" + referenceId + ", senderAccountId=" + senderAccountId
				+ ", beneficairyAccountId=" + beneficairyAccountId + ", routingNumber=" + routingNumber + ", amount="
				+ amount + ", txnCurrency=" + txnCurrency + ", status=" + status + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + "]";
	}
	
	
	
	
	

}
