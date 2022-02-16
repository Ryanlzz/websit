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
	<style>
	.d1{
			margin-top: 10px;
			float: right;
			margin-right: 80px;
			border:1px solid #ccc;
			padding: 5px;
			border-radius: 5px;
			background: #f00;
		}
		.d1 a{
			text-decoration: none;
			font-size: 18px;
			background: #f00;
			color: #fff;
			border-radius: 5px;

		}
		#left {
			float: left;
			width: 15%;
			background-color: yellow;
            height: 670px;
            margin-right: 10px;
		}
		#right {
			overflow: auto;
			background-color: gainsboro;
			width: 81%;;
            height: 710px;
		}
        .section{
            font-size: 25px;
            

        }
        html {
            margin: 0;
            padding: 0;
        }

        h2 {
            font-size: 20px;
            color: #d9534f;
            text-align: center;
            padding: 18px 0 18px 0;
            margin: 0 0 10px 0;
        }
        p {
            padding: 0;
            margin: 0;
            line-height: 24px;
        }
        .img-circle {
            border: 3px solid #fff;
            border-radius: 50%;
        }
        .section {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 10px;
            border-radius: 8px;
        }
        #header {
            background-image: url("/statics/demosource/myblog/head.png");
            background-size: cover;
        }
        #header img {
            display: block;
            width: 80px;
            height: 80px;
            margin: auto;
        }
        #header p {
            font-size: 24px;
            color: #fff;
            padding-top: 10px;
            margin: 0;
            font-weight: bold;
            text-align: center;
        }
        .quote {
            font-size: 16px;
            text-align: right;
            margin-top: 10px;
        }
        table {
            width: 100%;
            font-size: 14px;
        }
        table, th, td {
            border: 2px solid #cecece;
            border-collapse: collapse;
            text-align: center;
        }
        th, td {
              padding: 7px 5px;
        }
        .selected {
            background-color: #fdc602;
            font-weight: bold;
            color: #fff;
        }
        li {
            margin-bottom: 15px;
            font-weight: bold;
        }
        iframe, audio {
            display: block;
            margin: 0 auto;
        }
        form {
            text-align: center;
            margin-top: 0;
        }
        .submit {
            background-color: #d9534f;
            padding: 12px 45px;
            border-radius: 5px;
            cursor: pointer;
            color: #ffffff;
            border: none;
            outline: none;
            margin: 0;
            font-weight: bold;
        }
        .submit:hover {
            background-color: #d2322d;
        }
        textarea {
            height: 100px;
        }
        input, textarea {
            margin-bottom: 10px;
            font-size: 14px;
            padding: 15px 10px 10px;
            border: 1px solid #cecece;
            background-color: #efefef;
            color: #787575;
            border-radius: 4px;
            width: 70%;
            outline: none;
        }
        #follow img {
            height: 50px;
            width: 50px;
            margin-left: 7px;
            margin-right: 7px;
        }
        #follow a {
            text-decoration: none;
        }
        #follow img:hover {
            opacity: 0.8;
        }
        #follow {
            text-align: center;
        }
        .left-btn{
        	cursor: pointer;
        }
        .left-btn:hover{
        	color: cornflowerblue;
        }
        .copyright {
            font-size: 13px;
            text-align: center;
            padding-bottom: 10px;
            color: #666;
        }
	</style>
    	<meta charset="utf-8">
        <title>我的博客</title>
        <link href="https://www.w3cschool.cn/statics/demosource/myblog/myblog.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${path}comm/jquery-2.1.4.js" charset="utf-8"></script>
		<script type="text/javascript">
			function goMyInfo(o){
				var myInfo = document.getElementById('myInfo');
				var ifm = document.getElementById('right');
				if(o == myInfo){
					ifm.src = "mydata.jsp";
				}
			}
			function goMyArtical(o){
				var myInfo = document.getElementById('myArtical');
				var ifm = document.getElementById('right');
				if(o == myInfo){
					ifm.src = "myArtical.jsp";
				}
			}

		</script>
    </head>   
    <body>
    <form action="../UserAction" method="post">
 <div id="header" class="section">
            <div class="d1" id="login">
				 <a href="${pageContext.request.contextPath}/admin/mainpage.jsp">返回主界面</a>
			</div>
            <!-- 如果图像无法显示，则alt属性用来为图像定义一串可替换的文本。alt属性是必需的 -->
            <!-- img src="url" height="" width="" border="" alt=""/ -->
            <img src="https://www.w3cschool.cn/statics/demosource/myblog/avatar.png" alt="头像" class="img-circle" />
            <p>小鑫鑫</p> 
            </div>
		<div id = "left" class="section">
			
            <div >
                <h4 class="left-btn" id="myArtical" onclick="goMyArtical(this)"><span>我的文章</span></h4>
            </div>     
            
            <div>
                <h4 class="left-btn" id="myInfo" onclick="goMyInfo(this)"><span>个人资料</span></h4>
            </div>    

            <div>
                <h4 class="left-btn" onclick=""><span>我的评论</span></h4>
            </div>

            <div>
                <h4 class="left-btn" onclick=""><span>我的回复</span></h4>
            </div>

            <div>
                <h4 class="left-btn" onclick=""><span>我的点赞</span></h4>
            </div>

            <div>
                <h4 class="left-btn" onclick=""><span>我的粉丝</span></h4>
            </div>

            <div>
                <h4 class="left-btn" onclick=""><span>我的留言</span></h4>   
            </div>

        </div>

        <iframe id="right" src="" frameborder="0">
        	${requestScope.datauser.user_sex}
        </iframe>

        <!-- Follow section end --> 
        <div class="section" style="margin-top: 10px;">
            <center>&copy; 2019 My Blog.</center>
        </div>
        </form>
    </body>
</html>