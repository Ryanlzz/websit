<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("path", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Login</title>
	
		<link rel = "stylesheet" type = "text/css" href = "css/login.css"/>
		
		<c:if test="${sessionScope.islogin=='no'}">
			<script type="text/javascript">
				alert("用户名或密码错误");
			</script>		 
  		</c:if>
		<script type="text/javascript">
			function forgetpwd(){
				location.href = "findpassword.jsp";
			}
		</script>
	</head>

	<body>
	<form action="UserAction" method="post">
		<div id="login_div">
			<h2>用户登录</h2>

			<input class="login_input" type="text" name="user_name" id="name" placeholder="用户名" required="" autofocus="" style="margin-top:30px; border-radius:5px;"/><br/>
			<br/>
			<input class="login_input" type="password" name="user_password" id="password" placeholder="密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
			<div id="remember">
				<p><input type="checkbox" name = "rememberpassword" value = "auto" style="vertical-align:-3px;"/>记住密码</p>
				<p style="left:0;text-align:right;" onclick="forgetpwd()")>忘记密码?</p>
				
			</div>
			<input id="log" type="submit" value="登录"/>
			<a href="register.jsp"><font color="white">注册账号</font></a>
			<input type="hidden" name="method" value="login">
		</div>
	</form>
	</body>
</html>
