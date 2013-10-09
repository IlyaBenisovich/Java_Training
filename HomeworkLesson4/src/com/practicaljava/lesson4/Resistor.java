package com.practicaljava.lesson4;

import java.util.Scanner;

public class Resistor extends PcbComponent implements Reservable {

	static final int MAX_NUMBER_OF_RESISTOR_IN_CELL = 100;
	
	public int 		resistance;
	public int 		tolerance;
	public String 	enclosureType; 
	
	private int getPositiveValue (Scanner sc){
		int tempLengh		= 0;
		
		while(tempLengh == 0){
			if(sc.hasNextInt()){
				tempLengh = sc.nextInt();			
				if(tempLengh  < 0){
					System.out.printf("\nСледует ввести положительное значение  или 0: ");
					tempLengh = 0;
				}else{
					break;
				}
					
			}else if(sc.hasNextLine()){
				sc.next();									//очищаем строку ввода
				System.out.print("\nСледует ввести число а не строку\n" +
								 "Попробуйте еще раз: ");
			}
				
		}
		
		return tempLengh;
	}
	
	
	public Resistor(Scanner scanner){		
		this.type 			= "resistor";	
		this.refdesPrefix 	= "R";

		
		System.out.println("Enter the full name of PCB component:");
		if(scanner.hasNextLine()){
			this.name = scanner.next();	
		}
		
		System.out.printf("Enter the resistance value (in Ohm): ");
		this.resistance = getPositiveValue(scanner);
		
		System.out.printf("Enter the tolerance value: ");
		this.tolerance = getPositiveValue(scanner);		
	
	
		System.out.println("Enter the name of the manufacturer:");
		if(scanner.hasNextLine()){
			this.producer = scanner.next();	
		}
		
		System.out.println("Enter the enclosure type of " + this.type +" :");
		if(scanner.hasNextLine()){
			this.enclosureType = scanner.next();	
		}
		
		System.out.printf("Enter the number of " + this.type +"s  :");
		this.quantityInStock = getPositiveValue(scanner);			

		
		System.out.printf("Enter the box number: ");
		this.boxNumber =getPositiveValue(scanner);		
	
		
		System.out.printf("Enter the cell number: ");
		this.cellNumber = getPositiveValue(scanner);
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
