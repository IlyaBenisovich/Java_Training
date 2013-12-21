package com.practicalJava.lesson13.chapter23.exception;

public class DBException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	DBException(String msg){
		super(msg);
	}
	
	DBException(String msg, Exception cause){
		super(msg, cause);
	}
}
