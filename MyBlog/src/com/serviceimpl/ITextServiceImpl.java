/**
 * 
 */
package com.serviceimpl;

import java.util.List;

import com.dao.ITextDao;
import com.daoimpl.ITextDaoImpl;
import com.entries.Text;
import com.service.ITextService;

/**
 *
 * @FileName：         ITextServiceImpl.java 
 * @TODO：   	    
 * @author:     Z
 * @Date：                       2019年1月7日 上午10:44:24
 * @version:    1.0
 *
 */

public class ITextServiceImpl implements ITextService{
	
	ITextDao textdao = new ITextDaoImpl();

	@Override
	public int write(Text text) {
		// TODO Auto-generated method stub
		int flag = textdao.write(text);
		return flag;
	}

	@Override
	public Text search(int text_id) {
		// TODO Auto-generated method stub
		Text text = textdao.search(text_id);
		return text;
	}

	@Override
	public List<Text> getAll() {
		// TODO Auto-generated method stub
		List<Text> list = textdao.getAll();
		return list;
	}
	
	@Override
	public List<Text> getMy(String username) {
		// TODO Auto-generated method stub
		List<Text> list = textdao.getMy(username);
		return list;
	}
	@Override
	public boolean textExist(int text_id) {
		// TODO Auto-generated method stub
		boolean textExist=false;
		int flag = textdao.textExist(text_id);
		if(flag==0) textExist=true;
		return textExist;
	}
	
}
