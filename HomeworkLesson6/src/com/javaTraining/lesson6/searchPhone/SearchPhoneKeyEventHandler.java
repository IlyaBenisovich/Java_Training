package com.javaTraining.lesson6.searchPhone;

import java.awt.event.KeyAdapter;

public class SearchPhoneKeyEventHandler extends KeyAdapter{
	private SearchPhoneGUI parent;
	
	SearchPhoneKeyEventHandler(SearchPhoneGUI parent){
		this.parent = parent;
	}
	
	public void keyTyped(java.awt.event.KeyEvent e) {
      String inputedData = parent.getData();
      if(inputedData.length() > (parent.getMaxDataLengh()- 1)){
    	  e.consume();
      }
    	 
    }
}
