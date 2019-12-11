<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/22/022
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("input[type=button]:first").click(function () {
                $.ajax({
                    url:"person",
                    type:"post",
                    data:$("form").serialize()+"&method=addPerson",
                    dataType:"json",
                    success:function (data) {
                      if(data){
                          alert("增加成功");
                          window.location.href="index.jsp"
                      }else{
                          alert("增加失败");
                      }
                    }
                })
            })
        })
    </script>
</head>
<body>
<form  method="post">
    <table border="1px">
        <tr>
            <td colspan="2"><h3>增加联系人</h3></td>
        </tr>
        <tr >
            <td>姓名</td>
            <td><input type="text" name="name"></td>

        </tr>
        <tr >
            <td >性别</td>
            <td><input type="text" name="sex"></td>

        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone"></td>

        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"></td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="提交"/>
                <input type="button" value="返回" onclick="window.history.back()"/>
            </td>

        </tr>
    </table>
</form>
</body>
</html>
