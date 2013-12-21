package com.practicalJava.lesson13.chapter23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class MyJTableEngine {
	private MyJTableGUI parent;
	
	public MyJTableEngine (MyJTableGUI parent){
		this.parent = parent;
	}
	
	private class buttonGetUsersAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public buttonGetUsersAdapter getButtonGetNewsAdapter(){
		return new buttonGetUsersAdapter();
	}
}
