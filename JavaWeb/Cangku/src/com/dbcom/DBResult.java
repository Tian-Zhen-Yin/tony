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
   * 用于获得执行SQL语句的ResultSet对象
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
   * 用于执行SQL语句没有返回值
   */
  public void doExecute(String sql){
    try{
      PreparedStatement pstmt=con.prepareStatement(sql);
      pstmt.executeUpdate();
    }catch(Exception e){}
  }
  /**
   * 用于获得执行SQL语句的PreparedStatement(预处理)对象
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
   * 关闭连接
   */
  public void closeCon(){
    try{
      this.con.close();
    }catch(Exception e){
        e.printStackTrace();
    }
  }
}
