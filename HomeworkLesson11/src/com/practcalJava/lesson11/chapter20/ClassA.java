package com.practcalJava.lesson11.chapter20;

public class ClassA implements Updatable{
	private String marketNews = null;
	
	public void someWork(){
		Thread maretNewsGetter = new Thread(new ClassB(this)); 
		
		 maretNewsGetter.start();
		 synchronized (this) {
			try{
				wait();
			}catch(InterruptedException e){/* NOP */}
		}
		 System.out.println(marketNews);
	}
	
	
	public void setData(String source){
		marketNews = source;
	}
}
