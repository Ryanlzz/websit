package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entries.Message;
import com.service.IMessageService;

/**
 * Servlet implementation class MessageAction
 */
@WebServlet("/MessageAction")
public class MessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMessageService messageservice;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		
		System.out.println(method);
		
		if("addmessage".equals(method))
			//添加留言
			this.addMessage(request, response);
		else if("getmessage".equals(method))
			//获取留言
			this.getMesage(request, response);
		
		
	}
	protected void addMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int writer_id = Integer.parseInt(request.getParameter("message_writer_id"));
		int user_id = Integer.parseInt(request.getParameter("message_user_id"));
		String message_cont = request.getParameter("message_cont");
		
		Message message = new Message(writer_id,user_id,message_cont);
		int flag = messageservice.addMessage(message);
		if(flag==0){
			System.out.println("添加留言失败");
		}else{
			System.out.println("添加留言成功");
		}
		
	}
	
	protected void getMesage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id = Integer.parseInt(request.getParameter("message_user_id"));
		//获取留言列表
		List<Message> list = messageservice.getMessage(user_id);
		
		System.out.println(list.size());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
