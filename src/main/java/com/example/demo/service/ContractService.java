package com.example.demo.service;

import java.util.List;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.example.demo.entity.Contract;

public interface ContractService {
	public Contract getContract(String address) throws Exception;

	public int insertContract(TransactionReceipt contract) throws Exception;

	public int updateContract(TransactionReceipt contract) throws Exception;

	public int deleteContract(String address) throws Exception;

	public List<TransactionReceipt> getAllContracts() throws Exception;

}
