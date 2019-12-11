package com.info;

import com.dbcom.DBResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhRegist
{
  private KhinfoBean khinfo;
  DBResult rst=new DBResult();

  public void setKhinfo(KhinfoBean khinfo){
    this.khinfo=khinfo;
  }

  public void regist() throws Exception{
	  ResultSet rs = rst.getResult("select max(ID) from tb_customer");
	  int cid = 2001;//默认是2001
	  if(rs.next()){
		  cid = rs.getInt(1) + 1;
	  }
    String reg="insert into tb_customer(khname,khjc,address,postcode,tel,fax,lxr,lxrtel,Email,khyh,yhzh,ID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try{
      PreparedStatement pstmt=rst.getPreparedStatement(reg);
      //创建一个预处理语句，然后设置他们的参数
      pstmt.setString(1,khinfo.getKhname());
      pstmt.setString(2,khinfo.getKhjc());
      pstmt.setString(3,khinfo.getAddress());
      pstmt.setString(4,khinfo.getPostcode());
      pstmt.setString(5,khinfo.getTel());
      pstmt.setString(6,khinfo.getFax());
      pstmt.setString(7,khinfo.getLxr());
      pstmt.setString(8,khinfo.getLxrtel());
      pstmt.setString(9,khinfo.getEmail());
      pstmt.setString(10,khinfo.getKhyh());
      pstmt.setString(11,khinfo.getYhzh());
      pstmt.setInt(12,cid);
      //执行更新操作
      pstmt.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
      throw e;
    }
  }
}

