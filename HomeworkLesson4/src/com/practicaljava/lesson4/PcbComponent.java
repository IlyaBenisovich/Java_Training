package com.practicaljava.lesson4;

import java.util.Scanner;

public class PcbComponent  implements Reservable {
		static int quantiyDifferentTypes; 
		
		protected String 		name;
		protected String 		type;
		protected String 		refdesPrefix;
		protected String 		producer;
		protected int 			quantityInStock;
		protected int 			boxNumber;
		protected int 			cellNumber;
		public String 			enclosureType; 
		//double 					dissipationPower;
		
		
		protected int getPositiveValue (Scanner sc){
			int tempLengh		= 0;
			
			while(tempLengh == 0){
				if(sc.hasNextInt()){
					tempLengh = sc.nextInt();			
					if(tempLengh  < 0){
						System.out.printf("\nYou must enter a positive value or 0: ");
						tempLengh = 0;
					}else{
						break;
					}
						
				}else if(sc.hasNextLine()){
					sc.next();									//очищаем строку ввода
					System.out.print("\nYou must enter the number, not a string\n" +
									 "Try again: ");
				}
					
			}
			
			return tempLengh;
		}
		
		
		protected PcbComponent(Scanner scanner, boolean overrideQuestions){
			
//			if(!overrideQuestions){
//				System.out.println("Enter the reference designator prefix :");
//			}
//			if(scanner.hasNextLine()){
//				refdesPrefix = scanner.next();	
//			}
			
			if(!overrideQuestions){
				System.out.println("Enter the full name of PCB component:");
			}
			if(scanner.hasNextLine()){
				name = scanner.next();	
			}
			
			if(!overrideQuestions){
				System.out.println("Enter the name of the manufacturer:");
			}
			
			if(scanner.hasNextLine()){
				producer = scanner.next();	
			}
				
			if(!overrideQuestions){
				System.out.println("Enter the enclosure type of PCB component :");
			}
			if(scanner.hasNextLine()){
				enclosureType = scanner.next();	
			}
			
			if(!overrideQuestions){
				System.out.printf("Enter the number of PCB components  :");
			}
			quantityInStock = getPositiveValue(scanner);			

			if(!overrideQuestions){
				System.out.printf("Enter the box number: ");
			}
			boxNumber =getPositiveValue(scanner);		
		
			if(!overrideQuestions){
				System.out.printf("Enter the cell number: ");
			}
			cellNumber = getPositiveValue(scanner);
		}
		
		public Reservation_result bookItself(int amount) {
			return null;
		}
		
}
