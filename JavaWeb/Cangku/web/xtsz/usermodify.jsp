<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="dbr" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="dbc" scope="page" class="com.dbconn.DBConn"/>
<%
try{
   request.setCharacterEncoding("gb2312");
   String username=request.getParameter("username");//�����û���
   String password=request.getParameter("password");//���վ�����
   String newpw1=request.getParameter("newpw1");//����������
   String sql="select * from tb_user where username='"+
                 username+"'and password='"+password+"'";
   ResultSet rs=dbr.getResult(sql);
   //����û��ľ�������ȷ,���޸�����
   if(rs.next()){
	   //�����û���Ϣ��
     String update="update tb_user set password='"+newpw1+
                     "' where username='"+username+"'";
     PreparedStatement pstmt = dbc.getConnection().prepareStatement(update);
     pstmt.executeUpdate();
     out.println("<script language='javascript'>alert('�����޸ĳɹ�');"+
                   "window.location.href='usermanager.jsp';</script>");
   }else{
     out.println("<script language='javascript'>alert('�û������������');"+
                   "window.location.href='usermanager.jsp';</script>");
   }
}catch(Exception e) {
	out.println("<script language='javascript'>alert('�û������������');"+
                   "window.location.href='usermanager.jsp';</script>");
}
%> 
