<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>FindPassWord</title>
		<link rel = "stylesheet" type = "text/css" href = "css/findpassword.css"/>
	</head>

	<body>
	<form action="UserAction" method="post">
		<div id="login_div">
			<h2>找回密码</h2>
			<input class="login_input" type="text" name="user_name" id="name" placeholder="用户名" required="" autofocus="" style="margin-top:30px; border-radius:5px;"/><br/>
			<br/>
			<input class="login_input" type="email" name="user_email" id="em" placeholder="邮箱" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
			<div id="remember">
			</div>
			<input id="log" type="submit" value="找回密码"/>
			<input type="hidden" name="method" value="findpassword">
		</div>
	</form>
	</body>
</html>
