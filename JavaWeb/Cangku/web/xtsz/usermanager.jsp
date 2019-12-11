<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="trans" scope="page" class="com.chinese.ToChinese"/>
<html>
  <title>操作员密码修改</title>
  <link href="../CSS/style.css" rel="stylesheet" type="text/css">
  <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
  <body bgcolor="#F2F2F2">
<%
    request.setCharacterEncoding("gb2312");//对字符串统一编码解决表单提交中的中文乱玛问题
   //防止非法用户绕过登录页面，直接进入系统内部
   boolean isLog=false;
   try{
     //获得用户是否登录的信息
     isLog=((String)session.getAttribute("isLog")).equals("1");
     }catch(Exception e){}
   if(!isLog){
     out.println("<script language='javascript'>alert('您还没有登录');"+
                  "parent.location.href='../login.html';</script>");
     }
%>
    <table width="100%" height="112"  border="0" cellpadding="0" cellspacing="0">
	<tr><td  height="34">
      <h2 style="filter:glow(color=#ccccff,strength=5);height:1pt" align="center">
<img src="../KCM/user.gif" width="569" height="70"></h2>
    </td></tr>
      <form name="form1" method="post" action="usermodify.jsp">
        <tr><td><div align="center">操作员姓名：
          <input type="text" name="username"
             value="<%=session.getAttribute("username")%>" readonly>
          <br>
          原&nbsp;&nbsp;密&nbsp;&nbsp;码：
          <input type="password" name="password">
          <br>
          新&nbsp;&nbsp;密&nbsp;&nbsp;码：
          <input type="password" name="newpw1">
          <br>
          确认新密码：
          <input type="password" name="newpw2">
          <br>
        </div></td></tr>
      </form>
        <tr><td>
          <div align="center">
            <input name="submit" type="button" class="btn_grey" value="确认修改" onClick="check()">
            <input type="reset" class="btn_grey" value="取消修改" onClick="reset()">          
          </div></td></tr>
    </table>
  </body>
</html>
<script language="javascript">
function check()
{
  if(form1.password.value==0){
    alert("请输入密码");form1.password.focus();return;
  }
  if(form1.newpw1.value==0){
    alert("请输入新密码");form1.newpw1.focus();return;
  }
  if(form1.newpw2.value==0){
    alert("请再次输入新密码");form1.newpw2.focus();return;
  }
  if(form1.newpw1.value!=form1.newpw2.value){
    alert("两次新密码输入不一致,请从新输入");
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







