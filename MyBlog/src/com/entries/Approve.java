package com.entries;

/*
create table DB_Approve (点赞表
	    approve_user_id int NOT NULL,点赞人ID
	    approve_text_id int NOT NULL,点赞文章ID
	    approve_id int NOT NULL AUTO_INCREMENT,点赞自身ID
	    PRIMARY KEY(Text_Id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Approve {
	
	private int approve_user_id;
	private int approve_text_id;
	private int approve_id;
	
	public Approve(int approve_user_id,int approve_text_id){
		this.approve_user_id = approve_user_id;
		this.approve_text_id = approve_text_id;
	}
	public int getApprove_user_id() {
		return approve_user_id;
	}
	public void setApprove_user_id(int approve_user_id) {
		this.approve_user_id = approve_user_id;
	}
	public int getApprove_text_id() {
		return approve_text_id;
	}
	public void setApprove_text_id(int approve_text_id) {
		this.approve_text_id = approve_text_id;
	}
	public int getApprove_id() {
		return approve_id;
	}
	public void setApprove_id(int approve_id) {
		this.approve_id = approve_id;
	}
	
}
