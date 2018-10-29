package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class TransactionReceiptServiceImpl implements TransactionReceiptService {

	@Autowired
	private TransactionReceiptService transactionReceiptService;
	@Override
	public TransactionReceipt getTransactionReceipt(String address)
			throws Exception {
		// TODO Auto-generated method stub
		return transactionReceiptService.getTransactionReceipt(address);
	}

	@Override
	public int insertTransactionReceipt(TransactionReceipt transactionReceipt)
			throws Exception {
		// TODO Auto-generated method stub
		return transactionReceiptService.insertTransactionReceipt(transactionReceipt);
	}

	@Override
	public int updateTransactionReceipt(TransactionReceipt transactionReceipt)
			throws Exception {
		// TODO Auto-generated method stub
		return transactionReceiptService.updateTransactionReceipt(transactionReceipt);
	}

	@Override
	public int deleteTransactionReceipt(String address) throws Exception {
		// TODO Auto-generated method stub
		return transactionReceiptService.deleteTransactionReceipt(address);
	}

	@Override
	public List<TransactionReceipt> getAllTransactionReceipts()
			throws Exception {
		// TODO Auto-generated method stub
		return transactionReceiptService.getAllTransactionReceipts();
	}

}
