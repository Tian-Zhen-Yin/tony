<%@ page contentType="text/html;charset=gb2312" language="java"%>
<%@ page import="java.sql.*,java.io.*,java.util.*"%>
<jsp:useBean id="rst" scope="page" class="com.dbconn.DBResult"/>
<jsp:useBean id="calendar" scope="page" class="com.showtime.ShowTime"/>
<html>
<title>��Ʒ�����Ϣ</title>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<body>
<%
   request.setCharacterEncoding("gb2312");//���ַ���ͳһ���������ύ�е�������������
   String strSql="select * from tb_brand";
   ResultSet rs=rst.getResult(strSql);//�������б�����ʾ��Ʒ����
   String jc="";  //���
   String gg="";  //���
   String bz="";   //��װ
   String spid="";  //ID��
   String spname="";   //��Ʒ����
   String gysname="";   //��Ӧ��ȫ��
   String cd="";   //����
   String dw="";   //��λ
   String theMax="";   //
   String rkspname=(String)request.getParameter("rkspname");//����û���ѡ��Ʒ�ļ��
   String rkStr="select * from tb_brand where spname='"+rkspname+"'";
   ResultSet rs1=rst.getResult(rkStr);//������Ʒ���Ʋ�ѯ���û���ѡ��Ʒ

   if(rs1.next()){
     jc=rs1.getString("jc");
     gg=rs1.getString("gg");
     bz=rs1.getString("bz");
     gysname=rs1.getString("gysname"); 
     cd=rs1.getString("cd");
     dw=rs1.getString("dw");
     spid=rs1.getString("ID");
     spname=rs1.getString("spname");
   }

   String rkbh="RK"+calendar.getDateString()+new Random().nextInt(999);
%>
  <center><img src="../KCM/sprk.gif"></center>
    <table width="557" height="112"  border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#F2F2F2">
         <tr><td width="274" >
    <form  name="form1" method="post" action="sprk.jsp" >
       <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <select name="rkspname" onchange="spchange()">
         <option selected="selected">��ѡ�������Ʒ����Ʒ����</option>
        <%while(rs.next()){%>
        <option value=<%=rs.getString("spname")%>> <%=rs.getString("spname")%> </option>
        <%}%>
        </select></td>
        <td width="276"> <font color="#585858">ע:��*��Ϊ������ </font></td></tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����:<font color="#585858"><%=rkbh%></font></td></tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Ʒ����:<font color="#585858"><%=spname%></font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��:<font color="#585858"><%=jc%></font></td>
        </tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��:<font color="#585858"><%=gg%></font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;װ:<font color="#585858"><%=bz%></font></td>
        </tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��Ӧ��ȫ��:<font color="#585858"><%=gysname%></font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��:<font color="#585858"><%=cd%></font></td>
        </tr>
    </form>

    <form  name="form2" method="post" action="spChange.jsp" >
      <%
         session.setAttribute("jc",jc); 
         session.setAttribute("spname",spname);
         session.setAttribute("gg",gg); 
         session.setAttribute("bz",bz);
         session.setAttribute("cd",cd); 
         session.setAttribute("rkbh",rkbh);
         session.setAttribute("dw",dw); 
         session.setAttribute("spid",spid);
         session.setAttribute("gysname",gysname);
      %>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��:<input type="text" name="sl" onblur="autoje()">
              <font color="#585858">(<%=dw%>)*</font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��:<input type="text" name="je" readonly></td>
        </tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��:<input type="text" name="dj" onblur="autoje()">
              <font color="#585858">(Ԫ)*</font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ӧ&nbsp;&nbsp;��:<input type="text" name="yf" readonly></td>
        </tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ʵ&nbsp;&nbsp;��:<input type="text" name="sf" onblur="autoje()">
              <font color="#585858">(Ԫ)*</font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;δ&nbsp;&nbsp;��:<input type="text" name="wf" readonly></td>
        </tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����Ա:<input type="text" name="czy" readonly value="<%=session.getAttribute("username")%>">
              <font color="#585858"></font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������:<input type="text" name="jsr">*</td>
        </tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�������:<input type="text" name="rkdate" readonly value="<%=calendar.getDate()%>">
              <font color="#585858"></font></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���㷽ʽ:<select name="jsfs">
            <option value="�ֽ�" selected>�ֽ�</option>
            <option value="yf" >Ԥ��</option>
            <option value="zp" >֧Ʊ</option>
            <option value="gz" >����</option></select></td>
        </tr>

        <input type="hidden" name="hjc" value=<%=jc%>></form>
        <tr><td><div align="center">
          <input name="mySubmit"  type="button" value="������Ϣ"  onclick="check()">
        </div></td>
        <td><input name="myeset"type="reset" class="btn_grey" value="�������" onclick="myreset()"></td></tr>
</form>
      </td></tr>
</table>
</body>
</html>
<script language='JavaScript'>
function spchange()
{
  form1.submit();
}
function autoje()
{
    str=form2.sl.value;
    if(isNaN(str)){//�ж������Ƿ�Ϊ����
      form2.sl.value=0;
      alert("�������,����������");
      form2.sl.focus();
      return;
    }
    str=form2.dj.value;
    if(isNaN(str)){
      form2.dj.value=0;
      alert("�������,����������");
      form2.dj.focus();
      return;
    }
    str=form2.sf.value;
    if(isNaN(str)){
      form2.sf.value=0;
      alert("�������,����������");
      form2.sf.focus();
      return;
    }
    //�Զ������Ӧ�ռ�δ�տ�
    form2.je.value=form2.dj.value*form2.sl.value;
    form2.yf.value=form2.je.value;
    form2.wf.value=form2.yf.value-form2.sf.value;
    if(form2.sf.value-form2.yf.value>0){
      form2.sf.value=0;
      form2.wf.value=form2.yf.value;
      alert("ʵ����Ӧ����Ӧ�����!");
      form2.sf.focus();
      return;
    }
}
function check()
{
  if(form2.sl.value==0){
    alert("����������");
    form2.sl.focus();
    return;
  }
  if(form2.dj.value==0){
    alert("�����뵥��");
    form2.dj.focus();
    return;
  }
  if(form2.sf.value==0){
    alert("������ʵ��");
    form2.sf.focus();
    return;
  }
  if(form2.jsr.value==""){
    alert("�����뾭��������");
    form2.jsr.focus();
    return;
  }
  form2.submit();
}
function myreset()
{
  form2.reset();
}
</script>




















