package com.info;

import com.dbcom.DBResult;

import java.sql.PreparedStatement;

public class RukuRegist
{
  private RukuBean ruku;
  DBResult rst=new DBResult();

  public void setRuku(RukuBean ruku){
    this.ruku=ruku;
  }

  public void regist() throws Exception{
	  
    String reg="insert into tb_ruku(ID,spid,spname,jc,cd,gg,bz,dw,dj,sl,je,gysname,rkdate,czy,jsr,jsfs) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try{
      PreparedStatement pstmt=rst.getPreparedStatement(reg);
      //创建一个预处理语句，然后设置他们的参数
      pstmt.setString(1,ruku.getID());
      pstmt.setString(2,ruku.getSpid());
      pstmt.setString(3,ruku.getSpname());
      pstmt.setString(4,ruku.getJc());
      pstmt.setString(5,ruku.getCd());
      pstmt.setString(6,ruku.getGg());
      pstmt.setString(7,ruku.getBz());
      pstmt.setString(8,ruku.getDw());
      pstmt.setString(9,ruku.getDj());
      pstmt.setFloat(10,ruku.getSl());
      pstmt.setString(11,ruku.getJe());
      pstmt.setString(12,ruku.getGysname());
      pstmt.setString(13,ruku.getRkdate());
      pstmt.setString(14,ruku.getCzy());
      pstmt.setString(15,ruku.getJsr());
      pstmt.setString(16,ruku.getJsfs());
      //执行更新操作
      pstmt.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
      throw e;
    }
  }
}

