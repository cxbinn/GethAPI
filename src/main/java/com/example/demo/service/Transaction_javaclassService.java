package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Transaction_javaclass;

public interface Transaction_javaclassService {
	public Transaction_javaclass getTransaction_javaclassByAddress(String address) throws Exception;
	
	public Transaction_javaclass getTransaction_javaclassByID(String ID) throws Exception;

	public int insertTransaction_javaclass(Transaction_javaclass transaction_javaclass) throws Exception;

	public int updateTransaction_javaclass(Transaction_javaclass transaction_javaclass) throws Exception;
	
	public int updateContractAddress(Transaction_javaclass transaction_javaclass);

	public int deleteTransaction_javaclass(String address) throws Exception;

	public List<Transaction_javaclass> getAllTransaction_javaclasses() throws Exception;

}
