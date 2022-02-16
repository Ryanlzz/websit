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
			//�ж��û��Ǳ���ע���
			this.userExist(request, response);
		} else if("user_email".equals(method)) {
			//�ж������Ƿ�ע���
			this.emailExist(request, response);
		}
			
	}
	
	
	private void userExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// ��ǰ�˻�ȡ��¼����
			String name = request.getParameter("user_name");

			//ʵ������¼����
			userservice = new IUserServiceImpl();
			boolean flag = userservice.userExist(name);
			
			if (!flag) {
				//����ע��		
				System.out.println("�û�����ע��");
				response.getWriter().write("yes");
			} else {
				//�û����ѱ�ע���		
				System.out.println("�û��ѱ�ע��");
				response.getWriter().write("no");
			}
	}

	private void emailExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ��ǰ�˻�ȡ��¼����
		String email = request.getParameter("user_email");
		
		//ʵ������¼����
		userservice = new IUserServiceImpl();
		boolean flag = userservice.emailExist(email);
		
		if (!flag) {
			//����ע��			
			System.out.println("�������ע��");
			response.getWriter().write("yes");
		} else {
			//�����ѱ�ע���	
			System.out.println("�����ѱ�ע��");
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
