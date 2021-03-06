package filter;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class EncodingFilter implements Filter {
 
	  @Override
      public void init(FilterConfig filterconfig) throws ServletException {
 
      }
 
      @Override
      public void doFilter(ServletRequest req, ServletResponse res,
                  FilterChain filterchain) throws IOException, ServletException {
    	  
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
 
            // ??????Ӧ????
            request.setCharacterEncoding("UTF-8");	//???????????롰UTF-8??
            response.setContentType("text/html;charset=utf-8");
 
            filterchain.doFilter(request, response);
      }
      
      @Override
      public void destroy() {
 
      }
}