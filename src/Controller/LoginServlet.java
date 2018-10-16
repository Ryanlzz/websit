package Controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.Userbean;
import dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rememberpassword = request.getParameter("rememberpassword");

		ServletContext context = this.getServletContext();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Userbean user = new Userbean();
		UserDaoImpl userdao = new UserDaoImpl((DataSource) context.getAttribute("dataSource"));
		
		user.setId(id);
		user.setPassword(password);
		
		boolean flag = false;
		
		try {
			
			flag = userdao.get(user);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(flag) {
			
			 if (rememberpassword != null && "auto".equals(rememberpassword)) {
		            Cookie cookie = new Cookie("user", id);
		            cookie.setMaxAge(7 * 24 * 60 * 60); 
		            response.addCookie(cookie);
		        }
			
			//跳转至成功登陆页面
			request.getSession().setAttribute("user", user);
			//request.setAttribute("user", user);
			request.getRequestDispatcher("front/blog.jsp").forward(request, response);	
			
		} else {
			
		    request.setAttribute("err","用户名或密码错误!");
		    request.getRequestDispatcher("login.jsp").forward(request, response);
		    
		  }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
