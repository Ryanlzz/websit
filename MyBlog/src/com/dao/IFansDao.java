package com.dao;

import java.util.List;

import com.entries.Fans;


public interface IFansDao {
	/**
	 * @TODO      ��ע
	 * @param     fan
	 * @return    int
	 */
	public int addFans(Fans fan);
	/**
	 * @TODO      ��ȡ��˿
	 * @param     int
	 * @return    List<Fans>
	 */
	public List<Fans> getFans(int user_id);
}
