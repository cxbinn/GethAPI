package com.example.test;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

public class Wallet_Geth {
	//public static final String walletPath="/data/geth/wallet";
	public static final String walletPath="/home/ms/go-ethereum/build/bin/data_demo2/keystore";
	public static final String walletName="UTC--2018-07-18T07-18-04.394000000Z--0527994f021c9d54547f890e8f8c72cbf2a852fb.json";
	public static final String password="foxconn.88";
	//UTC--2018-07-18T07-18-04.394000000Z--0527994f021c9d54547f890e8f8c72cbf2a852fb.json
	public void createWallet() throws NoSuchAlgorithmException,
			NoSuchProviderException, InvalidAlgorithmParameterException,
			CipherException, IOException {

		File file = new File(walletPath);
		String fileName = WalletUtils.generateFullNewWalletFile(password, file);
		System.out.println(fileName);

	}
	
	
	//0x0527994f021c9d54547f890e8f8c72cbf2a852fb
	public void walletAddress() throws IOException, CipherException {

		File file = new File(
				walletPath+"/"+walletName);
		Credentials credentials = WalletUtils.loadCredentials(password, file);
		System.out.println(credentials.getAddress());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Wallet_Geth wallet = new Wallet_Geth();
		try {
			wallet.createWallet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Wallet_Geth wallet = new Wallet_Geth();
//		try {
//			wallet.walletAddress();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
