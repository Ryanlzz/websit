package com.daoimpl;

import com.dao.IUserDao;
import com.entries.User;
import com.rock.util.JDBCUtil;


/**   
* ------------------------------------------------   
* @FileName：        MyBlog      IUserDaoImpl   
* @TODO：   	         实现关于用户个人信息的数据库的操作（增删改查）
* @author:     Mr Ryan
* @Date：                    2019年1月4日 下午3:51:18   
* @version:    1.0
* ------------------------------------------------        
*/
public class IUserDaoImpl implements  IUserDao{
	
	JDBCUtil util;
	
	public IUserDaoImpl(){
		util = new JDBCUtil();
		System.out.println("连接成功");
	}
	@Override
	public User login(User user) {
		String sql = "select * from DB_User where user_name=? and user_password=?";
		User u = util.queryById(User.class, sql, user.getUser_name(),user.getUser_password());
		return u;
	}
	
	@Override
	public int register(User user) {
		String sql = "insert into DB_User(user_name,user_password,user_email) values(?,?,?)";
		int flag = util.runSql(sql, user.getUser_name(),user.getUser_password(),user.getUser_email());
		return flag;
	}
	@Override
	public int userExist(String user_name) {
		String sql = "select count(*) from DB_User where user_name=?";
		int flag = util.getCount(sql, user_name);
		return flag;
	}
	@Override
	public int emailExist(String user_email) {
		String sql = "select count(*) from DB_User where user_email=?";
		int flag = util.getCount(sql, user_email);
		return flag;
	}
	@Override
	public String getPassword(String name) {
		String sql = "select user_password from DB_User where user_name = ?";
		User u= util.queryById(User.class,sql, name);
		return u.getUser_password();
	}
	@Override
	public String findTextName(int text_user_id) {
		String sql = "select * from DB_User where user_id = ?";
		User u = util.queryById(User.class,sql, text_user_id);
		return u.getUser_name();
	}
	
	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from DB_User where user_name = ?";
		User u = util.queryById(User.class,sql, name);
		return u;
	}
}
