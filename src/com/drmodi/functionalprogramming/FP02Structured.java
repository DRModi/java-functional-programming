package com.drmodi.functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class FP02Structured {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(12,11,4,6,9,13,2,5,8,7,11,21,12);
		
		int sum = sumOfAllNumbersInList(numbers);
		System.out.println("** Sum of all list memeber : "+sum);
		
	}

	private static int sumOfAllNumbersInList(List<Integer> numbers) {

		int sum = 0;
		for(int number:numbers) {
			sum += number;
		}
		
		return sum;
	}

	

}
