package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import bean.Userbean;

/**
 * DAO层
 */
public class UserDaoImpl implements IUserDao {
	
	private Connection conn;
	
	public UserDaoImpl(DataSource dataSource) {	
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存信息保存到数据库
	 */
	@Override
	public void save(Userbean user) throws SQLException {
		
		String sql = "insert into login (id,password) values(?,?)";
		
		try{
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,user.getId());
			pstm.setString(2,user.getPassword());
			pstm.execute();
           
        } catch(SQLException e) {
        	
            System.out.println(e.toString());
            e.printStackTrace();
            
        } finally {
        	
        	//conn.close();
        }

	}

	/**
	 * 修改数据库中信息
	 */
	@Override
	public void update(String id, Userbean user) throws SQLException {
		
		String sql = "update login set password=? where id=?";
        
        try{
			
        	PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getId());
            pstm.setString(2,user.getPassword());
            pstm.execute();
           
        } catch(SQLException e) {
        	
            System.out.println(e.toString());
            e.printStackTrace();
            
        } finally {
        	
        	//conn.close();
        }
	}

	/**
	 * 删除指定的数据库中的信息
	 */
	@Override
	public void delete(Userbean user) throws SQLException {
		
		String sql = "delete from login where id=?";

        try{
			
        	PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1,user.getId());
            pstm.execute();
           
        } catch(SQLException e) {
        	
            System.out.println(e.toString());
            e.printStackTrace();
            
        } finally {
        	
        	//conn.close();
        }
	}

	
	
	/**
	 * 返回指定的数据库中的信息
	 */
	@Override
	public boolean get(Userbean user) throws SQLException {
		
		String sql = "select * from login where id=? and password=?";
	        
        try{
			
        	PreparedStatement ps = conn.prepareStatement(sql);
 	        ps.setString(1,user.getId());
 	        ps.setString(2,user.getPassword());
 	        ResultSet rs = ps.executeQuery();
 	        if(rs.next()) {
 	        	return true;
 	        }	       
           
        } catch(SQLException e) {
        	
            System.out.println(e.toString());
            e.printStackTrace();
            
        } finally {
        	
        	//conn.close();
        }
		return false; 
	}
	
	
	/**
	 * 判断用户是否存在
	 */
	public boolean judgeid(String id) throws SQLException {
		
		String sql = "select id from login where id=?";
	        
        try{
			
        	PreparedStatement ps = conn.prepareStatement(sql);
 	        ps.setString(1,id);
 	        ResultSet rs = ps.executeQuery();
 	        if(rs.next()) {
 	        	return true;
 	        }	       
           
        } catch(SQLException e) {
        	
            System.out.println(e.toString());
            e.printStackTrace();
            
        } finally {
        	
        	//conn.close();
        }
		return false; 
	}
	    
}
