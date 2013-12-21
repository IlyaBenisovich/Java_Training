package com.practicalJava.lesson13.chapter23.exception;

public class DBSystemException extends DBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public DBSystemException(String msg){
		super(msg);
	}
	
	public DBSystemException(String msg, Exception cause){
		super(msg, cause);
	}
}
