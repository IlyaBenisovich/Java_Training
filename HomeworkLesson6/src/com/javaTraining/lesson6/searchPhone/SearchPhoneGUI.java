package com.javaTraining.lesson6.searchPhone;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPhoneGUI implements IDataCommunication {
	private  	JTextField  displayField;
	private 	final int	DISPLAY_FIELD_LENGH = 20;
	
	public SearchPhoneGUI(){
		JPanel windowContent = new JPanel();
									
		GridBagLayout gbl = new GridBagLayout();
		windowContent.setLayout(gbl);
		
		displayField = new JTextField("");	
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		displayField.addKeyListener(new SearchPhoneKeyEventHandler(this));
		
		
		Component[] graphics = { new JLabel("Insert your phone number:"),								
								 new JButton("Get phone number"),	
								 displayField,
							   };
		
		((JButton)graphics[1]).addActionListener(new SearchPhoneActionEventHandler(this));

		for(Component primitive:graphics){
			primitive.setFont(new Font("Arial", Font.PLAIN, 20));
			if(primitive != displayField)
				primitive.setFocusable(false);
		}
		
		//---------Placing graphics primitives---------------
		GBC constraints = new GBC(0,0);	
		
		constraints.setInsets(10);
		windowContent.add(graphics[0], constraints);
		
		constraints.setPosition(0,2);
		windowContent.add(graphics[1],constraints); 
		
		constraints.setPosition(0,1);
		constraints.setFill(GridBagConstraints.HORIZONTAL);
		windowContent.add(graphics[2],constraints); 
		//--------------------------------------------------

		
		//Создаём фрейм и задаём его основную панель
		JFrame frame = new JFrame("Searching phone number");
		frame.setContentPane(windowContent);
	
		
		// делаем размер окна достаточным
		// для того, чтобы вместить все компоненты
		frame.pack();
		//frame.setSize(500,300);
		
		// Наконец, отображаем окно
		frame.setVisible(true);
		
		frame.addWindowListener( new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
			}
		});
	}
	
    public String getData(){
    	return displayField.getText();
    }
    
    public void   setData(String data){
    	displayField.setText(data);
    }
    
    public int	  getMaxDataLengh(){
    	return DISPLAY_FIELD_LENGH;
    }
	
}

