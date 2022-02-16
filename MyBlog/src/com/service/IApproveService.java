package com.service;

import com.entries.Approve;

public interface IApproveService {
	/**  
	* @Title: approve  
	* @Description: TODO 0为添加点赞失败 非零为添加点赞成功
	* @param approve
	* @return int
	*/
	public int addApprove(Approve approve);

	/**  
	* @Title: approve  
	* @Description: TODO 0为点赞失败 非零为点赞成功
	* @param approve
	* @return int
	*/
	public int approveText(Approve approve);
	/**  
	* @Title: disApprove 
	* @Description: TODO 0为取消赞失败 非零为取消赞成功
	* @param approve
	* @return Text
	*/
	public int disApprove(Approve approve);
}
