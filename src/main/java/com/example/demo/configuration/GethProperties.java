package com.example.demo.configuration;


import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "geth")
@PropertySource("classpath:geth.properties")
public class GethProperties {
	public static String SERVER;
	public static String KeyStorePath;
	public static String MasterWallet;
	public static String MasterAddress;
	public static String MasterPassword;
	@NotNull
	public static Path path;
	
	
	public static class Path{
		private static String java;
		private static  String solc;
		private static String keystore;
		private static String abi;
		private static String solc_package;
		private static String parent;
		public String getJava() {
			return java;
		}
		public void setJava(String java) {
			this.java = java;
		}
		public String getSolc() {
			return solc;
		}
		public void setSolc(String solc) {
			this.solc = solc;
		}
		public String getKeystore() {
			return keystore;
		}
		public void setKeystore(String keystore) {
			this.keystore = keystore;
		}
		public String getAbi() {
			return abi;
		}
		public void setAbi(String abi) {
			this.abi = abi;
		}
		public String getSolc_package() {
			return solc_package;
		}
		public void setSolc_package(String solc_package) {
			this.solc_package = solc_package;
		}
		public static String getParent() {
			return parent;
		}
		public static void setParent(String parent) {
			Path.parent = parent;
		}
		
		
		
	}

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

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		GethProperties.path = path;
	}
	

}
