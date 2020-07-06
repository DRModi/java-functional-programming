package com.drmodi.functionalprogramming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehavioralParameterization {
	
	public static void main(String[] args) {
		
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		System.out.println("Print Even Number:-");
		filterAndPrint(numbers, x -> x%2==0);
		System.out.println();

		System.out.println("Print Odd Number:-");
		filterAndPrint(numbers, x -> x%2!=0);
		System.out.println();

		System.out.println("Print Multiple 3 Numbers:-");
		filterAndPrint(numbers, x -> x%3==0);
		System.out.println();
		
		System.out.println("*** Exercises ***"+"\n");
		System.out.println("*** Doubling the Numbers:-"+"\n");
		List<Integer> doubleList = incrementInputList(numbers, x -> x + x);
		System.out.println(numbers+" => "+doubleList+"\n");
		
		System.out.println("SquareRoot of the Numbers:-");
		List<Integer> squaredList = incrementInputList(numbers, x -> x * x);
		System.out.println(numbers+" => "+squaredList+"\n");
		
		
		System.out.println("Cube of the Numbers:-");
		List<Integer> cubedList = incrementInputList(numbers, x -> x * x * x);
		System.out.println(numbers+" => "+cubedList+"\n");
		
		

	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {

		numbers.stream()
			.filter(predicate)
			.forEach(System.out::println);
	}
	
	
	private static List<Integer> incrementInputList(List<Integer> numbers, Function<Integer, Integer> function) {
		
		return numbers.stream()
			.map(function)
			.collect(Collectors.toList());
	}

}
