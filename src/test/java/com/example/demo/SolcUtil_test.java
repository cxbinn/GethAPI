package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.utils.SolcUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GethApItestApplication.class)
public class SolcUtil_test {
	
	@Test
	public void createFile() throws Exception{
		String code="pragma solidity ^0.4.19;contract finalmission {string name;int num;function HelloWorld() public{name = \"Bruce Wayne\";num = 1;}function setName(string _name) public{name = _name;}function getName() public view returns(string){return name;}function setNum(int n) public{num = n;}function addNum(int m) public view returns(int res){res = m + num;}}";
		String result=SolcUtil.compileSolc(code).get("result");
		System.out.print("there're million heroes,but i'm the best of them!!!!:\n"+result);
		
	}

}
