package com.practicalJava.lesson8.chapter16;


public class MyZipReaderException extends Exception {
	public MyZipReaderException(String msg, Exception ex){
		super(msg,ex);
	}
}
