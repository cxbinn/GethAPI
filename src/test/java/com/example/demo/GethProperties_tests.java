package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.configuration.GethProperties;
import com.example.demo.utils.initDir;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GethApItestApplication.class)
public class GethProperties_tests {
	@Test
	public void showGethProperties(){
		System.out.println("aa"+GethProperties.path.getAbi());
		System.out.println("aa"+GethProperties.path.getKeystore());
		System.out.println("aa"+GethProperties.MasterAddress);
		initDir.init();
	}

}
