package com.practcalJava.lesson11.chapter20;

public class ClassB implements Runnable {

	private Updatable parrent;
	
	
	public ClassB(Updatable parrent) {
		this.parrent = parrent;
	}

	@Override
	public void run() {
		// Do some work, and get news from the markets.
		
		parrent.setData("Shares \"Apple\" went up by $ 15.");
		synchronized(parrent){
			parrent.notify();
		}
		
	}

}
