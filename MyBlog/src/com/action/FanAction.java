package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entries.Fans;
import com.service.IFansService;

/**
 * Servlet implementation class FanAction
 */
@WebServlet("/FanAction")
public class FanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IFansService fanservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FanAction() {
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
		
		if("addfan".equals(method))
			//关注
			this.addFans(request, response);
		else if("getfan".equals(method))
			//...
			this.getFans(request, response);
	}

	protected void addFans(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fan_id = Integer.parseInt(request.getParameter("fans_fan_id"));
		int user_id = Integer.parseInt(request.getParameter("fans_user_id"));
		Fans fan = new Fans(user_id,fan_id);
		
		int flag = fanservice.addFans(fan);
		
		if(flag==0){
			System.out.println("关注失败");
		}else{
			System.out.println("关注成功");
		}
		
		
		
	}
	
	protected void getFans(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("fans_user_id"));
		//获取粉丝列表
		List<Fans> list = fanservice.getFans(user_id);
		
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
