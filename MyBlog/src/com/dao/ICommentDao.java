package com.dao;

import java.util.List;

import com.entries.Comment;


public interface ICommentDao {
	/**
	 * @TODO      д����
	 * @param     message
	 * @return    int
	 */
	public int addComment(Comment comment);
	/**
	 * @TODO      ��ȡ����
	 * @param     int
	 * @return    int
	 */
	public List<Comment> getComment(int text_id);
}
