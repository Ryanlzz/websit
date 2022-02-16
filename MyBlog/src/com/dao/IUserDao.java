package com.dao;

import com.entries.User;


/**   
* ------------------------------------------------   
* @FileName：        MyBlog      IUserDao   
* @TODO：                    
* @author:     Mr Ryan
* @Date：                    2019年1月8日 上午9:17:08   
* @version:    1.0
* ------------------------------------------------        
*/
public interface IUserDao {

	/**
	 * @TODO:     用户登录
	 * @param:    user
	 * @return    User
	 */
	public User login(User user);
	
	/**
	 * @TODO      用户注册
	 * @param     user
	 * @return    int
	 */
	public int register(User user);
	
	/**
	 * @TODO 验证用户是否被注册过
	 * @return  int  0为可以注册，1为已被注册
	 */
	public int userExist(String user_name);
	
	/**
	 * @TODO 验证用户邮箱是否被注册过
	 * @return  int  0为可以注册，1为已被注册
	 */
	public int emailExist(String user_email);
	
	/**
	 * @TODO      获取用户密码
	 * @param     user
	 * @return    String 返回用户密码 
	 */
	public String getPassword(String name);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String findTextName(int text_user_id);
	
	/**
	 * @TODO      获取用户
	 * 获取用户名和密码返回整个用户信息
	 * @param     user
	 * @return    User 返回用户
	 */
	public User getUser(String name);


}
