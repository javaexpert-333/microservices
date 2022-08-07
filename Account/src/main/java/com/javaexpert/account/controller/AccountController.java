package com.javaexpert.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.account.model.Account;
import com.javaexpert.account.service.AccountService;

@RestController
@RequestMapping("/banking/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@GetMapping("/getAccounts")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}
	
	@GetMapping("/getAccount/{accountCode}")
	public Account getAccount(@PathVariable String accountCode) {
		return accountService.getAccount(accountCode);
	}
}
