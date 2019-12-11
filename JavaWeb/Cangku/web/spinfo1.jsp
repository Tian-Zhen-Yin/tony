<html>
<title>商品信息登记</title>
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<body>
  <center><h3>商品信息登记 </h3>
    <table width="336" height="112"  border="0" align="center" cellpadding="1" cellspacing="1">
      <tr><td width="168">
        <form method="post" action="spinfo.jsp" >
        <tr>注:带*号为必填项
        <tr><td>商品名称:</td><td width="168"><input type="text" name="spname">*</td></tr>
        <tr><td>简称:</td><td><input type="text" name="jc"></td></tr>
        <tr><td>产地:</td><td><input type="text" name="cd">*</td></tr>
        <tr><td>计量单位:</td><td><input type="text" name="dw">*</td></tr>
        <tr><td>规格:</td><td><input type="text" name="gg">*</td></tr>
        <tr><td>包装:</td><td><input type="text" name="bz"></td></tr>
        <tr><td>批号:</td><td><input type="text" name="ph"></td></tr>
        <tr><td>批准文号:</td><td><input type="text" name="pzwh"></td></tr>
        <tr><td>供应商全称:</td><td><input type="text" name="gysname"></td></tr>
        <tr><td>备注:</td><td><input type="text" name="memo"></td></tr>
        <tr><td><input name="submit" type="submit" class="btn_grey" value="保存信息"></td>
        <td><input type="reset" class="btn_grey" value="清除重置"></td></tr>
	</form>
      </td></tr>
   </table>
   </body>
</html> 
