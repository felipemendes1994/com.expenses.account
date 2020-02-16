package com.expenses.account.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtAccount;
	
	private String accountName;
	private String accountNick;
	private AccountType accountType;
	private String bankNumber;
	
	private BigDecimal initialBalance;
	private BigDecimal balance;
	
	private String agencyNumber;
	private String accountNumber;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public BigDecimal getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
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
	public Long getIdtAccount() {
		return idtAccount;
	}
	public void setIdtAccount(Long idtAccount) {
		this.idtAccount = idtAccount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getAccountNick() {
		return accountNick;
	}
	public void setAccountNick(String accountNick) {
		this.accountNick = accountNick;
	}
	public String getBanckNumber() {
		return bankNumber;
	}
	public void setBanckNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtAccount == null) ? 0 : idtAccount.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (idtAccount == null) {
			if (other.idtAccount != null)
				return false;
		} else if (!idtAccount.equals(other.idtAccount))
			return false;
		return true;
	}
	
	public String toString(){
		return "{idConta:"+idtAccount+", "
				+ "nomeConta:"+accountName+", "
				+ "tipoConta: "+accountType+","
				+ "numAgencia: "+agencyNumber+", "
				+ "numConta: "+accountNumber+"}";
	}
}
