package com.example.test;

import java.io.IOException;
import java.math.BigDecimal;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

public class transferTest {
	public static Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:3333"));
	///home/ms/go-ethereum/build/bin/testNet/keystore
	public static String path="/home/ms/go-ethereum/build/bin/testNet/keystore";
	public static String wallet="UTC--2018-06-05T11-10-38.729572359Z--aef3ac241a8172bcd613fa05980f41e3271fe774";
	public static void main(String[] args) throws InterruptedException, IOException, TransactionException, Exception{
		float coin=1;
		String password = "";
		String walletfile =path+"/"+wallet;
		String account0 = web3j.ethAccounts().send().getAccounts().get(0);
		String account1 = web3j.ethAccounts().send().getAccounts().get(2);
		
		
		PersonalUnlockAccount personalUnlockAccount = Admin.build(new HttpService("http://127.0.0.1:3333")).personalUnlockAccount(account0, "").sendAsync().get();
		if (personalUnlockAccount.accountUnlocked()) {
		    // send a transaction
			System.out.println("unlock successfully!!!!");
			
		}
		Credentials credentials = WalletUtils.loadCredentials(password, walletfile);
		//Credentials credentials = Credentials.create(account0);

		
		
		TransactionReceipt transactionReceipt = Transfer
				.sendFunds(web3j, credentials, account1, BigDecimal.valueOf(coin), Convert.Unit.ETHER).send();
		System.out.println(transactionReceipt.getStatus());
	}

}
