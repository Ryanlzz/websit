package com.dao;

import java.util.List;

import com.entries.Fans;


public interface IFansDao {
	/**
	 * @TODO      ¹Ø×¢
	 * @param     fan
	 * @return    int
	 */
	public int addFans(Fans fan);
	/**
	 * @TODO      »ñÈ¡·ÛË¿
	 * @param     int
	 * @return    List<Fans>
	 */
	public List<Fans> getFans(int user_id);
}
