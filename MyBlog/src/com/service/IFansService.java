package com.service;

import java.util.List;

import com.entries.Fans;

public interface IFansService {
	/**  
	* @Title: ��ע����ӷ�˿��
	* @Description:  0Ϊ���ʧ�� ����Ϊ��ӳɹ�
	* @param fans
	* @return int
	*/
	public int addFans(Fans fan);
	
	/**  
	* @Title: ��ȡ��˿
	* @Description:  0Ϊ��ȡ��˿ʧ�� ����Ϊ��ȡ��˿�ɹ�
	* @param int
	* @return List<Fans>
	*/
	public List<Fans> getFans(int user_id);
}
