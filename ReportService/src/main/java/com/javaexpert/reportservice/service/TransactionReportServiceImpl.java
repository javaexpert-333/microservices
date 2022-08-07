package com.javaexpert.reportservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.javaexpert.reportservice.model.Account;
import com.javaexpert.reportservice.model.FundTransfer;
import com.javaexpert.reportservice.model.TransactionDetails;

@Service
public class TransactionReportServiceImpl implements TransactionReportService {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Override
	public TransactionDetails getTransactionDetails(String accountCode) {
		
		TransactionDetails transactionDetails = new TransactionDetails();
		
		Account accoutResponse = restTemplateBuilder.build().getForObject("http://localhost:333/banking/account/getAccount/"+accountCode, Account.class);
		
		List<FundTransfer> fundTransferResponse = restTemplateBuilder.build().getForObject("http://localhost:555/banking/fundtransfer/getTxnForAccount/"+accountCode, List.class);
		
		transactionDetails.setAccount(accoutResponse);
		transactionDetails.setFundTransfer(fundTransferResponse);
		return transactionDetails;
	}

}
