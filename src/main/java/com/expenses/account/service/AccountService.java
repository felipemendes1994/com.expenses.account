package com.expenses.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountRepository;
import com.expenses.account.exception.NotFoundException;

@Service
public class AccountService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	AccountRepository accountRepository;
	
	public void createAccount(Account account) {
		accountRepository.save(account);
		LOGGER.info(String.format("Agency %s account %s created successfully"), account.getAgencyNumber(), account.getAccountNumber());
	}
//	
//	public Account checkBankAccount(Account extractAccount) {
//		Optional<Account> account = accountRepository.findByAccountNumber(extractAccount.getAccountNumber());
//		
//		if(account.isEmpty()) {
//			LOGGER.info("Bank Account Not Found! Creating its record!");
//			return createAccount(extractAccount);
//		}
//		
//		return account.get();
//	}
	
	public Account findAccount(String accountNumber, String agencyNumber) throws Exception {
		return accountRepository.findByAccountNumberAndAgencyNumber(accountNumber, agencyNumber)
				.orElseThrow(() -> new NotFoundException(String.format("Agency %s, Account %s not found", agencyNumber, accountNumber)));
	}
}
