package com.practicalJava.lesson7.bicycleShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Vector;


public class BicycleDataStorage {
	Vector<Bicycle>	 bicycleDatabase	= new Vector<Bicycle>(10);
	BicycleDataStorage(){
		Scanner scanFile = null;
		try{
			scanFile = new Scanner(new File(IBycicleDataConstraints.storagePath));
			while(scanFile.hasNext())
			{
				String s = scanFile.nextLine();
				Scanner scanStr = new Scanner(s);
				
				bicycleDatabase.add(new Bicycle(scanStr));
			}
			
		}catch(BicycleDataProcessingExceptions e1){
			e1.printStackTrace();		
		}catch(FileNotFoundException e2){
			e2.printStackTrace();
		}catch(IllegalStateException e3){
			e3.printStackTrace();
		}finally{
			scanFile.close();
		}
		
	}
}
