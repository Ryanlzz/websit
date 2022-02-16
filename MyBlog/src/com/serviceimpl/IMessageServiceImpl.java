package com.serviceimpl;

import java.util.List;


import com.dao.IMessageDao;
import com.daoimpl.IMessageDaoImpl;
import com.entries.Message;
import com.service.IMessageService;

public class IMessageServiceImpl implements IMessageService {
	IMessageDao messagedao = new IMessageDaoImpl();
	
	
	@Override
	public int addMessage(Message message) {
		// TODO Auto-generated method stub
		int flag = messagedao.addMessage(message);
		return flag;
	}

	@Override
	public List<Message> getMessage(int user_id) {
		// TODO Auto-generated method stub
		List<Message> list = messagedao.getMessage(user_id);
		return list;
	}

}
