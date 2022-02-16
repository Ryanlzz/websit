package com.service;

import com.entries.User;

/**
* ------------------------------------------------   
* @FileName：        MyBlog      IUserService   
* @TODO：                    用户业务逻辑接口
* @author:     Mr Ryan
* @Date：                    2019年1月4日 下午3:36:54   
* @version:    1.0
* ------------------------------------------------
 */

public interface IUserService {
	
	/**
	 * @TODO 验证用户的登录信息
	 * @return User  返回查询到的用户信息
	 */
	public User login(User user);
	
	/**
	 * @TODO 用户注册
	 * @return int   0为注册失败，非0为注册成功
	 */
	public int register(User user);
	
	/**
	 * @TODO 验证用户是否被注册过
	 * @return  bool  ture为用户存在，false为用户不存在
	 */
	public boolean userExist(String user_name);
	
	/**
	 * @TODO 验证用户邮箱是否被注册过
	 * @return  bool  ture为邮箱存在，false为邮箱不存在
	 */
	public boolean emailExist(String user_name);
	
	/**
	 * @TODO 获取密码
	 * @return String  返回用户密码
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
