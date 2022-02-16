package com.service;

import java.util.List;

import com.entries.Fans;

public interface IFansService {
	/**  
	* @Title: 关注（添加粉丝）
	* @Description:  0为添加失败 非零为添加成功
	* @param fans
	* @return int
	*/
	public int addFans(Fans fan);
	
	/**  
	* @Title: 获取粉丝
	* @Description:  0为获取粉丝失败 非零为获取粉丝成功
	* @param int
	* @return List<Fans>
	*/
	public List<Fans> getFans(int user_id);
}
