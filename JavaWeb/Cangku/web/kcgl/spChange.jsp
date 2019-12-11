<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.sql.*,java.io.*,java.util.*,java.text.*"%>
<%@ page import="com.dbconn.DBResult"%>
<jsp:useBean id="dbr" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="calendar" scope="page" class="com.showtime.CalendarBean"/>
<jsp:useBean id="rukubean" scope="page" class="com.info.RukuBean"/>
<jsp:useBean id="regist" scope="page" class="com.info.RukuRegist"/>
<jsp:useBean id="kucunbean" scope="page" class="com.info.KucunBean"/>
<jsp:useBean id="kcregist" scope="page" class="com.info.KucunRegist"/>

<%
try{
   request.setCharacterEncoding("gb2312");//解决表单提交中的中文乱码问题
   //获取表单数据
   String jc=(String)session.getAttribute("jc"); 
   String spname=(String)session.getAttribute("spname");
   String gg=(String)session.getAttribute("gg"); 
   String rkid=(String)session.getAttribute("rkbh");
   String bz=(String)session.getAttribute("bz"); 
   String gysname=(String)session.getAttribute("gysname");
   String cd=(String)session.getAttribute("cd"); 
   String spid=(String)session.getAttribute("spid");
   String dw=(String)session.getAttribute("dw");
   int sl=Integer.parseInt(request.getParameter("sl")); 
   String czy=(String)request.getParameter("czy");
   String je=request.getParameter("je"); 
   String jsr=(String)request.getParameter("jsr");
   String dj= request.getParameter("dj"); 
   String rkdate=calendar.getDate();
   String yf=(String)request.getParameter("yf"); 
   String jsfs=(String)request.getParameter("jsfs");
   String sf=(String)request.getParameter("sf"); 
   String wf=(String)request.getParameter("wf");
   String whether="";
   if(wf.equals("0")){//记录商品入库时是否有未付款
     whether="是";
     }else{
       whether="否";
     }
   //保存入库信息
rukubean.setID(rkid);		
rukubean.setSpid(spid); 	
rukubean.setSpname(spname); 	
rukubean.setJc(jc); 		
rukubean.setCd(cd);		
rukubean.setGg(gg); 		
rukubean.setBz(bz); 		
rukubean.setDw(dw); 		
rukubean.setDj(dj);		
rukubean.setSl(sl);		
rukubean.setJe(je);		
rukubean.setGysname(gysname); 		
rukubean.setRkdate(rkdate);		
rukubean.setCzy(czy); 		
rukubean.setJsr(jsr); 		
rukubean.setJsfs(jsfs); 

regist.setRuku(rukubean);
regist.regist();
		


kucunbean.setID(spid);
kucunbean.setSpname(spname); 
kucunbean.setJc(jc); 
kucunbean.setCd(cd); 
kucunbean.setGg(gg); 
kucunbean.setBz(bz); 
kucunbean.setDw(dw); 
kucunbean.setDj(dj); 
kucunbean.setKcsl(sl); 
kucunbean.setKcje(je); 
	


   //保存或修改库存信息
   String rkkcSelect="select * from tb_kucun where id='"+spid+"'";
   ResultSet rkkc=dbr.getResult(rkkcSelect);
   kcregist.setKucun(kucunbean);
   
   //判断库存中是否有该商品，如果有则修改库存信息，否则插入库存记录。
   if(rkkc.next()){
   float kcsl = rkkc.getFloat("kcsl");
   int n = Integer.parseInt(dj); 
   float kcje = (kcsl+sl)*n;
   kcregist.add(kcsl);
   }else{  
     kcregist.regist();
   }
    out.println("<script language='javascript'>alert('商品入库添加成功');"+
                "window.location.href='sprk.jsp';</script>");
   }catch(Exception e) {
   	e.printStackTrace();
   }
%>
