package com.service;

import java.util.List;

import com.entries.Comment;



public interface ICommentService {
	/**  
	* @Title: �������
	* @Description:  0Ϊ����ʧ�� ����Ϊ���۳ɹ�
	* @param comment
	* @return int
	*/
	public int addComment(Comment comment);
	
	/**  
	* @Title: ��ȡ����
	* @Description:  0Ϊ��ȡ����ʧ�� ����Ϊ��ȡ���۳ɹ�
	* @param int
	* @return List<Comment>
	*/
	public List<Comment> getComment(int text_id);
}
