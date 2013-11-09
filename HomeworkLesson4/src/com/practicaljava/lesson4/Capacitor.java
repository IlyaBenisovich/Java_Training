package com.practicaljava.lesson4;

import java.util.Scanner;

	public class Capacitor extends PcbComponent implements Reservable{
		private static final int MAX_NUMBER_OF_CAPACITORS_IN_CELL = 50;
	
		public long 			capacistance;
		public int 				tolerance;
		
		public static int 		counter = 0;	
		
		private String convertCapacistanceToString(){
			StringBuffer retStr = new StringBuffer(10);
			
			int 		 micro 	= (int)(capacistance/1000000);
			
			int 		 nano	= (int)(capacistance - (micro * 1000000))/1000;
			
			int 		 pico  =  (int)(capacistance - (micro * 1000000) - (nano * 1000));
			
			
		
			if(micro > 0){
			  	retStr.append(micro);
				if(nano > 0){
					retStr.append(",");
					retStr.append(nano/100);	
			    }
				retStr.append(" uF");
			}else if(nano > 0){
				retStr.append(nano);
				if(pico > 0){
					retStr.append(",");
					retStr.append(pico/100);
				}
				retStr.append(" nF");
			}else{
				retStr.append(pico);
				retStr.append(" pF");
			}
			return retStr.toString();
		}
		
		public Capacitor(Scanner scanner, boolean overrideQuestions){
			super(scanner, overrideQuestions);
			
			Capacitor.counter++;
			type 			= "capacitor";	
			refdesPrefix	= "C";
			
			if(!overrideQuestions){
				System.out.printf("Enter the capacistanse value (in pF): ");
			}
			capacistance = getPositiveValue(scanner);
			
			if(!overrideQuestions){
				System.out.printf("Enter the tolerance value (in %%): ");
			}
			tolerance = getPositiveValue(scanner);		
		}
		
		
		public String toString (){
			return (
					name + " " + type + " " + enclosureType + " " + 
					convertCapacistanceToString() + " " + "+-" + tolerance + "%   " +
					"quantity in stock = " + quantityInStock + "  (box #" + 	
		            boxNumber + ", cell #" + cellNumber + ")"
		            );
		}
		
		
		@Override
		public Reservation_result bookItself(int amount) {
			// TODO Auto-generated method stub
			if(quantityInStock >= MAX_NUMBER_OF_CAPACITORS_IN_CELL){
				System.out.println("Not ordered. the cell is full.  Now there are "+
						quantityInStock +" capasitors");
				return Reservation_result.NOT_TO_BOOK_THE_CELL_IS_FULL;
			}
			
			int quantity = quantityInStock + amount;
			
			if(quantity > MAX_NUMBER_OF_CAPACITORS_IN_CELL)	
			{
				System.out.print("In stock not need as many (" + quantity +
						") capasitors. ");
				System.out.print("The maximum number of capasitors in the cell =" + 
						MAX_NUMBER_OF_CAPACITORS_IN_CELL + ", now there are "+
						quantityInStock +" capasitors");
				System.out.println(" It was ordered " + (MAX_NUMBER_OF_CAPACITORS_IN_CELL - 
						quantityInStock) + " " + name + "s " + "at the stock");
				quantityInStock =MAX_NUMBER_OF_CAPACITORS_IN_CELL;
				return Reservation_result.ORDERED_PARTIALLY;
			}else{
				System.out.println("It was ordered " + amount + " " + 
						name + "s " + "at the stock");
				quantityInStock += amount;
				return Reservation_result.ORDERED_FULLY;
			}
		}

}
