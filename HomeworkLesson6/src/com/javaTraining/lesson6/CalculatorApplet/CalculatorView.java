package com.javaTraining.lesson6.CalculatorApplet;

import javax.swing.*;

import java.awt.*;


public class CalculatorView extends JApplet {
	JPanel 		windowContent;
	JTextField 	displayField;
	JButton 	buttonClear;
	JButton 	buttonMR;
	JButton 	buttonMC;
	JButton 	buttonMPlus;
	
	JButton 	button0;
	JButton 	button1;
	JButton 	button2;
	JButton 	button3;
	JButton 	button4;
	JButton 	button5;
	JButton 	button6;
	JButton 	button7;
	JButton 	button8;
	JButton 	button9;
	JButton 	buttonPlusMinus;
	JButton 	buttonPoint;
	
	JButton 	buttonDivide;
	JButton 	buttonMultiply;
	JButton 	buttonDiff;
	JButton 	buttonSum;
	
	JButton 	buttonSqrt;
	JButton 	buttonPersent;
	JButton 	buttonHyperbole;
	JButton 	buttonEqual;

	
	private Insets setInsetsValues(
									Insets  target,
									int 	top, 
									int 	left,
									int 	bottom,
									int 	right
								  ){
		target.top 	  = top;
		target.left   = left;
		target.bottom = bottom;
		target.right  = right;	
		return target;
	}


	public void init(){
		
		displayField 			= new JTextField("0.",6);
		
		buttonClear	 			= new JButton("C");
		buttonMR	 			= new JButton("MR");
		buttonMC	 			= new JButton("MC");
		buttonMPlus				= new JButton("M+");
		
		button0		 			= new JButton(" 0 ");
		button1		 			= new JButton(" 1 ");
		button2		 			= new JButton(" 2 ");
		button3		 			= new JButton(" 3 ");
		button4		 			= new JButton(" 4 ");
		button5		 			= new JButton(" 5 ");
		button6		 			= new JButton(" 6 ");
		button7		 			= new JButton(" 7 ");
		button8		 			= new JButton(" 8 ");
		button9		 			= new JButton(" 9 ");
		buttonPlusMinus			= new JButton("+/-");
		buttonPoint				= new JButton(" . ");
		
		buttonDivide			= new JButton(" / ");
		buttonMultiply			= new JButton(" * ");
		buttonDiff	 			= new JButton(" - ");
		buttonSum	 			= new JButton(" + ");
		
		buttonSqrt	 			= new JButton("sqrt");
		buttonPersent			= new JButton(" %  ");
		buttonHyperbole			= new JButton(" 1/x");
		buttonEqual				= new JButton(" =  ");

		
		displayField.setFocusable(false);
		buttonClear.setFocusable(false);
		buttonMR.setFocusable(false);
		buttonMC.setFocusable(false);
		buttonMPlus.setFocusable(false);
		
		button0.setFocusable(false);
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		button5.setFocusable(false);
		button6.setFocusable(false);
		button7.setFocusable(false);
		button8.setFocusable(false);
		button9.setFocusable(false);
		buttonPlusMinus.setFocusable(false);
		buttonPoint.setFocusable(false);
		
		buttonDivide.setFocusable(false);
		buttonMultiply.setFocusable(false);
		buttonDiff.setFocusable(false);
		buttonSum.setFocusable(false);
		
		buttonSqrt.setFocusable(false);
		buttonPersent.setFocusable(false);
		buttonHyperbole.setFocusable(false);
		buttonEqual.setFocusable(false);

		windowContent	 	   = new JPanel();
		GridBagLayout gl 	   = new GridBagLayout();
		windowContent.setLayout(gl);
		
		GridBagConstraints gbc = new GridBagConstraints();		
		Insets 			   ins = new Insets(0,0,0,0);
				
		gbc.ipadx		= 20;
		gbc.fill		= GridBagConstraints.BOTH; 
		gbc.gridx		= 0;
		gbc.gridy		= 0;
		gbc.ipadx		= 20;
		gbc.insets 		= setInsetsValues(ins,7,7,0,7);
		gbc.gridwidth 	= GridBagConstraints.REMAINDER;
		
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		displayField.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	          char a = e.getKeyChar();
	          //if (!Character.isDigit(a) && (a != '.') && (a != '\b')) {
	            e.consume();
	          //}
	        }
	      });
		windowContent.add(displayField,gbc); 
		gbc.ipadx		= 0;
		
	
		gbc.fill 		= gbc.fill=GridBagConstraints.BOTH;
		gbc.gridwidth 	= 1;
		gbc.gridx		= 0;
		gbc.gridy		= 1;
		gbc.insets 		= setInsetsValues(ins,8,7,5,9);
		windowContent.add(buttonClear,gbc); 
		

	
		
		gbc.gridy		= GridBagConstraints.RELATIVE;
		gbc.insets 		= setInsetsValues(ins,0,7,2,9);
		windowContent.add(buttonMPlus,gbc);
		windowContent.add(buttonMR,gbc);
		gbc.insets 		= setInsetsValues(ins,0,7,9,9);
		windowContent.add(buttonMC,gbc);
		
		gbc.gridx		= 2;
		gbc.insets 		= setInsetsValues(ins,7,0,2,2);
		windowContent.add(button7,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,2,2);
		windowContent.add(button4,gbc);
		windowContent.add(button1,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,7,2);
		windowContent.add(button0,gbc);
		
		gbc.gridx		= 3;
		gbc.insets 		= setInsetsValues(ins,7,0,2,2);
		windowContent.add(button8,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,2,2);
		windowContent.add(button5,gbc);
		windowContent.add(button2,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,7,2);
		windowContent.add(buttonPlusMinus,gbc);
		
		gbc.gridx		= 4;
		gbc.insets 		= setInsetsValues(ins,7,0,2,2);
		windowContent.add(button9,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,2,2);
		windowContent.add(button6,gbc);
		windowContent.add(button3,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,7,2);
		windowContent.add(buttonPoint,gbc);
		
		gbc.gridx		= 5;
		gbc.insets 		= setInsetsValues(ins,7,0,2,2);
		windowContent.add(buttonDivide,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,2,2);
		windowContent.add(buttonMultiply,gbc);
		windowContent.add(buttonDiff,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,7,2);
		windowContent.add(buttonSum,gbc);
		
		gbc.gridx		= 6;
		gbc.insets 		= setInsetsValues(ins,7,0,2,7);
		windowContent.add(buttonSqrt,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,2,7);
		windowContent.add(buttonPersent,gbc);
		windowContent.add(buttonHyperbole,gbc);
		gbc.insets 		= setInsetsValues(ins,0,0,7,7);
		windowContent.add(buttonEqual,gbc);
		
		
		
		CalculatorEngine calcEngine= new CalculatorEngine(this);
		buttonClear.addActionListener(calcEngine);
		
		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);
		
		buttonDivide.addActionListener(calcEngine);
		buttonMultiply.addActionListener(calcEngine);
		buttonDiff.addActionListener(calcEngine);
		buttonSum.addActionListener(calcEngine);
		
		buttonEqual.addActionListener(calcEngine);
		
		buttonPoint.addActionListener(calcEngine);
		buttonPlusMinus.addActionListener(calcEngine);
		
		buttonSqrt.addActionListener(calcEngine);
		buttonPersent.addActionListener(calcEngine);
		buttonHyperbole.addActionListener(calcEngine);
		
		buttonMPlus.addActionListener(calcEngine);	
		buttonMC.addActionListener(calcEngine);
		buttonMR.addActionListener(calcEngine);	
		
		
		add(windowContent);
		
//		//Создаём фрейм и задаём его основную панель
//		JFrame frame = new JFrame("Calculator");
//		frame.setContentPane(windowContent);
//		
//		// делаем размер окна достаточным
//		// для того, чтобы вместить все компоненты
//		frame.pack();
//		
//		// Наконец, отображаем окно
//		frame.setVisible(true);
	}
	
   public void setDisplayValue(String val){
	   displayField.setText(val);
   }

   public String getDisplayValue() {
       return displayField.getText();
   } 

   public void showThatTheMemoryContainsData(){
	   buttonMPlus.setBackground(Color.GREEN);
	   buttonMR.setBackground	(Color.GREEN);
	   buttonMC.setBackground	(Color.RED);
   }
	
   public void showThatTheMemoryEmpty(){
	   Color bg = buttonClear.getBackground();
	   
	   buttonMPlus.setBackground(bg);
	   buttonMR.setBackground	(bg);
	   buttonMC.setBackground	(bg);
   }
	
}
