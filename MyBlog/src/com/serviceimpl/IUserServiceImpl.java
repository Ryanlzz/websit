package com.serviceimpl;

import com.dao.IUserDao;
import com.daoimpl.IUserDaoImpl;
import com.entries.User;
import com.service.IUserService;

/**   
* ------------------------------------------------   
* @FileName��        MyBlog      IUserServiceImpl   
* @TODO��   	         �û�ҵ���߼�ʵ��
* @author:     Mr Ryan
* @Date��                    2019��1��4�� ����8:41:13   
* @version:    1.0
* ------------------------------------------------        
*/
public class IUserServiceImpl implements IUserService{

	//ʵ������¼dao
	IUserDao userdao = new IUserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User u = userdao.login(user);
		return u;
	}
	
	@Override
	public int register(User user) {

		//��ע����Ϣ���뵽���ݿ⣬���ط�0ֵ��ʾ�ɹ�
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
		//�����û��Ƿ���ڣ����ط�0ֵ��ʾ����
		int flag = userdao.userExist(name);
		if(flag!=0){
			//��ȡ����
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
