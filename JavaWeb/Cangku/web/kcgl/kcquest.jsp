<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="qu" scope="page" class="com.info.QuestString"/>
<jsp:useBean id="trans" scope="page" class="com.chinese.ToChinese"/>
<html>
<title>����ѯ</title>
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<body>
<%
   String table="tb_kucun",httpFile="kcquest.jsp";
   String pages=request.getParameter("pages");
   String cif=request.getParameter("cif");
   String ccif=request.getParameter("ccif");
   String qvalue=trans.trans(request.getParameter("qvalue"));
   qu.setCcif(ccif);qu.setCif(cif);qu.setQValue(qvalue);
   String strCount=qu.getCount(table);
   if(pages==null||pages.equals("null")){
     pages="0";
   }
   qu.setQuerySql(httpFile,pages,strCount);
   ResultSet rs=rst.getResult((String)qu.getString(table));
   int i=0,Page=qu.getCurPage(),pagesize=qu.getPageSize();
   while(rs.next()){
     if(i>(Page-1)*pagesize-1){
%>

<table width="500" border="1" cellpadding="-1" cellspacing="0" align="center">
  <tr bgcolor="#DDDDDD">
    <td width="202" height="29" bgcolor="#D9ECFF"><font color="#336699">��Ʒ����:
      <%=rs.getString("spname")%></font></td>
    <td width="195" bgcolor="#D9ECFF"><font color="#336699">���:
      <%=rs.getString("jc")%></font></td>
    <td width="202" bgcolor="#D9ECFF"><font color="#336699">����:
      <%=rs.getString("cd")%></font></td>
  </tr>
  <tr bgcolor="#DDDDDD">
    <td width="185" height="29" bgcolor="#D9ECFF"><font color="#336699">���:
      <%=rs.getString("gg")%></font></td>
    <td width="202" bgcolor="#D9ECFF"><font color="#336699">��װ:
      <%=rs.getString("bz")%></font></td>
    <td width="202" bgcolor="#D9ECFF"><font color="#336699">������λ:
      <%=rs.getString("dw")%></font></td>
  </tr>
  <tr bgcolor="#DDDDDD">
    <td width="202" height="26" bgcolor="#D9ECFF"><font color="#336699">����:
      <%=rs.getString("dj")%></font></td>
    <td width="202" bgcolor="#D9ECFF"><font color="#336699">�������:
      <%=rs.getString("kcsl")%></font></td>
    <td width="202" bgcolor="#D9ECFF"><font color="#336699">�����:
      <%=rs.getString("kcje")%></font></td>
  </tr>
</table><br>
<%}i++;}
rs.close();
String str_parameter="&cif="+qu.getCif()+"&ccif="+qu.getCcif()+"&qvalue="+qu.getQValue()+"";
session.setAttribute("str_parameter",str_parameter);
qu.setStr_parameter(str_parameter);
%>
<%=qu.pageFooter()%>
</table>
</body>
</html>
