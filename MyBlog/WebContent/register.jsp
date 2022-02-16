<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Register</title>
		<link rel = "stylesheet" type = "text/css" href = "css/register.css"/>
		<script type="text/javascript" src="comm/jquery-2.1.4.js" charset="utf-8"></script>
		<script type="text/javascript" charset="utf-8" src="js/verification.js"></script>

	</head>

	<body>
	<form action="UserAction" method="post">
		<div id="register_div">
			<h2>用户注册</h2>			
			<input class="register_input" type="text" name="user_name" id="name" placeholder="用户名" required="" autofocus="" style="margin-top:30px; border-radius:5px;"/>
			<br/>
		    <br/>
		    <input class="register_input" type="password" name="user_password" id="password1" placeholder="设置密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
		 	<br/>
		    <input class="register_input" type="password" name="user_rpassword" id="password2" placeholder="确认密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
		    <br/>		   
		    <input class="register_input" type="email" name="user_email" id="em" placeholder="输入邮箱" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/>
		    <br/>
		 	<br/>
		    <input id="regist" type="submit" value="注册"/> 
		    <a href="login.jsp"><input id="back" type="button" value="返回"/></a>
		    <input type="hidden" name="method" value="register">
		</div>
	</form>
	</body>
</html>
