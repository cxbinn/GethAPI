package com.example.demo.GethUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.example.demo.configuration.gethProperties;

public class initDB {
	private static final String URL = "jdbc:postgresql://10.134.159.156:5432/geth"; // JDBC连接URL
	private static final String USR = "postgres"; // 用户名
	private static final String PWD = "postgres"; // 密码
	private Connection con = null;
	private PreparedStatement pstmt = null;

	static {
		try {
			// 加载驱动
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载出错！");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USR, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;

		return con;
	}

	public initDB() {

	}

	public void test_getinfo() throws IOException, SQLException {
		HashMap<String, String> relation = new HashMap<String, String>();

		final String keystore = gethProperties.KeyStorePath;
		System.out.println(keystore);
		File f = new File(keystore);
		
		for (String account : Geth.getAccounts()) {
			for (String wallet : f.list()) {
				if (wallet.contains(account.subSequence(2, account.length()))) {
					relation.put(account, wallet);
					break;
				}
			}
		}
		
		con = getConnection();
		insertWallet_List(relation);
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();

	}

	public static void main(String[] args) throws IOException {
		final String keystore = gethProperties.KeyStorePath;
		System.out.println(keystore);
		File f = new File(keystore);

		System.out.println(Geth.getAccounts());

		for (String a : f.list())
			System.out.println(a);

		// Connection con = null;
		//
		// try {
		// con = getConnection();
		//
		// PreparedStatement pstmt =
		// con.prepareStatement("select * from u_user");
		// //PreparedStatement pstmt =
		// con.prepareStatement("insert into u_user(serial,name,password,email,tel,code) values('aa','myname','pw','e@email.com','123453156315','F3262695')");
		// ResultSet rs = pstmt.executeQuery();
		// //pstmt.execute();
		// while (rs.next()) {
		// System.out.println("total:" + rs.getString("serial"));
		// }
		//
		// rs.close();
		// pstmt.close();
		// con.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}

	public void insertWallet(String address, String wallet) {
		String sql="insert into wallet(address,wallet) values('"
				+ address + "','" + wallet + "')";
		System.out.println(sql);
		try {
			pstmt = con
					.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void insertWallet_List(HashMap<String, String> data) {
		data.keySet().forEach(
				address -> insertWallet(address, data.get(address)));
	}

}
