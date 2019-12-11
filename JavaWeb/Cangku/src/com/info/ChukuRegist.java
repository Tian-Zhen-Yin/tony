package com.info;

import com.dbcom.DBResult;

import java.sql.PreparedStatement;

public class ChukuRegist
{
  private ChukuBean chuku;
  DBResult rst=new DBResult();

  public void setChuku(ChukuBean chuku){
    this.chuku = chuku;
  }

  public void regist() throws Exception{
	  
    String reg="insert into tab_rukuth(ID,spid,spname,jc,cd,gg,bz,dw,dj,sl,je,gysname,thdate,czy,jsr,jsfs) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try{
      PreparedStatement pstmt=rst.getPreparedStatement(reg);
      //创建一个预处理语句，然后设置他们的参数
      pstmt.setString(1,chuku.getID());
      pstmt.setString(2,chuku.getSpid());
      pstmt.setString(3,chuku.getSpname());
      pstmt.setString(4,chuku.getJc());
      pstmt.setString(5,chuku.getCd());
      pstmt.setString(6,chuku.getGg());
      pstmt.setString(7,chuku.getBz());
      pstmt.setString(8,chuku.getDw());
      pstmt.setString(9,chuku.getDj());
      pstmt.setFloat(10,chuku.getSl());
      pstmt.setString(11,chuku.getJe());
      pstmt.setString(12,chuku.getGysname());
      pstmt.setString(13,chuku.getThdate());
      pstmt.setString(14,chuku.getCzy());
      pstmt.setString(15,chuku.getJsr());
      pstmt.setString(16,chuku.getJsfs());
      //执行更新操作
      pstmt.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
      throw e;
    }
  }
}

