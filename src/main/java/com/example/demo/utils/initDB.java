package com.example.demo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.BaseData;
import com.example.demo.configuration.GethProperties;
import com.example.demo.entity.Wallet;
import com.example.demo.service.WalletService;

@Component
public class initDB {

	@Autowired
	private WalletService walletService;
	

	public void updateWallet(){
		List<Wallet> tmp=null;
		try {
			tmp = walletService.getAllWallets();
			if(tmp.size()==0){
				match(Geth.getAccounts());
			}else{
//				if(Geth.getAccounts().size()==tmp.size()){
//					return;
//				}
//				if(Geth.getAccounts().size()<tmp.size()){
//					return;
//				}
				if(Geth.getAccounts().size()>tmp.size()){
					ArrayList<String> newAccount=BaseData.getAccounts();
					
					//remove addresses which already exist;
					tmp.forEach(old->{
						newAccount.remove(old.getAddress());
					});
					
					//insert into db
					match(newAccount);
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void match(List<String> target) throws Exception {
		
		if(target==null){
			target=Geth.getAccounts();
		}else{
			
		}
		String keystore = GethProperties.path.getKeystore();
		File f = new File(keystore);

		for (String account : target) {
			for (String wallet : f.list()) {
				if (wallet.contains(account.subSequence(2, account.length()))) {
					insertWallet(account, wallet);
					break;
				}
			}
		}
	}

	public void match(String account) throws Exception {

		String keystore = GethProperties.path.getKeystore();
		File f = new File(keystore);

		for (String wallet : f.list()) {
			if (wallet.contains(account.subSequence(2, account.length()))) {
				insertWallet(account, wallet);
				break;
			}
		}
	}

	public void insertWallet(String address, String wallet) {
		Wallet tmp = new Wallet();
		tmp.setAddress(address);
		tmp.setFile_name(wallet);
		try {
			walletService.insertWallet(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * it will check whether the table about wallet is empty in db;
	 * if it is not empty,return size;
	 * @return boolean
	 * @throws Exception
	 */
	public int isEmpty() throws Exception {
		return walletService.getAllWallets().size();
	}

}
