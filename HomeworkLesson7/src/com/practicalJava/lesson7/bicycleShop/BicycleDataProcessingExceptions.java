package com.practicalJava.lesson7.bicycleShop;

public class BicycleDataProcessingExceptions extends Exception {
	
	BicycleDataProcessingExceptions(String info, Throwable previousEx){
		super(info, previousEx);
	}
	
	BicycleDataProcessingExceptions(String info){
		super(info);
	}
}
