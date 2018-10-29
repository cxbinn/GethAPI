package com.example.demo.entity;

public class Account_sol {

	public String address;
	public String originalfile;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	@Override
	public String toString() {
		return "Account_sol [address=" + address + ", originalfile="
				+ originalfile + "]";
	}
	
}
