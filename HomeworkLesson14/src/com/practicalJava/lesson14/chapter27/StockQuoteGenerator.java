package com.practicalJava.lesson14.chapter27;

import java.util.HashSet;
import java.util.Set;

/**
 * Sample class to generate random prices for stock symbols.
 * 
 * 
 */
public class StockQuoteGenerator {
	private Set<String> supportedSymbols = new HashSet<String>();
	public StockQuoteGenerator() {
		supportedSymbols.add("AAPL");
		supportedSymbols.add("MSFT");
		supportedSymbols.add("YHOO");
		supportedSymbols.add("AMZN");
		supportedSymbols.add("MOT");
	}

	/**
	 * Calculate quote price for the specified stock symbol.
	 * 
	 * @param symbol
	 *            Stock symbol which price is requested.
	 * @return Return price for the specified stock symbol.
	 */
	public String getPrice(String symbol) {
		String price = "";

		if (supportedSymbols.contains(symbol)) {
			// Generate a random price for valid symbols
			Short tmp = (new Double(Math.random() * 10000)).shortValue();
			price     = (new Double(tmp.doubleValue()/100)).toString();
		} else {
			price = "no such symbol";
		}

		return price;
	}

}
