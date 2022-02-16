package com.serviceimpl;

import java.util.List;
import com.dao.IFansDao;
import com.daoimpl.IFansDaoImpl;
import com.entries.Fans;
import com.service.IFansService;

public class IFansServiceImpl implements IFansService {
	IFansDao fansdao = new IFansDaoImpl();
	@Override
	public int addFans(Fans fan) {
		// TODO Auto-generated method stub
		int flag = fansdao.addFans(fan);
		
		return flag;
	}

	@Override
	public List<Fans> getFans(int user_id) {
		// TODO Auto-generated method stub
		List<Fans> list = fansdao.getFans(user_id);
		return list;
	}

}
