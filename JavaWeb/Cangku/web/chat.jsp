<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>企业进销存页面框架</title>
</head>
<frameset rows="*" cols="*,776,*" framespacing="1" frameborder="no" border="1" >
  <frame src="blank.jsp" name="blankFrame" scrolling="NO" noresize>
	<frameset rows="179,*" cols="*" frameborder="NO" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="NO" noresize>
		<frameset rows="*" cols="231,*" framespacing="0" frameborder="NO" border="0">
  		<frame src="left.jsp" name="leftFrame" frameborder="no" scrolling="AUTO" noresize>
		<frame src="main.jsp" name="mainFrame" frameborder="no" scrolling="AUTO" noresize marginwidth="0" marginheight="0" bordercolor="#CCCCCC">
		 </frameset>
	</frameset>
  <frame src="blank.jsp" name="blankFrame">	
</frameset>	
<noframes>
<body>
</body></noframes>
</html>
