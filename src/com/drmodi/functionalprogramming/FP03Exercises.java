package com.drmodi.functionalprogramming;

import java.util.List;
import java.util.function.BinaryOperator;


public class FP03Exercises {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 3, 4, 5, 7, 11, 10);
		
		BinaryOperator<Integer> accumulator = Integer::sum;
		/*Represents an operation upon two operands of the same type, producing a result
		 * of the same type as the operands.  This is a specialization of
		 * {@link BiFunction} for the case where the operands and the result are all of
		 * the same type.
		*/
		
		BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
		};
		
		
		
		Integer reduce = numbers.stream().reduce(0, accumulator);
		System.out.println(reduce);
		
		System.out.println();
		System.out.println("Using Accumulator - BinaryOperator behind the scene");
		System.out.println();
		
		Integer reduce2 = numbers.stream().reduce(0, accumulator2);
		System.out.println(reduce2);
		
	}
}
