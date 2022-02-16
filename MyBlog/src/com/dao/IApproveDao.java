package com.dao;

import com.entries.Approve;

public interface IApproveDao {
	/**  
	* @Title: approve
	* @Description: 添加点赞信息
	* @param approve
	* @return int
	*/
	public int addApprove(Approve approve);
	
	/**  
	* @Title: approve
	* @Description: 点赞文章
	* @param approve
	* @return int
	*/
	public int approveText(Approve approve);
	
	/**  
	* @Title: approve
	* @Description: 删除点赞信息
	* @param approve
	* @return int
	*/
	public int disApprove(Approve approve);
}
