<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="dbr" class="com.dbconn.DBResult"/>
<html>
<head>
	<title>商品信息查询</title>
</head>
<body>
<center>

	<%
		// 进行乱码处理
		request.setCharacterEncoding("GB2312") ;
	%>
	<%!
		final String jspUrl = "spkc02.jsp" ;
	%>
	<%
		// 定义如下分页变量
		// 1、定义没页要显示的记录数
		int lineSize = 10 ;
		// 2、定义一个当前是第几页
		int currentPage = 1 ;
		// 计算出总页数
		int pageSize = 0 ;
		// 总记录数 / 每页显示的记录数
		int allRecorders = 0 ;
		// 加入查询关键字变量
		String keyWord = null ;
		//表名
		String table = "tb_kucun";
	%>
	<%
		// 接收查询关键字
		keyWord = request.getParameter("kw") ;
		// 接收传过来的当前页
		try
		{
			currentPage = Integer.parseInt(request.getParameter("cp")) ;
		}
		catch(Exception e)
		{}
	%>
	<%
		try
		{
			String sql = null ;
			if(keyWord==null||"".equals(keyWord))
			{
				// 如果为空则没有查询，表示查询出全部
				sql = "SELECT COUNT(*) from "+table ;
			}
			else
			{
				sql = "SELECT COUNT(*) from "+table+" WHERE id LIKE '%"+keyWord+"%' OR spname LIKE '%"+keyWord+"%'";
			}
			ResultSet rs = dbr.getResult(sql) ;
			if(rs.next())
			{
				allRecorders = rs.getInt(1) ;
			}
			rs.close() ;
			if(keyWord==null||"".equals(keyWord))
			{
				sql = "SELECT * FROM "+table+" limit "+(currentPage-1)*lineSize+","+lineSize ;
			}
			else
			{
				sql = "SELECT * FROM "+table+" WHERE id LIKE '%"+keyWord+"%' OR spname LIKE '%"+keyWord+"%' limit "+(currentPage-1)*lineSize+","+lineSize ;
			}
			rs = dbr.getResult(sql) ;
	%>
<jsp:include page="kcquest1.jsp">
	<jsp:param name="jspUrl" value="<%=jspUrl%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="searchFlag" value="T"/>
</jsp:include>
	<table border="1" width="80%">
	<tr>	
		<td>商品编号</td>
		<td>商品名称</td>
		<td>简称</td>
		<td>产地</td>		
		<td>规格</td>
		<td>包装</td>
		<td>单位</td>
		<td>单价</td>
		<td>库存数量</td>
		<td>库存金额</td>
	</tr>
	<%
			int i = 0 ;
			
			while(rs.next())
			{
				int col = 1;
				i++ ;
				int id = rs.getInt(1) ;
	%>
			<tr>
				<td><%=id%></td>
				<%
				while(col<10) { 
				col++;
				%>
				<td><%=rs.getString(col)%></td>
				<%}%>
			</tr>
	<%
			}
			rs.close() ;
			if(i==0)
			{
	%>
				<tr>
					<td colspan="10">没有任何数据！！</td>
				</tr>
	<%
			}
	%>
	</table>
	<%
		}
		catch(Exception e)
		{
			out.println(e) ;
	%>
			<h2>系统出错！！！</h2>
	<%
		}
	%>
</center>
</body>
</html>