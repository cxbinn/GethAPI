package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountMapper {
	public Account getUser(String address) throws Exception;

	public int insertAccountr(Account account) throws Exception;

	public int updateAccount(Account account) throws Exception;

	public int deleteAccount(String address) throws Exception;

	public List<Account> getAllAccounts() throws Exception;

}
