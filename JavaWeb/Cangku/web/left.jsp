<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>
<html>
  <head>
    <title>�ֿ����ϵͳ������</title>
    <meta content="text/html; charset=gb2312" http-equiv="Content-Type" />
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
  <style type="text/css">
<!--
.style1 {color: #5095CD}
-->
  </style></head>
  <body>
<script language="JavaScript">
  function show_div(menu){
    var Imgname;
    if(document.all.item(menu).style.display=="none"){
      document.all.item(menu).style.display="block";
      }else{
        document.all.item(menu).style.display="none";
        }
    }
</script>
<a href="#" onClick="show_div('menu1')" ><img name="Imgmenu1" border="0"
     src="KCM/Imgmenu1_1.gif" align="ABSMIDDLE" width="215" height="70">
</a>
<Div id="menu1" style="display:none">
  <table width="100%" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="31%" height="24">&nbsp;</td>
       <td><a href="./jcxx/khinfodemo.jsp" target="mainFrame" class="1 style1">�ͻ���Ϣע��</a></td>
  </tr>
  <tr><td height="20">&nbsp;</td>
      <td><a href="./jcxx/spinfo1.jsp" target="mainFrame" class="1 style1">��Ʒ��Ϣע��</a></td>
  </tr>

  <tr><td height="21">&nbsp;</td>
      <td><a href="./jcxx/gysinfo01.jsp" target="mainFrame" class="1 style1">��Ӧ����Ϣ����</a></td>
  </tr>

  <tr><td height="20">&nbsp;</td>
      <td><a href="./jcxx/spchat.jsp" target="mainFrame" class="1 style1">��Ʒ��Ϣ��ѯ</a></td>
  </tr>
  <tr><td height="19">&nbsp;</td>
      <td><a href="./jcxx/khchat.jsp" target="mainFrame" class="1 style1">�ͻ���Ϣ��ѯ</a></td>
  </tr>

  <tr><td height="24">&nbsp;</td>
      <td><a href="./jcxx/gyschat.jsp" target="mainFrame" class="1 style1">��Ӧ����Ϣ��ѯ</a></td>
  </tr>

 </table>
</Div>

<a href="#" onClick="show_div('menu3')"><img name="Imgmenu3" align="ABSMIDDLE"
    src="KCM/Imgmenu3_1.gif" border="0" width="215" height="42"></a><br>
<Div id="menu3" style="display:none">
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
<tr>
<td width="31%" height="24">&nbsp;</td>
<td width="69%"> <a href="./kcgl/sprk.jsp" target="mainFrame" class="1 style1">��Ʒ���</a></td>
</tr>
<tr>
  <td height="19">&nbsp; </td>
  <td> <a href="./kcgl/spck.jsp" target="mainFrame" class="1 style1">��Ʒ����</a></td>
</tr>
<tr>
  <td height="20">&nbsp; </td>
  <td> <a href="./kcgl/kcchat.jsp" target="mainFrame" class="1 style1">����ѯ</a></td>
</tr>
<tr>
  <td height="22">&nbsp;</td>
  <td><a href="./kcgl/modifyPrice1.jsp" target="mainFrame" class="1 style1">�۸����</a> </td>
</tr>
</table>
</Div>

<a href="#" onClick="show_div('menu4')"><img name="Imgmenu4" align="ABSMIDDLE"
    src="KCM/Imgmenu4_1.gif" border="0" width="215" height="42"></a><br>
<Div id="menu4" style="display:none">
<table width="100%" height="44" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
<tr>
<td width="31%" height="20">&nbsp;</td>
<td width="69%"><a href="./spxs/spxs.jsp" target="mainFrame" class="1 style1">��Ʒ����</a></td>
<tr>
<td width="31%" height="24">&nbsp;</td>
<td><a href="./spxs/spxsth.jsp" target="mainFrame" class="1 style1">�����˻�</a></td>
</tr></table>
</Div>

<a href="#" onClick="show_div('menu5')"><img name="Imgmenu5" align="ABSMIDDLE"
    src="KCM/Imgmenu5_1.gif" border="0" width="215" height="42"></a><br>
<Div id="menu5" style="display:none">
<table width="100%" height="44" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
<tr>
<td width="31%" height="20">&nbsp;</td>
<td width="69%"><a href="./cxtj/xsxxchat.jsp" target="mainFrame" class="1 style1">������Ϣ��ѯ</a></td>
<tr>
  <td width="31%" height="24">&nbsp;</td>
  <td><a href="./cxtj/sprkchat.jsp" target="mainFrame" class="1 style1">��Ʒ����ѯ</a></td>
</tr>
</table>
</Div>
<!--
<a href="#" onClick="show_div('menu6')"><img name="Imgmenu6" align="ABSMIDDLE"
    src="KCM/Imgmenu6_1.gif" border="0" width="215" height="42"></a><br>
  <Div id="menu6" style="display:none">
  <table width="100%" height="129" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
  <tr><td width="36%" height="24">
  </td>
    <td width="64%"><a href="./wlgl/spxsjz/spxsjzchat.jsp" target="mainFrame" class="1 style1">��Ʒ���۽���</a></td>
  </tr>
  <tr>
    <td height="21">&nbsp;</td>
    <td><a href="./wlgl/rkthjz/rkthjzchat.jsp" target="mainFrame" class="1 style1">����˻�����</a></td>
  </tr>
  <tr>
    <td height="20">&nbsp;</td>
    <td><a href="./wlgl/xsjzquest/xsjzchat.jsp" target="mainFrame" class="1 style1">���۽��˲�ѯ</a></td>
  </tr>
  <tr>
    <td height="23">&nbsp;</td>
    <td><a href="./wlgl/sprkjz/sprkjzchat.jsp" target="mainFrame" class="1 style1">��Ʒ������</a></td>
  </tr>
  <tr>
    <td height="21">&nbsp;</td>
    <td><a href="./wlgl/xsthjz/xsthjzchat.jsp" target="mainFrame" class="1 style1">�����˻�����</a></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><a href="./wlgl/rkjzquest/rkjzchat.jsp" target="mainFrame" class="1 style1">�����˲�ѯ</a></td>
  </tr>
  </table>
  </Div>
  -->
<a href="#" onClick="show_div('menu7')"><img name="Imgmenu7" align="ABSMIDDLE"
    src="KCM/Imgmenu7_1.gif" border="0" width="215" height="42"></a><br>
<Div id="menu7" style="display:none">
<table width="100%" height="45" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
 <% 
 	String username = null;
 	username = session.getAttribute("username").toString();
 	if(username.equals("tuzhirong")) {
 %>
 <tr>
 <td width="31%" height="22">&nbsp;</td>
 <td width="69%"><a href="./xtsz/addUser.jsp" target="mainFrame" class="1 style1">���Ӳ���Ա</a></td>
 </tr>
 <tr>
 <td width="31%" height="22">&nbsp;</td>
 <td width="69%"><a href="./xtsz/deleteUser.jsp" target="mainFrame" class="1 style1">ɾ������Ա</a></td>
 </tr>
 <tr>
 <td width="31%" height="22">&nbsp;</td>
 <td width="69%"><a href="./xtsz/Userchat.jsp" target="mainFrame" class="1 style1">��ѯ����Ա</a></td>
 </tr>
 <%} %>
  <tr>
 <td width="31%">&nbsp;</td>
 <td width="69%"><a href="./xtsz/usermanager.jsp" target="mainFrame" class="1 style1">���������޸�</a></td>
 </tr>
   <tr>
 <td width="31%">&nbsp;</td>
 <td width="69%"><a href="userexit.jsp" target="mainFrame" class="1 style1">�˳�ϵͳ</a></td>
 </tr>
</table>
</Div>
</body>
</html>


