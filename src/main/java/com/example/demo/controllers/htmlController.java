package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("content")
public class htmlController {
	@RequestMapping("codeCommit")
	public String codeCommit() {
		return "codeCommit";
	}

	@RequestMapping("tx")
	public String tx() {
		return "tx";
	}

	@RequestMapping("deployContract")
	public String deployContract() {
		return "deployContract";
	}

	@RequestMapping("displayMethods")
	public String displayMethods() {
		return "displayMethods";
	}

	@RequestMapping("call")
	public String call() {
		return "callContract";
	}
	@RequestMapping("user_info")
	public String user_info() {
		return "user_info";
	}


}
