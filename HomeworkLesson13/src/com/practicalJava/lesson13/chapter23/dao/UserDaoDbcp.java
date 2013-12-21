package com.practicalJava.lesson13.chapter23.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.practicalJava.lesson13.chapter23.exception.DBSystemException;
import com.practicalJava.lesson13.chapter23.exception.NotUniqueUserEmailException;
import com.practicalJava.lesson13.chapter23.exception.NotUniqueUserLoginException;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.impl.GenericObjectPool;


public class UserDaoDbcp extends UserDaoJdbc{
	static {
		JdbcUtils.initDriver(UserDao.DRIVER_CLASS_NAME);
	}
	
	private GenericObjectPool connectionPool;
	
	public  UserDaoDbcp(){
		// Creates an instance of GenericObjectPool that holds our
        // pool of connections object.
        //
        connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(10);
        
		// Creates a connection factory object which will be use by
        // the pool to create the connection object. We passes the
        // JDBC url info, username and password.
        //
        ConnectionFactory cf = new DriverManagerConnectionFactory(
        		UserDao.JDBC_URL,
        		UserDao.LOGIN,
        		UserDao.PASSWORD);
        
        
        // Creates a PoolableConnectionFactory that will wraps the
        // connection object created by the ConnectionFactory to add
        // object pooling functionality.
        //
        PoolableConnectionFactory pcf =
                new PoolableConnectionFactory(cf   , connectionPool,
                		                      null , null, 
                		                      false, false);     
        //
        // Finally, we create the PoolingDriver itself...
        //
        
        try {
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
		} catch (ClassNotFoundException e) {
			throw new  RuntimeException("Ошибка при попытке загрузить класс "
					+ "org.apache.commons.dbcp.PoolingDriver",e);
		}
        PoolingDriver driver = null;
        try{
        	driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
		}catch(SQLException e){
			throw new  RuntimeException("Ошибка при попытке получить"
					+ "jdbc:apache:commons:dbcp:",e);
		}
        
        //
        // ...and register our pool with it.
        //
        driver.registerPool("example",connectionPool);
        
	}
	
	
	private Connection getConnection () throws DBSystemException{
		try{
			return  DriverManager.getConnection("jdbc:apache:commons:dbcp:example");
		}catch(SQLException e){
			throw new DBSystemException("Can't create connection",e);
		}
	}
	
	
	@Override
	public void shutdown() throws DBSystemException{
		PoolingDriver driver = null;
		
		try{
			driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.closePool("example");
		}catch(SQLException e2){
			throw new DBSystemException("Ошибка при закрытии драйвера пула-" +
						"jdbc:apache:commons:dbcp:example", e2);
	
		}
		
	}
	
	
}
