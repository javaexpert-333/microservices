package com.javaexpert.account.service;

import java.util.List;

import com.javaexpert.account.model.Account;


public interface AccountService {
	public Account createAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(String accountCode);
}
