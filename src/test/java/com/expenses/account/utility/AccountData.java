package com.expenses.account.utility;

import com.expenses.account.entity.Account;

public class AccountData {
	private String agencyNumber;
	private String accountNumber;
	private String bankName;
	private String bankNumber;
	
	public String getAgencyNumber() {
		return agencyNumber;
	}
	public void setAgencyNumber(String agency) {
		this.agencyNumber = agency;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String account) {
		this.accountNumber = account;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	public Account toAccount() {
		Account account = new Account();
		
		account.setAgencyNumber(this.agencyNumber);
		account.setAccountNumber(this.accountNumber);
		account.setBankName(this.bankName);
		account.setBankNumber(this.bankNumber);
		
		return account;
	}
}
