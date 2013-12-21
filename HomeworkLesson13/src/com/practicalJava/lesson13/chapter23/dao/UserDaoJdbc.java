package com.practicalJava.lesson13.chapter23.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.practicalJava.lesson13.chapter23.exception.DBSystemException;
import com.practicalJava.lesson13.chapter23.exception.NotUniqueUserEmailException;
import com.practicalJava.lesson13.chapter23.exception.NotUniqueUserLoginException;
import com.practicalJava.lesson13.chapter24.annotation.DBParam;

@DBParam(jdbcUrl = "jdbc:mysql://127.0.0.1:3306/production", 
login    = "user1", 
password = "password"
)

public class UserDaoJdbc implements UserDao {

	static {
		JdbcUtils.initDriver(UserDao.DRIVER_CLASS_NAME);
	}
	
	private Connection getConnection () throws DBSystemException{
		try{
			return DriverManager.getConnection(UserDao.JDBC_URL,
					UserDao.LOGIN, UserDao.PASSWORD);
		}catch(SQLException e){
			throw new DBSystemException("Can't create connection",e);
		}
	}
	
	
	@Override
	public int deleteById (int id) throws DBSystemException{
		Connection 		  conn = getConnection();
		PreparedStatement ps   = null;
		
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UserDao.DELETE_BY_ID_SQL);
			ps.setInt(1,id);
			
			int result = ps.executeUpdate();
			conn.commit();
			return result;
		}catch(SQLException e){
			JdbcUtils.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '" + 
					UserDao.DELETE_BY_ID_SQL +"'", e);
		}finally{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}	
	}
	
	@Override
	public List<User> selectAll() throws DBSystemException{
		Connection  conn 	  = getConnection();
		Statement   statement = null;
		ResultSet   rs 		  = null;
		
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			rs = statement.executeQuery(UserDao.SELECT_ALL_SQL);
			List<User> result = new ArrayList<>();
			while(rs.next()){
				int id = rs.getInt("id");
				String login = rs.getString("login");
				String email = rs.getString("email");
				User user = new User(id);
				user.setLogin(login);
				user.setEmail(email);
				result.add(user);
			}
			conn.commit();
			return result;
		}catch(SQLException e){
			JdbcUtils.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '" + 
					UserDao.SELECT_ALL_SQL +"'", e);
		}finally{
			JdbcUtils.closeQuietly(rs);
			JdbcUtils.closeQuietly(statement);
			JdbcUtils.closeQuietly(conn);
		}
	}
	
	@Override
	public void insert (User user) throws DBSystemException,NotUniqueUserLoginException,NotUniqueUserEmailException{
		Connection 		  conn = getConnection();
		PreparedStatement ps   = null;
		
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			
			if(existWithLogin0(conn,user.getLogin())){
				throw new NotUniqueUserLoginException ("Login '" + user.getLogin()+"'");
			}
			
			if(existWithEmail0(conn,user.getLogin())){
				throw new NotUniqueUserEmailException ("Email '" + user.getLogin()+"'");
			}
			
			ps = conn.prepareStatement(UserDao.INSERT_SQL);
			ps.setString(1,user.getLogin());
			ps.setString(2,user.getEmail());
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e){
			JdbcUtils.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '" +
					UserDao.DELETE_BY_ID_SQL +"'", e);
		}finally{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
	}
	
	@Override
	public void shutdown() throws DBSystemException{};
	
	
	
	private boolean existWithLogin0(Connection conn, String login) throws SQLException{
		PreparedStatement ps   = conn.prepareStatement(UserDao.SELECT_BY_LOGIN);
		ps.setString(1, login);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	private boolean existWithEmail0(Connection conn, String email) throws SQLException{
		PreparedStatement ps   = conn.prepareStatement(UserDao.SELECT_BY_EMAIL);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
}
