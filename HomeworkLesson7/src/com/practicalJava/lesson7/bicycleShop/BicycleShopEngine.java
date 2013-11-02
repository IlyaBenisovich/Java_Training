package com.practicalJava.lesson7.bicycleShop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;

import com.practicalJava.lesson7.bicycleShop.Bicycle.EBicycleType;

public class BicycleShopEngine{
	private BicycleShopGUI     parent;
	private BicycleDataStorage dataStorage;
	
	BicycleShopEngine(BicycleShopGUI parent, BicycleDataStorage dataStorage){
		 this.parent 		= parent;
		 this.dataStorage 	= dataStorage;
	}
	
	private  class TextFieldAdapter extends KeyAdapter{
		public void keyTyped(java.awt.event.KeyEvent e) {
		      String inputedData = parent.getTextfromNumberField();
		      if(inputedData.length() > (parent.getMaxTextFieldLengh()- 1)){
		    	  e.consume();
		      }else{
		    	  char a = e.getKeyChar();
		    	  if (!Character.isDigit(a) && (a != '\b')) {
		            e.consume();
		          }
		      }
		      
		    	 
		    }
	}
	
	public TextFieldAdapter getTextFieldAdapter(){
		return new TextFieldAdapter();
	}
	
	
	
	private class ComboBoxAdapter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			parent.removeChooseModelString(dataStorage.bicycleDatabase);
			EBicycleType typeFromGUI = parent.getBicycleType();
			
			for(Bicycle bike: dataStorage.bicycleDatabase){
				if(bike.type == typeFromGUI){
					parent.setImageInLabel(bike.getImage());
					parent.setMessageInStausBar("<HTML>Overall dimensions: "+ bike.getDimetions() +"<BR>"
							+ "Price: <b>" + bike.getPrice() + "$</b><BR>"
							+ "<i><font size = -2>(We can deliver " +bike.getMaxCountInOrder()+ " at a time)"
							+ "</font></i>");
					break;
				}
			}
		}

    }
	
	public ComboBoxAdapter getComboBoxAdapter(){
		return new ComboBoxAdapter();
	}
	
	
	private class ButtonMakeOrderAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int countBicycleInOrder  = Integer.parseInt(parent.getTextfromNumberField());
			if(countBicycleInOrder == 0)
				return;
			
			EBicycleType typeFromGUI = parent.getBicycleType();
			
			try{
				for(Bicycle bike: dataStorage.bicycleDatabase){
					if(bike.type == typeFromGUI){
						if(countBicycleInOrder > bike.getMaxCountInOrder()){
							throw new TooManyBikesException(bike.getMaxCountInOrder(),countBicycleInOrder);
						}else{
							parent.setMessageInStausBar("<HTML> <font color = green>We have taken your order: "+ bike 
									+" * " + countBicycleInOrder + "<BR>"
									+ "Ñost of the order: <b>" + bike.getPrice() * countBicycleInOrder + "$</b><BR>"
									+ "<i><font size = -2>(We will deliver your order within two days)"
									+ "</font></i></font>");
						}
							
					}
				}
			}catch(TooManyBikesException ex){
				 parent.setMessageInStausBar("<HTML><font color= red>Oops."
					 		+ " You ordered too many bikes ("+ex.info.requestedNumberOfBikes+").<BR>"
					 		+ "We can not bring them all at once.<BR>"
					 		+ "Please break your order into several ( less " 
					 		+ (ex.info.maxBikesInOrder+1) +")." );
				 
				 parent.setImageInLabel(new ImageIcon("resources/too_much.gif"));
			}
			
		}		
	}
	
	public ButtonMakeOrderAdapter getButtonMakeOrderAdapter(){
		return new ButtonMakeOrderAdapter();
	}
		
}
