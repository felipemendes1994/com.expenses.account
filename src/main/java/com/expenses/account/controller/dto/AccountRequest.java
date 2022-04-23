package com.expenses.account.controller.dto;

import com.expenses.account.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AccountRequest {
	private String accountType;
	private String agencyNumber;
	private String accountNumber;
	private String bankNumber;
	private String bankName;
	
	public Account toAccount(){
		Account account = new Account();
		account.setAccountNumber(this.accountNumber);
		account.setBankNumber(this.bankNumber);
		account.setAgencyNumber(this.agencyNumber);
		account.setBankName(this.bankName);
		return account;
	}
}
