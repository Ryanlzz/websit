package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.Userbean;
import dao.UserDaoImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet.do"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		
		if(!password.equals(rpassword)) {
			request.setAttribute("err","两次密码不一样");
		    request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		Userbean user = new Userbean();
		UserDaoImpl userdao = new UserDaoImpl((DataSource) context.getAttribute("dataSource"));
		
		user.setId(id);
		user.setPassword(password);
		
		boolean flag = false;
		
		try {
			
			flag = userdao.judgeid(id);
			
			if(flag) {
				
				request.setAttribute("err","用户已存在");
			    request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			
			userdao.save(user);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("success","用户注册成功");
	    request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
