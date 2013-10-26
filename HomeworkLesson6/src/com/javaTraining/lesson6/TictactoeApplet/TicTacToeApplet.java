package com.javaTraining.lesson6.TictactoeApplet;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.Random;


public class TicTacToeApplet extends JApplet
{
    private static final String 	PLAYERX		= "Player X";
    private static final String  	PLAYERO 	= "Player O";
    private				 String  	playerName 	= PLAYERX;
    
    private 			 JLabel  	statusCell;
    private 			 JButton[] 	buttons;
    private 			 int[][]	lines 	    = { {0,1,2}, {3,4,5}, {6,7,8},
    												{0,3,6}, {1,4,7}, {2,5,8},
    												{0,4,8}, {2,4,6}
    };
    

    
    private  class TicTacToeEngine extends MouseAdapter{
    	public void mouseClicked(MouseEvent e) {
    		JButton currentButton = (JButton)e.getComponent();
    	    
			if (currentButton.getText() == ""){
    			if (playerName == PLAYERX) {
    				currentButton.setText("X");
    				statusCell.setText(PLAYERO);
    				playerName = PLAYERO;	
    			}
    			checkForWinner();
    			
    			int i=20;
    			while(i>0){
    				if(playerOTurn()){
    					break;
    				}
    				i--;
    			}
    		}
    	}
    	
    	private boolean playerOTurn(){
    		Random randomno = new Random();
    		int    i        = randomno.nextInt(8);
    		
    		if(buttons[i].getText()== ""){
    			buttons[i].setText("O");
    			statusCell.setText(PLAYERX);
	            playerName = PLAYERX; 
	            checkForWinner();
	            return true;
    		}	
    		return false;
    	}
    	
    	private void checkForWinner(){
    		int column = findThreeInARow();
	        if(column != -1 ){
	            String winnerName=(playerName == PLAYERX)?PLAYERO:PLAYERX;
	            statusCell.setText(winnerName + " won!!! Congratulations!!!");
	            
	            for(int row=0; row<lines[column].length; row++){
	            	buttons[lines[column][row]].setBackground(Color.GREEN);
	            }
	            
	            disableAllButtons();
	        }      
	    } 
    	
        private void disableAllButtons(){
        	for(JButton btn:buttons){
        		btn.setEnabled(false);
        	}
        }
       		      
    	private int findThreeInARow(){
	    	for(int i=0; i<lines.length; i++)
	    	{		
	    		if(buttons[lines[i][0]].getText() != ""){
	    			if(buttons[lines[i][0]].getText() ==  buttons[lines[i][1]].getText() &&
	    			   buttons[lines[i][1]].getText() ==  buttons[lines[i][2]].getText()){
	    				return i;
	    			}		
	    		}
	    	}
	    	return -1;
	    }
    }
    
   
   
    public void init(){
    	Panel 	highLevelPanel =  new Panel(); 
    	highLevelPanel.setLayout(new BoxLayout(highLevelPanel, BoxLayout.Y_AXIS));
    	
    	
    	Panel 	buttonsPanel =  new Panel(); 	
    	buttonsPanel.setLayout(new GridLayout(3, 3));
    	
    	JButton[] buttons_1    = {new JButton(), new JButton(),new JButton(),
    							  new JButton(), new JButton(),new JButton(),
    							  new JButton(), new JButton(),new JButton()			
    	};
    	buttons = buttons_1;
    	
    	
    	TicTacToeEngine  listener   = new  TicTacToeEngine();
    	Font			 buttonFont = new Font("Times New Roman", Font.PLAIN, 50);
    	
	    for(JButton btn:buttons){
	    	btn.setFont(buttonFont);
	    	btn.setFocusable(false);
	    	btn.setBackground((Color)null);
	    	btn.addMouseListener(listener);
	    	
	    	buttonsPanel.add(btn);
	    }
      
	    highLevelPanel.add(buttonsPanel);
	    
	    statusCell = new JLabel(playerName, SwingConstants.CENTER);
	    statusCell.setText(PLAYERX); 
	    highLevelPanel.add(statusCell);
	    statusCell.setAlignmentX(Component.CENTER_ALIGNMENT);
        
	    JButton buttonReset = new JButton("Reset");
	    highLevelPanel.add(buttonReset);
	    buttonReset.setAlignmentX(Component.CENTER_ALIGNMENT);
	    buttonReset.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e) {
	    		reset();
	    	}
	    });
        
        add(highLevelPanel);
    }
	
    private void reset(){
    	for(JButton btn:buttons){
    		btn.setText("");
    		btn.setBackground((Color)null);
    		btn.setEnabled(true);
    	}
    	statusCell.setText(PLAYERX);
    	playerName 	= PLAYERX;
    }
    

    
    
}