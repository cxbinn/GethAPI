package com.example.demo.entity;

public class TransactionReceipt {
	public String blockHash;
	public String blockNumber;
	public String contractAddress;
	public String cumulativeGasUsed;
	public String from;
	public String gasUsed;
	public String status;
	public String to;
	public String transactionHash;
	public String transactionIndex;
	public String getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public String getCumulativeGasUsed() {
		return cumulativeGasUsed;
	}
	public void setCumulativeGasUsed(String cumulativeGasUsed) {
		this.cumulativeGasUsed = cumulativeGasUsed;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getGasUsed() {
		return gasUsed;
	}
	public void setGasUsed(String gasUsed) {
		this.gasUsed = gasUsed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getTransactionHash() {
		return transactionHash;
	}
	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}
	public String getTransactionIndex() {
		return transactionIndex;
	}
	public void setTransactionIndex(String transactionIndex) {
		this.transactionIndex = transactionIndex;
	}
	@Override
	public String toString() {
		return "TransactionReceipt [blockHash=" + blockHash + ", blockNumber="
				+ blockNumber + ", contractAddress=" + contractAddress
				+ ", cumulativeGasUsed=" + cumulativeGasUsed + ", from=" + from
				+ ", gasUsed=" + gasUsed + ", status=" + status + ", to=" + to
				+ ", transactionHash=" + transactionHash
				+ ", transactionIndex=" + transactionIndex + "]";
	}

}
