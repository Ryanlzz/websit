package com.dao;

import java.util.List;

import com.entries.Text;

/**
*
* @FileName：         ITextDao.java 
* @TODO：   	          文章dao层
* @author:     Z
* @Date：                       2019年1月7日 
* @version:    1.0
*
*/

public interface ITextDao {
	
	
	
	/**  
	* @Title: write  
	* @Description: 写文章
	* @param t
	* @return int
	*/
	public int write(Text text);

	
	/**  
	* @Title: search  
	* @Description: 检索文章
	* @param id
	* @return Text
	*/
	public Text search(int text_id);
	
	
	/**  
	* @Title: getAll  
	* @Description: 搜索所有文章
	* @param id
	* @return List<Text>
	*/
	public List<Text> getAll();
	
	
	/**  
	* @Title: getMy  
	* @Description: 搜索所有文章
	* @param id
	* @return List<Text>
	*/
	public List<Text> getMy(String username);
	
	
	/**  
	* @Title: textExist  
	* @Description: TODO
	* @param text_id
	* @return int
	*/
	public int textExist(int text_id);
	
}
