package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entries.Comment;
import com.service.ICommentService;

/**
 * Servlet implementation class CommentAction
 */
@WebServlet("/CommentAction")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICommentService commentservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAction() {
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
		
		if("addcomment".equals(method))
			//添加留言
			this.addComment(request, response);
		else if("getcomment".equals(method))
			//获取留言
			this.getComment(request, response);
	}

	protected void addComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int text_id = Integer.parseInt(request.getParameter("comment_text_id"));
		int user_id = Integer.parseInt(request.getParameter("comment_user_id"));
		String text_cont = request.getParameter("text_cont");
		
		Comment comment = new Comment(text_id,user_id,text_cont);
		int flag = commentservice.addComment(comment);
		if(flag==0){
			System.out.println("添加评论失败");
		}else{
			System.out.println("添加评论成功");
		}
		
	}
	
	protected void getComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int text_id = Integer.parseInt(request.getParameter("comment_text_id"));
		//获取留言列表
		List<Comment> list = commentservice.getComment(text_id);
		
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
