package com.expenses.account.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.expenses.account.controller.dto.AccountResponse;
import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountRepository;
import com.expenses.account.exception.ConflictException;
import com.expenses.account.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	
	private final AccountRepository accountRepository;
	
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

	public void deleteAccount(String accountNumber, String agencyNumber) throws NotFoundException {
		Account account = accountRepository.findByAccountNumberAndAgencyNumber(accountNumber, agencyNumber)
				.orElseThrow(() -> new NotFoundException(String.format("Agency %s, Account %s not found", agencyNumber, accountNumber)));
		
		accountRepository.delete(account);
	}
}
