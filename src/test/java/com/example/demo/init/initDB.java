package com.example.demo.init;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;

import com.example.demo.GethApItestApplication;
import com.example.demo.configuration.GethProperties;
import com.example.demo.entity.Account;
import com.example.demo.entity.Wallet;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionService;
import com.example.demo.service.WalletService;
import com.example.demo.utils.Geth;
import com.example.demo.utils.pool.Web3jPool;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GethApItestApplication.class)
public class initDB {

	@Autowired
	private WalletService walletService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;
	public void test_initDB() throws Exception  {
		String keystore = GethProperties.KeyStorePath;
		System.out.println(keystore);
		File f = new File(keystore);

		List<String> accounts=Geth.getAccounts();

		for (String wallet : f.list()){
			for(String account:accounts){
			if (wallet.contains(account.subSequence(2, account.length()))) {
				System.out.println(account+"\t"+wallet);
				Wallet tmp=new Wallet();
				tmp.setAddress(account);
				tmp.setFile_name(wallet);
				walletService.insertWallet(tmp);
				break;
			}
			
			
			}
		}

	}

	public void init_account() throws Exception{
		String keystore = GethProperties.KeyStorePath;
		List<String> accounts=Geth.getAccounts();
		for(String account:accounts){
			Account tmp=new Account();
			tmp.setAddress(account);
			tmp.setPassword("");
			tmp.setLasttime(0);
			tmp.setCreatedate(0);
			accountService.insertAccount(tmp);
		}
	}

	public void init_transaction() throws Exception {
		Web3j web3j = Web3jPool.getWeb3jpool().borrowObject();

		BigInteger max = web3j.ethBlockNumber().send().getBlockNumber();
		for (BigInteger i = BigInteger.valueOf(1); i.compareTo(max) <= 0; i = i
				.add(BigInteger.valueOf(1))) {
			List<EthBlock.TransactionResult> txs = web3j
					.ethGetBlockByNumber(new DefaultBlockParameterNumber(i),
							true).send().getBlock().getTransactions();
			txs.forEach(tx -> {
				EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx
						.get();

				try {
					transactionService.insertTransaction(transaction);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

		Web3jPool.getWeb3jpool().returnObject(web3j);
	}
	



}
