package com.drmodi.functionalprogramming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 11, 4, 6, 9, 13, 2, 5, 8, 7, 11, 21, 12);
		
		printAllNumbersInListFunctional(numbers);
		System.out.println("#### PRINTING EVEN NUMBERS FROM ABOVE LIST ####");
		printAllEvenNumbersInListFunctional(numbers);

	}

//	private static void print(int number) {
//		System.out.println(number);
//	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {

		// loop the numbers
		// for(int number:numbers) {
		// System.out.println(number);
		// }

		// In functional programming
		// 1. convert list to stream
		// 2. call method directly using method reference

		// numbers.stream()
		// .forEach(FP01Functional::print); // Method Reference

		numbers.stream()
			.forEach(System.out::println);
	}

	/*
	 * private static boolean isEven(int number) { return (number%2==0); }
	 */	
	
	private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			//.filter(FP01Functional::isEven) //Filter only allow even numbers
			.filter(number -> number%2==0) //Use of Lambda expression, instead of usage of functions.
			.forEach(System.out::println); //Method Reference.
	}

}
