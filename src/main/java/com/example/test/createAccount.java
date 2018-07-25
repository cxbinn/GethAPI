package com.example.test;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
public class createAccount {
	
	/*
	 * 0xe921f1dafefc7901516c718a2f2fe7c6d6aeb5ec
	 * 0x4f2055268db028c1345c85247c988214b9524a98
	 */
	public static void main(String[] args) throws IOException{
		String url = "http://10.134.159.154:3333/";
		Web3j web3j = Web3j.build(new HttpService(url)); // defaults to http://localhost:8545/
		
		/*
		 * Admin admin=Admin.build(new HttpService(url));
		 * System.out.println(admin.personalNewAccount("foxconn.88").send().getAccountId());
		 */
		
		BigInteger balance=web3j.ethGetBalance("0xe921f1dafefc7901516c718a2f2fe7c6d6aeb5ec",DefaultBlockParameterName.LATEST).send().getBalance();
		//
		System.out.println("balance:"+balance);
		System.out.println("aaaaaaaaaaaa:"+web3j.ethAccounts().send().getResult().get(0));
		try {
			Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			System.out.println(clientVersion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
