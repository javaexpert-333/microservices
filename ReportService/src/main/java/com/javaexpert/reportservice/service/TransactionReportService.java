package com.javaexpert.reportservice.service;

import com.javaexpert.reportservice.model.TransactionDetails;

public interface TransactionReportService {
	public TransactionDetails getTransactionDetails(String accountCode);
}
