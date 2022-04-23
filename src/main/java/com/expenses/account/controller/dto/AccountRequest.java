package com.expenses.account.rest.dao;

import com.expenses.account.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRequest {
	private String accountType;
	private String agencyNumber;
	private String accountNumber;
	private String bankNumber;
	private String bankName;
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	
	public String getBankNumber() {
		return bankNumber;
	}
	
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public Account toAccount(){
		Account account = new Account();
		account.setAccountNumber(this.accountNumber);
		account.setBankNumber(this.bankNumber);
		account.setAgencyNumber(this.agencyNumber);
		account.setBankName(this.bankName);
		return account;
	}
}
