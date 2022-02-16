package com.dao;

import java.util.List;

import com.entries.Text;

/**
*
* @FileName��         ITextDao.java 
* @TODO��   	          ����dao��
* @author:     Z
* @Date��                       2019��1��7�� 
* @version:    1.0
*
*/

public interface ITextDao {
	
	
	
	/**  
	* @Title: write  
	* @Description: д����
	* @param t
	* @return int
	*/
	public int write(Text text);

	
	/**  
	* @Title: search  
	* @Description: ��������
	* @param id
	* @return Text
	*/
	public Text search(int text_id);
	
	
	/**  
	* @Title: getAll  
	* @Description: ������������
	* @param id
	* @return List<Text>
	*/
	public List<Text> getAll();
	
	
	/**  
	* @Title: getMy  
	* @Description: ������������
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
