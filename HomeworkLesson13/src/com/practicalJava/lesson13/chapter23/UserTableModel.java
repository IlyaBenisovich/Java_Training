package com.practicalJava.lesson13.chapter23;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.practicalJava.lesson13.chapter23.dao.User;
import com.practicalJava.lesson13.chapter23.dao.UserDao;
import com.practicalJava.lesson13.chapter23.dao.UserDaoDbcp;
import com.practicalJava.lesson13.chapter23.dao.UserDaoJdbcCachedConn;
import com.practicalJava.lesson13.chapter23.exception.DBException;


public class UserTableModel extends AbstractTableModel {
	
	UserDao dao;
	
	UserTableModel(){
		//dao = new UserDaoJdbc(); 
		//dao = new UserDaoJdbcCachedConn(); 
		dao = new UserDaoDbcp(); 
	}
	
	
	@Override
	public int getColumnCount() {
		Class<User> clazz = User.class;
		Field[] field_arr = clazz.getDeclaredFields();

		return field_arr.length;
	}
	
	@Override 
	public String getColumnName(int col){
		Class<User> clazz = User.class;
		Field[] field_arr = clazz.getDeclaredFields();
		
		return field_arr[col].getName().toUpperCase();
	}

	@Override
	public int getRowCount() {
		int result = 0;
		try{
			result = dao.selectAll().size();
		}catch(DBException e){
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object result = null;
		
		try{
			List<User> users = dao.selectAll();
			switch(arg1){
			case 0:
				result =  users.get(arg0).getId();
				break;
			case 1:
				result =  users.get(arg0).getLogin();
				break;	
			case 2:
				result =  users.get(arg0).getEmail();
				break;		
			}

		}catch(DBException e){
			e.printStackTrace();
		}
		
		
		return result;
	}

}
