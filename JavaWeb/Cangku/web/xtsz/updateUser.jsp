<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.sql.*,java.io.*"%>
<jsp:useBean id="dbr" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="trans" scope="page" class="com.chinese.ToChinese"/>
<jsp:useBean id="calendar" scope="page" class="com.showtime.ShowTime"/>
<jsp:useBean id="dbc" scope="page" class="com.dbconn.DBConn"/>
<%
try{
   request.setCharacterEncoding("gb2312");
   String username=request.getParameter("username");
   String password=request.getParameter("newpw1");
   String userid = request.getParameter("userid");
   if(!(password == null)) {
   	String sql="select * from tb_user where username='"+username+"'";
   	ResultSet rs=dbr.getResult(sql);
   	if(rs.next()){
   	      out.println("<script language='javascript'>alert('该用户名已存在');"+
   	                "window.location.href='addUser.jsp';</script>");
   	}
   	else{
  	   String last=calendar.getDate();
  	   String addSql="insert into tb_user(Username,Password,userLastLogTime) values('"+username+"','"+password+"','"+last+"')";
  	   PreparedStatement pstmt = dbc.getConnection().prepareStatement(addSql);
  	   pstmt.executeUpdate();
  	   out.println("<script language='javascript'>alert('注册成功');"+
  	                 "window.location.href='addUser.jsp';</script>");
  	 }
   }else if(!(userid==null)){
   	int id = Integer.parseInt(userid);
   	String sql="select * from tb_user where id="+userid;
   	ResultSet rs=dbr.getResult(sql);
   	if(rs.next()){
   	      String addSql="delete from tb_user where id="+id;
  	   PreparedStatement pstmt = dbc.getConnection().prepareStatement(addSql);
  	   pstmt.executeUpdate();
  	   out.println("<script language='javascript'>alert('删除成功');"+
  	                 "window.location.href='deleteUser.jsp';</script>");
   	}else{
   		out.println("<script language='javascript'>alert('该用户不存在');"+
   	                "window.location.href='deleteUser.jsp';</script>");
   	}
   }else{
   		out.println("<script language='javascript'>alert('操作错误');"+
   	                "window.location.href='addUser.jsp';</script>");
   }
   
}catch(Exception e) {
	e.printStackTrace();
}
%>
