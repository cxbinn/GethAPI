package com.example.demo;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.web3j.protocol.Web3j;

import com.example.demo.utils.pool.Web3jFactory;

public class pool_test {
	public static void main(String[] args){
		final GenericObjectPool<Web3j> pool = new GenericObjectPool<Web3j>(

		new Web3jFactory());
		try {
			Web3j tmp=pool.borrowObject();
			pool.returnObject(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
