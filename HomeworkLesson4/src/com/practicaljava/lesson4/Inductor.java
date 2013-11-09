package com.practicaljava.lesson4;

import java.util.Scanner;

public class Inductor extends PcbComponent implements Reservable {
	private static final int MAX_NUMBER_OF_INDUCTORS_IN_CELL = 50;

	public int 				inductance;
	public int 				tolerance;
	public int				resistance;
	public int				iDCMax;

	public static int 		counter = 0;
	
	private String convertInductanceToString(){
		StringBuffer retStr = new StringBuffer(10);
		
		int 		 mili 	= (int)(inductance/1000000);
		
		int 		 micro	= (int)(inductance - (mili* 1000000))/1000;
		
		int 		 nano   = (int)(inductance - (mili * 1000000) - micro * 1000);
		
		
	
		if(mili > 0){
		  	retStr.append(mili);
			if(micro > 0){
				retStr.append(",");
				retStr.append(micro/100);	
		    }
			retStr.append(" mH");
		}else{
			retStr.append(micro);
			if(nano > 0){
				retStr.append(",");
				retStr.append(nano/100);
			}
			retStr.append(" uH");
		}
		
		return retStr.toString();
	}
	
	
	public Inductor (Scanner scanner, boolean overrideQuestions){
		super(scanner, overrideQuestions);
		
		Inductor.counter++;
		type 			= "inductor";	
		refdesPrefix	= "L";
		
		if(!overrideQuestions){
			System.out.printf("Enter the Inductance value (in nF): ");
		}
		inductance = getPositiveValue(scanner);
		
		if(!overrideQuestions){
			System.out.printf("Enter the tolerance value (in %%): ");
		}
		tolerance = getPositiveValue(scanner);	
		
		if(!overrideQuestions){
			System.out.printf("Enter the resistance value (in mOhm): ");
		}
		resistance = getPositiveValue(scanner);
		
		if(!overrideQuestions){
			System.out.printf("Enter the I DC maximum  value (in mA): ");
		}
		iDCMax = getPositiveValue(scanner);
	}
	
	public String toString (){
		return (
				name + " " + type + " " + enclosureType + " " + 
				convertInductanceToString() + " " + "+-" + tolerance + "%   " +
				"quantity in stock = " + quantityInStock + "  (box #" + 	
	            boxNumber + ", cell #" + cellNumber + ")"
	            );
	}
	
	@Override
	public Reservation_result bookItself(int amount) {
		// TODO Auto-generated method stub
		if(quantityInStock >= MAX_NUMBER_OF_INDUCTORS_IN_CELL){
			System.out.println("Not ordered. the cell is full.  Now there are "+
					quantityInStock +" inductors");
			return Reservation_result.NOT_TO_BOOK_THE_CELL_IS_FULL;
		}
		
		int quantity = quantityInStock + amount;
		
		if(quantity > MAX_NUMBER_OF_INDUCTORS_IN_CELL)	
		{
			System.out.print("In stock not need as many (" + quantity +
					") capasitors. ");
			System.out.print("The maximum number of inductors in the cell =" + 
					MAX_NUMBER_OF_INDUCTORS_IN_CELL + ", now there are "+
					quantityInStock +" inductors");
			System.out.println(" It was ordered " + (MAX_NUMBER_OF_INDUCTORS_IN_CELL - 
					quantityInStock) + " " + name + "s " + "at the stock");
			quantityInStock = MAX_NUMBER_OF_INDUCTORS_IN_CELL;
			return Reservation_result.ORDERED_PARTIALLY;
		}else{
			System.out.println("It was ordered " + amount + " " + 
					name + "s " + "at the stock");
			quantityInStock += amount;
			return Reservation_result.ORDERED_FULLY;
		}
	}
}
