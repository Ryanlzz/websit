package com.daoimpl;

import com.dao.IApproveDao;
import com.entries.Approve;
import com.rock.util.JDBCUtil;

public class IApproveDaoImpl implements IApproveDao {
	
	JDBCUtil util;
	
	public IApproveDaoImpl(){
		util = new JDBCUtil();
		System.out.println("连接成功");
	}
	@Override
	public int addApprove(Approve approve) {
		
		String sql = "INSERT INTO DB_Approve (approve_text_id,approve_user_id)VALUES(?,?); ";
		
		int flag = util.runSql(sql, approve.getApprove_text_id(),approve.getApprove_user_id());
		
		return flag;
		
	}
	
	@Override
	public int approveText(Approve approve) {
		
		String sql = "UPDATE DB_Text SET text_approve_number = text_approve_number+1 WHERE text_id = ? ";
		
		int flag = util.runSql(sql, approve.getApprove_text_id());
		
		return flag;
		
	}
	
	@Override
	public int disApprove(Approve approve) {
		
		String sql = "DELETE FROM DB_Approve WHERE approve_textid = ? and approve_userid = ?; ";
		
		int flag = util.runSql(sql, approve.getApprove_text_id(),approve.getApprove_user_id());
		
		return flag;
		
	}
}
