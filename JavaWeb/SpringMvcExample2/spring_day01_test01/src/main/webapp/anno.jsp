<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/26/026
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用注解--%>
<a href="anno/tessRequestParam?name=欧文">RequestParam注解</a>
<br/>
<form action="anno/testRequestBody" method="post">

    用户姓名:<input type="text" name="uname"><br/>
    用户年龄:<input type="text" name="age"><br/>
    <input type="submit" value="提交">
</form>
<br/>
<a href="anno/testRequestHeader">RequestHeader</a>
<br/>
<!-- CookieValue 注解 -->
<a href="anno/testCookieValue">绑定 cookie 的值</a>
<br/>
<form action="anno/testModelAttribute" method="post">

用户姓名:<input type="text" name="uname"><br/>
用户年龄:<input type="text" name="age"><br/>
<input type="submit" value="提交">
    <br/>
    <a href="anno/testSessionAttribute">存入</a>
    <br/>
    <a href="anno/getSessionAttribute">取出</a>
    <br/>
    <a href="anno/deleteSessionAttribute">删除</a>
    <br/>
</form>
</body>
</html>
