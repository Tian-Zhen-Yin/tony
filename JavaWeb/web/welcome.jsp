<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/8/008
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    <%
        String name=request.getParameter("userid");
    %>你好：<%=name%>！
</body>
</html>
