package com.dao;

import com.entries.Approve;

public interface IApproveDao {
	/**  
	* @Title: approve
	* @Description: ��ӵ�����Ϣ
	* @param approve
	* @return int
	*/
	public int addApprove(Approve approve);
	
	/**  
	* @Title: approve
	* @Description: ��������
	* @param approve
	* @return int
	*/
	public int approveText(Approve approve);
	
	/**  
	* @Title: approve
	* @Description: ɾ��������Ϣ
	* @param approve
	* @return int
	*/
	public int disApprove(Approve approve);
}
