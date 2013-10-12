package com.practicaljava.lesson4;

import java.util.Scanner;

public class Resistor extends PcbComponent {

	private static final int MAX_NUMBER_OF_RESISTOR_IN_CELL = 100;
	
	public int 				resistance;
	public int 				tolerance;

	public static int 		counter = 0;
	

	
		
	private String convertResistanceToString(){
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
	            convertResistanceToString() + " " + "+-" + tolerance + "%   " +
				"quantity in stock = " + quantityInStock + "  (box #" + 	
	            boxNumber + ", cell #" + cellNumber + ")"
	            );
	}
	

	@Override
	public Reservation_result bookItself(int amount) {
		// TODO Auto-generated method stub
		
		if(quantityInStock >= MAX_NUMBER_OF_RESISTOR_IN_CELL){
			System.out.println("Not ordered. the cell is full.  Now there are "+
					quantityInStock +" resistors");
			return Reservation_result.NOT_TO_BOOK_THE_CELL_IS_FULL;
		}
					
		int quantity = quantityInStock + amount;
		
		if(quantity > MAX_NUMBER_OF_RESISTOR_IN_CELL)	
		{
			System.out.print("In stock not need as many (" + quantity +
					           ") resistors.");
			System.out.print(" The maximum number of resistors in the cell =" + 
					MAX_NUMBER_OF_RESISTOR_IN_CELL + ", now there are "+
					quantityInStock +" resistors");
			System.out.println(" It was ordered " + (MAX_NUMBER_OF_RESISTOR_IN_CELL - 
					quantityInStock) + " " + name + "s " + "at the stock");
			quantityInStock = MAX_NUMBER_OF_RESISTOR_IN_CELL;
			return Reservation_result.ORDERED_PARTIALLY;
		}else{
			System.out.println("It was ordered " + amount + " " + 
					name + "s " + "at the stock");
			quantityInStock += amount;
			return Reservation_result.ORDERED_FULLY;
		}
	}

}
