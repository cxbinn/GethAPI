package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.initDB;
import com.example.demo.utils.initDir;


@RestController
@RequestMapping("/utils")
public class utilController {
	@Autowired
	private initDB initdb;
	public String init(){
		//init dir 
		initDir.init();
		//init wallet
		initdb.updateWallet();
		
		return "404";
	}

}
