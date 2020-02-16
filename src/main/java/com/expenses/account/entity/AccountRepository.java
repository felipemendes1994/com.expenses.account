package com.expenses.account.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
//	Optional<Account> findByAccountNumber(String accountNumber);
//	
//	Optional<Account> findByAgencyNumber(String agencyNumber);
//	
	Optional<Account> findByAccountNumberAndAgencyNumber(String accountNumber, String agencyNumber);
}

