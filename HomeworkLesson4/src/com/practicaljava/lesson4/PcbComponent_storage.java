package com.practicaljava.lesson4;

import java.util.Scanner;

public class PcbComponent_storage {

	public static void main(String[] args) {
		
		Scanner 	scanner = new Scanner(System.in);
		
		Resistor r1 = new Resistor(scanner);	
		scanner.close();
	}

}
