package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entries.Approve;
import com.service.IApproveService;

/**
 * Servlet implementation class ApproveAction
 */
@WebServlet("/ApproveAction")
public class ApproveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IApproveService approveservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveAction() {
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
		
		if("approve".equals(method))
			//����
			this.approve(request, response);
		else if("getapprove".equals(method))
			//ȡ����
			this.disapprove(request, response);

	}
	protected void approve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int text_id = Integer.parseInt(request.getParameter("approve_text_id"));
		int user_id = Integer.parseInt(request.getParameter("approve_user_id"));
		Approve approve = new Approve(user_id,text_id);
		
		int flag1 = approveservice.addApprove(approve);
		
		if(flag1==0){
			System.out.println("��ӵ�����Ϣʧ��");
		}else{
			System.out.println("��ӵ�����Ϣ�ɹ�");
		}
		
		
		int flag2 = approveservice.approveText(approve);
		
		if(flag2==0){
			System.out.println("��������ʧ��");
		}else{
			System.out.println("�������³ɹ�");
		}
	}
	
	protected void disapprove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int text_id = Integer.parseInt(request.getParameter("approve_text_id"));
		int user_id = Integer.parseInt(request.getParameter("approve_user_id"));
		Approve approve = new Approve(user_id,text_id);
		int flag = approveservice.disApprove(approve);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
