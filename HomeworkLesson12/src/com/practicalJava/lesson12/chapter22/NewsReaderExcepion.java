package com.practicalJava.lesson12.chapter22;

public class NewsReaderExcepion extends Exception {
	
	private static final long serialVersionUID = 1L;

	NewsReaderExcepion(String msg, Exception cause){
		super(msg, cause);
	}
}
