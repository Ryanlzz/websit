package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entries.User;
import com.service.IUserService;
import com.serviceimpl.IUserServiceImpl;

import net.sf.json.JSONArray;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**   
* ------------------------------------------------   
* @FileName：        MyBlog      UserAction   
* @TODO：   	         用户操作控制
* @author:     Mr Ryan
* @Date：                    2019年1月4日 下午8:29:37   
* @version:    1.0
* ------------------------------------------------        
*/
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IUserService userservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		System.out.println(method);
		
		if("login".equals(method))
			//登录
			this.login(request, response);
		else if("register".equals(method))
			//注册
			this.register(request, response);
		else if("findpassword".equals(method))
			try {
				this.findPassword(request, response);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if ("finduser".equals(method))
			// 登录
			this.findUser(request, response);
		
	}
	
	protected void findUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("user_name");
		userservice = new IUserServiceImpl();
		boolean flag = userservice.userExist(name);
		if (!flag) {
			System.out.println("用户不存在！");
		} else {
			User u = userservice.getUser(name);
			request.getSession().setAttribute("datauser", u);	
			response.getWriter().write("请求成功");
			System.out.println("123");
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从前端获取登录属性
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String remember = request.getParameter("rememberpassword");
		HttpSession session=request.getSession(true);
		
		//判断是否勾选了保存密码
        if("auto".equals(remember)){
        	
        	//清楚之前保存的用户信息
    		Cookie[] cookies=request.getCookies();
        	
        	if(cookies!=null){ 
        		System.out.println("在删除cookie");
        		Cookie cookie = null;
        		//删除之前储存的用户名密码
        		for(int i=0;i<cookies.length;i++){
    				cookie = cookies[i];
    				cookie.setMaxAge(0);
    				response.addCookie(cookie);
        		}
    			System.out.println("cookie删除完毕");
            } 
        	
        	
        	System.out.println("保存cookie成功");
        	//写入新的用户名密码
        	Cookie cookie=new Cookie(name,password);
        	cookie.setMaxAge(7*24*60*60);
        	response.addCookie(cookie);	 
        } 
        
		//实例化对象，存登录的信息
		User user = new User(name,password);
		
		//实例化登录服务
		userservice = new IUserServiceImpl();
		User u = userservice.login(user);

		
		if (u != null) {
			//数据合法 跳转到主界面
			session.setAttribute("user_id", u.getUser_id());
			session.setAttribute("user_name", u.getUser_name());
			session.setAttribute("islogin","yes" );
			session.setAttribute("datauser", u);
			System.out.println(u.getLevel());
			response.getWriter().write("请求成功");
			request.getRequestDispatcher("/TouristAction").forward(request, response);	
			System.out.println("登录成功，跳转到主界面");
		} else {
			//数据非法
			session.setAttribute("islogin","no");
			System.out.println("用户名或密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从前端获取属性信息
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		
		//实例化注册服务
		userservice = new IUserServiceImpl();
		
		//实例化用户对象，将其插入到数据库中
		User user = new User(name,password,email);
		
		//创建flag判断数据是否插入成功，0失败，非0成功
		int flag = userservice.register(user);
		
		if(flag != 0) {
			//插入成功，返回非0值
			System.out.println("注册成功");
		} else {
			//插入失败，返回0
			System.out.println("注册失败");
		}
	}
	
	protected void findPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MessagingException{
		// 从前端获取属性信息
		String name = request.getParameter("user_name");
		
		String email = request.getParameter("user_email");
		
		//实例化邮件服务
		userservice = new IUserServiceImpl();
		
		
		boolean flag = userservice.userExist(name);
		
		
		
		if(!flag){
			System.out.println("用户不存在！");
		}else{
			String password = userservice.getPassword(name);
			Properties props = new Properties();  
	        props.setProperty("mail.debug", "true");  	        
	        props.setProperty("mail.smtp.auth", "true");  	        
	        props.setProperty("mail.host", "smtp.qq.com");  	        
	        props.setProperty("mail.transport.protocol", "smtp");  	         
	        Session session = Session.getInstance(props);  
	          	        
	        Message msg = new MimeMessage(session);  
	        try {
				msg.setSubject("找回密码邮件");
			} catch (MessagingException e) {
				e.printStackTrace();
			}  
	        
	        msg.setText("尊敬的用户您好，您用户名为"+name+"的账户，密码为"+password+"。请您牢记密码。");  	       
	        msg.setFrom(new InternetAddress("1184189060@qq.com"));  
	          
	        Transport transport = session.getTransport();  
	        System.out.println(email);
	        transport.connect("1184189060@qq.com", "hbnplwescxewiffd");  	       
	        transport.sendMessage(msg, new Address[] {new InternetAddress(email)}); 
	        transport.close();  
		}
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
