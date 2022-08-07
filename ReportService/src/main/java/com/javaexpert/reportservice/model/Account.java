package com.javaexpert.reportservice.model;


public class Account {
	private String accountCode;
	private String accountType;
	private String accountName;
	private String address;
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Account [accountCode=" + accountCode + ", accountType=" + accountType + ", accountName=" + accountName
				+ ", address=" + address + "]";
	}
	
	

}
