<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<html>
<title>��Ʒ�۸����</title>
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<body bgcolor="#F2F2F2">
<%
   request.setCharacterEncoding("gb2312");//���ַ���ͳһ���������ύ�е�������������
   String spbh="";
   String cd="";
   String spname="";
   String jc="";
   String gg="";
   String bz="";
   String sl="";
   String je="";
   String dj="";
   String jgspname=request.getParameter("jgspname");
   String strSql="select * from tb_kucun ";
   String strSpname="select * from tb_kucun where spname='"+jgspname+"'";
   ResultSet rs=rst.getResult(strSql);
   ResultSet rsSpname=rst.getResult(strSpname);
   if(rsSpname.next()){
     spbh=rsSpname.getString("id"); 
     cd=rsSpname.getString("cd");
     jc=rsSpname.getString("jc");   
     gg=rsSpname.getString("gg");
     bz=rsSpname.getString("bz");   
     sl=rsSpname.getString("kcsl");
     je=rsSpname.getString("kcje");   
     dj=rsSpname.getString("dj");
     spname=rsSpname.getString("spname");
   }
%>
<img src="../KCM/modifyprice.gif" width="565" height="70">
<table width="550" cellspacing="1" cellpadding="1">
 <form action="modifyPrice1.jsp" method="post" name="form1">
  <tr>
    <td>&nbsp;</td>
    <td><select name="jgspname" onchange="spChange()">
      <option selected>��ѡ������۸����Ʒ����:</option>
      <%while(rs.next()){%>
      <option value=<%=rs.getString("spname")%>><%=rs.getString("spname")%></option>
      <%}%>
    </select></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="54">&nbsp;</td>
    <td width="228">��Ʒ���:
      <input type="hidden" name="spbh" value="<%=spbh%>"><%=spbh%></td>
    <td width="256">�� &nbsp;&nbsp;&nbsp;��:
      <input type="hidden" name="cd" value="<%=cd%>"> <%=cd%></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>��Ʒ����:
      <input type="hidden" name="spname" value="<%=spname%>"><%=spname%></td>
    <td>�� &nbsp;&nbsp;&nbsp;��:
      <input type="hidden" name="jc" value="<%=jc%>"><%=jc%></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>�� &nbsp;&nbsp;&nbsp;��:
      <input type="hidden" name="gg" value="<%=gg%>"><%=gg%></td>
    <td>�� &nbsp;&nbsp;&nbsp;װ:
      <input type="hidden" name="bz" value="<%=bz%>"><%=bz%></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>�������:
      <input name="kcsl" type="hidden" size="15" value="<%=sl%>" readonly><%=sl%></td>
    <td>�����:
      <input type="text" name="kcje" size="15" value="<%=je%>"readonly></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>�� &nbsp;&nbsp;&nbsp;��:
      <input type="text" name="dj" size="15" onblur="autoje()"></td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><div align="center">
      <input name="Submit1" type="button" id="Submit13" value="ȷ��" onclick="check()">
    </div></td>
    <td><input type="reset" name="Submit2" value="ȡ��"></td>
    </tr>
  </form>
</table>
<form name="form2" action="modifyPrice.jsp" method="POST">
  <input type="hidden" name="hid">
  <input type="hidden" name="hkcje">
  <input type="hidden" name="hdj">
</form>
<body>
<html>
<script language="JavaScript">
  function spChange(){
    form1.submit();
  }
  function autoje(){
    if(isNaN(form1.dj.value)){
      alert("����������");form1.dj.value=0;form1.dj.focus();return}
    form1.kcje.value=form1.dj.value*form1.kcsl.value;
  }
  function check(){
    form2.hid.value=form1.spbh.value;
    form2.hkcje.value=form1.kcje.value;
    form2.hdj.value=form1.dj.value;    
	if(form1.dj.value==0){
      alert("�����뵥��!");form1.dj.focus();return}
    form2.submit();
  }
</script>

