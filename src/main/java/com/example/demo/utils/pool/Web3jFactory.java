package com.example.demo.utils.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.example.demo.configuration.GethProperties;

public class Web3jFactory extends BasePooledObjectFactory<Web3j> {
	private static final String GethURL = GethProperties.SERVER;
	
	
	@Override
	public Web3j create() throws Exception {
		// TODO Auto-generated method stub
		return Web3j.build(new HttpService(GethURL));
	}

	@Override
	public PooledObject wrap(Web3j arg0) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<Web3j>( arg0);
	}
	

}
