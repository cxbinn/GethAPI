package com.example.demo.entity;

public class Transaction_javaclass {
	public String contractAddress;
	public String className;
	public String javaName;
	public String originalFile;
	public String abi_name;
	public String parent_of_date;


	public String getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getAbi_name() {
		return abi_name;
	}

	public void setAbi_name(String abi_name) {
		this.abi_name = abi_name;
	}

	public String getParent_of_date() {
		return parent_of_date;
	}

	public void setParent_of_date(String parent_of_date) {
		this.parent_of_date = parent_of_date;
	}

	@Override
	public String toString() {
		return "Transaction_javaclass [contractAddress=" + contractAddress
				+ ", className=" + className + ", javaName=" + javaName
				+ ", originalFile=" + originalFile + ", abi_name=" + abi_name
				+ ", parent_of_date=" + parent_of_date + "]";
	}
	




	
	

}
