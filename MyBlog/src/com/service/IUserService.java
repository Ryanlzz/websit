package com.service;

import com.entries.User;

/**
* ------------------------------------------------   
* @FileName��        MyBlog      IUserService   
* @TODO��                    �û�ҵ���߼��ӿ�
* @author:     Mr Ryan
* @Date��                    2019��1��4�� ����3:36:54   
* @version:    1.0
* ------------------------------------------------
 */

public interface IUserService {
	
	/**
	 * @TODO ��֤�û��ĵ�¼��Ϣ
	 * @return User  ���ز�ѯ�����û���Ϣ
	 */
	public User login(User user);
	
	/**
	 * @TODO �û�ע��
	 * @return int   0Ϊע��ʧ�ܣ���0Ϊע��ɹ�
	 */
	public int register(User user);
	
	/**
	 * @TODO ��֤�û��Ƿ�ע���
	 * @return  bool  tureΪ�û����ڣ�falseΪ�û�������
	 */
	public boolean userExist(String user_name);
	
	/**
	 * @TODO ��֤�û������Ƿ�ע���
	 * @return  bool  tureΪ������ڣ�falseΪ���䲻����
	 */
	public boolean emailExist(String user_name);
	
	/**
	 * @TODO ��ȡ����
	 * @return String  �����û�����
	 */
	public String getPassword(String name);
	
	/**
	 * 
	 * @param text_id
	 * @return
	 */
	public String findTextName(int text_user_id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public User getUser(String name);

}
