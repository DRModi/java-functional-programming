package com.drmodi.functionalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03Functional {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 3, 4, 5, 7, 11, 10);
		
		/*
		 * Understand each lambda expression - How works
		 
		numbers.stream()
			.filter(x -> x%2 != 0)
			.map(x -> x * x)
			.forEach(System.out::println);
		
		*/
			
		Predicate<Integer> predicate = x -> x%2 != 0;
		//Above predicate work behind the scene like below
		//Represents a predicate (boolean-valued function) of one argument.
		Predicate<Integer> predicate2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				return x%2 != 0;
			}
			
		};
		
		
		
		Function<Integer, Integer> function = x -> x * x;
		//Above function work behind the scene like below
		//Represents a function that accepts one argument and produces a result.
		Function<Integer, Integer> function2 = new Function<Integer,Integer>(){

			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
			
		};
		
		
		
		
		Consumer<Integer> consumer = System.out::println;
		//Above Consumer work behind the scene like below
		// Represents an operation that accepts a single input argument and returns no result.
		//So it consume the input and it might send it to utilities or display on screen (println), etc..
		Consumer<Integer> consumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
			
		};
		
		
		//Extracted Lambda expression	
		numbers.stream()
		.filter(predicate)
		.map(function)
		.forEach(consumer);
	
		
		System.out.println();
		System.out.println("Same value being displayed as above, after creating object insted of lambda expression.");
		System.out.println("To see how, behind the scene all Functional interface works, like Predicates, Function and Consumer");
		System.out.println("In Jave Object is first class citizen.. :-)");
		System.out.println();
		
		//Created object of functional interface of the lambda expression
		numbers.stream()
		.filter(predicate2)
		.map(function2)
		.forEach(consumer2);	
	
	}
}
