package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction_javaclass;
import com.example.demo.entity.Wallet;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionReceiptService;
import com.example.demo.service.TransactionService;
import com.example.demo.service.Transaction_javaclassService;
import com.example.demo.service.WalletService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GethApItestApplication.class)
public class serviceTests {
	@Autowired
	private AccountService accountService;
	@Autowired
	private WalletService walletService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private TransactionReceiptService transactionReceiptService;
	@Autowired 
	private Transaction_javaclassService transaction_javaclassService;
	
	public void get() throws Exception{
		Account account=new Account();
		account.setAddress("aaaa");
		account.setCreatedate(123123213);
		account.setLasttime(1231234555);
		account.setPassword("vvvv");
		accountService.insertAccount(account);
		accountService.getAllAccounts().forEach(System.out::println);
	}
	
	public void wallet_test() throws Exception{

		System.out.println(walletService.getWallet("0xaef3ac241a8172bcd613fa05980f41e3271fe774").getFile_name());
		walletService.getAllWallets().forEach(System.out::println);
	}
	
	@Test
	public void Transaction_test() throws Exception{
		Transaction t=new Transaction();
		t.setBlockHash("1");
		t.setBlockNumber("0x0");
		t.setFrom("asa");
		t.setGas("0x0");
		t.setGasPrice("0x0");
		t.setHash("cxvbcxbv");
		t.setV(new Integer(1));
		t.setValue("0x0");
		t.setNonce("0x0");
		t.setTransactionIndex("0x0");
		transactionService.insertTransaction(t);
		transactionService.getAllTransactions().forEach(System.out::println);
	}
	
	
	public void Transaction_javaclass_test() throws Exception{
//		Transaction_javaclass t=new Transaction_javaclass();
//		t.setContractAddress("zxczxczx");
//		t.setClassName("vc21212");
//		t.setJavaName("sacvberwe");
//		t.setOriginalFile("p0lper");
//		transaction_javaclassService.insertTransaction_javaclass(t);
		System.out.println(transaction_javaclassService.getTransaction_javaclassByID("1537338252141.sol"));
		transaction_javaclassService.getAllTransaction_javaclasses().forEach(System.out::println);
	}
	
	public void TransactionReceipt_test() throws Exception{
		TransactionReceipt t=new TransactionReceipt();
		t.setBlockHash("xzcvx");
		t.setBlockNumber("0x0");
		t.setContractAddress("asdzxcvv");
		t.setCumulativeGasUsed("0x0");
		t.setFrom("asdsadf");
		t.setTransactionIndex("0x0");
		t.setGasUsed("0x0");
		
		transactionReceiptService.insertTransactionReceipt(t);
		transactionReceiptService.getAllTransactionReceipts().forEach(System.out::println);
	}
}
