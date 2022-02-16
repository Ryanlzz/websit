package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entries.User;
import com.service.IUserService;
import com.serviceimpl.IUserServiceImpl;

import net.sf.json.JSONArray;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**   
* ------------------------------------------------   
* @FileName��        MyBlog      UserAction   
* @TODO��   	         �û���������
* @author:     Mr Ryan
* @Date��                    2019��1��4�� ����8:29:37   
* @version:    1.0
* ------------------------------------------------        
*/
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IUserService userservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		System.out.println(method);
		
		if("login".equals(method))
			//��¼
			this.login(request, response);
		else if("register".equals(method))
			//ע��
			this.register(request, response);
		else if("findpassword".equals(method))
			try {
				this.findPassword(request, response);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if ("finduser".equals(method))
			// ��¼
			this.findUser(request, response);
		
	}
	
	protected void findUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("user_name");
		userservice = new IUserServiceImpl();
		boolean flag = userservice.userExist(name);
		if (!flag) {
			System.out.println("�û������ڣ�");
		} else {
			User u = userservice.getUser(name);
			request.getSession().setAttribute("datauser", u);	
			response.getWriter().write("����ɹ�");
			System.out.println("123");
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ǰ�˻�ȡ��¼����
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String remember = request.getParameter("rememberpassword");
		HttpSession session=request.getSession(true);
		
		//�ж��Ƿ�ѡ�˱�������
        if("auto".equals(remember)){
        	
        	//���֮ǰ������û���Ϣ
    		Cookie[] cookies=request.getCookies();
        	
        	if(cookies!=null){ 
        		System.out.println("��ɾ��cookie");
        		Cookie cookie = null;
        		//ɾ��֮ǰ������û�������
        		for(int i=0;i<cookies.length;i++){
    				cookie = cookies[i];
    				cookie.setMaxAge(0);
    				response.addCookie(cookie);
        		}
    			System.out.println("cookieɾ�����");
            } 
        	
        	
        	System.out.println("����cookie�ɹ�");
        	//д���µ��û�������
        	Cookie cookie=new Cookie(name,password);
        	cookie.setMaxAge(7*24*60*60);
        	response.addCookie(cookie);	 
        } 
        
		//ʵ�������󣬴��¼����Ϣ
		User user = new User(name,password);
		
		//ʵ������¼����
		userservice = new IUserServiceImpl();
		User u = userservice.login(user);

		
		if (u != null) {
			//���ݺϷ� ��ת��������
			session.setAttribute("user_id", u.getUser_id());
			session.setAttribute("user_name", u.getUser_name());
			session.setAttribute("islogin","yes" );
			session.setAttribute("datauser", u);
			System.out.println(u.getLevel());
			response.getWriter().write("����ɹ�");
			request.getRequestDispatcher("/TouristAction").forward(request, response);	
			System.out.println("��¼�ɹ�����ת��������");
		} else {
			//���ݷǷ�
			session.setAttribute("islogin","no");
			System.out.println("�û��������벻��ȷ");
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ǰ�˻�ȡ������Ϣ
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		
		//ʵ����ע�����
		userservice = new IUserServiceImpl();
		
		//ʵ�����û����󣬽�����뵽���ݿ���
		User user = new User(name,password,email);
		
		//����flag�ж������Ƿ����ɹ���0ʧ�ܣ���0�ɹ�
		int flag = userservice.register(user);
		
		if(flag != 0) {
			//����ɹ������ط�0ֵ
			System.out.println("ע��ɹ�");
		} else {
			//����ʧ�ܣ�����0
			System.out.println("ע��ʧ��");
		}
	}
	
	protected void findPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MessagingException{
		// ��ǰ�˻�ȡ������Ϣ
		String name = request.getParameter("user_name");
		
		String email = request.getParameter("user_email");
		
		//ʵ�����ʼ�����
		userservice = new IUserServiceImpl();
		
		
		boolean flag = userservice.userExist(name);
		
		
		
		if(!flag){
			System.out.println("�û������ڣ�");
		}else{
			String password = userservice.getPassword(name);
			Properties props = new Properties();  
	        props.setProperty("mail.debug", "true");  	        
	        props.setProperty("mail.smtp.auth", "true");  	        
	        props.setProperty("mail.host", "smtp.qq.com");  	        
	        props.setProperty("mail.transport.protocol", "smtp");  	         
	        Session session = Session.getInstance(props);  
	          	        
	        Message msg = new MimeMessage(session);  
	        try {
				msg.setSubject("�һ������ʼ�");
			} catch (MessagingException e) {
				e.printStackTrace();
			}  
	        
	        msg.setText("�𾴵��û����ã����û���Ϊ"+name+"���˻�������Ϊ"+password+"�������μ����롣");  	       
	        msg.setFrom(new InternetAddress("1184189060@qq.com"));  
	          
	        Transport transport = session.getTransport();  
	        System.out.println(email);
	        transport.connect("1184189060@qq.com", "hbnplwescxewiffd");  	       
	        transport.sendMessage(msg, new Address[] {new InternetAddress(email)}); 
	        transport.close();  
		}
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
