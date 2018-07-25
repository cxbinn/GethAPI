package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test_psql_connection {
	private static final String URL = "jdbc:postgresql://10.134.159.156:5432/flashcat"; //JDBC连接URL
	private static final String USR = "postgres"; //用户名
	private static final String PWD = "postgres"; //密码
	
	static {
		try {
			//加载驱动
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载出错！");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL , USR , PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
		return con;
	}
	public static void main(String[] args) {
		Connection con = null;
		 
		try {
			con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from u_user");
			//PreparedStatement pstmt = con.prepareStatement("insert into u_user(serial,name,password,email,tel,code) values('aa','myname','pw','e@email.com','123453156315','F3262695')");
			ResultSet rs = pstmt.executeQuery();
			//pstmt.execute();
			while (rs.next()) {
				System.out.println("total:" + rs.getString("serial"));
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
