package com.info;

import com.dbcom.DBResult;

import java.sql.PreparedStatement;

public class KucunRegist
{
  private KucunBean kucun;
  DBResult rst=new DBResult();

  public void setKucun(KucunBean kucun){
    this.kucun=kucun;
  }

  public void add(float kcsl) throws Exception{
	  try{
		  String sql="update tb_kucun set kcsl="+kcsl+kucun.getKcsl()+",dj="+kucun.getDj()+","+"kcje='"+kucun.getKcje()+"' where id="+"'"+kucun.getID()+"'";
		  PreparedStatement pstmt=rst.getPreparedStatement(sql);
		  pstmt.executeUpdate();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  public void delete(float kcsl) {
	  try {
		  int d = Integer.parseInt(kucun.getDj());
		  float k = kcsl-kucun.getKcsl();
		  float f = k*d;
		  String sql = null;
		  if(k>0){
			  sql="update tb_kucun set kcsl="+(kcsl-kucun.getKcsl())+",dj="+kucun.getDj()+","+"kcje='"+f+" where id='"+kucun.getID()+"'";
		  }else {
			  sql = "delete from tb_kucun where id='"+kucun.getID()+"'";
		  }
		  PreparedStatement pstmt=rst.getPreparedStatement(sql);
		  pstmt.executeUpdate();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
      
  }
  
  public void regist() throws Exception{
	  
    String sql = "insert into tb_kucun(ID,spname,jc,cd,gg,bz,dw,dj,kcsl,kcje) value(?,?,?,?,?,?,?,?,?,?)";
    try{
      PreparedStatement pstmt=rst.getPreparedStatement(sql);
      //创建一个预处理语句，然后设置他们的参数
      pstmt.setString(1,kucun.getID());
      pstmt.setString(2,kucun.getSpname());
      pstmt.setString(3,kucun.getJc());
      pstmt.setString(4,kucun.getCd());
      pstmt.setString(5,kucun.getGg());
      pstmt.setString(6,kucun.getBz());
      pstmt.setString(7,kucun.getDw());
      pstmt.setString(8,kucun.getDj());
      pstmt.setFloat(9,kucun.getKcsl());
      pstmt.setString(10,kucun.getKcje());
      //执行更新操作
      pstmt.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
      throw e;
    }
  }
}

