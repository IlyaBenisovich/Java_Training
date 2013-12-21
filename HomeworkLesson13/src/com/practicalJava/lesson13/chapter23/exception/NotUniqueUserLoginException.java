package com.practicalJava.lesson13.chapter23.exception;

public class NotUniqueUserLoginException extends DBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotUniqueUserLoginException(String msg){
		super(msg);
	}
	
	public NotUniqueUserLoginException(String msg, Exception cause){
		super(msg, cause);
	}
}
