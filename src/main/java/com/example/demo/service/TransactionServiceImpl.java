package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.core.methods.response.Transaction;


public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionService transactionService;
	
	@Override
	public Transaction getTransaction(String address) throws Exception {
		// TODO Auto-generated method stub
		return transactionService.getTransaction(address);
	}

	@Override
	public int insertTransaction(Transaction transaction) throws Exception {
		// TODO Auto-generated method stub
		return transactionService.insertTransaction(transaction);
	}

	@Override
	public int updateTransaction(Transaction transaction) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTransaction(String address) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transaction> getAllTransactions() throws Exception {
		// TODO Auto-generated method stub
		return transactionService.getAllTransactions();
	}


}
