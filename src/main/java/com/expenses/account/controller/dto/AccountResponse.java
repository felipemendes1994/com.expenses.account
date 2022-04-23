package com.expenses.account.rest.dao;

import java.math.BigDecimal;

import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNick() {
		return accountNick;
	}

	public void setAccountNick(String accountNick) {
		this.accountNick = accountNick;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
