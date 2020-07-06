package com.drmodi.functionalprogramming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewSource(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return name + " : " + reviewScore  + " : " + noOfStudents;
	}
	
	
	
}

public class FP04CustomClass {
	
	public static void main(String[] args) {
		
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("Microservices", "Microservices", 97, 22000),
				new Course("API", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kuberenetes", "Cloud", 91, 20000));
		
		
		
		Predicate<Course> reviewScoreGT95 = course -> course.getReviewScore() > 95;
		Predicate<Course> reviewScoreGT90 = course -> course.getReviewScore() > 90;
		Predicate<Course> reviewScoreLT90 = course -> course.getReviewScore() < 90;
		Predicate<Course> reviewScoreEqual95= course -> course.getReviewScore() == 95;
		Predicate<Course> reviewScoreEqual94= course -> course.getReviewScore() == 94;
		
		//all match - when every element in the stream match
		System.out.println("All Courses Score are > 95 : " +
				courses.stream().allMatch(reviewScoreGT95));
	
		System.out.println("All Courses Score are > 90 : " +
				courses.stream().allMatch(reviewScoreGT90));
		
		//Any match - when any element in the stream match
		System.out.println("Any Courses Score are more than 95: "
					+ courses.stream().anyMatch(reviewScoreGT95));
		
		System.out.println("Any Courses Score are Less Than 90: "
				+ courses.stream().anyMatch(reviewScoreLT90));
		
		//None Match - None of the element in the stream match
		System.out.println("None Courses Score are equal 95 : " +
				courses.stream().noneMatch(reviewScoreEqual95));
		System.out.println("None Courses Score are equal 94 : " +
				courses.stream().noneMatch(reviewScoreEqual94));
		
		
		Comparator<Course> compareByNoOfStudentsIncreasingOrder = 
				Comparator.comparingInt(Course::getNoOfStudents);
		
		Comparator<Course> compareByNoOfStudentsDecreasingOrder = 
				Comparator.comparing(Course::getNoOfStudents).reversed();
		
		//Using primitive method is always good, since no auto-boxing
		Comparator<Course> compareByNoOfStudentsAndScoreReverse = 
				Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore).reversed();
		
		
		//sorting
		List<Course> listByNoOfStudentsIncrease = courses.stream()
				.sorted(compareByNoOfStudentsIncreasingOrder)
				.collect(Collectors.toList());
		
		
		System.out.println("****** PRINT Courses Based on number of students Increasing Order: "+"\n"+listByNoOfStudentsIncrease+"\n");
		
		List<Course> listByNoOfStudentsDecrease = courses.stream()
				.sorted(compareByNoOfStudentsDecreasingOrder)
				.collect(Collectors.toList());
		System.out.println("****** PRINT Courses Based on number of students Decreasing Order: "+"\n"+listByNoOfStudentsDecrease+"\n");
		
		
		//All match and sorting increasing number
		List<Course> listByNoOfStudentsIncreaseGT95 = courses.stream()
				.filter(reviewScoreGT95)
				.sorted(compareByNoOfStudentsIncreasingOrder)
				.collect(Collectors.toList());
		
		
		System.out.println("****** PRINT Courses Based on number of students  and GT95 review Score Increasing Order: "+"\n"+listByNoOfStudentsIncreaseGT95+"\n");
		
		
		//Reverse order of #students and then #Score		
		List<Course> listByNoOfStudentsAndScoreRevers = courses.stream()
				.sorted(compareByNoOfStudentsAndScoreReverse)
				.collect(Collectors.toList());
		
		System.out.println("****** PRINT Courses Based on number of students and Score Reverse: "+"\n"+listByNoOfStudentsAndScoreRevers+"\n");
		
		List<Course> listByGroupAndNoOfStudents = courses.stream()
				.filter(course -> course.getCategory()=="Cloud")
				.sorted(compareByNoOfStudentsAndScoreReverse)
				.collect(Collectors.toList());
		
		System.out.println("****** PRINT Courses Based on number of students and Category Cloud: "+"\n"+listByGroupAndNoOfStudents+"\n");
		
		
		//Limit - Output top 3 only from list
		List<Course> listByNoOfStudentsAndScoreReversTop3 = courses.stream()
				.sorted(compareByNoOfStudentsAndScoreReverse)
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println("****** PRINT Top 3 - Courses Based on number of students and Score Reverse: "+"\n"+listByNoOfStudentsAndScoreReversTop3+"\n");
		
		
		//Limit - Output top 3 only from list
				List<Course> listByNoOfStudentsAndScoreReversSkip2Top1 = courses.stream()
						.sorted(compareByNoOfStudentsAndScoreReverse)
						.skip(2)
						.limit(1)
						.collect(Collectors.toList());
				
				System.out.println("****** PRINT Skip 2 Top 1 - Courses Based on number of students and Score Reverse: "+"\n"+listByNoOfStudentsAndScoreReversSkip2Top1+"\n");
		
		
		//Print all courses
		System.out.println("All Courses : "+"\n"+courses+"\n");
		
		//Take while
		System.out.println("Print all courses till you match the review Score GT 95: "+"\n"+
		courses.stream()
			.takeWhile(course -> course.getReviewScore()>=95)
			.collect(Collectors.toList()) + "\n");
		
		
		//Drop while
		System.out.println("Drop all courses till you match the review Score GT 95: "+"\n"+
				courses.stream()
					.dropWhile(course -> course.getReviewScore()>=95)
					.collect(Collectors.toList()) + "\n");
		
		
		
		//Max - it will return the last element in the list
		System.out.println("Max from the number of students and review score : "+"\n"+
				courses.stream()
					.max(compareByNoOfStudentsAndScoreReverse) + "\n");

		
		//Min - it will return the First element in the list
		System.out.println("Min from the number of students and review score : "+"\n"+
				courses.stream()
					.min(compareByNoOfStudentsAndScoreReverse) + "\n");
		
		//Return optional which allows to check any element exist or not,
		//if not then return default one and save from null pointer exceptions
		System.out.println("Default return -> Min from the number of students and review score < 90 : "+"\n"+
				courses.stream()
					.filter(reviewScoreLT90)
					.min(compareByNoOfStudentsAndScoreReverse) //[Optional.empty]
					.orElse(new Course("ML", "AI", 100, 50000))+ "\n");
		
		
		System.out.println("Default return -> Max from the number of students and review score < 90 : "+"\n"+
				courses.stream()
					.filter(reviewScoreLT90)
					.max(compareByNoOfStudentsAndScoreReverse) //[Optional.empty]
					.orElse(new Course("DSA", "Fundamentals", 100, 100000))+ "\n");
		
		//Find First
		System.out.println("Find First from the number of students and review score : "+"\n"+
				courses.stream()
					.filter(reviewScoreGT95) 
					.findFirst()+ "\n");
		
		//Find Any
		System.out.println("Find Any from the number of students and review score > 95 : "+"\n"+
				courses.stream()
					.filter(reviewScoreGT95) 
					.findAny()+ "\n");
		

		//Count course
		System.out.println("Number of courses review score > 95 : "+"\n"+
				courses.stream()
					.filter(reviewScoreGT95)
					.mapToInt(Course::getNoOfStudents)
					.count()+ "\n");
		
		
		//count of all students from the courses are GT 95
		System.out.println("Sum of all students where review score > 95 : "+"\n"+
				courses.stream()
					.filter(reviewScoreGT95)
					.mapToInt(Course::getNoOfStudents)
					.sum()+ "\n");
		
		//Average
		System.out.println("Average students in courses where review score > 95 : "+"\n"+
				courses.stream()
					.filter(reviewScoreGT95)
					.mapToInt(Course::getNoOfStudents)
					.average()+ "\n");
		
		//Max
		System.out.println("Max students in courses where review score > 95 : "+"\n"+
				courses.stream()
					.filter(reviewScoreGT95)
					.mapToInt(Course::getNoOfStudents)
					.max()+ "\n");

		
		
		
		
		
		//Grouping by Category
		System.out.println("Group courses by Category: " + "\n" +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory))+"\n");
		
		//Grouping by Category - Counting the total course for that category
		System.out.println("Counting the total course for that category: " + "\n" +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.counting()))+"\n");
		
		
		//Get max/top course from the category which has higher reviewScore
		System.out.println("Top course from the category which has higher reviewScore: " + "\n" +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))+"\n");	
		
		
		//Grouping the courses by the category and return the only name of the course
		System.out.println("Grouping the courses by the category and return the only name of the course: " + "\n" +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.mapping(Course::getName, Collectors.toList())))+"\n");
		
		
	}
	
	
	
	


}
