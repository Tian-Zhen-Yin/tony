<%@ page contentType="text/html;charset=gb2312"%>
<html>
  <title>�����Ϣ��ѯ</title>
  <link href="../CSS/style.css" rel="stylesheet" type="text/css">
  <style type="text/css">
<!--
.style2{color: #333333}
-->
  </style>
<body>
<%
	// �������봦��
	request.setCharacterEncoding("GB2312") ;
%>
<%
	// ҳ������·��
	String jspUrl = null ;
	// �������·�ҳ����
	// 1������ûҳҪ��ʾ�ļ�¼����Ĭ����10��ÿҳ
	int lineSize = 10 ;
	// 2������һ����ǰ�ǵڼ�ҳ
	int currentPage = 1 ;
	// �������ҳ��
	int pageSize = 0 ;
	// �ܼ�¼�� / ÿҳ��ʾ�ļ�¼��
	int allRecorders = 0 ;
	// �����ѯ�ؼ��ֱ���
	String keyWord = null ;
	// ����һ���������
	String searchFlag = "F" ;
%>
<%
	// ��Ҫ������������²���
	// ��ǰҳ��ÿҳ��ʾ�ļ�¼�����ܼ�¼������ѯ�ؼ��֡����ӵ�ַ
	jspUrl = request.getParameter("jspUrl") ;
	keyWord = request.getParameter("keyWord") ;
	searchFlag = request.getParameter("searchFlag") ;
	try
	{
		lineSize = Integer.parseInt(request.getParameter("lineSize")) ;
		currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
		allRecorders = Integer.parseInt(request.getParameter("allRecorders")) ;
	}
	catch(Exception e)
	{}
%>
<%
	// ������ҳ��
	pageSize = (allRecorders+lineSize-1)/lineSize ;
%>
<script language="javaScript">
	function openPage(curpage)
	{
		document.spage.cp.value = curpage ;
		// alert(cupage) ;
		document.spage.submit() ;
	}
	function selOpenPage()
	{
		document.spage.cp.value = document.spage.selpage.value ;
		document.spage.submit() ;
	}
</script>
  <table width="590" border="0" cellspacing="-2" cellpadding="-2">
    <tr height="6"><td>
        </td>
    </tr>
	 <tr bgcolor="#FFB13E">
        <td height="25" colspan="6" class="style2">
          &nbsp;��ǰλ�ã�������> ����ѯ &gt;&gt;&gt;</td>
     </tr>
    <tr><td valign="top" height="83">
      <table width="590" border="0" cellspacing="-2" cellpadding="-2">
        <tr><td width="590" height="43" align="Top">
          <form name="spage" action="<%=jspUrl%>">
<%
	if("T".equals(searchFlag))
	{
%>
	�����ѯ�ؼ��֣�<input type="text" name="kw" value="<%=keyWord.equals("null")?"":keyWord%>">
	<input type="submit" value="��ѯ">
	<br>
	<br>
<%
	}
%>
<%
	if(allRecorders>0)
	{
%>	
	<input type="button" value="��ҳ" onClick="openPage(1)" <%=currentPage==1?"disabled":""%>>
	<input type="button" value="��һҳ" onClick="openPage(<%=currentPage-1%>)" <%=currentPage==1?"disabled":""%>>
	<input type="button" value="��һҳ" onClick="openPage(<%=currentPage+1%>)" <%=currentPage==pageSize?"disabled":""%>>
	<input type="button" value="βҳ" onClick="openPage(<%=pageSize%>)" <%=currentPage==pageSize?"disabled":""%>>
	<input type="hidden" name="cp" value="">
	<font color="red" size="5"><%=currentPage%></font>
	/
	<font color="red" size="5"><%=pageSize%></font>
	��ת��
		<select name="selpage" onChange="selOpenPage()">
		<%
			for(int x=1;x<=pageSize;x++)
			{
		%>
			<option value="<%=x%>" <%=currentPage==x?"selected":""%>><%=x%></option>
		<%
			}	
		%>
		</select>
	ҳ
<%
	}
%>
</form>
        </td></tr>
      </table>
    </td></tr>
  </table>
</body>
</html>
<script language='JavaScript'>
function listall()
{
form1.ccif.value="ALL";
window.location.reload();
form1.submit();}
function  aa()
{
  window.location.reload();
  form1.submit();
}
</script>
