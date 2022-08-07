package com.javaexpert.fundtransfer.service;

import java.util.List;


import com.javaexpert.fundtransfer.model.FundTransfer;


public interface FundTransferService {
	public FundTransfer processTxn(FundTransfer fundTransfer);
	public FundTransfer processTxnWithDefaultRate(FundTransfer fundTransfer);
	public List<FundTransfer> getTxns();
	public List<FundTransfer> getTxnForAccount(String accountCode);
}
