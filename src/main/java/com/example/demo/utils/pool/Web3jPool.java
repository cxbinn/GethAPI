package com.example.demo.utils.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.web3j.protocol.Web3j;

public class Web3jPool {
	private static GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
	static {
		conf.setMaxTotal(10);
		conf.setMaxWaitMillis(30000);
		conf.setBlockWhenExhausted(true);
		
	}
	private static final GenericObjectPool<Web3j> web3jPool = new GenericObjectPool<Web3j>(new Web3jFactory(),conf);
	public static GenericObjectPool<Web3j> getWeb3jpool() {
		return web3jPool;
	}
	
	
}
