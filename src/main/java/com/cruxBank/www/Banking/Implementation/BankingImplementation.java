package com.cruxBank.www.Banking.Implementation;

import com.cruxBank.www.Banking.Api.TransferRequest;
import com.cruxBank.www.Common.BaseResponse;

public interface BankingImplementation {
	
	public BaseResponse doTransfer(TransferRequest  request);

}
