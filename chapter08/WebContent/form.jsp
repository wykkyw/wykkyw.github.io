<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<center><h3>用户登录</h3></center>
<body>
<a href = "<%=request.getContextPath()%>/CharacterServlet?name=史上最酷&password=123456">单击链接登录</a>
<form action="<%=request.getContextPath()%>/CharacterServlet" method = "post"></form>
<table border = "1" width = "600px" cellpadding = "0" cellspacing = "0" ailgn = "center">
<tr>
<td height = "30" align = "center">用户名：</td>
<td>&nbsp;<input type = "password" name = "password" /></td>
</tr>
<tr>
<td height = "30" colspan = "2" align = "center">
<input type = "submit" value = "登录" />
&nbsp;&nbsp;&nbsp;&nbsp;
<input type = "reset" value = "重置">
</td>
</tr>
</table>
</body>
</html>