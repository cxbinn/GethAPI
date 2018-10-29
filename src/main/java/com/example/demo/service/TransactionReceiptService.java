package com.example.demo.service;

import java.util.List;

import org.web3j.protocol.core.methods.response.TransactionReceipt;


public interface TransactionReceiptService {
	public TransactionReceipt getTransactionReceipt(String address) throws Exception;

	public int insertTransactionReceipt(TransactionReceipt transactionReceipt) throws Exception;

	public int updateTransactionReceipt(TransactionReceipt transactionReceipt) throws Exception;

	public int deleteTransactionReceipt(String address) throws Exception;

	public List<TransactionReceipt> getAllTransactionReceipts() throws Exception;

}
