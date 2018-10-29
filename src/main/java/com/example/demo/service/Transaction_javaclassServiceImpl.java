package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Transaction_javaclass;

public class Transaction_javaclassServiceImpl implements Transaction_javaclassService{
	
	@Autowired
	private Transaction_javaclassService transaction_javaclassService;
	
	@Override
	public Transaction_javaclass getTransaction_javaclassByAddress(String address)
			throws Exception {
		// TODO Auto-generated method stub
		return transaction_javaclassService.getTransaction_javaclassByAddress(address);
	}
	
	@Override
	public Transaction_javaclass getTransaction_javaclassByID(String ID)
			throws Exception {
		// TODO Auto-generated method stub
		return transaction_javaclassService.getTransaction_javaclassByID(ID);
	}


	@Override
	public int insertTransaction_javaclass(
			Transaction_javaclass transaction_javaclass) throws Exception {
		// TODO Auto-generated method stub
		return transaction_javaclassService.insertTransaction_javaclass(transaction_javaclass);
	}

	@Override
	public int updateTransaction_javaclass(
			Transaction_javaclass transaction_javaclass) throws Exception {
		// TODO Auto-generated method stub
		return transaction_javaclassService.updateTransaction_javaclass(transaction_javaclass);
	}

	@Override
	public int deleteTransaction_javaclass(String address) throws Exception {
		// TODO Auto-generated method stub
		return transaction_javaclassService.deleteTransaction_javaclass(address);
	}

	@Override
	public List<Transaction_javaclass> getAllTransaction_javaclasses()
			throws Exception {
		// TODO Auto-generated method stub
		return transaction_javaclassService.getAllTransaction_javaclasses();
	}

	@Override
	public int updateContractAddress(Transaction_javaclass transaction_javaclass) {
		// TODO Auto-generated method stub
		return transaction_javaclassService.updateContractAddress(transaction_javaclass);
	}

}
