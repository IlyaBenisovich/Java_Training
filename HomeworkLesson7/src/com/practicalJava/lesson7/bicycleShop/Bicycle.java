package com.practicalJava.lesson7.bicycleShop;

import java.util.Scanner;

import javax.swing.ImageIcon;

public class Bicycle {
	
	private double 			length;
	private double 			width;
	private double 			height;
	private double 			price;

	private int 			wheelSize;
	private int             maxCountInOrder;
	
	private ImageIcon		image;
	
	enum EBicycleType{
		BMXBIKE,
		CITYBIKE,
		CROSSBIKE,
		CRUISERBIKE,
		FOLDINGBIKE,
		KIDSBIKE,
		ROADBIKE,
		TRACKBIKE,
		TOURNINGBIKE
	}
	public  EBicycleType	type;
	
	protected String		typeName;
	
	
	public Bicycle(String typeName){
		length    = 0.0;
		width     = 0.0;
		height    = 0.0;
		
		wheelSize = 0;
		image     = null;
		type      = null;
		
		this.typeName  = typeName;
	}
	
	
	public Bicycle(Scanner scanner) throws BicycleDataProcessingExceptions{
		if(scanner.hasNextLine()){
			typeName = scanner.next();	
			
			switch(typeName){
			case "bmxbike":
				type = EBicycleType.BMXBIKE;
				break;
			
			case "citybike":
				type = EBicycleType.CITYBIKE;
				break;
				
			case "crossbike":
				type = EBicycleType.CROSSBIKE;
				break;
				
			case "cruiserbike":
				type = EBicycleType.CRUISERBIKE;
				break;
				
			case "foldingbike":
				type = EBicycleType.FOLDINGBIKE;
				break;	
				
			case "kidsbike":
				type = EBicycleType.KIDSBIKE;
				break;	
				
			case "roadbike":
				type = EBicycleType.ROADBIKE;
				break;	
				
			case "touringbike":
				type = EBicycleType.TOURNINGBIKE;
				break;
				
			case "trekbike":
				type = EBicycleType.TRACKBIKE;
				break;
				
			default: 
				throw new BicycleDataProcessingExceptions(typeName + " - this "
						+ "type of bycile is not recognized");
			}
			System.out.println("Bicycle(): new object - a " + typeName +
							" was created");
		}
		
		if(scanner.hasNextLine()){
			String imageName = scanner.next();
				   image     = new ImageIcon(IBycicleDataConstraints.imagePath +  imageName);
		}else
			throw new BicycleDataProcessingExceptions("Constructor "
					+ "was expecting a string, as name of the image,"
					+ " but did not get it.");
		
		if(scanner.hasNextDouble()){
			length = scanner.nextDouble();		
		}else 
			throw new BicycleDataProcessingExceptions("Constructor "
				+ "was expecting a double, as length of the bicycle,"
				+ " but did not get it.");
		
		if(scanner.hasNextDouble()){
			width = scanner.nextDouble();		
		}else
			throw new BicycleDataProcessingExceptions("Constructor "
				+ "was expecting a double, as width of the bicycle,"
				+ " but did not get it.");
		
		if(scanner.hasNextDouble()){
			height = scanner.nextDouble();		
		}else
			throw new BicycleDataProcessingExceptions("Constructor "
				+ "was expecting a double, as height of the bicycle,"
				+ " but did not get it.");
		
		if(scanner.hasNextInt()){
			wheelSize = scanner.nextInt();		
		}else
			throw new BicycleDataProcessingExceptions("Constructor "
				+ "was expecting an int, as height of the bicycle,"
				+ " but did not get it.");
		
		if(scanner.hasNextInt()){
			maxCountInOrder = scanner.nextInt();		
		}else
			throw new BicycleDataProcessingExceptions("Constructor "
				+ "was expecting an int, as maximum count of bicycles"
				+ " in the order, but did not get it.");
		

		if(scanner.hasNextDouble()){
			price = scanner.nextDouble();		
		}else
			throw new BicycleDataProcessingExceptions("Constructor "
				+ "was expecting a double, as price of the bicycle,"
				+ " but did not get it.");
	}

	public ImageIcon getImage(){
		return image;
	}
	
	public String getDimetions(){
		return length + "x" + width + "x" + height ;
	}
	
	double getPrice(){
		return price ;
	}
	
	int  getMaxCountInOrder(){
		return  maxCountInOrder ;
	}
	
	
	@Override
	public String toString (){
		return typeName;
	}
}
