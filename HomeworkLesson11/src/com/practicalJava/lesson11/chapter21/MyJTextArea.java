package com.practicalJava.lesson11.chapter21;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MyJTextArea extends JTextArea {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitledBorder tb;
	
	public MyJTextArea (String text, int rows, int columns, String title){
		super(text,rows,columns);
		
		Border compound = BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(), 
				BorderFactory.createLoweredBevelBorder()
		);
	
		tb = BorderFactory.createTitledBorder(compound,title);
		this.setBorder(tb);
	}
	
	void setTitle(String data){
		tb.setTitle(data);
	}
}
