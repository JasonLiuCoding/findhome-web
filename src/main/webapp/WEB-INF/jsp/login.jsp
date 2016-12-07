<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
简陋的登录：
<br />
<form action="${pageContext.request.contextPath}/login/login" method="post">
	<input name="userName" type="text" value="${userName }"><br />
	<input name="password" type="text" value="${password }"><br />
	<input value="提交" type="submit">
</form>
</body>
</html>