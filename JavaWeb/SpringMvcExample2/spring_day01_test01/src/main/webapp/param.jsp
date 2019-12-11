<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/26/026
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%-- <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        金额：<input type="text" name="money"/><br/>
        <input type="submit" value="提交">
    </form>--%>
   <%--把数据封装到Account中，类中存在list和map集合--%>
   <form action="param/saveAccount" method="post">
       姓名：<input type="text" name="username"/><br/>
       密码：<input type="text" name="password"/><br/>
       金额：<input type="text" name="money"/><br/>

       用户姓名:<input type="text" name="list[0].uname"><br/>
       用户年靓:<input type="text" name="list[0].age"><br/>

       用户姓名:<input type="text" name="map['one'].uname"><br/>
       用户年靓:<input type="text" name="map['one'].age"><br/>
       <input type="submit" value="提交">
   </form>

   <form action="param/saveUser" method="post">

       用户姓名:<input type="text" name="luname"><br/>
       用户年龄:<input type="text" name="age"><br/>
       用户生日:<input type="text" name="date">
       <input type="submit" value="提交">
   </form>
</body>
</html>
