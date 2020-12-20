package com.ozgur.webservice.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozgur.webservice.bankaccount.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findByName(String name);
}
