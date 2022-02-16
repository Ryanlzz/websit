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

	<title>Blog</title>
	<link href="${path}css/style.css" rel="stylesheet">
	<script type="text/javascript" src="${path}comm/jquery-2.1.4.js" charset="utf-8"></script>
	
	<script type="text/javascript" src="${path}comm/bootstrap-3.3.7-dist/js/bootstrap.min.js" charset="utf-8"></script>
</head>
<style type="text/css">

	#p1{
		color:#000000;
		font-weight:bold;
	}

	textarea{
				border:1px solid #ccc; 
				height: 400px;
				width: 400px;
				resize: none;
				border-radius: 5px;
			}
			form{
				margin-left: 300px;
				padding-top: 30px;
				color: #d0a685;
			}
	
</style>
<body>
	<div class="div1">
		<p class="p1">博客交流平台</p>
		<div class="d1" id="user" style='display:none'>
			<a href="homepage.jsp">
				${sessionScope.user_name}的个人中心
			</a>
		</div>
		<div class="d1" id="login">
			<a href="${path}login.jsp" >登录</a>
			&nbsp;&nbsp;
			<a href="${path}register.jsp">注册</a>
		</div>
	</div>
	<div class="div2">
		<div class="d2">
			<ul>
				<li>
					<a href="mainpage.jsp">热门</a>
					
				</li>
				<li>
					<a href="postArtical.jsp" target="bottom">发表</a>
				</li>
				<li>
					<a href="">捐助</a>
				</li>
			</ul>
			<input type="text" name="" class="te">
			<input type="button" name="" value="搜索" class="bu">
		</div>
	</div>
	<br>
	
	<div>
		<form action="../TextAction" method="post">
			<p id="p1">标题<br></p><br><input id="title" type="text" name = "text_title" size="30">
			<br>
			<br>
			<p id="p1">内容</p>
			<br>
			<textarea name="text_cont" id="cont"></textarea>
			<input type="submit" name="" value="发表">
			<br>
			<br>
			<input type="hidden" name="method" value="write">
		</form>
	</div>
	<c:if test="${sessionScope.islogin=='yes'}">
		<script type="text/javascript">

			
			var user = document.getElementById('user');
			var login = document.getElementById('login');
			login.style.display='none';
			user.style.display='';
		</script>
 	</c:if>
</body>
</html>