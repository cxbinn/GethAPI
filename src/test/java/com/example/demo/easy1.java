package com.example.demo;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.configuration.GethProperties;
import com.example.demo.entity.Wallet;
import com.example.demo.service.WalletService;
import com.example.demo.utils.Geth;
import com.example.demo.utils.initDB;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GethApItestApplication.class)
public class easy1 {
	@Test
	public void set(){
		StringBuilder sb = new StringBuilder();
		URLClassLoader urlClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
        for (URL url : urlClassLoader.getURLs()) {
            sb.append(url.getFile()).append(File.pathSeparator).append("\n");
        }
		System.out.println(sb);
		
	}
	
}
