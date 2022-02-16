package com.service;

import java.util.List;

import com.entries.Comment;



public interface ICommentService {
	/**  
	* @Title: 添加评论
	* @Description:  0为评论失败 非零为评论成功
	* @param comment
	* @return int
	*/
	public int addComment(Comment comment);
	
	/**  
	* @Title: 获取评论
	* @Description:  0为获取评论失败 非零为获取评论成功
	* @param int
	* @return List<Comment>
	*/
	public List<Comment> getComment(int text_id);
}
