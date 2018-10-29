package com.example.demo;
import org.web3j.tx.Contract;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.crypto.CipherException;

import com.example.demo.configuration.GethProperties;
import com.example.demo.utils.ContractObject;
import com.example.demo.utils.ContractUtil;
import com.example.demo.utils.Geth;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GethApItestApplication.class)
public class ContractUtils_test {
	
	public void deploy() throws Exception{
//		try {
//			for(String tmp:ContractUtil.AllMethod_Detail(""))
//				System.out.println(tmp);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	@Test
	public void call() throws Exception{
		String address="0x77bdf3f3c3bf657c31413259e65acfb8c47ce788";
		Geth.unlockAccount(GethProperties.MasterAddress, GethProperties.MasterPassword);
		ContractObject tmp=ContractUtil.load_local(address, "Testweb" ,GethProperties.MasterPassword);
		if(tmp==null){
			System.out.println("I'm null!!!");
		}
		else{
			System.out.println(ContractUtil.call(tmp, "HelloWorld",null));
		//System.out.println(ContractUtil.call(tmp, "Hello",null));
		System.out.println(ContractUtil.call(tmp, "getName",null));
		//System.out.println(ContractUtil.call(tmp, "getContractAddress", null));
		System.out.println(ContractUtil.call(tmp, "getName",null));
		}
	}
	

}
