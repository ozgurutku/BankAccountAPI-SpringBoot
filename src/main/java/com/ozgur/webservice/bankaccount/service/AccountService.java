package com.ozgur.webservice.bankaccount.service;

import java.util.List;

import com.ozgur.webservice.bankaccount.model.Account;

public interface AccountService {

	Account createAccount(Account account);

	Account updateAccount(Account account);

	List<Account> getAllAccount();

	Account getAccountByName(String accountName);

	Account getAccountById(long id);

	void deleteAccount(long id);

}
