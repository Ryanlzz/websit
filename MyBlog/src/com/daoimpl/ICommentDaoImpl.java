package com.daoimpl;

import java.util.List;

import com.dao.ICommentDao;
import com.entries.Comment;
import com.rock.util.JDBCUtil;

public class ICommentDaoImpl implements ICommentDao {
	JDBCUtil util;
	
	public ICommentDaoImpl(){
		util = new JDBCUtil();
		System.out.println("连接成功");
	}
	@Override
	public int addComment(Comment comment) {
		String sql="INSERT INTO DB_Comment (comment_cont,comment_time,comment_user_id,comment_text_id) VALUES (?,?,?,?);";
		int flag = util.runSql(sql, comment.getComment_cont(),comment.getComment_time(),comment.getComment_user_id(),comment.getComment_text_id());
		return flag;
		
	}

	@Override
	public List<Comment> getComment(int text_id) {
		String sql = "select * from DB_Comment where comment_text_id=?";
		List<Comment> list = util.queryAll(Comment.class, sql, text_id);
		return list;
	}

}
