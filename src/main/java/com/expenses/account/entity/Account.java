package com.expenses.account.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtAccount;
	
	private String accountName;
	private String accountNick;
	private AccountType accountType;
	private String bankNumber;
	private String bankName;
	
	private BigDecimal initialBalance;
	private BigDecimal balance;
	
	private String agencyNumber;
	private String accountNumber;
	
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
