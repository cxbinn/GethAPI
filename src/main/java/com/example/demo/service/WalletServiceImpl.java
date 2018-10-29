package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Wallet;

public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletService walletService;
	
	@Override
	public Wallet getWallet(String address) throws Exception {
		// TODO Auto-generated method stub
		return walletService.getWallet(address);
	}

	@Override
	public int insertWallet(Wallet wallet) throws Exception {
		// TODO Auto-generated method stub
		return walletService.insertWallet(wallet);
	}

	@Override
	public int updateWallet(Wallet wallet) throws Exception {
		// TODO Auto-generated method stub
		return walletService.updateWallet(wallet);
	}

	@Override
	public int deleteWallet(String address) throws Exception {
		// TODO Auto-generated method stub
		return walletService.deleteWallet(address);
	}

	@Override
	public List<Wallet> getAllWallets() throws Exception {
		// TODO Auto-generated method stub
		return walletService.getAllWallets();
	}

}
