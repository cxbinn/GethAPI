package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountService {
	public Account getAccount(String address) throws Exception;

	public int insertAccount(Account account) throws Exception;

	public int updateAccount(Account account) throws Exception;

	public int deleteAccount(String address) throws Exception;

	public List<Account> getAllAccounts() throws Exception;

}
