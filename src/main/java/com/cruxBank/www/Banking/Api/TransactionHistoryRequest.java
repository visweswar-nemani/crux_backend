package com.cruxBank.www.Banking.Api;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionHistoryRequest {
	
	private Long userAccountId;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	
	
	public TransactionHistoryRequest(Long userAccountId, LocalDate startDate, LocalDate endDate) {
		super();
		this.userAccountId = userAccountId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	
	public TransactionHistoryRequest() {
		super();
	}




	public Long getUserAccountId() {
		return userAccountId;
	}



	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}



	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	@Override
	public String toString() {
		return "TransactionHistoryRequest [userAccountId=" + userAccountId + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}



	
	

}
