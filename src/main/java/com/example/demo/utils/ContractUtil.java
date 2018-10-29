package com.example.demo.utils;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import com.example.demo.configuration.GethProperties;
import com.example.demo.entity.Transaction_javaclass;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionReceiptService;
import com.example.demo.service.Transaction_javaclassService;
import com.example.demo.service.WalletService;
import com.example.demo.utils.pool.Web3jPool;

@Component
public class ContractUtil {
	public static String path = GethProperties.path.getKeystore();
	private static LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();

	
	private static AccountService accountServiceImpl;
	private static WalletService walletServiceImpl;
	private static Transaction_javaclassService transaction_javaclassServiceImpl;
	private static TransactionReceiptService transactionReceiptServiceImpl;

	private static GenericObjectPool<Web3j> web3jPool=Web3jPool.getWeb3jpool();	
	@Autowired
	private  AccountService accountService;
	@Autowired
	private WalletService walletService;
	@Autowired
	private Transaction_javaclassService transaction_javaclassService;
	@Autowired
	private TransactionReceiptService transactionReceiptService;
	
	
	@PostConstruct
	public void init(){
		accountServiceImpl=accountService;
		walletServiceImpl=walletService;
		transaction_javaclassServiceImpl=transaction_javaclassService;
		transactionReceiptServiceImpl=transactionReceiptService;
	}
	
	private ContractUtil(){}
	
	public static TransactionReceipt deploy(String account, String password,
			String contract_ID) throws Exception {

		String wallet = getWallet(account);
		String walletfile = path + "/" + wallet;
		Credentials credentials = WalletUtils.loadCredentials(password,
				walletfile);
		
		Transaction_javaclass target=transaction_javaclassServiceImpl.getTransaction_javaclassByID(contract_ID);
		
		
		ContractObject contract = new ContractObject();
		contract.forClass(GethProperties.path.getParent()+target.getParent_of_date()+"/"+GethProperties.path.getJava()+"/", target.getClassName());

		Web3j web3j=web3jPool.borrowObject();
		
		contract.paramsReady(web3j, credentials, ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		RemoteCall<?> result = (RemoteCall<?>) contract.invoke("deploy",
				Web3j.class, Credentials.class, BigInteger.class,
				BigInteger.class);
		Object o = result.send();
		
		contract.init(o);
		//getTransactionReceipt
		Optional<TransactionReceipt> receipt = (Optional<TransactionReceipt>) contract
				.invoke("getTransactionReceipt", null);
		
		web3jPool.returnObject(web3j);
		
		TransactionReceipt re=receipt.get();
		transactionReceiptServiceImpl.insertTransactionReceipt(re);
		
		Transaction_javaclass tmp=new Transaction_javaclass();
		tmp.setOriginalFile(contract_ID);
		tmp.setContractAddress(re.getContractAddress());
		transaction_javaclassServiceImpl.updateContractAddress(tmp);
		
		
		return re;
	}

	public static ContractObject loadContract(String address, String account,
			String password) throws Exception {

		String wallet = getWallet(account);

		String walletfile = path + "/" + wallet;
		Credentials credentials = WalletUtils.loadCredentials(password,
				walletfile);

		Transaction_javaclass target = transaction_javaclassServiceImpl
				.getTransaction_javaclassByAddress(address);
		String java_package = target.getClassName();
		
		
		ContractObject contract = new ContractObject();
		contract.forClass(GethProperties.path.getParent()
				+ target.getParent_of_date() + "/"
				+ GethProperties.path.getJava()+"/", java_package);
		
		Web3j web3j=web3jPool.borrowObject();
		
		contract.paramsReady(address, web3j, credentials,
				ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		contract.init(contract.invoke("load", String.class, Web3j.class,
				Credentials.class, BigInteger.class, BigInteger.class));
		web3jPool.returnObject(web3j);
		
		
		
		
		return contract;
	}
	
	public static ContractObject loadClass(String id) throws Exception {

		Transaction_javaclass target = transaction_javaclassServiceImpl
				.getTransaction_javaclassByID(id);
		String java_package = target.getClassName();

		ContractObject contract = new ContractObject();
		contract.forClass(
				GethProperties.path.getParent()
						+ target.getParent_of_date() + "/"
						+ GethProperties.path.getJava()+"/", java_package);

		return contract;
	}
	public static ContractObject load_local(String address, String java_package,
			String password) throws Exception {

		String wallet = GethProperties.MasterWallet;

		String walletfile = path + "/" + wallet;

		Credentials credentials = WalletUtils.loadCredentials(password,
				walletfile);

		ContractObject contract = new ContractObject();
		contract.forClass(GethProperties.path.getJava(), java_package);
		
		Web3j web3j=web3jPool.borrowObject();
		
		contract.paramsReady(address, web3j, credentials,
				ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		contract.init(contract.invoke("load", String.class, Web3j.class,
				Credentials.class, BigInteger.class, BigInteger.class));
		web3jPool.returnObject(web3j);
		
		//we should save this contract object for a while to keep calling it,without reloading it;
		
		/*
		 * code of save
		 */
		return contract;
	}

	public static String AllMethod_Detail(String contract_ID) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		ContractObject co = loadClass(contract_ID);

		Class<?> clazz = co.getContractClass();

		Method[] a = clazz.getDeclaredMethods();

		for (Method tmp : a) {
			result.add(tmp.toString());
		}

		return result.toString();
	}

	public static Object getContract() {

		return null;
	}

	public static Object getContractMethod(String address) {

		return null;
	}

	public static Object call(ContractObject co, String methodName,
			Object... params) throws Exception {
		Object result = null;
		System.out.println("---" + methodName);
		co.paramsReady(params);
		if (params == null) {
			result = ((RemoteCall<?>) co.invoke(methodName)).send();
		} else {

			result = ((RemoteCall<?>) co.invoke(methodName, params.getClass()))
					.send();
		}

		// System.out.println(result);
		// System.out.println("---");
		return result;
	}
	
	private static String getWallet(String address) throws Exception{
		return walletServiceImpl.getWallet(address).getFile_name();
	}
	public void test() {
		// “0x0faeccab659d7d8809a2037427d14e631c7668ede5cabd26da071d9b073442ba”

	}

}
