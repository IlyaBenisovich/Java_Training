package com.practicaljava.lesson4;

public interface Reservable {

	public enum Reservation_result{
		ORDERED_FULLY,
		ORDERED_PARTIALLY,
		NOT_TO_BOOK_THE_CELL_IS_FULL
		
	}

	public  Reservation_result bookItself (int amount);
}
