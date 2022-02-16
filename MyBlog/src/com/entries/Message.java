package com.entries;


import java.sql.Timestamp;
import java.util.Date;

import net.sf.json.JSONObject;

/*
create table DB_Message (���Ա�
	    message_writer_id int NOT NULL,д�����˵�ID
	    message_id int NOT NULL AUTO_INCREMENT,��������ID
	    message_user_id int NOT NULL,����ID
	    message_time DATETIME,����ʱ��
	    message_cont text,��������
	    PRIMARY KEY(Message_Id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/


public class Message {
	
	private int message_writer_id;
	private int message_id;
	private int message_user_id;
	private Timestamp message_time;
	private String message_cont;
	
	public Message(int message_writer_id,int message_user_id,String message_cont){
		this.message_writer_id = message_writer_id;
		this.message_user_id = message_user_id;
		this.message_cont = message_cont;
		//��ȡʱ��
		Date date = new Date();   
		//ת����ʽ
		message_time = new Timestamp(date.getTime()); 
		
	}
	
	
	public int getMessage_writer_id() {
		return message_writer_id;
	}

	public void setMessage_writer_id(int message_writer_id) {
		this.message_writer_id = message_writer_id;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getMessage_user_id() {
		return message_user_id;
	}

	public void setMessage_user_id(int message_user_id) {
		this.message_user_id = message_user_id;
	}

	public Timestamp getMessage_time() {
		return message_time;
	}

	public void setMessage_time(Timestamp message_time) {
		this.message_time = message_time;
	}

	public String getMessage_cont() {
		return message_cont;
	}

	public void setMessage_cont(String message_cont) {
		this.message_cont = message_cont;
	}
	
	public String jsonStrByJavaBean(){
		JSONObject jsonObject = JSONObject.fromObject(this);
		return jsonObject.toString();
	}

	
}
