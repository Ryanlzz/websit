/**
 * 
 */
package com.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entries.Text;
import com.entries.ArticalDisplay;
import com.service.ITextService;
import com.service.IUserService;
import com.serviceimpl.ITextServiceImpl;
import com.serviceimpl.IUserServiceImpl;

import net.sf.json.JSONArray;
/**
 *
 * @FileName：        TextAction.java 
 * @TODO：   	            文章操作控制
 * @author:     Z
 * @Date：                    2019年1月7日 上午11:16:22
 * @version:    1.0
 *
 */


@WebServlet("/TextAction")
public class TextAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ITextService textService;
	IUserService userService;
	
	public TextAction(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String method = request.getParameter("method");
		
		System.out.println(method);
		
		if("write".equals(method))
			this.write(request,response);
		else if("getAllArtical".equals(method))
			this.getAll(request,response);
		else if("getMyArtical".equals(method))
			this.getMy(request,response);


	}
	

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		textService = new ITextServiceImpl();
		userService = new IUserServiceImpl();
		List<Text> all = textService.getAll();
		
		List<ArticalDisplay> allartical = new ArrayList<ArticalDisplay>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		for (int i = 0; i < all.size(); i++) {
			ArticalDisplay artical = new ArticalDisplay();
			String text_user_name = userService.findTextName(all.get(i).getText_user_id());
			artical.setText_user_name(text_user_name);
			artical.setText_time(dateFormat.format(all.get(i).getText_time()));
			artical.setText_title(all.get(i).getText_title());
			artical.setText_cont(all.get(i).getText_cont());
			allartical.add(artical);
		}
		
		if(all.size() == 0) {
			//TODO 失败
			System.out.println("还没有文章");

		}
		else
			//TODO 成功
			System.out.println("读取全部文章成功");
			response.getWriter().write(JSONArray.fromObject(allartical).toString());

	}
	
private void getMy(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user_name");
		textService = new ITextServiceImpl();
		userService = new IUserServiceImpl();
		List<Text> all = textService.getMy(username);

		
		List<ArticalDisplay> allartical = new ArrayList<ArticalDisplay>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		for (int i = 0; i < all.size(); i++) {
			ArticalDisplay artical = new ArticalDisplay();
			String text_user_name = userService.findTextName(all.get(i).getText_user_id());
			artical.setText_user_name(text_user_name);
			artical.setText_time(dateFormat.format(all.get(i).getText_time()));
			artical.setText_title(all.get(i).getText_title());
			artical.setText_cont(all.get(i).getText_cont());
			allartical.add(artical);
		}
		
		if(all.size() == 0) {
			//TODO 失败
			System.out.println("你还没有文章");

		}
		else
			//TODO 成功
			System.out.println("读取我的文章成功");
			response.getWriter().write(JSONArray.fromObject(allartical).toString());

	}

	protected void write(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession(true);
		String text_title = request.getParameter("text_title");
		int text_user_id = (int)session.getAttribute("user_id");
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date text_time = new Date();
		//String text_time = dateFormat.format(now);		
		String text_cont = request.getParameter("text_cont");
		
		Text text = new Text(text_title, text_user_id, text_time, text_cont);

		textService = new ITextServiceImpl();
		int flag = textService.write(text);
		if(flag==0) {
			//TODO 失败
			System.out.println("失败");
		}
		else
			//TODO 成功
			System.out.println("成功");
	}

}
