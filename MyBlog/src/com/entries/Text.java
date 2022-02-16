package com.entries;

import java.util.Date;


import net.sf.json.JSONObject;

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
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/


public class Text {
	
	private String text_title;
	private int text_user_id;
	private Date text_time;
	private int text_id;
	private String text_cont;
	private int text_approve_number;
	private int text_read_number;
	private int text_comment_number;
	
	
	
	public Text() {
		super();
	}

	public Text(String text_title, int text_user_id, Date text_time, String text_cont) {
		super();
		this.text_title = text_title;
		this.text_user_id = text_user_id;
		this.text_time = text_time;
		this.text_cont = text_cont;
	}
	
	public String getText_title() {
		return text_title;
	}
	public void setText_title(String text_title) {
		this.text_title = text_title;
	}
	public int getText_user_id() {
		return text_user_id;
	}
	public void setText_user_id(int text_user_id) {
		this.text_user_id = text_user_id;
	}
	public Date getText_time() {
		return text_time;
	}
	public void setText_time(Date text_time) {
		this.text_time = text_time;
	}
	public int getText_id() {
		return text_id;
	}
	public void setText_id(int text_id) {
		this.text_id = text_id;
	}
	public String getText_cont() {
		return text_cont;
	}
	public void setText_cont(String text_cont) {
		this.text_cont = text_cont;
	}
	public int getText_approve_number() {
		return text_approve_number;
	}
	public void setText_approve_number(int text_approve_number) {
		this.text_approve_number = text_approve_number;
	}
	public int getText_read_number() {
		return text_read_number;
	}
	public void setText_read_number(int text_read_number) {
		this.text_read_number = text_read_number;
	}
	public int getText_comment_number() {
		return text_comment_number;
	}
	public void setText_comment_number(int text_comment_number) {
		this.text_comment_number = text_comment_number;
	}
	
	public String jsonStrByJavaBean(){
		JSONObject jsonObject = JSONObject.fromObject(this);
		return jsonObject.toString();
	}
	

}
