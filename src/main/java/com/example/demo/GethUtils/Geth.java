package com.example.demo.GethUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import com.example.demo.configuration.gethProperties;

public class Geth {
	private static final String GethURL = gethProperties.SERVER;
	private static final String MasterAddress = gethProperties.MasterAddress;
	private static final String MasterPassword = gethProperties.MasterPassword;
	private static final String WalletPath = gethProperties.KeyStorePath;
	private static final Web3j web3j = Web3j.build(new HttpService(GethURL));
	private static final Admin admin = Admin.build(new HttpService(GethURL));

	public static String createAccount(String password) throws IOException {
		String accountID = admin.personalNewAccount(password).send()
				.getAccountId();
		return accountID;
	}

	public static String tx(String from, String to, float sum, String password)
			throws TransactionException, Exception {
		String wallet = null;
		String walletfile = WalletPath + "/" + wallet;
		unlockAccount(from, "");
		Credentials credentials = WalletUtils.loadCredentials(password,
				walletfile);
		TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j,
				credentials, to, BigDecimal.valueOf(sum), Convert.Unit.ETHER)
				.send();
		return null;
	}

	public static String unlockAccount(String account, String password)
			throws InterruptedException, ExecutionException {
		PersonalUnlockAccount personalUnlockAccount = admin
				.personalUnlockAccount(account, password).sendAsync().get();
		if (personalUnlockAccount.accountUnlocked()) {
			// send a transaction
			System.out.println("unlock successfully!!!!");
			return null;
		}
		return null;
	}

	public static String getBalance(String account) throws IOException {
		EthGetBalance ethGetBalance = web3j.ethGetBalance(account,
				DefaultBlockParameterName.LATEST).send();
		BigInteger balance = ethGetBalance.getBalance();
		return balance.toString();
	}

	public static String deployContract(String deployer, String password,
			String contract) throws InterruptedException, ExecutionException {
		unlockAccount(deployer, password);
		return null;
	}

	public static String callContract(String contract) {
		return null;
	}

	public static List<String> getAccounts() throws IOException {
		List<String> result = web3j.ethAccounts().send().getAccounts();
		return result;
	}

	public static String getAccountsInfo() {
		return null;
	}

	public static String getTXAddress() {
		return null;
	}

	public static String getAllTXAddress() {
		return null;
	}

}
