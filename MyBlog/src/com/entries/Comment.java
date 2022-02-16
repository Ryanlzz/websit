package com.entries;

import java.sql.Timestamp;
import java.util.Date;

import net.sf.json.JSONObject;

/*
create table DB_Comment (评论表
	    comment_text_Id int NOT NULL,评论所在文章ID
	    comment_id int NOT NULL AUTO_INCREMENT,评论本身ID
	    comment_user_id int NOT NULL,写评论人的ID
	    comment_time DATETIME,评论时间
	    comment_cont text,评论内容
	    PRIMARY KEY(comment_Id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
public class Comment {
	
	private int comment_text_id;
	private int comment_user_id;
	private Timestamp comment_time;
	private int comment_id;
	private String comment_cont;
	
	public Comment(int comment_text_id,int comment_user_id,String comment_cont){
		this.comment_text_id = comment_text_id;
		this.comment_user_id = comment_user_id;
		this.comment_cont = comment_cont;
		//获取时间
		Date date = new Date();   
		//转化格式
		comment_time = new Timestamp(date.getTime()); 
	}
	
	
	public int getComment_text_id() {
		return comment_text_id;
	}
	public void setComment_text_id(int comment_text_id) {
		this.comment_text_id = comment_text_id;
	}
	public int getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(int comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public Timestamp getComment_time() {
		return comment_time;
	}
	public void setComment_time(Timestamp comment_time) {
		this.comment_time = comment_time;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_cont() {
		return comment_cont;
	}
	public void setComment_cont(String comment_cont) {
		this.comment_cont = comment_cont;
	}
	
	public String jsonStrByJavaBean(){
		JSONObject jsonObject = JSONObject.fromObject(this);
		return jsonObject.toString();
	}
	
	
}
