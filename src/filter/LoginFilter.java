package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Userbean;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // 1. 检查用户是否已登录
        Userbean user = (Userbean) request.getSession().getAttribute("user");

        // 2. 没登录，登录去
        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
        	
        	request.getRequestDispatcher("admin/main.jsp").forward(request, response);
        }
		
	}

}
