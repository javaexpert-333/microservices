package com.javaexpert.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpert.account.model.Account;
import com.javaexpert.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
		
	}

	@Override
	public Account getAccount(String accountCode) {
		return accountRepository.findById(accountCode).get();
	}

}
