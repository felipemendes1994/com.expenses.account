package com.expenses.account.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountRepository;
import com.expenses.account.exception.ConflictException;
import com.expenses.account.exception.NotFoundException;
import com.expenses.account.rest.dao.AccountResponse;

@Service
public class AccountService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	AccountRepository accountRepository;
	
	public void createAccount(Account account) throws ConflictException {
		Optional<Account> old = accountRepository.findByAccountNumberAndAgencyNumber(account.getAccountNumber(), account.getAgencyNumber());
		
		if(old.isPresent()) {
			throw new ConflictException(String.format("Agency %s and account %s already exists", account.getAccountNumber(), account.getAgencyNumber()));
		}
		
		accountRepository.save(account);
		LOGGER.info(String.format("Agency %s account %s created successfully", account.getAgencyNumber(), account.getAccountNumber()));
	}
	
	public AccountResponse findAccount(String accountNumber, String agencyNumber) throws Exception {
		Account account = accountRepository.findByAccountNumberAndAgencyNumber(accountNumber, agencyNumber)
				.orElseThrow(() -> new NotFoundException(String.format("Agency %s, Account %s not found", agencyNumber, accountNumber)));
		
		return new AccountResponse(account);
	}
}
