package com.cruxBank.www.Common;

public class BaseResponse {
	
	private String status;
	private String errorDescription;
	private String error_code;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	@Override
	public String toString() {
		return "BaseResponse [status=" + status + ", errorDescription=" + errorDescription + ", error_code="
				+ error_code + "]";
	}
	
	

}
