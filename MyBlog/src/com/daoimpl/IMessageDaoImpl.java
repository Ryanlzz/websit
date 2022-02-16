package com.daoimpl;

import java.util.List;

import com.dao.IMessageDao;
import com.entries.Message;
import com.rock.util.JDBCUtil;

public class IMessageDaoImpl implements IMessageDao {

	JDBCUtil util;
	
	public IMessageDaoImpl(){
		util = new JDBCUtil();
		System.out.println("连接成功");
	}
	
	@Override
	public int addMessage(Message message) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO DB_Message (message_cont,message_time,message_user_id,message_writer_id) VALUES (?,?,?,?);";
		int flag = util.runSql(sql, message.getMessage_cont(),message.getMessage_time(),message.getMessage_user_id(),message.getMessage_writer_id());
		return flag;
	}

	@Override
	public List<Message> getMessage(int user_id) {
		// TODO Auto-generated method stub
		String sql = "select * from DB_Message where message_user_id=?";
		List<Message> list = util.queryAll(Message.class, sql, user_id);
		return list;
	}

}
