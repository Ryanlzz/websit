package com.entries;

import java.sql.Timestamp;
import java.util.Date;

import net.sf.json.JSONObject;

/*
create table DB_Comment (���۱�
	    comment_text_Id int NOT NULL,������������ID
	    comment_id int NOT NULL AUTO_INCREMENT,���۱���ID
	    comment_user_id int NOT NULL,д�����˵�ID
	    comment_time DATETIME,����ʱ��
	    comment_cont text,��������
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
		//��ȡʱ��
		Date date = new Date();   
		//ת����ʽ
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
