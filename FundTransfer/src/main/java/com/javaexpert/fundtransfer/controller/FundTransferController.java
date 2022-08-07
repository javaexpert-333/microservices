package com.javaexpert.fundtransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.fundtransfer.model.FundTransfer;
import com.javaexpert.fundtransfer.service.FundTransferService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/banking/fundtransfer")
public class FundTransferController {
	
	@Autowired
	FundTransferService fundTransferService;
	
	@PostMapping("/processTxn")
	@CircuitBreaker(name="rateService", fallbackMethod="processTxnWithDefaultRate")
	public FundTransfer processFundTransfer(@RequestBody FundTransfer fundTranfer) {
		return fundTransferService.processTxn(fundTranfer);
	}
	
	public FundTransfer processTxnWithDefaultRate(FundTransfer fundTranfer, Exception e) {
		return fundTransferService.processTxnWithDefaultRate(fundTranfer);
	}
	
	@GetMapping("/getTxns")
	public List<FundTransfer> getTxns() {
		return fundTransferService.getTxns();
	}
	
	@GetMapping("/getTxnForAccount/{accountCode}")
	public List<FundTransfer> getTxnForAccount(@PathVariable String accountCode) {
		return fundTransferService.getTxnForAccount(accountCode);
	}
	
}
