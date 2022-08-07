package com.javaexpert.reportservice.model;

public class FundTransfer {

	private String txnId;
	private String accountFrom;
	private String accountTo;
	private String beneName;
	private double amount;
	private String ifsc;
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	
	
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}
	public String getBeneName() {
		return beneName;
	}
	public void setBeneName(String beneName) {
		this.beneName = beneName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	@Override
	public String toString() {
		return "FundTransfer [txnId=" + txnId + ", accountFrom=" + accountFrom + ", accountTo=" + accountTo
				+ ", beneName=" + beneName + ", amount=" + amount + ", ifsc=" + ifsc + "]";
	}
	
	
}
