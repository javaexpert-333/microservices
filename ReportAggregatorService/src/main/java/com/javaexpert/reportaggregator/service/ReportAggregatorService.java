package com.javaexpert.reportaggregator.service;

import com.javaexpert.reportaggregator.model.TransactionDetails;

public interface ReportAggregatorService {
	public TransactionDetails getTransactionDetails(String account);
}
