package com.drmodi.functionalprogramming;

import java.util.List;
import java.util.function.Supplier;

public class FP04MethodReferences {

	private static void printStr(String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) {

		
		List<String> courses = List.of("Spring", "Spring boot", "Spring Batch", "API", 
				"Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes", "GCP");
		
		
		courses.stream()
			//.map(str -> str + " -> " + str.toUpperCase())
			.map(String::toUpperCase)
			//.forEach(System.out::println);
			//.forEach(str -> System.out.println(str));
			.forEach(FP04MethodReferences::printStr);
			
		
		Supplier<String> supplier = () -> new String();
		
		Supplier<String> supplier1 = String::new; //Constructor references
		
		String str1 = supplier.get();
		
		String str2 = supplier1.get();
		
		
		System.out.println("Print str -> supplier 1 Empty String : -" +str1);
		System.out.println("Print str -> supplier 1 Empty String : -" +str2);
		
		
		
	}

}
