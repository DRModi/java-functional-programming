package com.drmodi.functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class FP01Structured {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(12,11,4,6,9,13,2,5,8,7,11,21,12);
		
		printAllNumbersInListStructured(numbers);
		System.out.println("#### PRINTING EVEN NUMBERS FROM ABOVE LIST ####");
		printAllEvenNumbersInListStructured(numbers);
		
	}

	private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
		//loop the numbers
		for(int number:numbers) {
			if(number%2==0) {
			System.out.println(number);
			}
		}
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		
		//loop the numbers
		for(int number:numbers) {
			System.out.println(number);
		}
		
	}

}
