package com.practicaljava.lesson6;

public interface Payable {
	static final int INCREASE_CAP = 20;
	boolean increasePay(int percent);
}
