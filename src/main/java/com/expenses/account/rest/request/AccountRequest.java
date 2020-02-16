package com.expenses.account.rest.request;

import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountType;

public class AccountRequest {

	private String accountType;
	private String agencyNumber;
	private String accountNumber;
	private String bankNumber;
	
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
	
	public Account toAccount(){
		Account account = new Account();
		account.setAccountType(AccountType.valueOf(this.accountType));
		account.setAccountNumber(this.accountNumber);
		account.setBanckNumber(this.bankNumber);
		account.setAgencyNumber(this.agencyNumber);
		return account;
	}
}
