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
			System.out.println("��������֮ǰ");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
		} catch (ClassNotFoundException e) {
			System.err.print("��������ʧ��");
		}
		try {
			System.out.println("�������ݿ�֮ǰ");
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
		}
		return conn;
	}
}
