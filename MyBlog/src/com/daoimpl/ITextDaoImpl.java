/**
 * 
 */
package com.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import com.dao.ITextDao;
import com.entries.Text;
import com.rock.util.JDBCUtil;

/**
 *
 * @FileName：         ITextDaoImpl.java 
 * @TODO：   	    
 * @author:     Z
 * @Date：                       2019年1月7日 上午10:07:38
 * @version:    1.0
 *
 */

public class ITextDaoImpl implements ITextDao{
	
	JDBCUtil util;
	
	public ITextDaoImpl(){
		util = new JDBCUtil();
		System.out.println("连接成功");
	}
	
	/*
	create table DB_Text (文章表
		    text_title varchar(80) NOT NULL,文章标题
		    text_user_id   int NOT NULL,文章作者ID
		    text_time DATETIME,文章时间
		    text_id int NOT NULL AUTO_INCREMENT,文章ID
		    text_cont text,文章内容
		    text_approve_number int,文章点赞数
		    text_read_number int,文章阅读数
		    text_comment_number int,文章评论数
		    PRIMARY KEY(text_Id)
		)ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
	
	
	
	/**  
	* @Title: write  
	* @Description: TODO
	* @param text
	* @return int
	*/
	@Override
	public int write(Text text) {
		// TODO Auto-generated method stub
		String sql = "insert into DB_Text(text_title,text_user_id,text_time,text_cont) values(?,?,?,?) ";
		Timestamp temp = new Timestamp(text.getText_time().getTime());
		int flag = util.runSql(sql, text.getText_title(),text.getText_user_id(),temp,text.getText_cont());
		return flag;
	}
	
	
	/**  
	* @Title: search  
	* @Description: TODO
	* @param text_id
	* @return Text
	*/
	@Override
	public Text search(int text_id) {
		// TODO Auto-generated method stub
		String sql = "select * from DB_Text where text_id=?";
		Text text = util.queryById(Text.class, sql, text_id);
		return text;
	}
	
	
	@Override
	public List<Text> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from DB_Text";
		List<Text> list = util.queryAll(Text.class, sql);
		return list;
	}
	
	@Override
	public List<Text> getMy(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM DB_Text WHERE text_user_id = (select user_id FROM DB_User WHERE user_name = ?)";
		List<Text> list = util.queryAll(Text.class, sql,username);
		return list;
	}

	@Override
	public int textExist(int text_id) {
		// TODO Auto-generated method stub
		String sql = "select * from DB_Text where text_id=?";
		int flag = util.runSql(sql, text_id);
		return flag;
	}
}
