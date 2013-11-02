package com.practicalJava.lesson7.bicycleShop;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.practicalJava.lesson7.bicycleShop.Bicycle.EBicycleType;

public class BicycleShopGUI implements ICommunicationData {
	
	private		JPanel 				windowContent;
    private 	BoxLayout			layoutManager;
    
    private		JPanel 				auxiliaryPanel;
    private 	FlowLayout			auxLayoutManager;
    
	private  	JLabel  			statusBar;
	private  	JLabel  			statusImage;
	private		ImageIcon			icon;
	private 	JComboBox<Bicycle>	typeChooser;
	
	private 	JTextField			numberIntroducer; 
	private static final int 		MAX_TEXT_FIELD_LENGTH = 4;
	
	private 	JButton				buttonOrder; 
		
   
	public BicycleShopGUI(){
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
														     + "bicycle shop<BR>"
		);
		
		
		windowContent.add(statusBar);
			
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		icon = new ImageIcon("resources/welcome01.gif");	
		statusImage = new  JLabel(icon);
		statusImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		statusImage.setAlignmentY(Component.CENTER_ALIGNMENT);
		statusImage.setPreferredSize(new Dimension(300, 300));
		windowContent.add(statusImage);
		
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		auxiliaryPanel   = new JPanel();
		auxLayoutManager = new FlowLayout();
		auxiliaryPanel.setLayout(auxLayoutManager);
		auxiliaryPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
			BicycleDataStorage dataBase = new BicycleDataStorage();
			BicycleShopEngine  engine   = new BicycleShopEngine(this, dataBase);
			
			dataBase.bicycleDatabase.insertElementAt(new  Bicycle("Choose the model"), 0);
			typeChooser = new JComboBox<Bicycle>(dataBase.bicycleDatabase);
			typeChooser.setEditable(false);
			typeChooser.setFocusable(false);
			typeChooser.addActionListener(engine.getComboBoxAdapter());
			auxiliaryPanel.add(typeChooser);
			
			
			numberIntroducer = new JTextField("0", 6);	
			numberIntroducer.setHorizontalAlignment(JTextField.RIGHT);
			numberIntroducer.addKeyListener(engine.getTextFieldAdapter());
			auxiliaryPanel.add(numberIntroducer);
			
		windowContent.add(auxiliaryPanel);
		
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		buttonOrder = new JButton("Make an order");
		buttonOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonOrder.setFocusable(false);
		buttonOrder.setEnabled(false);
		buttonOrder.addActionListener(engine.getButtonMakeOrderAdapter());
		windowContent.add(buttonOrder);
		
		windowContent.add(Box.createRigidArea(new Dimension(0,10)));
		
		//Создаём фрейм и задаём его основную панель
		JFrame frame = new JFrame("Searching phone number");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(windowContent);
	
		
		// делаем размер окна достаточным
		// для того, чтобы вместить все компоненты
		//frame.pack();
		frame.setSize(300,550);
		frame.setResizable(false);
		
		// Наконец, отображаем окно
		frame.setVisible(true);
	}
	
	public EBicycleType  getBicycleType(){
		Bicycle bike = (Bicycle)typeChooser.getSelectedItem();
		return bike.type;
	}
	
	public String 	getTextfromNumberField(){
		return numberIntroducer.getText();
	}
	
	public int  getMaxTextFieldLengh(){
		return MAX_TEXT_FIELD_LENGTH;
	}
	
	public 	void setImageInLabel(ImageIcon icon){
		statusImage.setIcon(icon);
	}
	
	public void setMessageInStausBar(String msg){
		statusBar.setText(msg);
	}
	
	public void removeChooseModelString(Vector<Bicycle>	 dataBase){
		dataBase.remove(0);
		buttonOrder.setEnabled(true);
	}
}
