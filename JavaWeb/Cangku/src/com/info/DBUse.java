package com.info;

import com.dbcom.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUse {

	// �õ�ȫ���ļ�¼��
	public int getAllCount(String table) {
		int count = 0;
		try {
			String sql = "select count(*) from "+table;
			ResultSet rs = new DBResult().getResult(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	// �õ�ģ����ѯ�ļ�¼��
	public int getByLikeCount(String table,String key,String name,int id) {
		int count = 0;
		String sql = "select count(*) from "+table+" where "+name+" like %"+key+"% or "+id+" like %"+key+"%";
		try {
			ResultSet rs = new DBResult().getResult(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	// �õ�ȫ���ļ�¼
	public List queryAll(String table,int currentPage,int lineSize) {
		List all = new ArrayList() ;
		String sql = "SELECT * FROM "+table+" limit "+(currentPage-1)*lineSize+","+lineSize ;
		try {
			ResultSet rs = new DBResult().getResult(sql);
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}
	// ģ����ѯ��¼
	/*public List queryByLike(String cond,int currentPage,int lineSize) {
		String sql = "select * from "+table+" where "+name+" like %"+key+"% or "+id+" like %"+key+"%";
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	

	
	public static void main(String[] args) {
		String user = "tuzhirong";
		System.out.println(user.equals("tuzhirong"));
	}
}
