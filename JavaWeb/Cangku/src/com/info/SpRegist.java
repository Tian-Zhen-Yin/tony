package com.info;

import com.dbcom.DBResult;

import com.showtime.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class SpRegist
{
  private SpinfoBean spinfo;
  DBResult dbr=new DBResult();
  ShowTime showtime = new ShowTime();

  public void setSpinfo(SpinfoBean spinfo)
  {
    this.spinfo=spinfo;
  }

  public void regist() throws Exception
  {
	  String pzwh="sp"+showtime.getDateString()+new Random().nextInt(999);
	String str = "select max(id) from tb_brand";
	int bid = 1001;
	ResultSet rs = dbr.getResult(str);
	if(rs.next()){
		bid = rs.getInt(1) + 1;
	}
    String sql="insert into tb_brand(ID,spname,jc,cd,dw,gg,bz,ph,pzwh,gysname,memo) values(?,?,?,?,?,?,?,?,?,?,?)"; 
    try
    {
      PreparedStatement pstmt = dbr.getPreparedStatement(sql);
      pstmt.setInt(1,bid);
      pstmt.setString(2, spinfo.getSpname());
      pstmt.setString(3, spinfo.getJc());
      pstmt.setString(4, spinfo.getCd());
      pstmt.setString(5, spinfo.getDw());
      pstmt.setString(6, spinfo.getGg());
      pstmt.setString(7, spinfo.getBz());
      pstmt.setString(8, spinfo.getPh());
      pstmt.setString(9,pzwh);
      pstmt.setString(10, spinfo.getGysname());
      pstmt.setString(11, spinfo.getMemo());
      pstmt.executeUpdate();
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
