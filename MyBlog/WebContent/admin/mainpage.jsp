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
	<script type="text/javascript">
	
		/* 发起一个ajax的异步请求 */
		$.post('../TextAction',{'method':'getAllArtical'},function(data){
			var articals = [];
			$.each(data,function(index,element){//element::{}--->json
				var info='';
				var artical = [];
				info += '<div class="d">'+'<textarea class="form-control" style="background-color:#FFFF77;margin:10px 10px 5px 10px;font-size:15px;padding:10px 0 0 10px;" rows="3" overflow-y:visible readonly>'
				$.each(element,function(key,value){
					artical.push(value);			
				});
				articals.push(artical);
				info += '作者：' + articals[index][3] + '     ' + '发布时间：' + articals[index][1] + '\n\n' + '文章标题：' + articals[index][2]  + '\n\n' + '文章内容：'+ '\n\n' + articals[index][0];
				info += '</textarea>' + '<br><br>' + '<input type="button" value = "赞"  class="b"  id="'+index+'" onclick = \'myclick(this);\'></input><a href="" class="b1">'+'评论'+'</a>';
				$('#artical').append(info).appendTo($('#artical'));
			});
			
		},'json'); 
			

		function myclick(id){
			
			if(id.value == "取消赞"){
				id.value = "赞";
				id.style.background = '#d0a685';
      	  }else{
      		id.style.background = 'red';
      		id.value = "取消赞";
      		  
      	  }
		}
	</script>
</head>
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
					<a href="postArtical.jsp">发表</a>
				</li>
				<li>	
				</li>
				<li>		
				</li>
				<li>				
				</li>
				<li>
				</li>
				<li>		
				</li>
				<li>		
				</li>
			</ul>
			<input type="text" name="" class="te">
			<input type="button" name="" value="搜索" class="bu">
		</div>
	</div>
	<br>

		
	
	<div id="artical">
		
	
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
