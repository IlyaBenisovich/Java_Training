package com.practicalJava.lesson11.chapter21;

public class NewsReaderExcepion extends Exception {
	
	private static final long serialVersionUID = 1L;

	NewsReaderExcepion(String msg, Exception cause){
		super(msg, cause);
	}
}
