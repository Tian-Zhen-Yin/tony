<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/27/027
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>字符串返回</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
           $(function () {
               $("#testJson").click(function(){
                   console.log("123");
               $.ajax({
                       type:"post",
                       url:"jsonController/testResponseJson",
                       contentType:"application/json;charset=utf-8",
                       data:'{"username":"hello","money":"22"}',
                       dataType:"json",
                       success:function(data){
                           alert(data);
                           alert(data.username);
                           alert(data.money);
                           alert(data.password)
                       }
                   });

               });
           });
    </script>
</head>
<body>
<a href="string/testString">字符串测试</a>
<br/>
<a href="string/testVoid">方法返回</a>
<br/>
<a href="string/testModelAndView">返回ModelAndView</a>
<br/>
<input type="button" value="测试 ajax 请求 json 和响应 json" id="testJson"/>
</body>
</html>
