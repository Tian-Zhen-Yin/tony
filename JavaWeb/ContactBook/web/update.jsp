<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/23/023
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var id=getUrlParam("id");

            $.getJSON("person", {"id": id, "method": "queryById"}, function(data){

                $("input[name=name]").val(data.name);
                $("input[name=sex]").val(data.sex);
                $("input[name=phone]").val(data.phone);
                $("input[name=address]").val(data.address);
            });

            $("input[type=button]:first").click(function(){
                $.ajax({
                    url: "person",
                    type: "post",
                    data: $("form").serialize()+"&method=updatePerson&id="+id,
                    dataType: "json",
                    success: function(data){
                        if(data){
                            alert("修改成功！");
                            window.location.href = "index.jsp";
                        }else{
                            alert("修改失败！");
                        }
                    }
                });
            });
        });
        function getUrlParam(key) {
            // 获取参数
            var url = window.location.search;
            // 正则筛选地址栏
            var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
            // 匹配目标参数
            var result = url.substr(1).match(reg);
            //返回参数值
            return result ? decodeURIComponent(result[2]) : null;
        }

    </script>
</head>
<body>
<form  method="post">
    <table border="1px">
        <tr>
            <td colspan="2"><h3>修改联系人信息</h3></td>
        </tr>
        <tr >
            <td>姓名</td>
            <td><input type="text" name="name" value="${person.name}"></td>

        </tr>
        <tr>
            <td >性别</td>
            <td><input type="text" name="sex" value="${person.sex}"></td>

        </tr>
        <tr>
            <td>电话</td>

            <td><input type="text" name="phone" value="${person.phone}"></td>

        </tr>

        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${person.address}"></td>

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
