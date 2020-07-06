package com.drmodi.functionalprogramming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP05FileOperationsFunctional {
	
	public static void main(String[] args) throws IOException {
		
		String uri = "ReadFile.txt";
		
		System.out.println("*** Print content in File"+"\n");
		
		Files.lines(Paths.get("ReadFile.txt")).forEach(System.out::println);
		
		System.out.println("\n"+"*** Print Length of Each Line as stream"+"\n");
		
		Files.lines(Paths.get("ReadFile.txt"))
			.map(line -> line.length())
			.forEach(System.out::println);
		
		System.out.println("\n"+"*** Print Each Line as stream distinct"+"\n");
		
		Files.lines(Paths.get("ReadFile.txt"))
		.map(line -> line.split(""))
		.flatMap(Arrays::stream).distinct()
		.forEach(System.out::println);
		
		System.out.println("\n"+"*** Print Each Line words as stream distinct and sorted"+"\n");
		
		Files.lines(Paths.get(uri))
			.map(str -> str.split(" "))
			.flatMap(Arrays::stream)
			.distinct().sorted()
			.forEach(System.out::println);
		
		
		System.out.println("\n"+"*** Print list of files present in root directory"+"\n");
		
		Files.list(Paths.get("."))
				.forEach(System.out::println);
		

		System.out.println("\n"+"*** Print list of directories present in root directory"+"\n");
		
		Files.list(Paths.get("."))
				.filter(Files::isDirectory)
				.forEach(System.out::println);
		
		
		System.out.println("\n"+"*** Collect File, Each Line content as string list "+"\n");
		
		List<String> strLineList = Files.lines(Paths.get(uri))
				.map (line -> line.trim())	
				.collect(Collectors.toList());
		
		System.out.println("#### Print List: "+strLineList);
	
		
		
	
		
		
	}

}
