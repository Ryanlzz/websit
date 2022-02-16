package com.serviceimpl;

import java.util.List;

import com.dao.ICommentDao;
import com.daoimpl.ICommentDaoImpl;
import com.entries.Comment;
import com.service.ICommentService;

public class ICommentServiceImpl implements ICommentService {
	
	ICommentDao commentdao = new ICommentDaoImpl();
	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		int flag = commentdao.addComment(comment);
		return flag;
	}

	@Override
	public List<Comment> getComment(int text_id) {
		// TODO Auto-generated method stub
		List<Comment> list = commentdao.getComment(text_id);
		return list;
	}

}
