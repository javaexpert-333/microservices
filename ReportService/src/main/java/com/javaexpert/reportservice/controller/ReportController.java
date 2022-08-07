package com.javaexpert.reportservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.reportservice.model.TransactionDetails;
import com.javaexpert.reportservice.service.TransactionReportService;

@RestController
@RequestMapping("/banking/report")
public class ReportController {
	
	@Autowired
	TransactionReportService transactionReportService;
	
	@GetMapping("/getTxnDetails/{accountCode}")
	public TransactionDetails getTransactionDetails(@PathVariable String accountCode) {
		return transactionReportService.getTransactionDetails(accountCode);
	}
}
