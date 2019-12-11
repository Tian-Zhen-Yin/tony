<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="dbr" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="dbc" scope="page" class="com.dbconn.DBConn"/>
<%
try{
   request.setCharacterEncoding("gb2312");
   String username=request.getParameter("username");//接收用户名
   String password=request.getParameter("password");//接收旧密码
   String newpw1=request.getParameter("newpw1");//接收新密码
   String sql="select * from tb_user where username='"+
                 username+"'and password='"+password+"'";
   ResultSet rs=dbr.getResult(sql);
   //如果用户的旧密码正确,就修改密码
   if(rs.next()){
	   //更新用户信息表
     String update="update tb_user set password='"+newpw1+
                     "' where username='"+username+"'";
     PreparedStatement pstmt = dbc.getConnection().prepareStatement(update);
     pstmt.executeUpdate();
     out.println("<script language='javascript'>alert('密码修改成功');"+
                   "window.location.href='usermanager.jsp';</script>");
   }else{
     out.println("<script language='javascript'>alert('用户名或密码错误');"+
                   "window.location.href='usermanager.jsp';</script>");
   }
}catch(Exception e) {
	out.println("<script language='javascript'>alert('用户名或密码错误');"+
                   "window.location.href='usermanager.jsp';</script>");
}
%> 
