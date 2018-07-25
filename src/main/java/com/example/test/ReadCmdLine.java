package com.example.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCmdLine {
	public static void main(String args[]) {
		
		/*
		 * 
		 *  $ solc /data/geth/tmp_SmartContract/tmp.sol --bin --abi --optimize -o /data/geth/tmp_Compile
		 *	$ web3j solidity generate /data/geth/tmp_Compile/tmp1.bin /data/geth/tmp_abi/tmp1.abi -o /data/geth/tmp_java -p test.example.foxconn
		 */
		Process process = null;
		List<String> processList = new ArrayList<String>();
		try {
			process = Runtime.getRuntime().exec("less /etc/profile");
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = input.readLine()) != null) {
				processList.add(line);
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		for (String line : processList) {
			System.out.println(line);
		}
	}
}