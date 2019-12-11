<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%
   //session.removeAttribute("username");
   session.invalidate();
%>
<script language="javascript">
  parent.location.href("login.html");
</script>
