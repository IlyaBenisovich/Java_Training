package com.practicaljava.lesson19;

public class MailerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MailerException(String msg, Exception cause){
		super(msg, cause);
	}
}
