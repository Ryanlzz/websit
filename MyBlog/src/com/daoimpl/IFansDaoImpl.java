package com.daoimpl;

import java.util.List;
import com.dao.IFansDao;
import com.entries.Fans;
import com.rock.util.JDBCUtil;

public class IFansDaoImpl implements IFansDao {
	JDBCUtil util;
	
	public IFansDaoImpl(){
		util = new JDBCUtil();
		System.out.println("连接成功");
	}
	@Override
	public int addFans(Fans fan) {
		String sql = "INSERT INTO DB_Fans (fans_fan_id,fans_user_id)VALUES(?,?); ";
		
		int flag = util.runSql(sql, fan.getFans_fan_id(),fan.getFans_user_id());
		
		return flag;
		
	}

	@Override
	public List<Fans> getFans(int user_id) {
		// TODO Auto-generated method stub
		String sql = "select * from DB_Fans where fans_user_id=?";
		List<Fans> list = util.queryAll(Fans.class, sql, user_id);
		return list;
		
	}

}
