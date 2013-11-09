package com.practicalJava.lesson8.chapter15;

public class Employee extends Person {

	public Employee(String name){
		super(name);
	}
	
	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " +
		percent + "%. "+ getName());
		return true;
	}

}
