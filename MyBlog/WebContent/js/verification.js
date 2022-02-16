
$(function(){
			/* 通过on方法绑定一个blur（失去焦点）事件 */
			$('#name').on('blur',function(){
				
				var id = document.getElementById("name");
			    var reg = /[a-z0-9]{3,10}$/i;
			    if(reg.test(id.value)){ 
			    /* 
				get的四个必须参数：
				第一个参数：请求的URL  和from的action  和 a的href属性值得功能一致 
				第二个参数：向服务器端传递A的数据
				第三个参数：回调方法，当ajax的异步请求成功后，浏览器会自动调用这个回调方法，回到方法中的参数data是服务器端回来的数据
				第四个参数：指定服务器回来的数据的类型
				*/
			        $.get("VerificationAction",{
						'user_name':$('#name').val(),
						'method':'user_name'
					},function(data){
						var flag = data+"";
						if(flag == "no") {
							id.setCustomValidity("该用户名已被注册");
						} else {
							id.setCustomValidity("");
						}
					},'text');
			    } else {
			        id.setCustomValidity("用户名格式为3-10位数字或字母");
			    }     
			});
			
			$('#password1').on('blur',function(){
				var pass1 = document.getElementById("password1");
				var reg = /^\w{6,10}$/; 
			    if(pass1.value.length>0){
			       if(reg.test(pass1.value)){
			          pass1.setCustomValidity("");
			        } else{
			          pass1.setCustomValidity("密码应是6到10位");
			        }
			    }
			});
			
			$('#password2').on('blur',function(){
				var pass1 = document.getElementById("password1");
			    var pass2 = document.getElementById("password2");
			    if(pass1.value != pass2.value) {
			    	pass2.setCustomValidity("密码不一致");
			    } else {
			    	pass2.setCustomValidity("");
			    }
			});
			
			$('#em').on('blur',function(){
				var email=document.getElementById("em");
				var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
				if(!reg.test(email.value)){
			    	email.setCustomValidity("请输入正确的邮箱格式");
			    } else {
			    	$.get("VerificationAction",{
					'user_email':$('#em').val(),
					'method':'user_email'
					},function(data){
						var flag = data+"";
						if(flag == "no") {
							email.setCustomValidity("该邮箱已被注册");
						} else {
							email.setCustomValidity("");
						}
					},'text');
			    }
			    
			});	
			
		});