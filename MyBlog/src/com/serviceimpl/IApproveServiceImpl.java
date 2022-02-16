package com.serviceimpl;

import com.dao.IApproveDao;
import com.daoimpl.IApproveDaoImpl;
import com.entries.Approve;
import com.service.IApproveService;

public class IApproveServiceImpl implements IApproveService {
	
	IApproveDao approvedao = new IApproveDaoImpl();
	
	@Override
	public int addApprove(Approve approve) {
		// TODO Auto-generated method stub
		int flag = approvedao.addApprove(approve);
		return flag;
	}
	
	@Override
	public int approveText(Approve approve) {
		// TODO Auto-generated method stub
		int flag = approvedao.approveText(approve);
		return flag;
	}
	@Override
	public int disApprove(Approve approve) {
		// TODO Auto-generated method stub
		int flag = approvedao.disApprove(approve);
		return flag;
	}
}
