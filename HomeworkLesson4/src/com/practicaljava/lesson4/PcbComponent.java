package com.practicaljava.lesson4;

public abstract class PcbComponent {
		static int quantiyDifferentTypes; 
		
		protected String 		type;
		protected String 		refdesPrefix;
		protected String 		producer;
		protected int 			quantityInStock;
		protected int 			boxNumber;
		protected int 			cellNumber;
		

		protected PcbComponent(	String 	type,
								String 	refdesPrefix,
								String 	producer,
								int 	quantityInStock,
								int 	boxNumber,
								int 	cellNumber
							) {
			this.type 		  		= type;
			this.refdesPrefix 		= refdesPrefix;
			this.producer 	  		= producer;
			this.quantityInStock 	= quantityInStock;
			this.boxNumber 			= boxNumber;
			this.cellNumber 		= cellNumber;
		}
}
