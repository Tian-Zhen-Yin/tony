<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="dbconn" scope="page" class="com.dbconn.DBConn"/>
<%
try{
   request.setCharacterEncoding("gb2312");
   String id=request.getParameter("hid");
   String kcje=request.getParameter("hkcje");
   String dj=request.getParameter("hdj");
   System.out.println(id);
   System.out.println(kcje);
   System.out.println(dj);
   String sql="update tb_kucun set kcje="+kcje+
                 ",dj="+dj+" where id='"+id+"'";
   Connection conn = dbconn.getConnection();
   PreparedStatement pstmt = conn.prepareStatement(sql);
   pstmt.executeUpdate();
   out.println("<script language='javascript'>alert('商品价格修改成功');"+
                "window.location.href='modifyPrice1.jsp';</script>");
}catch(Exception e) {
	e.printStackTrace();
}
%>
