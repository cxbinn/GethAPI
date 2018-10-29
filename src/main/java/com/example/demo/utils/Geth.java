package com.example.demo.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import com.example.demo.configuration.BaseData;
import com.example.demo.configuration.GethProperties;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction_javaclass;
import com.example.demo.service.AccountService;
import com.example.demo.service.ContractService;
import com.example.demo.service.TransactionReceiptService;
import com.example.demo.service.TransactionService;
import com.example.demo.service.WalletService;
import com.example.demo.utils.pool.AdminPool;
import com.example.demo.utils.pool.Web3jPool;

@Component
public class Geth {
	private static Geth geth;
	private static final String GethURL = GethProperties.SERVER;
	private static final String MasterAddress = GethProperties.MasterAddress;
	private static final String MasterPassword = GethProperties.MasterPassword;
	private static final String WalletPath = GethProperties.path.getKeystore();
	
	private static GenericObjectPool<Web3j> web3jPool=Web3jPool.getWeb3jpool();
	private static GenericObjectPool<Admin> adminPool=AdminPool.getAdminpool();

	private static AccountService accountServiceImpl;
	private static TransactionService transactionServiceImpl;
	private static TransactionReceiptService transactionReceiptServiceImpl;
	private static WalletService walletServiceImpl;
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private TransactionReceiptService transactionReceiptService;
	@Autowired
	private  WalletService walletService;
	
	private static initDB initdbImpl;
	@Autowired
	private initDB initdb;
	
	private Geth() {
		
	}
	
	@PostConstruct
	  public void init() {
		accountServiceImpl=accountService;
		transactionServiceImpl=transactionService;
		transactionReceiptServiceImpl=transactionReceiptService;
		walletServiceImpl=walletService;
		initdbImpl=initdb;
	  }

	public static String createAccount(String password) throws Exception {
		Admin Admin=adminPool.borrowObject();
		NewAccountIdentifier result = Admin.personalNewAccount(password).send();
		adminPool.returnObject(Admin);
		
		String accountID = result.getAccountId();
		Account tmp = new Account();
		tmp.setAddress(accountID);
		tmp.setPassword(password);
		tmp.setCreatedate((int)System.currentTimeMillis()/1000);
		accountServiceImpl.insertAccount(tmp);
		
		initdbImpl.match(accountID);
		return accountID;
	}

	public static String tx(String from, String to, int sum,
			String password) throws TransactionException, Exception {

		if((exist(from)==false||exist(to)==false)){
			return "wrong accounts";
		}
		//check(sum)?
		String wallet_name = walletServiceImpl.getWallet(from).getFile_name();
		String walletfile = WalletPath + "/" + wallet_name;
		
		if(unlockAccount(from, password)==false){
			return "wrong password";
		}
		Credentials credentials = WalletUtils.loadCredentials(password,
				walletfile);
		
		Web3j web3j=web3jPool.borrowObject();
		
		TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j,
				credentials, to, BigDecimal.valueOf(sum), Convert.Unit.ETHER)
				.send();
		web3jPool.returnObject(web3j);
		
		transactionReceiptServiceImpl.insertTransactionReceipt(transactionReceipt);
		
		return transactionReceipt.toString();
	}

	public static boolean unlockAccount(String account, String password)
			throws Exception {
		boolean result=false;
		Admin Admin=adminPool.borrowObject();		
		PersonalUnlockAccount personalUnlockAccount = Admin
				.personalUnlockAccount(account, password).sendAsync().get();
		if (personalUnlockAccount.accountUnlocked()) {
			// send a transaction
			System.out.println("unlock successfully!!!!");
			result=true;
		}
		adminPool.returnObject(Admin);
		return result;
	}

	public static String getBalance(String account) throws Exception {
		Web3j web3j=web3jPool.borrowObject();
		EthGetBalance ethGetBalance = web3j.ethGetBalance(account,
				DefaultBlockParameterName.LATEST).send();
		BigInteger balance = ethGetBalance.getBalance();
		web3jPool.returnObject(web3j);
		return balance.toString();
	}

	public static String solc(String code) throws Exception {

		// insert(contractName);
		// return compile error or successs;
		// or compile status;
		return SolcUtil.compileSolc(code).get("result");
	}

	public static TransactionReceipt deployContract(String deployer,
			String password, String contract_ID) throws Exception {
		unlockAccount(deployer, password);

		// return deployed status;
		return ContractUtil.deploy(deployer, password, contract_ID);
	}

	public static Object callContract(String userAddress, String password,
			String address, String methodName, Object... params)
			throws Exception {
		unlockAccount(userAddress, password);

		ContractObject tmp=ContractUtil.loadContract(address, userAddress, password);
		//Object result = ContractUtil.call(tmp, methodName, params);
		Object result = ContractUtil.call(tmp, "getName",null);
		
		System.out.println((String)result);
		return result;
	}

	public static List<String> getAccounts() throws Exception {
		Web3j web3j=web3jPool.borrowObject();
		List<String> result=web3j.ethAccounts().send().getAccounts();
		web3jPool.returnObject(web3j);
		return result;
	}

	public static boolean exist(String account){
		return BaseData.getAccounts().contains(account);
	}
	
	public static String getAccountsInfo() {
		return null;
	}

	public static String getTXAddress() throws Exception {
		return null;
	}

	public static List<Transaction> getAllTXAddress() throws Exception {
		return transactionServiceImpl.getAllTransactions();
	}



	
}
