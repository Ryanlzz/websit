package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Userbean;

/**
 * UserDaoK接口
 */
public interface IUserDao {
	
	/**
	 * 保存信息到数据库
	 * @param conn
	 * @param user
	 * @throws SQLException
	 */
	public void save(Userbean user) throws SQLException;
	/**
	 * 修改数据库中的信息
	 * @param conn
	 * @param id
	 * @param user
	 * @throws SQLException
	 */
    public void update(String id, Userbean user) throws SQLException;
    /**
     * 删除数据库中的信息
     * @param conn
     * @param user
     * @throws SQLException
     */
    public void delete(Userbean user) throws SQLException;
    /**
     * 检测信息
     * @param conn
     * @param user
     * @return 指定的数据
     * @throws SQLException
     */
    public boolean get(Userbean user) throws SQLException;

}
