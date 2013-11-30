package com.practicalJava.lesson11.chapter21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;



public class Engine {
    private GUI parent;
    private NewsReader leftReader  = null;
    private NewsReader rightReader = null;
	
	Engine(GUI parent){
		this.parent = parent;
	}
	
	private class buttonGetNewsAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(leftReader != null){
				leftReader.cancel(true);
			}
			parent.setDataInLefttArea("");
			try{
				leftReader = new NewsReader("newsFile1.txt", "utf8",
					parent.getLeftAreaRef(),1000);	
			}catch(NewsReaderExcepion e1){
				e1.printStackTrace();
			}
			leftReader.execute();
			
			
				
			if(rightReader != null){
				rightReader.cancel(true);
			}
			parent.setDataInRightArea("");
			try{
				rightReader = new NewsReader("newsFile2.txt", "utf8",
						parent.getRightAreaRef(),2000);	
			}catch(NewsReaderExcepion e1){
				e1.printStackTrace();
			}
			rightReader.execute();
		
		}
	}
	
	public buttonGetNewsAdapter getButtonGetNewsAdapter(){
		return new buttonGetNewsAdapter();
	}
   
}
