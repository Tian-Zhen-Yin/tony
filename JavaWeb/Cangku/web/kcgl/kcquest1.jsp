<%@ page contentType="text/html;charset=gb2312"%>
<html>
  <title>库存信息查询</title>
  <link href="../CSS/style.css" rel="stylesheet" type="text/css">
  <style type="text/css">
<!--
.style2{color: #333333}
-->
  </style>
<body>
<%
	// 进行乱码处理
	request.setCharacterEncoding("GB2312") ;
%>
<%
	// 页面连接路径
	String jspUrl = null ;
	// 定义如下分页变量
	// 1、定义没页要显示的记录数，默认是10条每页
	int lineSize = 10 ;
	// 2、定义一个当前是第几页
	int currentPage = 1 ;
	// 计算出总页数
	int pageSize = 0 ;
	// 总记录数 / 每页显示的记录数
	int allRecorders = 0 ;
	// 加入查询关键字变量
	String keyWord = null ;
	// 加入一个检索标记
	String searchFlag = "F" ;
%>
<%
	// 需要从外面接收以下参数
	// 当前页、每页显示的记录数、总记录数、查询关键字、连接地址
	jspUrl = request.getParameter("jspUrl") ;
	keyWord = request.getParameter("keyWord") ;
	searchFlag = request.getParameter("searchFlag") ;
	try
	{
		lineSize = Integer.parseInt(request.getParameter("lineSize")) ;
		currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
		allRecorders = Integer.parseInt(request.getParameter("allRecorders")) ;
	}
	catch(Exception e)
	{}
%>
<%
	// 计算总页数
	pageSize = (allRecorders+lineSize-1)/lineSize ;
%>
<script language="javaScript">
	function openPage(curpage)
	{
		document.spage.cp.value = curpage ;
		// alert(cupage) ;
		document.spage.submit() ;
	}
	function selOpenPage()
	{
		document.spage.cp.value = document.spage.selpage.value ;
		document.spage.submit() ;
	}
</script>
  <table width="590" border="0" cellspacing="-2" cellpadding="-2">
    <tr height="6"><td>
        </td>
    </tr>
	 <tr bgcolor="#FFB13E">
        <td height="25" colspan="6" class="style2">
          &nbsp;当前位置：库存管理> 库存查询 &gt;&gt;&gt;</td>
     </tr>
    <tr><td valign="top" height="83">
      <table width="590" border="0" cellspacing="-2" cellpadding="-2">
        <tr><td width="590" height="43" align="Top">
          <form name="spage" action="<%=jspUrl%>">
<%
	if("T".equals(searchFlag))
	{
%>
	输入查询关键字：<input type="text" name="kw" value="<%=keyWord.equals("null")?"":keyWord%>">
	<input type="submit" value="查询">
	<br>
	<br>
<%
	}
%>
<%
	if(allRecorders>0)
	{
%>	
	<input type="button" value="首页" onClick="openPage(1)" <%=currentPage==1?"disabled":""%>>
	<input type="button" value="上一页" onClick="openPage(<%=currentPage-1%>)" <%=currentPage==1?"disabled":""%>>
	<input type="button" value="下一页" onClick="openPage(<%=currentPage+1%>)" <%=currentPage==pageSize?"disabled":""%>>
	<input type="button" value="尾页" onClick="openPage(<%=pageSize%>)" <%=currentPage==pageSize?"disabled":""%>>
	<input type="hidden" name="cp" value="">
	<font color="red" size="5"><%=currentPage%></font>
	/
	<font color="red" size="5"><%=pageSize%></font>
	跳转到
		<select name="selpage" onChange="selOpenPage()">
		<%
			for(int x=1;x<=pageSize;x++)
			{
		%>
			<option value="<%=x%>" <%=currentPage==x?"selected":""%>><%=x%></option>
		<%
			}	
		%>
		</select>
	页
<%
	}
%>
</form>
        </td></tr>
      </table>
    </td></tr>
  </table>
</body>
</html>
<script language='JavaScript'>
function listall()
{
form1.ccif.value="ALL";
window.location.reload();
form1.submit();}
function  aa()
{
  window.location.reload();
  form1.submit();
}
</script>
