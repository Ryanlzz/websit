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
		<meta charset="UTF-8">
		<title>个人资料</title>
		<style type="text/css">
				body{
				background: url("../images/3.jpg");
				background-repeat:no-repeat;
				background-size:100% 100%;
				background-attachment: fixed;
				margin:auto;
				
			}
			.all{
				padding:20px 100px;
			}
			.header{
				height: 120px;
				width: 100%;
			}
			.avater{
				width: 20%;
				height: 300px;
				text-align: center;
				float: left;
			}
			.mas{
				width: 80%;
				float: left;
			}
			.mas li{
				height: 50px;
				line-height: 50px;
				font-size: 20px;
				list-style-type: none;
			}
		</style>
		
	</head>
	<body>
	<%
		System.out.println((String) session.getAttribute("user_name"));
	%>
		<div class="all">
			<div class="header">
				<h1>个人资料</h1><br />
				<hr />
			</div>
			<div class="avater">
				<img src="../images/avtar.png" alt="头像" height="160px"/>
			</div>
			<div class="mas">
				<ul>
					<li>
						<span>用 户 名 ：</span><span style="margin-left: 20px;">${sessionScope.datauser.user_name }</span>
					</li>
					<li>
						<span>个性签名：</span><span style="margin-left: 20px;">${sessionScope.datauser.user_sign}</span>
					</li>
					<li>
						<span>邮　　箱：</span><span style="margin-left: 20px;">${sessionScope.datauser.user_email }</span>
					</li>
					<c:choose> 

						  <c:when test="${requestScope.datauser.user_sex == 1}">   
							<li>
						   <span>性　　别：</span><span style="margin-left: 20px;">女</span>
							</li>
						  </c:when> 
						
						
						  <c:otherwise>   
						<li>
						  <span>性　　别：</span><span style="margin-left: 20px;">男</span>
						</li>
						  </c:otherwise> 
						
						</c:choose> 
				
					<li>
						<span>等　　级：</span><span style="margin-left: 20px;">${sessionScope.datauser.level}</span>
					</li>
				</ul>
				
			</div>
			
		</div>
	</body>
</html>
