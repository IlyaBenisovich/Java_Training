package com.practicaljava.lesson4;

import java.util.Scanner;

public class Resistor extends PcbComponent implements Reservable {

	static final int MAX_NUMBER_OF_RESISTOR_IN_CELL = 100;
	
	public int 		resistance;
	public int 		tolerance;
	public String 	enclosureType; 
	
	public Resistor(){
		Scanner 	scanner = new Scanner(System.in);
		
		this.type 			= "resistor";	
		this.refdesPrefix 	= "R";
		
		System.out.println("Enter the full name of PCB component:");
		if(scanner.hasNextLine()){
			this.name = scanner.next();	
		}
		
		System.out.printf("Enter the resistance value (in Ohm): ");
		if(scanner.hasNextInt()){
			this.resistance = scanner.nextInt();				
		}
		
		System.out.printf("Enter the tolerance value: ");
		if(scanner.hasNextInt()){
			this.tolerance = scanner.nextInt();				
		}
		
		
		System.out.println("Enter the name of the manufacturer:");
		if(scanner.hasNextLine()){
			this.producer = scanner.next();	
		}
		
		System.out.println("Enter the enclosure type of " + this.type +" :");
		if(scanner.hasNextLine()){
			this.enclosureType = scanner.next();	
		}
		
		System.out.printf("Enter the number of " + this.type +"s  :");
		if(scanner.hasNextInt()){
			this.quantityInStock = scanner.nextInt();				
		}
		
		System.out.printf("Enter the box number: ");
		if(scanner.hasNextInt()){
			this.boxNumber = scanner.nextInt();				
		}
		
		System.out.printf("Enter the cell number: ");
		if(scanner.hasNextInt()){
			this.cellNumber = scanner.nextInt();				
		}
		
		scanner.close();
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
