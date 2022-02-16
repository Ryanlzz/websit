package com.dao;

import com.entries.User;


/**   
* ------------------------------------------------   
* @FileName��        MyBlog      IUserDao   
* @TODO��                    
* @author:     Mr Ryan
* @Date��                    2019��1��8�� ����9:17:08   
* @version:    1.0
* ------------------------------------------------        
*/
public interface IUserDao {

	/**
	 * @TODO:     �û���¼
	 * @param:    user
	 * @return    User
	 */
	public User login(User user);
	
	/**
	 * @TODO      �û�ע��
	 * @param     user
	 * @return    int
	 */
	public int register(User user);
	
	/**
	 * @TODO ��֤�û��Ƿ�ע���
	 * @return  int  0Ϊ����ע�ᣬ1Ϊ�ѱ�ע��
	 */
	public int userExist(String user_name);
	
	/**
	 * @TODO ��֤�û������Ƿ�ע���
	 * @return  int  0Ϊ����ע�ᣬ1Ϊ�ѱ�ע��
	 */
	public int emailExist(String user_email);
	
	/**
	 * @TODO      ��ȡ�û�����
	 * @param     user
	 * @return    String �����û����� 
	 */
	public String getPassword(String name);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String findTextName(int text_user_id);
	
	/**
	 * @TODO      ��ȡ�û�
	 * ��ȡ�û��������뷵�������û���Ϣ
	 * @param     user
	 * @return    User �����û�
	 */
	public User getUser(String name);


}
