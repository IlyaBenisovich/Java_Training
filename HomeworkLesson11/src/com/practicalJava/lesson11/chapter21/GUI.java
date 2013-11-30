package com.practicalJava.lesson11.chapter21;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class GUI extends JFrame {
	
	private		JPanel 				windowContent;
    private 	BoxLayout			layoutManager;
    
    private		JPanel 				auxiliaryPanel;
    private 	FlowLayout			auxLayoutManager;
    
    private		JLabel				statusBar;
    private		MyJTextArea			leftTextArea;
    private		MyJTextArea			rightTextArea;

    private		JButton				buttonGetNews;
    
	public GUI(String title){	
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
		statusBar.setText("<HTML> <H1 align=center>	 Welcome <BR>"
													 + "to my<BR>"
										  + "MarketNewsReader<BR>"
		);
		windowContent.add(statusBar);
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		auxiliaryPanel   = new JPanel();
		auxLayoutManager = new FlowLayout();
		auxiliaryPanel.setLayout(auxLayoutManager);
		auxiliaryPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			
			leftTextArea = new MyJTextArea("Left text area.",10,40,"File 1");
			leftTextArea.setLineWrap(true);
			leftTextArea.setWrapStyleWord(true);		
			leftTextArea.setEditable(false);
			leftTextArea.setFocusable(false);
			auxiliaryPanel.add(leftTextArea);
			
	
			rightTextArea = new MyJTextArea("Right text area.",10,40,"File 2");
			rightTextArea.setLineWrap(true);
			rightTextArea.setWrapStyleWord(true);
			rightTextArea.setEditable(false);
			rightTextArea.setFocusable(false);
			auxiliaryPanel.add(rightTextArea);
			
		windowContent.add(auxiliaryPanel);	
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		buttonGetNews = new JButton("Get market news");
		buttonGetNews.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonGetNews.setFocusable(false);
		
		Engine  engine   = new Engine(this);
		buttonGetNews.addActionListener(engine.getButtonGetNewsAdapter());
		
		windowContent.add(buttonGetNews);
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		this.setContentPane(windowContent);
	}
	
	MyJTextArea getLeftAreaRef(){
		return leftTextArea;
	}
	
	void setDataInLefttArea(String data){
		leftTextArea.setText(data);
	}
	
	MyJTextArea getRightAreaRef(){
		return rightTextArea;
	}
	
	void setDataInRightArea(String data){
		rightTextArea.setText(data);
	}
}
