<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>

<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="trans" scope="page" class="com.chinese.ToChinese"/>
<html>
   <title>操作员管理</title>
  <link href="../CSS/style.css" rel="stylesheet" type="text/css">
  <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
  <body bgcolor="#F2F2F2">
<%
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
      <h2 style="filter:glow(color=#ccccff,strength=5);height:1pt" align="center">        <img src="../KCM/user.gif" width="569" height="70"></h2>
    </td></tr>
      <form name="form1" method="post" action="updateUser.jsp">
        <tr><td><div align="center">操作员姓名：
          <input type="text" name="username">
          <br>
         	操作员ID&nbsp;：
          <input type="text" name="userid">
          <br>
        </div></td></tr>
      </form>
        <tr><td>
          <div align="center">
            <input name="submit" type="button" class="btn_grey" value="确认删除" onClick="check()">
            <input type="reset" class="btn_grey" value="重新填写" onClick="reset()">
            
          </div></td></tr>
    </table>
  </body>
</html>

<script language="javascript">
function check()
{
	if(form1.username.value==0){
    alert("请输入用户名");
    form1.username.focus();
    return;
  }
  if(form1.userid.value==0){
    alert("请输入ID号");
    form1.userid.focus();
    return;
  }
  form1.submit();
}
function reset()
{
  form1.reset();
}
</script>
