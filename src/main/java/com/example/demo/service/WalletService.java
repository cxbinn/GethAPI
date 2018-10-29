package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;
import com.example.demo.entity.Wallet;

public interface WalletService {
	public Wallet getWallet(String address) throws Exception;

	public int insertWallet(Wallet wallet) throws Exception;

	public int updateWallet(Wallet wallet) throws Exception;

	public int deleteWallet(String address) throws Exception;

	public List<Wallet> getAllWallets() throws Exception;

}
