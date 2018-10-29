package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.exceptions.TransactionException;

import com.example.demo.utils.ContractUtil;
import com.example.demo.utils.Geth;
import com.example.demo.utils.SolcUtil;

@RestController
@RequestMapping("/manager")
public class managerController {

	@GetMapping("/createAccount")
	public String createAccount(String password) throws Exception {
		return Geth.createAccount(password);
	}
	

	@RequestMapping("/tx")
	public String tx(String from, String to, int coins,String password) throws TransactionException, Exception {
		return Geth.tx(from, to, coins, password);
	}

	@RequestMapping("/unlockAccount")
	public boolean unlockAccount(String account, String password) throws Exception {
		return Geth.unlockAccount(account, password);
	}

	@GetMapping("/getBalance")
	public String getBalance(String account) throws Exception {
		return Geth.getBalance(account);
	}

	@RequestMapping("/deployContract")
	public String deployContract(String from,String password,String ID) throws Exception {
		return Geth.deployContract(from, password,ID).toString();
	}

	@RequestMapping("/callContract")
	public String callContract(String account,String password,String contractAddress) throws Exception {
		
		return Geth.callContract(account, password, contractAddress, null, null).toString();
	}

	@GetMapping("/getAccounts")
	public String getAccounts() throws Exception {
		return Geth.getAccounts().toString();
	}

	@GetMapping("/getAccountsInfo")
	public String getAccountsInfo() {
		return null;
	}
	
	@GetMapping("/listMethods")
	public String listMethods() {
		return null;
	}

	@RequestMapping("/TXAddress")
	public String getTXAddress() {
		return null;
	}

	@RequestMapping("/getAllTXAddress")
	public String getAllTXAddress() {
		return null;
	}
	
	@PostMapping(path="/compile_SOLCtoABI")
	public String compile_SOLCtoABI(String code){
		return SolcUtil.compile_SOLCtoABI(code);
		
	}
	@RequestMapping("/compile_ABItoJAVA")
	public String compile_ABItoJAVA(String solc_FileName){
		return SolcUtil.compile_ABItoJAVA(solc_FileName);
		
	}
	@RequestMapping("/solc")
	public String solc(String code) throws Exception{
		return SolcUtil.compileSolc(code).get("result");
	}
	
	/**
	 * only load class
	 */
	@RequestMapping("/AllMethod_Detail")
	public String AllMethod_Detail(String contract_ID) throws Exception{
		
		
		
		//return ContractUtil.AllMethod_Detail(contractAddress).toString();
		return ContractUtil.AllMethod_Detail(contract_ID);
	}
}
