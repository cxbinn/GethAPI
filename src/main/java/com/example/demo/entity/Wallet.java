package com.example.demo.entity;

public class Wallet {
	public String address;
	public String file_name;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	@Override
	public String toString() {
		return "Wallet [address=" + address + ", file_name=" + file_name + "]";
	}
	

}
