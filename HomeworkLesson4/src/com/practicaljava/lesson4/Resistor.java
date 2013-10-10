package com.practicaljava.lesson4;

import java.util.Scanner;

public class Resistor extends PcbComponent implements Reservable {

	private static final int MAX_NUMBER_OF_RESISTOR_IN_CELL = 100;
	
	public int 				resistance;
	public int 				tolerance;

	public static int 		counter = 0;
	

	
		
	private String convertResistancetoString(){
		StringBuffer retStr = new StringBuffer(10);
		int 		 mega 	=  resistance/1000000;
		int 		 kilo	= (resistance - (mega * 1000000))/1000;
		int 		 units  =  resistance - (mega * 1000000) - (kilo * 1000);
		
		if(mega > 0){
			retStr.append(mega);
			if(kilo > 0){
				retStr.append(",");
				retStr.append(kilo/100);	
			}
			retStr.append(" MOhm");
		 }else if(kilo > 0){
			retStr.append(kilo);
			if(units > 0){
					retStr.append(",");
					retStr.append(units/100);
			}
			retStr.append(" КOhm");
		 }else{
			 retStr.append(units);
			 retStr.append(" Ohm");
		 }
		
		 return retStr.toString();
	}
	
	
	
	public Resistor(Scanner scanner, boolean overrideQuestions){
		super(scanner, overrideQuestions);
		
		Resistor.counter++;
		type 			= "resistor";	
		refdesPrefix	= "R";
		
		if(!overrideQuestions){
			System.out.printf("Enter the resistance value (in Ohm): ");
		}
		resistance = getPositiveValue(scanner);
		
		if(!overrideQuestions){
			System.out.printf("Enter the tolerance value (in %%): ");
		}
		tolerance = getPositiveValue(scanner);		
	}
	
	
	public String toString (){
		return (
				name + " " + type + " " + enclosureType + " " + 
	            convertResistancetoString() + " " + "+-" + tolerance + "%   " +
				"quantity in stock = " + quantityInStock + "  (box #" + 	
	            boxNumber + ", cell #" + cellNumber + ")"
	            );
	}
	

	@Override
	public int bookItself(int amount) {
		// TODO Auto-generated method stub
		int quantity = this.quantityInStock + amount;
		
		if(quantity > MAX_NUMBER_OF_RESISTOR_IN_CELL)	
		{
			System.out.println("In stock not need as many (" + quantity +
					           ") resistors.");
			System.out.println("The maximum number of resistors s cell =" + 
					MAX_NUMBER_OF_RESISTOR_IN_CELL + ", now there are "+
					this.quantityInStock +" resistors");
			return (MAX_NUMBER_OF_RESISTOR_IN_CELL - this.quantityInStock);
		}
		else
		{
			this.quantityInStock += amount;
			return 0;
		}
	}

}
