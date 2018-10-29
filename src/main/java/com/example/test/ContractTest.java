package com.example.test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLClassLoader;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;


public class ContractTest {
	public static Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:3333"));
	public static String path="/home/ms/go-ethereum/build/bin/testNet/keystore";
	public static String wallet="UTC--2018-06-05T11-10-38.729572359Z--aef3ac241a8172bcd613fa05980f41e3271fe774";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String password = "";
		String walletfile =path+"/"+wallet;

		
		//Credentials credentials = WalletUtils.loadCredentials("", walletfile);
		/*
		 * 
		 	String account = web3j.ethAccounts().send().getAccounts().get(0);
			Credentials credentials = Credentials.create(account);
			ECKeyPair keyPair = credentials.getEcKeyPair();
			BigInteger privateKey = keyPair.getPrivateKey();
			BigInteger publicKey = keyPair.getPublicKey();
		 * 
		 */
		String account = web3j.ethAccounts().send().getAccounts().get(0);
		
		System.out.println("account:"+account);
		System.out.println("getBalance:"+getBalance(account));
		
		PersonalUnlockAccount personalUnlockAccount = Admin.build(new HttpService("http://127.0.0.1:3333")).personalUnlockAccount(account, "").sendAsync().get();
		if (personalUnlockAccount.accountUnlocked()) {
		    // send a transaction
			System.out.println("unlock successfully!!!!");
			
		}
		Credentials credentials = WalletUtils.loadCredentials(password, walletfile);
//		
//		URL[] urls = new URL[]{new URL("file:"+"/data/geth/tmp_java/")};
//		URLClassLoader loader = new URLClassLoader(urls);
//		Class<?> cls=loader.loadClass("test.example.foxconn.Testweb");
		
		
//		URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:" + "Testweb.java")});
//		Object a = classLoader.loadClass("Testweb").newInstance();
		
		
		ContractObject contract=new ContractObject("/data/geth/tmp_java/","test.example.foxconn.Testweb");
		contract.paramsReady(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		RemoteCall<?> result=(RemoteCall<?>)contract.invoke("deploy", Web3j.class,Credentials.class,BigInteger.class,BigInteger.class);
		Object o=result.send();
		
		
		//HelloWorld contract = HelloWorld.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
		
//		contract.init(o);
//		
//
//		contract.paramsReady(null);
//		boolean isValid=(boolean)contract.invoke("isValid");
//		System.out.println(isValid);
//		if (isValid) {
//			System.out.println("---");
//			
//			contract.paramsReady(null);
//			String contractAddress = (String) contract.invoke("getContractAddress");
//			System.out.println(contractAddress);
//			System.out.println("---");
//			
//			String getName = (String) ((RemoteCall<?>)contract.invoke("getName")).send();
//			System.out.println(getName);
//			
//			
//			System.out.println("---");
//			contract.paramsReady(BigInteger.valueOf(8));
//			((RemoteCall<?>)contract.invoke("setNum",BigInteger.class)).send();
//			
//			contract.paramsReady(BigInteger.valueOf(3));
//			BigInteger addNum=(BigInteger)((RemoteCall<?>)contract.invoke("addNum",BigInteger.class)).send();
//			System.out.println("contract.invoke(\"addNum\",BigInteger.class)).send()::"+addNum);
//			System.out.println("---");
//
//		} else {
//			System.out.println("Deploy ERROR !!!");
//		}
	}
	
	public static BigInteger getBalance(String account) throws IOException {

		EthGetBalance ethGetBalance = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).send();
		BigInteger balance = ethGetBalance.getBalance();
		return balance;

	}

}
