package com.javaexpert.reportaggregator.model;

import java.util.List;

public class TransactionDetails {
	private Account account;
	private List<FundTransfer> fundTrasferList;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<FundTransfer> getFundTrasferList() {
		return fundTrasferList;
	}
	public void setFundTrasferList(List<FundTransfer> fundTrasferList) {
		this.fundTrasferList = fundTrasferList;
	}
	@Override
	public String toString() {
		return "TransactionDetails [account=" + account + ", fundTrasferList=" + fundTrasferList + "]";
	}
	
	
}
