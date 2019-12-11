package com.info;



import com.dbcom.DBResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GysRegist
{
  private GysinfoBean gysinfo;
  DBResult dbr=new DBResult();
  public void setGysinfo(GysinfoBean gysinfo)
  {
    this.gysinfo=gysinfo;
  }
  public void regist()throws Exception
  {
	  String sql = null;
	  int id = 1201; //Ĭ����1201
	  try{
	  sql = "select max(ID) from tab_supplier";
		ResultSet rs = dbr.getResult(sql);		
		if(rs.next()) {
			id = rs.getInt(1)+1;
		}
		rs.close();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
    sql="insert into tab_supplier(gysname,jc,address,postcode,tel,fax,lxr,lxrtel,khyh,email,ID) value(?,?,?,?,?,?,?,?,?,?,?)";
    try
    {
      PreparedStatement pstmt=dbr.getPreparedStatement(sql);
      pstmt.setString(1,gysinfo.getGysname());
      pstmt.setString(2,gysinfo.getJc());
      pstmt.setString(3,gysinfo.getAddress());
      pstmt.setString(4,gysinfo.getPostcode());
      pstmt.setString(5,gysinfo.getTel());
      pstmt.setString(6,gysinfo.getFax());
      pstmt.setString(7,gysinfo.getLxr());
      pstmt.setString(8,gysinfo.getLxrtel());
      pstmt.setString(9,gysinfo.getKhyh());
      pstmt.setString(10,gysinfo.getEamil());
      pstmt.setInt(11,id);
      pstmt.executeUpdate();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      throw e;
    }
  }
}
