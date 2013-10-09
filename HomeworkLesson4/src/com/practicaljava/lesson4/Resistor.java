package com.practicaljava.lesson4;

import java.util.Scanner;

public class Resistor extends PcbComponent implements Reservable {

	static final int MAX_NUMBER_OF_RESISTOR_IN_CELL = 100;
	
	public int 		resistance;
	public int 		tolerance;
	public String 	enclosureType; 
	
	public Resistor(){
		super(type,refdesPrefix,producer,quantityInStock,boxNumber,cellNumber);
		
		String 		type;
		String 		refdesPrefix;
		String 		producer;
		int 		quantityInStock;
		int 		boxNumber;
		int 		cellNumber;
		
		
		Scanner 	scanner = new Scanner(System.in);
		
		System.out.println("Enter the type of PCB component:");
		if(scanner.hasNextLine()){
			type = scanner.next();	
		}
		
		System.out.println("Enter the prefix of PCB component:");
		if(scanner.hasNextLine()){
			refdesPrefix = scanner.next();	
		}
		
		System.out.println("Enter the name of the manufacturer:");
		if(scanner.hasNextLine()){
			producer = scanner.next();	
		}
		
		System.out.printf("Enter the number of PCB componen: ");
		if(scanner.hasNextInt()){
			quantityInStock = scanner.nextInt();				
		}
		
		System.out.printf("Enter the box number: ");
		if(scanner.hasNextInt()){
			boxNumber = scanner.nextInt();				
		}
		
		System.out.printf("Enter the cell number: ");
		if(scanner.hasNextInt()){
			cellNumber = scanner.nextInt();				
		}
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
