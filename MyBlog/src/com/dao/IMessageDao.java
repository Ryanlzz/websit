package com.dao;

import java.util.List;

import com.entries.Message;

public interface IMessageDao {
	/**
	 * @TODO      д����
	 * @param     message
	 * @return    int
	 */
	public int addMessage(Message message);
	/**
	 * @TODO      ��ȡ����
	 * @param     int
	 * @return    int
	 */
	public List<Message> getMessage(int user_id);
	
}
