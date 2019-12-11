package com.dbcom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBResult
{
  private Connection con;
  public Connection getCon() {
	return con;
}
public void setCon(Connection con) {
	this.con = con;
}
public  DBResult(){
    try {
		this.con=new DBConn().getConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  /**
   * ���ڻ��ִ��SQL����ResultSet����
   */
  public ResultSet getResult(String sql){
    try{
    	PreparedStatement stmt=con.prepareStatement(sql);
      ResultSet rs=stmt.executeQuery(sql);
      return rs;
    }
    catch(Exception e){}
    return null;
  }
  /**
   * ����ִ��SQL���û�з���ֵ
   */
  public void doExecute(String sql){
    try{
      PreparedStatement pstmt=con.prepareStatement(sql);
      pstmt.executeUpdate();
    }catch(Exception e){}
  }
  /**
   * ���ڻ��ִ��SQL����PreparedStatement(Ԥ����)����
   */
  public PreparedStatement getPreparedStatement(String sql){
    try{
      PreparedStatement pstmt=con.prepareStatement(sql);
      return pstmt;
    }
    catch(Exception e){}
    return null;
  }
  /**
   * �ر�����
   */
  public void closeCon(){
    try{
      this.con.close();
    }catch(Exception e){
        e.printStackTrace();
    }
  }
}
