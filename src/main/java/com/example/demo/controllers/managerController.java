package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;

import com.example.demo.GethUtils.Geth;
import com.example.demo.configuration.gethProperties;

@RestController
public class managerController {
	public String createAccount(String password) throws IOException{
		String accountID=Geth.createAccount(password);
		return accountID;
	}
	@RequestMapping("/hello")
	public String tx(String from,String to,int sum){
		return null;
	}
	public String unlockAccount(String account,String password){
		return null;
	}
	public String getBalance(String account){
		return null;
	}
	public String deployContract(String contract){
		return null;
	}
	public String callContract(String contract){
		return null;
	}
	public String getAccounts(){
		return null;
	}
	public String getAccountsInfo(){
		return null;
	}
	public String getTXAddress(){
		return null;
	}

	public String getAllTXAddress(){
		return null;
	}
	
	
	
	
}
