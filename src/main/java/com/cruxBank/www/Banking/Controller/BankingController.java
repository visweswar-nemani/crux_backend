package com.cruxBank.www.Banking.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruxBank.www.Banking.Api.TransactionHistoryRequest;
import com.cruxBank.www.Banking.Api.TransferRequest;
import com.cruxBank.www.Banking.Implementation.BankingServiceImpl;
import com.cruxBank.www.Common.BaseResponse;

@RestController
public class BankingController {
	
	@Autowired
	BankingServiceImpl bankingService;
	
	@CrossOrigin
	@PostMapping("/doTransfer")
	public BaseResponse doTransfer(@RequestBody TransferRequest transferRequest) {
		System.out.println("the transfer request received "+transferRequest);
		return bankingService.doTransfer(transferRequest);		
	}
	
	
	@CrossOrigin
	@PostMapping("/getTransactionHistory")
	public BaseResponse getTransactionHistory(@RequestBody TransactionHistoryRequest request) {
		System.out.println("the transfer request received "+request);
		return bankingService.getTransactionHistory(request);		
	}

}
