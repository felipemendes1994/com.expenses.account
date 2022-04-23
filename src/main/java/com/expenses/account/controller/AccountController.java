package com.expenses.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.account.exception.ConflictException;
import com.expenses.account.exception.NotFoundException;
import com.expenses.account.rest.dao.AccountRequest;
import com.expenses.account.rest.dao.AccountResponse;
import com.expenses.account.service.AccountService;

@RestController
public class AccountRest {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/accounts")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createAccount(@RequestBody AccountRequest request) throws ConflictException {
		service.createAccount(request.toAccount());
	}
	
	@GetMapping("/accounts/{account}/agencies/{agency}")
	@ResponseStatus(code = HttpStatus.OK)
	public AccountResponse getAccount(@PathVariable String account, @PathVariable String agency) throws Exception {
		return service.findAccount(account, agency);
	}
	
	@DeleteMapping("/accounts/{account}/agencies/{agency}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAccount(@PathVariable String account, @PathVariable String agency) throws NotFoundException {
		service.deleteAccount(account, agency);
	}
	
	@GetMapping("/health")
	@ResponseStatus(code = HttpStatus.OK)
	public void health() {}
}
