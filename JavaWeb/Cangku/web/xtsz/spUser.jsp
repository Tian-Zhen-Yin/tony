<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="dbr" class="com.dbconn.DBResult"/>
<html>
<head>
	<title>��Ʒ��Ϣ��ѯ</title>
</head>
<body>
<center>

	<%
		// �������봦��
		request.setCharacterEncoding("GB2312") ;
	%>
	<%!
		final String jspUrl = "spUser.jsp" ;
	%>
	<%
		// �������·�ҳ����
		// 1������ûҳҪ��ʾ�ļ�¼��
		int lineSize = 10 ;
		// 2������һ����ǰ�ǵڼ�ҳ
		int currentPage = 1 ;
		// �������ҳ��
		int pageSize = 0 ;
		// �ܼ�¼�� / ÿҳ��ʾ�ļ�¼��
		int allRecorders = 0 ;
		// �����ѯ�ؼ��ֱ���
		String keyWord = null ;
		//����
		String table = "tb_user";
	%>
	<%
		// ���ղ�ѯ�ؼ���
		keyWord = request.getParameter("kw") ;
		// ���մ������ĵ�ǰҳ
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
				// ���Ϊ����û�в�ѯ����ʾ��ѯ��ȫ��
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
<jsp:include page="Userquest.jsp">
	<jsp:param name="jspUrl" value="<%=jspUrl%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="searchFlag" value="T"/>
</jsp:include>
	<table border="1" width="80%">
	<tr>	
		<td>����Ա���</td>
		<td>����Ա����</td>
		<td>�����½</td>		
	</tr>
	<%
			int i = 0 ;
			
			while(rs.next())
			{
				i++ ;
				int id = rs.getInt(1) ;
	%>
			<tr>
				<td><%=id%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(4)%></td>
				
			</tr>
	<%
			}
			rs.close() ;
			if(i==0)
			{
	%>
				<tr>
					<td colspan="3">û���κ����ݣ���</td>
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
			<h2>ϵͳ��������</h2>
	<%
		}
	%>
</center>
</body>
</html>