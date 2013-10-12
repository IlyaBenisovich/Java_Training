package com.practicaljava.lesson4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException; 

public class PcbComponent_storage {

	public static void main(String[] args) {
		
		ArrayList <PcbComponent>	pcbDatabase		= new ArrayList<PcbComponent>();
		File 					    file 			= new File("storage.txt");
		String       				s				= "";
		
	
	
		try{
			Scanner scanFile = new Scanner(file);
			
			System.out.println("The database were added the following components:");
			System.out.println("--------------------------------------------------------");
			while(scanFile.hasNext())
			{
				s = scanFile.nextLine();
				Scanner scanStr = new Scanner(s);
				

				switch(scanStr.next()){
					case "R":
					case "r":		
						pcbDatabase.add(new Resistor(scanStr,true));
						break;
						
					case "C":
					case "c":
						pcbDatabase.add(new Capacitor(scanStr,true));
						break;
						
					case "L":
					case "l":
						pcbDatabase.add(new Inductor(scanStr,true));
						break;	
						
					default:
						break;	
				}
				scanStr.close();
				
				System.out.println(pcbDatabase.get(pcbDatabase.size() - 1));
			}
			scanFile.close();	
			System.out.println("--------------------------------------------------------\n\n");
			
			
			System.out.println("I order book of " + args[0] + " pieces of each component to stock:\n");
			for(PcbComponent pcb:pcbDatabase){
				pcb.bookItself(Integer.parseInt(args[0]));
			}
			
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) {
//		
//		Scanner  sc_in = new Scanner(System.in);
//		Resistor r1    = new Resistor(sc_in, false);
//	
//		System.out.println(r1);
//		
//	}

}
