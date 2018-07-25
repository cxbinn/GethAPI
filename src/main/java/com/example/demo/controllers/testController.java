package com.example.demo.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GethUtils.initDB;

@RestController
public class testController {
	@RequestMapping(value="/testInitDB", method = RequestMethod.GET)
	public String testInitDB() throws IOException, SQLException{
		initDB test=new initDB();
		test.test_getinfo();
		return "lalaland";
	}

}
