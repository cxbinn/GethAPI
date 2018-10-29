package com.example.demo.entity;


public class Transaction implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2057216447692967482L;
	public String blockHash;
	public int blockNumber;
	public String from;
	public long gas;
	public long gasPrice;
	public String hash;
	public String input;
	public int nonce;
	public String r;
	public String s;
	public String to;
	public int transactionIndex;
	public String v;
	public long value;
	public String getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public long getGas() {
		return gas;
	}
	public void setGas(long gas) {
		this.gas = gas;
	}
	public long getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(long gasPrice) {
		this.gasPrice = gasPrice;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getTransactionIndex() {
		return transactionIndex;
	}
	public void setTransactionIndex(int transactionIndex) {
		this.transactionIndex = transactionIndex;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Transaction [blockHash=" + blockHash + ", blockNumber="
				+ blockNumber + ", from=" + from + ", gas=" + gas
				+ ", gasPrice=" + gasPrice + ", hash=" + hash + ", input="
				+ input + ", nonce=" + nonce + ", r=" + r + ", s=" + s
				+ ", to=" + to + ", transactionIndex=" + transactionIndex
				+ ", v=" + v + ", value=" + value + "]";
	}
	
	
	
}
