package com.practicalJava.lesson13.chapter23.dao;


import java.util.List;

import com.practicalJava.lesson13.chapter23.exception.DBSystemException;
import com.practicalJava.lesson13.chapter23.exception.NotUniqueUserEmailException;
import com.practicalJava.lesson13.chapter23.exception.NotUniqueUserLoginException;



public interface UserDao {
	String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/production";
	String LOGIN = "user1";
	String PASSWORD = "password";
	
	String SELECT_ALL_SQL = "SELECT id, login, email FROM User";
	String DELETE_BY_ID_SQL = "DELETE FROM User WHERE id=?";
	String INSERT_SQL = "INSERT INTO User (login, email) VALUES(?,?)";
	String SELECT_BY_LOGIN = "SELECT id FROM User WHERE login=?";
	String SELECT_BY_EMAIL = "SELECT id FROM User WHERE email=?";
	
	public List<User> selectAll() throws DBSystemException;
	
	public int deleteById (int id) throws DBSystemException;
	
	public void insert (User user) throws DBSystemException,
							NotUniqueUserLoginException,NotUniqueUserEmailException;
	
	public void shutdown() throws DBSystemException;
}
