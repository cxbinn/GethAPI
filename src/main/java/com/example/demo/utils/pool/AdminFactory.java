package com.example.demo.utils.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;

import com.example.demo.configuration.GethProperties;

public class AdminFactory extends BasePooledObjectFactory<Admin>  {
	private static final String GethURL = GethProperties.SERVER;
	@Override
	public Admin create() throws Exception {
		// TODO Auto-generated method stub
		return Admin.build(new HttpService(GethURL));
	}

	@Override
	public PooledObject<Admin> wrap(Admin obj) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<Admin>(obj);
	}

}
