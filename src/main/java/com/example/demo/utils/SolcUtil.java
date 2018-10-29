package com.example.demo.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.BaseData;
import com.example.demo.configuration.GethProperties;
import com.example.demo.entity.Transaction_javaclass;
import com.example.demo.service.Transaction_javaclassService;

@Component
public class SolcUtil {
	// private final String PACKAGE="test.example.foxconn";
	// private final String SOLC_FROM="/data/geth/tmp_SmartContract/";
	// private final String SOLC_TO="/data/geth/tmp_Compile/";
	// private final String WEB3J_FROM="/data/geth/tmp_Compile/";
	// private final String WEB3J_TO="/data/geth/tmp_java";
	private final static String PARENT=GethProperties.path.getParent();
	private final static String PACKAGE = GethProperties.path.getSolc_package();
	private final static String SOLC_FROM = GethProperties.path.getSolc();
	private final static String SOLC_TO = GethProperties.path.getAbi();
	private final static String WEB3J_FROM = GethProperties.path.getAbi();
	private final static String WEB3J_TO = GethProperties.path.getJava();
	
	private static Transaction_javaclassService transaction_javaclassServiceImpl;
	@Autowired
	private Transaction_javaclassService transaction_javaclassService;
	
	@PostConstruct
	public void init(){
		transaction_javaclassServiceImpl=transaction_javaclassService;
	}
	private SolcUtil(){}
	public static String compile_SOLCtoABI(String solcCode) {
		String solc = createSolcFile(solcCode);
		String name = getContractName(solcCode);

		File f = new File(SOLC_FROM + name + ".bin");
		if (f.exists()) {
			return "ALREADY EXISTS！\nRename this contract,please";
		}
//		final String cmd1 = "solc " + SOLC_FROM + solc
//				+ ".sol --bin --abi --optimize -o " + SOLC_TO;
		final String cmd1 = "solc " + PARENT+BaseData.getPATH_OF_DATE()+"/"+SOLC_FROM + solc
				+ ".sol --bin --abi --optimize -o " + PARENT+BaseData.getPATH_OF_DATE()+"/"+SOLC_TO;
		return cmd(cmd1);
	}

	public static String compile_ABItoJAVA(String name) {
		final String cmd2 = "web3j solidity generate " + PARENT+BaseData.getPATH_OF_DATE()+"/"+WEB3J_FROM+"/" + name
				+ ".bin " + PARENT+BaseData.getPATH_OF_DATE()+"/"+WEB3J_FROM+"/" + name + ".abi -o " + PARENT+BaseData.getPATH_OF_DATE()+"/"+WEB3J_TO + " -p "
				+ PACKAGE;
		return cmd(cmd2);
	}

	public static Map<String,String> compileSolc(String solcCode) throws Exception {
		Map<String,String> result=new HashMap<String,String>();
		
		String solc = createSolcFile(solcCode);
		String abi_name=getContractName(solcCode);
		String name = Standardize_Name(abi_name);
		
		File f = new File(PARENT+BaseData.getPATH_OF_DATE()+"/"+SOLC_FROM + name + ".bin");
		if (f.exists()) {
			result.put("result", "rename this contract,please");
			return result;
		}

		// String cmd1 = "solc /data/geth/tmp_SmartContract/tmp1.sol --bin --abi --optimize -o /data/geth/tmp_Compile";
		// String cmd2 = "web3j solidity generate /data/geth/tmp_Compile/HelloWorld.bin /data/geth/tmp_Compile/HelloWorld.abi -o /data/geth/tmp_java -p test.example.foxconn";
		String cmd1 = "solc " + PARENT+BaseData.getPATH_OF_DATE()+"/"+SOLC_FROM+"/" + solc
				+ ".sol --bin --abi --optimize -o " + PARENT+BaseData.getPATH_OF_DATE()+"/"+SOLC_TO;
		String cmd2 = "web3j solidity generate " + PARENT+BaseData.getPATH_OF_DATE()+"/"+WEB3J_FROM + "/"+abi_name + ".bin "
				+ PARENT+BaseData.getPATH_OF_DATE()+"/"+WEB3J_FROM+"/" + abi_name + ".abi -o " + PARENT+BaseData.getPATH_OF_DATE()+"/"+WEB3J_TO + " -p " + PACKAGE;

		/*
		 * PARENT+BaseData.getPATH_OF_DATE()
		 * +GethProperties.path.getJava()+GethProperties.path.getSolc_package().replace(".", "/")+"/";
		 * 
		 */
		
		
		String result1 = cmd(cmd1);
		String result2 = cmd(cmd2);
		
		String target=PARENT+BaseData.getPATH_OF_DATE()+"/"+GethProperties.path.getJava()+"/"+GethProperties.path.getSolc_package().replace(".", "/")+"/";
		System.out.println("now it's compiling :"+target+name+".java");
		JavacUtil.javac(target+name+".java");
		
		Transaction_javaclass tmp=new Transaction_javaclass();
		tmp.setClassName(name);
		tmp.setAbi_name(abi_name);
		tmp.setContractAddress("0x0");
		tmp.setJavaName(name+".java");
		tmp.setOriginalFile(solc+".sol");
		tmp.setParent_of_date(BaseData.getPATH_OF_DATE().toString());
		transaction_javaclassServiceImpl.insertTransaction_javaclass(tmp);
		
		
		result.put("result", result1 + "\n" + result2);
		result.put("id", solc+".sol");
		return result;
	}

	private static String cmd(String cmd) {
		System.out.println("Now it is running cmd:"+cmd);
		StringBuilder sb = new StringBuilder();
		Process process = null;
		List<String> processList = new ArrayList<String>();
		try {
			process = Runtime.getRuntime().exec(cmd);
			InputStream in = null;
			if (process.getErrorStream().available() > 0) {
				in = process.getErrorStream();
			} else {
				in = process.getInputStream();
			}
			BufferedReader input = new BufferedReader(new InputStreamReader(
					in));
			String line = "";
			while ((line = input.readLine()) != null) {
				processList.add(line);
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (process != null) {
				process.destroy();
			}
		}

		for (String line : processList) {
			sb.append(line + "\n");
			// System.out.println(line);
		}
		return cmd + "\n" + sb.toString();
	}

	// solcCode write in a ".sol" file;
	// return the filename;
	public static String createSolcFile(String solcCode) {
		String solc = String.valueOf(System.currentTimeMillis());
		File tmp = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			tmp = new File(PARENT+BaseData.getPATH_OF_DATE()+"/"+SOLC_FROM +"/"+ solc + ".sol");
			fos = new FileOutputStream(tmp);
			bos = new BufferedOutputStream(fos);
			byte[] target = solcCode.getBytes();
			bos.write(target);
		} catch (Exception e) {

		} finally {

			try {
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return solc;
	}

	public static String getContractName(String code) {
		// ###pragma solidity ^0.4.19;contract test1 {###
		//return code.substring(32, code.indexOf("{")).replace(" ", "");
		return code.split("contract")[1].split("\\{")[0].replace(" ", "");
	}
	private static String Standardize_Name(String name){
		char[] cs = name.toCharArray();
		if (cs[0] > 96) {
			cs[0] -= 32;
		}
		return String.valueOf(cs);
	}

}
