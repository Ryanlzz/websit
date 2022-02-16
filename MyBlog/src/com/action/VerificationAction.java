package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IUserService;
import com.serviceimpl.IUserServiceImpl;

/**
 * Servlet implementation class RegisterVerificationAction
 */
@WebServlet("/VerificationAction")
public class VerificationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");

		if("user_name".equals(method)) {
			//判断用户是被被注册过
			this.userExist(request, response);
		} else if("user_email".equals(method)) {
			//判断邮箱是否被注册过
			this.emailExist(request, response);
		}
			
	}
	
	
	private void userExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// 从前端获取登录属性
			String name = request.getParameter("user_name");

			//实例化登录服务
			userservice = new IUserServiceImpl();
			boolean flag = userservice.userExist(name);
			
			if (!flag) {
				//可以注册		
				System.out.println("用户可以注册");
				response.getWriter().write("yes");
			} else {
				//用户名已被注册过		
				System.out.println("用户已被注册");
				response.getWriter().write("no");
			}
	}

	private void emailExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 从前端获取登录属性
		String email = request.getParameter("user_email");
		
		//实例化登录服务
		userservice = new IUserServiceImpl();
		boolean flag = userservice.emailExist(email);
		
		if (!flag) {
			//可以注册			
			System.out.println("邮箱可以注册");
			response.getWriter().write("yes");
		} else {
			//邮箱已被注册过	
			System.out.println("邮箱已被注册");
			response.getWriter().write("no");
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
