package com.serviceimpl;

import com.dao.IUserDao;
import com.daoimpl.IUserDaoImpl;
import com.entries.User;
import com.service.IUserService;

/**   
* ------------------------------------------------   
* @FileName：        MyBlog      IUserServiceImpl   
* @TODO：   	         用户业务逻辑实现
* @author:     Mr Ryan
* @Date：                    2019年1月4日 下午8:41:13   
* @version:    1.0
* ------------------------------------------------        
*/
public class IUserServiceImpl implements IUserService{

	//实例化登录dao
	IUserDao userdao = new IUserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User u = userdao.login(user);
		return u;
	}
	
	@Override
	public int register(User user) {

		//将注册信息插入到数据库，返回非0值表示成功
		int flag = userdao.register(user);
		return flag;
	}

	@Override
	public boolean userExist(String user_name) {
		// TODO Auto-generated method stub
		boolean userExit = true;
		int flag = userdao.userExist(user_name);
		if(flag == 0 ) {
			userExit = false;
		}
		return userExit;
	}

	@Override
	public boolean emailExist(String user_name) {
		// TODO Auto-generated method stub
		boolean emailExit = true;
		int flag = userdao.emailExist(user_name);
		if(flag == 0 ) {
			emailExit = false;
		}
		return emailExit;
	}

	@Override
	public String getPassword(String name) {
		String password = null;
		//检索用户是否存在，返回非0值表示存在
		int flag = userdao.userExist(name);
		if(flag!=0){
			//获取密码
			password = userdao.getPassword(name);
		}
		return password;
	}

	@Override
	public String findTextName(int text_user_id) {
		// TODO Auto-generated method stub
		String user_name = userdao.findTextName(text_user_id);
		return user_name;
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return userdao.getUser(name);
	}
}
