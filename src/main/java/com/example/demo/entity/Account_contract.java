package com.example.demo.entity;

public class Account_contract {
	public String account;
	public String contractaddress;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getContractaddress() {
		return contractaddress;
	}
	public void setContractaddress(String contractaddress) {
		this.contractaddress = contractaddress;
	}
	@Override
	public String toString() {
		return "Account_contract [account=" + account + ", contractaddress="
				+ contractaddress + "]";
	}
	

}
