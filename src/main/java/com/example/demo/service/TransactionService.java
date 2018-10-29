package com.example.demo.service;

import java.util.List;

import org.web3j.protocol.core.methods.response.Transaction;



public interface TransactionService {
	public Transaction getTransaction(String address) throws Exception;

	public int insertTransaction(Transaction transaction) throws Exception;

	public int updateTransaction(Transaction transaction) throws Exception;

	public int deleteTransaction(String address) throws Exception;

	public List<Transaction> getAllTransactions() throws Exception;

}
