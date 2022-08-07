package com.javaexpert.reportaggregator.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.reportaggregator.model.TransactionDetails;
import com.javaexpert.reportaggregator.service.ReportAggregatorService;

@RestController
@RequestMapping("/banking/reports")
public class ReportAggregatorController {
	
	@Autowired
	private ReportAggregatorService reportAggregatorService;
	
	@GetMapping("/transactiondetails/{accountCode}")
	public TransactionDetails getTransactionDetails(@PathVariable String accountCode) {
		return reportAggregatorService.getTransactionDetails(accountCode);
	}
}
