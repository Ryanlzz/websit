package com.service;

import com.entries.Approve;

public interface IApproveService {
	/**  
	* @Title: approve  
	* @Description: TODO 0Ϊ��ӵ���ʧ�� ����Ϊ��ӵ��޳ɹ�
	* @param approve
	* @return int
	*/
	public int addApprove(Approve approve);

	/**  
	* @Title: approve  
	* @Description: TODO 0Ϊ����ʧ�� ����Ϊ���޳ɹ�
	* @param approve
	* @return int
	*/
	public int approveText(Approve approve);
	/**  
	* @Title: disApprove 
	* @Description: TODO 0Ϊȡ����ʧ�� ����Ϊȡ���޳ɹ�
	* @param approve
	* @return Text
	*/
	public int disApprove(Approve approve);
}
