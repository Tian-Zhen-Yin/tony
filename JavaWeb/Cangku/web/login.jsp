<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.io.*,java.sql.*"%>
<jsp:useBean id="rst" scope="page" class="com.dbcom.DBResult"/>
<jsp:useBean id="calendar" scope="page" class="com.showtime.ShowTime"/>
<%
   request.setCharacterEncoding("gb2312");//对请求进行统一编码，能正常接受到中文
   String username=request.getParameter("username"); //接收表单中的username属性
   String password=request.getParameter("password");//接收表单中的password属性
   String str="select * from tb_user where "+
               "username='"+username+"' and password='"+password+"'";
   ResultSet rs=rst.getResult(str);//执行SQL语句获得结果集对象
   session.setAttribute("isLog",new String("0"));//判断用户是否登陆，当isLog的属性为0时，说明用户并没有登陆
   if(!rs.next())//结果集没有找到所要查找的行
   {
    out.println("<script language='javascript'>alert('用户名或密码错误');"+
                "parent.location.href='login.html';</script>");
   }
   else
   {
     session.setAttribute("username",username);//保存登录信息到session对象中
     session.setAttribute("password",password);
     session.setAttribute("userid",rs.getString("ID"));
     session.setAttribute("isLog",new String("1"));//将isLog属性设置为1
     //获得用户上次登陆系统的时间
     session.setAttribute("userLastLogTime",rs.getString("userLastLogTime"));
     String strsql=calendar.getDate();
     int id=rs.getInt("ID");
     //将该用户本次登陆系统的时间在用户信息表中更新
     String strUpdate="update tb_user set userLastLogTime='"+strsql+"' where ID="+id+"";
     rst.getResult(strUpdate);//执行SQL语句
     response.sendRedirect("chat.jsp");//登陆成功后转到系统主页面
   }
%>


















