<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.sql.*,java.io.*"%>
<%@ page import="com.dbconn.DBResult"%>
<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="calendar" scope="page" class="com.showtime.CalendarBean"/>
<jsp:useBean id="chukubean" scope="page" class="com.info.ChukuBean"/>
<jsp:useBean id="regist" scope="page" class="com.info.ChukuRegist"/>
<jsp:useBean id="kucunbean" scope="page" class="com.info.KucunBean"/>
<jsp:useBean id="kcregist" scope="page" class="com.info.KucunRegist"/>

<%
try{
   request.setCharacterEncoding("gb2312");//������ύ�е�������������
   //��ȡ������
   String jc=(String)session.getAttribute("jc"); 
   String spname=(String)session.getAttribute("spname");
   String gg=(String)session.getAttribute("gg"); 
   String ckid=(String)session.getAttribute("ckbh");
   String bz=(String)session.getAttribute("bz"); 
   String gysname=(String)session.getAttribute("gysname");
   String cd=(String)session.getAttribute("cd"); 
   String spid=(String)session.getAttribute("spid");
   String dw=(String)session.getAttribute("dw");
   int sl=Integer.parseInt(request.getParameter("sl")); 
   String czy=(String)request.getParameter("czy");
   String je=request.getParameter("je"); 
   String jsr=(String)request.getParameter("jsr");
   String dj=request.getParameter("dj"); 
   String thdate=(String)request.getParameter("rkdate");
   String yf=(String)request.getParameter("yf"); 
   String jsfs=(String)request.getParameter("jsfs");
   String sf=(String)request.getParameter("sf"); 
   String wf=(String)request.getParameter("wf");
   String whether="";
   if(wf.equals("0")){//��¼��Ʒ���ʱ�Ƿ���δ����
     whether="��";
     }else{
       whether="��";
     }
   //��������˻���Ϣ
chukubean.setID(ckid);		
chukubean.setSpid(spid); 	
chukubean.setSpname(spname); 	
chukubean.setJc(jc); 		
chukubean.setCd(cd);		
chukubean.setGg(gg); 		
chukubean.setBz(bz); 		
chukubean.setDw(dw); 		
chukubean.setDj(dj);		
chukubean.setSl(sl);		
chukubean.setJe(je);		
chukubean.setGysname(gysname); 		
chukubean.setThdate(thdate);		
chukubean.setCzy(czy); 		
chukubean.setJsr(jsr); 		
chukubean.setJsfs(jsfs); 

   
   //������޸Ŀ����Ϣ
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

   String rkkcSelect="select * from tb_kucun where id='"+spid+"'";
   ResultSet rkkc=rst.getResult(rkkcSelect);
   String rkkcSql="";
   //�жϿ�����Ƿ��и���Ʒ����������޸Ŀ����Ϣ��������ʾ������Ϣ
   if(rkkc.next()){
     	kcregist.setKucun(kucunbean);
     	kcregist.regist();
     	
        //��¼�˿���Ϣ
        regist.setChuku(chukubean);
		regist.regist();
   }else{
     out.println("<script language='javascript'>alert('�����û�и���Ʒ�����˻�');"+
     "window.location.href='spck.jsp';</script>");
   }
   rst.getResult(rkkcSql);
    out.println("<script language='javascript'>alert('��Ʒ����˻��ɹ�');"+
                "window.location.href='spck.jsp';</script>");
}catch(Exception e) {
	e.printStackTrace();
}
%>
