package com.dao;

import java.util.List;

import com.entries.Comment;


public interface ICommentDao {
	/**
	 * @TODO      写评论
	 * @param     message
	 * @return    int
	 */
	public int addComment(Comment comment);
	/**
	 * @TODO      获取评论
	 * @param     int
	 * @return    int
	 */
	public List<Comment> getComment(int text_id);
}
