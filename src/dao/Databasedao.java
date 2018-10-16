package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class Databasedao implements ServletContextListener {
	
	private DataSource dataSource;
	 
	public void contextInitialized(ServletContextEvent sce) {
	     	try{
	     
	     		Context initContext = new InitialContext();     	
	     		Context envContext = (Context)initContext.lookup("java:/comp/env");	     	
	            dataSource = (DataSource)envContext.lookup("jdbc/demo");  
	            ServletContext context = sce.getServletContext();
	            context.setAttribute("dataSource", dataSource);
	           
	     	}catch(NamingException e){ throw new RuntimeException(e);}
	     }
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

     
}
