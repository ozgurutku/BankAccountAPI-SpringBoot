package com.ozgur.webservice.bankaccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ozgur.webservice.bankaccount.model.Account;
import com.ozgur.webservice.bankaccount.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/getAllAccount")
	public List<Account> getAllAccount() {
		return accountService.getAllAccount();
	}

	@GetMapping("/searchById/{id}")
	public Account getAccountById(@PathVariable(value = "id") long id) {
		return accountService.getAccountById(id);
	}
	
	 @GetMapping("/searchByName/{name}")
	 public Account getAccountByName(@PathVariable(value="name") String name) {
		 return accountService.getAccountByName(name);
	 }

	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	@PutMapping("/update/{id}")
	public Account updateAccount(@RequestBody Account account, @PathVariable("id") long id) {
		account.setId(id);
		return accountService.updateAccount(account);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Account> deleteAccount(@PathVariable("id") long id) {
		accountService.deleteAccount(id);
		return ResponseEntity.ok().build();
	}

}
