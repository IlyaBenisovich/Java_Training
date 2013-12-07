package com.practicalJava.lesson12.chapter22;

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
				leftReader = new NewsReader(parent.getLeftAreaRef(),2000,"employee");
			}catch(NewsReaderExcepion e1){
				e1.printStackTrace();
			}
			leftReader.execute();
			
			
				
			if(rightReader != null){
				rightReader.cancel(true);
			}
			parent.setDataInRightArea("");
			try{
				rightReader = new NewsReader(parent.getRightAreaRef(),1000,"marketData");	
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
