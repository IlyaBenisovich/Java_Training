package com.practicalJava.lesson13.chapter23;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MyJTableGUI extends JFrame{
	
	private		JPanel 				windowContent;
    private 	BoxLayout			layoutManager;
    private		JLabel				statusBar;
    
    private     JScrollPane			scroller;
    private 	UserTableModel	    userTableModel;
    private		JTable				userTable;
    

    public MyJTableGUI(String title){
    	super(title);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	windowContent = new JPanel();
		layoutManager = new BoxLayout(windowContent,BoxLayout.Y_AXIS);
		windowContent.setLayout(layoutManager);
		
		statusBar = new  JLabel();
		statusBar.setAlignmentX(Component.CENTER_ALIGNMENT);
		statusBar.setAlignmentY(Component.TOP_ALIGNMENT);
		statusBar.setHorizontalAlignment(JLabel.CENTER);
		statusBar.setPreferredSize(new Dimension(200, 100));
		statusBar.setText("<HTML> <H1 align=center, color=blue>"
												  + "Welcome <BR>"
													 + "to my<BR>"
										    + "UserDataRenderer<BR>"
		);
		windowContent.add(statusBar);
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		userTableModel = new UserTableModel();
		userTable	   = new JTable(userTableModel);
		
		scroller       = new JScrollPane(userTable);
		scroller.setPreferredSize(new Dimension(200,200));
		windowContent.add(scroller);
		
	
		this.setContentPane(windowContent);
    }
}
