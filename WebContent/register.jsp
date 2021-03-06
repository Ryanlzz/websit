<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Login</title>
		<link rel = "stylesheet" type = "text/css" href = "css/register.css"/>
	</head>

	<body>
	<form action="RegisterServlet.do" method="post">
		<div id="register_div">
			<h2>用户注册</h2>			
			<input class="register_input" type="text" name="id" placeholder="用户名" required="" autofocus="" style="margin-top:30px; border-radius:5px;"/><br/>
		    <br/>
		    <input class="register_input" type="password" name="password" placeholder="密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
		 	<br/>
		    <input class="register_input" type="password" name="rpassword" placeholder="确认密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
		    <br/>		   
		    <input id="register" type="submit" value="注册"/> 
		    <a href="login.jsp"><input id="register" type="button" value="返回"/></a>
	        <c:if test = "${err != null}">
				<script language='javaScript'> alert('${err}')</script>
			</c:if>			
			<c:if test = "${success != null}">
				<script language='javaScript'> alert('${success}')</script>
			</c:if>			
		</div>
	</form>
	</body>
</html>
