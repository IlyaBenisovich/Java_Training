package com.practicalJava.lesson13.chapter23.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtils {
	private static boolean initialized = false;
	
	public static void initDriver (String name){
		if(!initialized){
			try{
				Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			}catch(Exception e){
				throw new  RuntimeException("Ошибка при попытке зарегистировать "
						+ "JDBC-driver:" + name,e);
			}
			initialized = true;
		}
	}

	public static void rollbackQuietly(Connection conn) {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
					conn.rollback();
			}
		}catch (SQLException e) {
		}
		
	}
	
	public static void closeQuietly(ResultSet rs) {
		// TODO Auto-generated method stub
		 try {
			 if (rs != null) {
				 rs.close();
			 }
		} catch (SQLException e) {
		}	
	}
	
	public static void closeQuietly(Statement stmt) {
		// TODO Auto-generated method stub
		 try {
			 if (stmt != null) {
				 stmt.close();
			 }
		} catch (SQLException e) {
		}	
	}

	public static void closeQuietly(PreparedStatement ps) {
		// TODO Auto-generated method stub
		 try {
			 if (ps != null) {
				 ps.close();
			 }
		} catch (SQLException e) {
		}	
	}
	
	public static void closeQuietly(Connection conn) {
		// TODO Auto-generated method stub
		 try {
			 if (conn != null) {
				 conn.close();
			 }
		} catch (SQLException e) {
		}	
	}
}
