package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "geth")
@PropertySource("classpath:geth.properties")
public class gethProperties {
	/*
	 * server:127.0.0.1 port:3333
	 * keystorePath:/home/ms/go-ethereum/build/bin/data_demo2/keystore
	 * masterWallet:UTC--2018-06-05T11-10-38.729572359Z--
	 * aef3ac241a8172bcd613fa05980f41e3271fe774
	 * masterAddress:0xaef3ac241a8172bcd613fa05980f41e3271fe774 masterPassword:
	 */
	public static String SERVER;
	public static String KeyStorePath;
	public static String MasterWallet;
	public static String MasterAddress;
	public static String MasterPassword;

	public static String getSERVER() {
		return SERVER;
	}

	public void setSERVER(String sERVER) {
		SERVER = sERVER;
	}

	public String getKeyStorePath() {
		return KeyStorePath;
	}

	public void setKeyStorePath(String keyStorePath) {
		KeyStorePath = keyStorePath;
	}

	public String getMasterWallet() {
		return MasterWallet;
	}

	public void setMasterWallet(String masterWallet) {
		MasterWallet = masterWallet;
	}

	public String getMasterAddress() {
		return MasterAddress;
	}

	public void setMasterAddress(String masterAddress) {
		MasterAddress = masterAddress;
	}

	public String getMasterPassword() {
		return MasterPassword;
	}

	public void setMasterPassword(String masterPassword) {
		MasterPassword = masterPassword;
	}

}
