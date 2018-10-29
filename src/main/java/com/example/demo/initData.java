package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.BaseData;
import com.example.demo.utils.Geth;
import com.example.demo.utils.initDir;

@Component
public class initData implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		BaseData.update();
		initDir.init();
		
	}

}
