package com.practicalJava.lesson13.chapter23.exception;

public class NotUniqueUserEmailException extends DBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotUniqueUserEmailException(String msg){
		super(msg);
	}
	
	public NotUniqueUserEmailException(String msg, Exception cause){
		super(msg, cause);
	}
}
