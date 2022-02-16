package com.entries;



/**   
* ------------------------------------------------   
* @FileName：        MyBlog      User   
* @TODO：                    用户类
* @author:     Mr Ryan
* @Date：                    2019年1月5日 上午9:05:55   
* @version:    1.0
* ------------------------------------------------        
*/
public class User {

	/**
	 * 用户个人信息
	 * 
	 * 用户名
	 * 密码
	 * 邮箱
	 * 用户id,唯一自增主键
	 * 头像
	 * 性别
	 * 签名
	 * 等级
	 */
	private String user_name;
	private String user_password;
	private String user_email;
	private int user_id;
	private int user_sex;
	private String user_sign;
	private int level;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param user_name
	 * @param user_password
	 */
	public User(String user_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
	}

	
	/**
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 */
	public User(String user_name, String user_password, String user_email) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
	}



	/**
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 * @param user_id
	 * @param user_avatar
	 * @param user_sex
	 * @param user_sign
	 * @param level
	 */
	public User(String user_name, String user_password, String user_email, int user_id, 
			int user_sex, String user_sign, int level) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_id = user_id;
		this.user_sex = user_sex;
		this.user_sign = user_sign;
		this.level = level;
	}

	/**
	 * 
	 * @return
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * 
	 * @param user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * 
	 * @return
	 */
	public String getUser_password() {
		return user_password;
	}

	/**
	 * 
	 * @param user_password
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * 
	 * @return
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * 
	 * @param user_email
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * 
	 * @return
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * 
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * 
	 * @return
	 */
	public int getUser_sex() {
		return user_sex;
	}

	/**
	 * 
	 * @param user_sex
	 */
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	/**
	 * 
	 * @return
	 */
	public String getUser_sign() {
		return user_sign;
	}

	/**
	 * 
	 * @param user_sign
	 */
	public void setUser_sign(String user_sign) {
		this.user_sign = user_sign;
	}

	/**
	 * 
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
}
