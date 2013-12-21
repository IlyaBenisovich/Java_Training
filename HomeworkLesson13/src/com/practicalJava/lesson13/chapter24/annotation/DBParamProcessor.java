package com.practicalJava.lesson13.chapter24.annotation;



public class DBParamProcessor {

	public static void process(String className) {
		// Load the provided class
		try {
			Class<?> clazz= Class.forName(className);
			DBParam dbParamAnnotation = (DBParam) clazz.getAnnotation(DBParam.class);
			System.out.println("Data base name: " + dbParamAnnotation.jdbcUrl());
			System.out.println("User ID: " + dbParamAnnotation.login());
			System.out.println("Password: " + dbParamAnnotation.password());


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
