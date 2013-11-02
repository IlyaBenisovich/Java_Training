package com.practicalJava.lesson7.bicycleShop;

import javax.swing.ImageIcon;

import com.practicalJava.lesson7.bicycleShop.Bicycle.EBicycleType;
public interface ICommunicationData {
	
	EBicycleType  getBicycleType();
	String 		  getTextfromNumberField();
	int 		  getMaxTextFieldLengh();
	
	void 		  setImageInLabel(ImageIcon icon);
	void 		  setMessageInStausBar(String msg);	
}
