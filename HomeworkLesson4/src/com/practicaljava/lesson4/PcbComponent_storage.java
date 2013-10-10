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
			
			
			while(scanFile.hasNext())
			{
				s = scanFile.nextLine();
				Scanner scanStr = new Scanner(s);
				

				switch(scanStr.next()){
					case "R":
					case "r":		
						pcbDatabase.add(new Resistor(scanStr,true));
						break;
						
					default:
						break;	
				}
				scanStr.close();
				
				System.out.println(pcbDatabase.get(pcbDatabase.size() - 1));				
			}
			scanFile.close();				
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
