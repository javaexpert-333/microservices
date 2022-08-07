package com.javaexpert.fundtransfer.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaexpert.fundtransfer.model.CrossRate;
import com.javaexpert.fundtransfer.model.FundTransfer;
import com.javaexpert.fundtransfer.repository.FundTransferRepository;


@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	FundTransferRepository fundTransferRepository;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Override
	public FundTransfer processTxn(FundTransfer fundTransfer) {
		CrossRate crossRate = new CrossRate("INR","USD",70);
		
		ResponseEntity<CrossRate> responseEntity = restTemplateBuilder.build().exchange("http://rates-service/banking/rates/crossRate", HttpMethod.POST, new HttpEntity<CrossRate>(crossRate), CrossRate.class);
		crossRate = responseEntity.getBody();
		
		fundTransfer.setAmount(fundTransfer.getAmount()*crossRate.getCrossRate());
		
		return fundTransferRepository.save(fundTransfer);
	}
	
	@Override
	public FundTransfer processTxnWithDefaultRate(FundTransfer fundTransfer) {
		
		CrossRate crossRate = new CrossRate("INR","USD",70);
		
		fundTransfer.setAmount(fundTransfer.getAmount()*crossRate.getCrossRate());
		
		return fundTransferRepository.save(fundTransfer);
	}

	@Override
	public List<FundTransfer> getTxns() {
		return fundTransferRepository.findAll();
	}

	@Override
	public List<FundTransfer> getTxnForAccount(String accountCode) {
		return fundTransferRepository.findByAccountFrom(accountCode);
	}

}
