package com.javaexpert.reportservice.model;

import java.util.List;

public class TransactionDetails {
	private Account account;
	private List<FundTransfer> fundTransfer;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<FundTransfer> getFundTransfer() {
		return fundTransfer;
	}
	public void setFundTransfer(List<FundTransfer> fundTransfer) {
		this.fundTransfer = fundTransfer;
	}
	@Override
	public String toString() {
		return "TransactionDetails [account=" + account + ", fundTransfer=" + fundTransfer + "]";
	}
	
	
}
