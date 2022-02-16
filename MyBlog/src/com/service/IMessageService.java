package com.service;


import java.util.List;

import com.entries.Message;

public interface IMessageService {
		/**  
		* @Title: �������
		* @Description:  0Ϊ����ʧ�� ����Ϊ���Գɹ�
		* @param message
		* @return int
		*/
		public int addMessage(Message message);
		
		/**  
		* @Title: ��ȡ����
		* @Description:  0Ϊ��ȡ����ʧ�� ����Ϊ��ȡ���Գɹ�
		* @param message
		* @return List<Message>
		*/
		public List<Message> getMessage(int user_id);
}
