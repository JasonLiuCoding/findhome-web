<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
hello,index.jsp


<a href="/findhome-web/mvc/hello">测试欢迎的按钮</a>
<a href="/findhome-web/mvc/add">增加用户按钮</a>

<br/>

<form action="${pageContext.request.contextPath}/user/addUser" method="post">
	<input name="name" type="text">
	<input name="qq" type="text">
	<input name="phone" type="text">
	<input value="提交" type="submit">
</form>
</body>
</html>