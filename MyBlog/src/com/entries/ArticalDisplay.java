package com.entries;

import java.util.Date;

public class ArticalDisplay {
	
	private String text_title;
	private String text_user_name;
	private String text_time;
	private String text_cont;
	
	
	public ArticalDisplay() {
		super();
	}
	
	public ArticalDisplay(String text_title, String text_user_name, String text_time, String text_cont) {
		super();
		this.text_title = text_title;
		this.text_user_name = text_user_name;
		this.text_time = text_time;
		this.text_cont = text_cont;
	}
	public String getText_title() {
		return text_title;
	}
	public void setText_title(String text_title) {
		this.text_title = text_title;
	}
	public String getText_user_name() {
		return text_user_name;
	}
	public void setText_user_name(String text_user_name) {
		this.text_user_name = text_user_name;
	}
	public String getText_time() {
		return text_time;
	}
	public void setText_time(String text_time) {
		this.text_time = text_time;
	}
	public String getText_cont() {
		return text_cont;
	}
	public void setText_cont(String text_cont) {
		this.text_cont = text_cont;
	}
	
	
}
