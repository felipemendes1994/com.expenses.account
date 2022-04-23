package com.expenses.account.controller.dto;

import java.math.BigDecimal;

import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AccountResponse {
	
	private String bankNumber;
	private String bankName;
	
	private String agencyNumber;
	
	private String accountName;
	private String accountNick;
	private AccountType accountType;
	private String accountNumber;
	
	private BigDecimal initialBalance;
	private BigDecimal balance;
	
	public AccountResponse(Account account) {
		this.accountName = account.getAccountName();
		this.accountNick = account.getAccountNick();
		this.bankNumber = account.getBankNumber();
		this.initialBalance = account.getInitialBalance();
		this.balance = account.getBalance();
		this.agencyNumber = account.getAgencyNumber();
		this.accountNumber = account.getAccountNumber();
		this.bankName = account.getBankName();
	}
}
