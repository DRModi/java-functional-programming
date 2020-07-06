package com.drmodi.functionalprogramming;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 11, 4, 6, 9, 13, 2, 5, 8, 7, 11, 21, 12);
		
		printAllNumbersInListFunctional(numbers);
		
		System.out.println("#### PRINTING ODD NUMBERS FROM ABOVE LIST ####");
		printAllOddNumbersInListFunctional(numbers);
		
		System.out.println("#### PRINTING Square of the Even NUMBERS FROM ABOVE LIST ####");
		printAllEvenNumbersSquareInListFunctional(numbers);
		
		System.out.println("#### PRINTING Cube of the Odd NUMBERS FROM ABOVE LIST ####");
		printAllOddNumbersCubeInListFunctional(numbers);
		
		
		List<String> courses = List.of("Spring", "Spring boot", "Spring Batch", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes", "GCP");
		
		System.out.println("#### PRINT ALL Courses FROM ABOVE LIST ####");
		printAllCoursesInListFunctional(courses);
		
		System.out.println("#### PRINT ALL Courses FROM ABOVE LIST - Contains the Spring word ####");
		printSpringCoursesInListFunctional(courses);
		
		System.out.println("#### PRINT ALL Courses FROM ABOVE LIST - Contains Altleast 4 letters ####");
		printCoursesContain4LettersInListFunctional(courses);
		
		
		System.out.println("#### PRINT character from ALL Courses FROM ABOVE LIST ####");
		printCoursesInCharacterLettersInListFunctional(courses);
		
		

	}



	
	private static void printCoursesContain4LettersInListFunctional(List<String> courses) {
		courses.stream()
			.filter(course -> course.length()>3)
			.forEach(System.out::println);
			
	}

	private static void printSpringCoursesInListFunctional(List<String> courses) {
		courses.stream()
			.filter(course -> course.contains("Spring"))
			.forEach(System.out::println);
	}
	
	

	private static void printAllCoursesInListFunctional(List<String> courses) {
		courses.stream().forEach(System.out::println);
	}
	
	
	private static void printCoursesInCharacterLettersInListFunctional(List<String> courses) {

		courses.stream()
			.map(course -> course + " : Length - " + course.length())
			.forEach(System.out::println);
	}

	private static void printAllOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> (number%2!=0))
		.forEach(System.out::println);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
			numbers.stream()
			.forEach(System.out::println);
	}


	private static void printAllOddNumbersCubeInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number % 2 != 0)
			.map(number -> number + " : Cube - " + number * number * number)
			.forEach(System.out::println);
	}

	private static void printAllEvenNumbersSquareInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number % 2 == 0)
			.map(number -> number + " : Square Root - " + number * number)
			.forEach(System.out::println);

	}

}
