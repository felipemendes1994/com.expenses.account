package com.expenses.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.account.entity.Account;
import com.expenses.account.rest.request.AccountRequest;
import com.expenses.account.service.AccountService;

@RestController
public class AccountRest {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/account")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createAccount(@RequestBody AccountRequest request) {
		service.createAccount(request.toAccount());
	}
	
	@GetMapping("/accounts/{account}/agencies/{agency}")
	@ResponseStatus(code = HttpStatus.OK)
	public Account getAccount(@PathVariable String account, @PathVariable String agency) throws Exception {
		return service.findAccount(account, agency);
	}
}
