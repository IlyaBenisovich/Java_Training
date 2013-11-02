package com.practicalJava.lesson7.bicycleShop;

import javax.management.RuntimeErrorException;

public class TooManyBikesException extends RuntimeException {
	ShippingErrorInfo info;
	
	TooManyBikesException(int maxBikesInOrder, int requestedNumberOfBicicle){
		super("User requests too many bikes ("+requestedNumberOfBicicle+") in the order."
				+ "(We can deliver " +maxBikesInOrder+ " at a time)" );
		info.maxBikesInOrder 		= maxBikesInOrder;
		info.requestedNumberOfBikes = requestedNumberOfBicicle;
	}

}
