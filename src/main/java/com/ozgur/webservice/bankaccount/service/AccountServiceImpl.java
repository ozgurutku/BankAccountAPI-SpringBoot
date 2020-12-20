package com.ozgur.webservice.bankaccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozgur.webservice.bankaccount.exception.ResourceNotFoundException;
import com.ozgur.webservice.bankaccount.model.Account;
import com.ozgur.webservice.bankaccount.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		Optional<Account> findAccount = accountRepository.findById(account.getId());
		if (findAccount.isPresent()) {
			Account accountUpdate = findAccount.get();
			accountUpdate.setBalance(account.getBalance());
			accountUpdate.setName(account.getName());
			accountUpdate.setSurname(account.getSurname());
			accountRepository.save(accountUpdate);
			return accountUpdate;
		} else {
			throw new ResourceNotFoundException("Account not found");
		}
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountByName(String accountName) {
		return accountRepository.findByName(accountName);
	}

	@Override
	public Account getAccountById(long id) {
		Optional<Account> account = this.accountRepository.findById(id);

		if (account.isPresent()) {
			return account.get();
		} else {
			throw new ResourceNotFoundException("Account not found with id : " + id);
		}
	}

	@Override
	public void deleteAccount(long id) {
		Optional<Account> account = this.accountRepository.findById(id);

		if (account.isPresent()) {
			accountRepository.delete(account.get());
		} else {
			throw new ResourceNotFoundException("Account not found with id : " + id);
		}
	}

}
