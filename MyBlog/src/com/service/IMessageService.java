package com.service;


import java.util.List;

import com.entries.Message;

public interface IMessageService {
		/**  
		* @Title: 添加留言
		* @Description:  0为留言失败 非零为留言成功
		* @param message
		* @return int
		*/
		public int addMessage(Message message);
		
		/**  
		* @Title: 获取留言
		* @Description:  0为获取留言失败 非零为获取留言成功
		* @param message
		* @return List<Message>
		*/
		public List<Message> getMessage(int user_id);
}
