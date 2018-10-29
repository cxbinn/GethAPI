package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Account;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountService accountService;
	@Override
	public Account getAccount(String address) throws Exception {
		// TODO Auto-generated method stub
		return accountService.getAccount(address);
	}

	@Override
	public int insertAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		return accountService.insertAccount(account);
	}

	@Override
	public int updateAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		return accountService.updateAccount(account);
	}

	@Override
	public int deleteAccount(String address) throws Exception {
		// TODO Auto-generated method stub
		return accountService.deleteAccount(address);
	}

	@Override
	public List<Account> getAllAccounts() throws Exception {
		// TODO Auto-generated method stub
		return accountService.getAllAccounts();
	}

}
