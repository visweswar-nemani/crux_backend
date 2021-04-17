package com.cruxBank.www.Banking.Implementation;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruxBank.www.Account.DAO.AccountData;
import com.cruxBank.www.Account.DAO.AccountDataRepository;
import com.cruxBank.www.Banking.Api.TransferRequest;
import com.cruxBank.www.Banking.DAO.TransactionData;
import com.cruxBank.www.Banking.DAO.TransactionDataRepository;
import com.cruxBank.www.Banking.DAO.WireTransfer;
import com.cruxBank.www.Banking.DAO.WireTransferRepository;
import com.cruxBank.www.Common.BaseResponse;
import com.cruxBank.www.Common.Constants;
import com.cruxBank.www.Common.Constants.ResponseStatus;
import com.cruxBank.www.Utils.RegistrationUtils;


@Service
public class BankingServiceImpl implements BankingImplementation{
	
	@Autowired
	AccountDataRepository accountDAO;
	
	@Autowired
	WireTransferRepository WireTransferDAO;
	
	@Autowired
	TransactionDataRepository transactionDataDAO;
	
	@Override
	public BaseResponse doTransfer(TransferRequest request) { 	
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatus.FAILURE.toString());
		if(!isValidRequest(request)) {			
			response.setErrorDescription("Invalid Request");
			return response;
		}
		
		Optional<AccountData> beforeTxnData =  accountDAO.findById(request.getUserAccountId());
		if(!beforeTxnData.isPresent()) {			
			response.setErrorDescription("Invalid Account Id");
			return  response;
		}
	
		//check for valid beneficiary account iD
		Optional<AccountData> isValidBeneficiary  = accountDAO.findById(request.getBeneficiaryAccountId());
		if(!isValidBeneficiary.isPresent()) {
			response.setErrorDescription("Invalid Beneficiary Account Id");
			return  response;
			
		}
				
		if(request.getAmount()>beforeTxnData.get().getBalance().doubleValue()) {	
			response.setErrorDescription("Insufficient funds");
			return response;
		}	
		
		System.out.println("user data: "+beforeTxnData);
		WireTransfer wireTransfer = WireTransferDAO.save(new WireTransfer(RegistrationUtils.generateReferenceId(),
				request.getUserAccountId(),request.getBeneficiaryAccountId(),request.getRoutingNumber(),
				request.getAmount(),Constants.Currency.USD.toString(),Constants.TransferStatus.INITIATED.toString(),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
		System.out.println(" the wire txn status "+WireTransferDAO.findById(wireTransfer.getReferenceId()).get());
		
		try {
			accountDAO.debitAmount(beforeTxnData.get().getAccount_id(),RegistrationUtils.roundToTwoDigits(request.getAmount()),new Timestamp(System.currentTimeMillis()));
		}catch(Exception e) {
			e.printStackTrace();
			response.setErrorDescription("Error while deducting amount");
			WireTransferDAO.updateTransferStatus(wireTransfer.getReferenceId(),Constants.TransferStatus.FAILED.toString(), new Timestamp(System.currentTimeMillis()));
			return response;
		}
		Optional<AccountData> afterTxnData = accountDAO.findById(request.getUserAccountId());
		TransactionData txnData = transactionDataDAO.save(new TransactionData(RegistrationUtils.generateTransactionId(),
									afterTxnData.get().getAccount_id(),wireTransfer.getReferenceId().toString(),
									Constants.OperationType.DEBIT.toString(), "Account transfer",
									Constants.Currency.USD.toString(), beforeTxnData.get().getBalance(),
									RegistrationUtils.roundToTwoDigits(request.getAmount()),
									RegistrationUtils.roundToTwoDigits(afterTxnData.get().getBalance()),
									new Timestamp(System.currentTimeMillis()),"System"));
		System.out.println("the txn data "+txnData);
		
		return creditAmountToBeneficiary(request,wireTransfer.getReferenceId());
	}
	
	
	public boolean isValidRequest(TransferRequest request) {
		if(request ==null) {
			return false;
		}
		if(request.getAmount()<=0 || 
				request.getBeneficiaryAccountId().toString().length()<18 || 
				request.getUserAccountId().toString().length()<18 ||
				request.getRoutingNumber().toString().length()<5){
					return false;
				}
		return true;
	}
	
	
	public BaseResponse creditAmountToBeneficiary(TransferRequest request,Long referenceNumber) {
				//add amount to beneficairy account
				//create a txn data record and save the the respective reference id of transfer request
		BaseResponse response = new BaseResponse();
		Optional<AccountData> beneficiaryData_beforeTxn  = accountDAO.findById(request.getBeneficiaryAccountId());	
		try {
			accountDAO.creditAmount(request.getBeneficiaryAccountId(),RegistrationUtils.roundToTwoDigits(request.getAmount()),new Timestamp(System.currentTimeMillis()));			
		}catch(Exception e) {
			e.printStackTrace();
			WireTransferDAO.updateTransferStatus(referenceNumber,Constants.TransferStatus.FAILED.toString(), new Timestamp(System.currentTimeMillis()));	
			response.setErrorDescription("Error while adding amount");
			response.setStatus(ResponseStatus.FAILURE.toString());			
		}
		Optional<AccountData> beneficiaryData_afterTxn  = accountDAO.findById(request.getBeneficiaryAccountId());
		transactionDataDAO.save(new TransactionData(RegistrationUtils.generateTransactionId(),request.getBeneficiaryAccountId(), 
								referenceNumber.toString(),Constants.OperationType.CREDIT.toString(),
								"Account transfer", Constants.Currency.USD.toString(),
								beneficiaryData_beforeTxn.get().getBalance(),
								RegistrationUtils.roundToTwoDigits(request.getAmount()),
								RegistrationUtils.roundToTwoDigits(beneficiaryData_afterTxn.get().getBalance()),
								new Timestamp(System.currentTimeMillis()),"System"));
		WireTransferDAO.updateTransferStatus(referenceNumber,Constants.TransferStatus.SUCCESS.toString(), new Timestamp(System.currentTimeMillis()));
		System.out.println(" the wire transfer status after txn "+ WireTransferDAO.findById(referenceNumber));
		response.setStatus(ResponseStatus.SUCCESS.toString());	
		return response;
		
	}

}
