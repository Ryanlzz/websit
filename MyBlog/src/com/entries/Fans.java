package com.entries;

/*
 * create table DB_Fans (粉丝表
    fans_user_id int NOT NULL,被粉人ID
    fans_fan_id int NOT NULL,粉丝ID
    fans_id int NOT NULL AUTO_INCREMENT,自身ID
    PRIMARY KEY(My_Id,fan_Id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Fans {
	
	private int fans_user_id;
	private int fans_fan_id;
	private int fans_id;
	
	public Fans(int fans_user_id,int fans_fan_id){
		this.fans_user_id = fans_user_id;
		this.fans_fan_id = fans_fan_id;
	}
	
	public int getFans_user_id() {
		return fans_user_id;
	}
	public void setFans_user_id(int fans_user_id) {
		this.fans_user_id = fans_user_id;
	}
	public int getFans_fan_id() {
		return fans_fan_id;
	}
	public void setFans_fan_id(int fans_fan_id) {
		this.fans_fan_id = fans_fan_id;
	}
	public int getFans_id() {
		return fans_id;
	}
	public void setFans_id(int fans_id) {
		this.fans_id = fans_id;
	}
	
	
}
