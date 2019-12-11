package com.dbcom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static synchronized Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/cangku";
		String userName = "root";
		String password = "root";
		Connection conn = null;
		try {
			System.out.println("加载驱动之前");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			System.err.print("驱动加载失败");
		}
		try {
			System.out.println("连接数据库之前");
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		}
		return conn;
	}
}
