package com.javaTraining.lesson6.searchPhone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPhoneActionEventHandler implements ActionListener {
	SearchPhoneGUI parent;
	StringBuffer   phoneNumber; 
	
	
	SearchPhoneActionEventHandler(SearchPhoneGUI parent) {
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		phoneNumber = parsePhoneNumber(parent.getData());
		parent.setData(formatPhoneNumber(phoneNumber));	
	}

	
	
	
	// Выделяю строку символов из данных в поле формы
	StringBuffer parsePhoneNumber(String enteredData){
		StringBuffer 	outputData  = new StringBuffer(parent.getMaxDataLengh());
		char[] 			chArr 		= enteredData.toCharArray();
		
		for(int i=0; i< chArr.length; i++){
			if(Character.isDigit(chArr[i])){
				outputData.append(chArr[i]);
			}else if(chArr[i] == '+' && outputData.length() == 0){
				outputData.append(chArr[i]);
			}	
		}
		
		if(outputData.length() > 0){
			if(outputData.length()< 12 || outputData.length() > 13){
				if(outputData.charAt(0) == '+'){
					outputData.deleteCharAt(0);
				}
			}
		}
			
		
		return outputData;
	}
	
	
	
	
	// Форматирую  телефонный номер что бы в форме он выглядел красиво
	String formatPhoneNumber (StringBuffer source){
		int dataLengh = source.length();
		
		if		 (dataLengh < 2)					{return "Error: Too small number";
		}else if (dataLengh > 1 &&  dataLengh < 5)	{return	source.toString();
		}else if (dataLengh > 4 &&  dataLengh < 8)  {source.insert((source.length() -4), '-');
													 return source.toString();
		}else if (dataLengh > 7 &&  dataLengh < 11) {source.insert((source.length() -4), '-');
													 source.insert((source.length() -8), ')');
													 source.insert(0,                    '(');
													 return source.toString();
		}else if (dataLengh < 14)					{ 
													 source.insert((source.length() -4), '-');
													 source.insert((source.length() -8), ')');
		 											 source.insert((source.length() -12),'(');
		 											 return source.toString();		
		}else    								    {return "Error: Too long number"; 
		}
	}
}
