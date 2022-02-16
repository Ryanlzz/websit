/**
 * 
 */
package com.service;

import java.util.List;

import com.entries.Text;;

/**
 *
 * @FileName：         ITextService.java 
 * @TODO：   	    
 * @author:     Z
 * @Date：                       2019年1月7日 上午10:40:46
 * @version:    1.0
 *
 */

public interface ITextService {
	
	
	/**  
	* @Title: write  
	* @Description: TODO 0为插入失败 非零为插入成功
	* @param text
	* @return int
	*/
	public int write(Text text);

	
	/**  
	* @Title: search  
	* @Description: TODO
	* @param text_id
	* @return Text
	*/
	public Text search(int text_id);
	
	
	/**  
	* @Title: getAll  
	* @Description: TODO
	* @param user_id
	* @return List<Text>
	*/
	public List<Text> getAll();
	
	/**  
	* @Title: getMy 
	* @Description: TODO
	* @param user_id
	* @return List<Text>
	*/
	public List<Text> getMy(String username);
	
	/**  
	* @Title: textExist  
	* @Description: TODO
	* @param text_id
	* @return boolean
	*/
	public boolean textExist(int text_id);

}
