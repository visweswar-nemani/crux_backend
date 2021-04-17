package com.cruxBank.www.Banking.Api;

public class TransferRequest {
	
	private Long userAccountId;
	private Long beneficiaryAccountId;
	private Long routingNumber;
	private double amount;
	
	
	
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public Long getBeneficiaryAccountId() {
		return beneficiaryAccountId;
	}
	public void setBeneficiaryAccountId(Long beneficiaryAccountId) {
		this.beneficiaryAccountId = beneficiaryAccountId;
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
	@Override
	public String toString() {
		return "TransferRequest [userAccountId=" + userAccountId + ", beneficiaryAccountId=" + beneficiaryAccountId
				+ ", routingNumber=" + routingNumber + ", amount=" + amount + "]";
	}
	
	

}
