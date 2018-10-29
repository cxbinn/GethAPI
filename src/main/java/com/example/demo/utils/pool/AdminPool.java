package com.example.demo.utils.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.web3j.protocol.admin.Admin;

public class AdminPool {
	private static GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
	static {
		conf.setMaxTotal(10);
		conf.setMaxWaitMillis(30000);
		conf.setBlockWhenExhausted(true);
		
	}
	private static final GenericObjectPool<Admin> adminPool = new GenericObjectPool<Admin>(new AdminFactory(),conf);
	public static GenericObjectPool<Admin> getAdminpool() {
		return adminPool;
	}
	

}
