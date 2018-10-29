package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.example.demo.entity.Contract;

public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractService contractService;

	@Override
	public Contract getContract(String address) throws Exception {
		// TODO Auto-generated method stub
		return contractService.getContract(address);
	}

	@Override
	public int insertContract(TransactionReceipt contract) throws Exception {
		// TODO Auto-generated method stub
		return contractService.insertContract(contract);
	}

	@Override
	public int updateContract(TransactionReceipt contract) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteContract(String address) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TransactionReceipt> getAllContracts() throws Exception {
		// TODO Auto-generated method stub
		return contractService.getAllContracts();
	}

}
