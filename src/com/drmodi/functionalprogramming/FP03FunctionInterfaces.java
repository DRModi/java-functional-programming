package com.drmodi.functionalprogramming;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionInterfaces {

	public static void main(String[] args) {

		Predicate<Integer> predicate = x -> x%2==0;
		System.out.println("Predicate Output : "+predicate.test(11));
		
		Function<Integer, Integer> squareFunction = x -> x * x;
		System.out.println("Function square Output: "+ squareFunction.apply(11));
		
		Function<Integer, String> concateIntString = x -> x + " appended.";
		System.out.println("Function Concate Output: "+ concateIntString.apply(11));
		
		Consumer<Integer> consumer = x -> System.out.println(x);
		consumer.accept(11);
		
		BinaryOperator<Integer> binOperator = (x,y) -> x + y;
		System.out.println("Print Binary Operator : "+ binOperator.apply(11, 11));
		
		Supplier<Integer> fixedSupplier = () -> 11;
		System.out.println("Print Fixed Supplier " + fixedSupplier.get());
		
		Supplier<Integer> randomSupplier = () -> {
		
			Random randomNum = new Random();
			return randomNum.nextInt(500);
		};
		System.out.println("Print Random Supplier " + randomSupplier.get());

		
		UnaryOperator<Integer> unaryOperator = (x) -> x * 100;
		System.out.println("Unary output: "+ unaryOperator.apply(11));
		
		
		BiPredicate<Integer, Integer> biPredicate = (x,y) -> {
			return x==y;
		};
		System.out.println("BiPredicate output: "+ biPredicate.test(11 * 2, 22));
		System.out.println("BiPredicate output:1 "+ biPredicate.test(11 , 22));
		
		
	
		BiFunction<Integer, Integer, String> biFunction = (x,y) -> {
			return x + "/" + y;
		};
		System.out.println("BiFunction output : "+ biFunction.apply(2, 11));
		System.out.println("BiFunction output1 : "+ biFunction.apply(8, 7));
	
	
		BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
			System.out.println("Two Input numbers are : "+x +" and "+y);
		};
		biConsumer.accept(2, 11);
	
	
		IntBinaryOperator intBinOperator = (x,y) -> x * y + x + y;
		System.out.println("Int Binary Operator : "+intBinOperator.applyAsInt(14, 11));
		
		
		IntConsumer intConsumer = x -> {
			System.out.println("Int Consumer output: "+x);
		};
		intConsumer.accept(11);
		
		IntFunction<Integer> intFunction = x -> {
			return x * x;
		};
		System.out.println("IntFunction : "+intFunction.apply(11));
		
		IntToDoubleFunction intToDouble = x -> {
			return x * x * x + 0.005;
		};
		System.out.println("IntToDoubleFunction : "+ intToDouble.applyAsDouble(11));
		
		IntToLongFunction intToLong = x -> x * x * x * x * x * x * 1112;
		System.out.println("IntToLongFunction : "+ intToLong.applyAsLong(11));
	
		IntUnaryOperator intUnary = x -> x + 50 + 20;
		System.out.println("intUnary : "+ intUnary.applyAsInt(30));
	
	}

}
