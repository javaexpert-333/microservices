package com.javaexpert.reportaggregator.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javaexpert.reportaggregator.model.Account;
import com.javaexpert.reportaggregator.model.FundTransfer;
import com.javaexpert.reportaggregator.model.TransactionDetails;

@Service
public class ReportAggregatorServiceImpl implements ReportAggregatorService {
	
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
	   // Do any additional configuration here
	   return builder.build();
	}*/
	
	/*@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/
	
	@Autowired
	private RestTemplateBuilder restTemplate;
	
	
	
	public TransactionDetails getTransactionDetails(String account) {
		TransactionDetails transactionDetails = new TransactionDetails();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity<?> entity = new HttpEntity(headers);
		//Account accountResponse = restTemplate.exchange("http://localhost:333/banking/account/getAccount/"+account, HttpMethod.GET,entity,Account.class).getBody();
		Account accountResponse  = restTemplate.build().getForObject("http://localhost:333/banking/account/getAccount/"+account, Account.class);
		@SuppressWarnings("unchecked")
		List<FundTransfer> fundtransferResponse  = restTemplate.build().getForObject("http://localhost:555/banking/fundtransfer/getTxn/"+account, List.class);
		
		transactionDetails.setAccount(accountResponse);
		transactionDetails.setFundTrasferList(fundtransferResponse);
		return transactionDetails;
	}
}
