package com.drmodi.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 11, 4, 6, 9, 13, 2, 5, 8, 7, 11, 21, 12);
		System.out.println("** Print all list memeber : " + numbers);

		int sum = sumOfAllNumbersInList(numbers);
		System.out.println("** Sum of all list memeber : " + sum);

		List<Integer> squreRootOfNumbers = doubledNumbers(numbers);
		System.out.println("** SquareRoot of all list memeber : " + squreRootOfNumbers);
		
		List<Integer> evenNumberList = evenNumberList(numbers);
		System.out.println("** Even number list : " + evenNumberList);
		
		List<String> courses = List.of("Spring", "Spring boot", "Spring Batch", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes", "GCP");
		System.out.println("** Print all Courses : " + courses);
		
		List<Integer> listCoursesLength = coursesLengthList(courses);
		System.out.println("** Print all Courses Length : " + listCoursesLength);
	}

	



//	  private static int sumNumbers(int aggregate, int nextNumber) {
//		  System.out.println(aggregate + " " + nextNumber); 
//		  return aggregate +nextNumber; 
//	 }

	
	private static int sumOfAllNumbersInList(List<Integer> numbers) {

		// Stream of number -> One result value
		// Combine them into one result => One value
		// O and FP02Functional::sumNumber

		return numbers.stream()
				// .reduce(0, FP02Functional::sumNumbers); //custom method reference
				// .reduce(0, (x,y) -> x + y); // Lambda Expression
				.reduce(0, Integer::sum); // Integer Class Sum method reference

	}
	
	private static List<Integer> evenNumberList(List<Integer> numbers) {
		return numbers.stream()
				.filter(x -> x%2==0).sorted()
				.collect(Collectors.toList());
	}

	private static List<Integer> doubledNumbers(List<Integer> numbers) {
		return numbers.stream().map(x -> x * x).collect(Collectors.toList());
	}

	private static List<Integer> coursesLengthList(List<String> courses) {
		return courses.stream()
				.map(x -> x.length())
				.collect(Collectors.toList());
	}
}
