<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="trans" scope="page" class="com.chinese.ToChinese"/>
<html>
  <title>����Ա�����޸�</title>
  <link href="../CSS/style.css" rel="stylesheet" type="text/css">
  <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
  <body bgcolor="#F2F2F2">
<%
    request.setCharacterEncoding("gb2312");//���ַ���ͳһ�����������ύ�е�������������
   //��ֹ�Ƿ��û��ƹ���¼ҳ�棬ֱ�ӽ���ϵͳ�ڲ�
   boolean isLog=false;
   try{
     //����û��Ƿ��¼����Ϣ
     isLog=((String)session.getAttribute("isLog")).equals("1");
     }catch(Exception e){}
   if(!isLog){
     out.println("<script language='javascript'>alert('����û�е�¼');"+
                  "parent.location.href='../login.html';</script>");
     }
%>
    <table width="100%" height="112"  border="0" cellpadding="0" cellspacing="0">
	<tr><td  height="34">
      <h2 style="filter:glow(color=#ccccff,strength=5);height:1pt" align="center">
<img src="../KCM/user.gif" width="569" height="70"></h2>
    </td></tr>
      <form name="form1" method="post" action="usermodify.jsp">
        <tr><td><div align="center">����Ա������
          <input type="text" name="username"
             value="<%=session.getAttribute("username")%>" readonly>
          <br>
          ԭ&nbsp;&nbsp;��&nbsp;&nbsp;�룺
          <input type="password" name="password">
          <br>
          ��&nbsp;&nbsp;��&nbsp;&nbsp;�룺
          <input type="password" name="newpw1">
          <br>
          ȷ�������룺
          <input type="password" name="newpw2">
          <br>
        </div></td></tr>
      </form>
        <tr><td>
          <div align="center">
            <input name="submit" type="button" class="btn_grey" value="ȷ���޸�" onClick="check()">
            <input type="reset" class="btn_grey" value="ȡ���޸�" onClick="reset()">          
          </div></td></tr>
    </table>
  </body>
</html>
<script language="javascript">
function check()
{
  if(form1.password.value==0){
    alert("����������");form1.password.focus();return;
  }
  if(form1.newpw1.value==0){
    alert("������������");form1.newpw1.focus();return;
  }
  if(form1.newpw2.value==0){
    alert("���ٴ�����������");form1.newpw2.focus();return;
  }
  if(form1.newpw1.value!=form1.newpw2.value){
    alert("�������������벻һ��,���������");
    form1.newpw1.value="";
    form1.newpw2.value="";
    form1.newpw1.focus();
    return;
  }
  form1.submit();
}
function reset()
{
  form1.reset();
}
</script> 






