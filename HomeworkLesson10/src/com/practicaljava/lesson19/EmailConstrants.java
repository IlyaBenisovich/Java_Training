package com.practicaljava.lesson19;

public interface EmailConstrants {
	   static  final  String 	emailHost 		 	= "smtp.yandex.ru";
	   static  final  int	 	emailPort		 	= 25;
	   static  final  boolean	emailAuth		 	= true;
	   
	   static  final  String 	emailSenderAddress  = "ibenisovich.java@yandex.ru";
	   static  final  String 	emailSenderPassword = "1qaz2wsx";
	   
	   static  final  String 	emailSubject        = "Happy Birthday!!!";
	   static  final  String 	emailText 			= "Happy birthday dear %s!!!";
}
