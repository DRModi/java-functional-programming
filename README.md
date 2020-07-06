Main thing with Funtional programming remember "what to do?"

- Convert list to Stream (what to do with each member inside stream of member)
- Meaning inside filter (what to filter?)
- Meaning using method reference (what to perform?)

(1) Method Reference:
	- Convert the list to stream (get one by one element in the list)
	- Method Reference
	
	list.stream
	 	.forEach(className::functionName); //Method Reference.

(2) Filter 
		.filter(FP01Functional::isEven) //Filter only allow even numbers

(3)Lambda expression used in Filter - Simplyfi the function expression
	.filter(number -> number%2==0)
	
(4) map - do the operation on right side and store value to left side
	.map (number -> number * number) //print the square root of the list of numbers.
	
(5) Reduce - Aggregation
		.reduce(0, (x,y) -> x + y)
		.reduce(0, Integer::sum)
		.reduce(0, (x,y) -> x>y?x:y)
		
		Finding Max Value: if negative number presents

(6) Distinct method
	.distinct()

(7) Sorted method
	.sorted()

(8) Custom sorted
	.sorted(Comparator.naturalOrder())
	.sorted(Comparator.reverseOrder())
	.sorted(Comparator.comparing(str -> str.length())) //custom comparison with length
	
(9) Collect Method:
	.collect(Collectors.toList())
		
		
(10) Stream Intermediate operation - All returns stream back
	.distinct() //Stream<T>
	.sorted() //Stream<T>
	.filter() //Stream<T>
	.map() //Stream<R>


(11) Terminal Operation - All return other type other than stream
	.forEach() //void
	.collect() // R custom type, converting stream to map, list, set etc..
	.reduce() //T custom type, reduce to 1 element
		
Note: so intermediate operations are used to perform operation on stream, and at the end terminal operation are for output.

(12) Functional Interfaces:

	> Predicates:
		- Filter behind the scene uses predicates, which takes input and provide results as boolean 
		- So its work as condition, and its output is boolean
		
		Predicate<Type> return boolean.
	
	> Function:
		- Map uses behind the scene functions, which takes arguments, process them and provide results
		
		Function<Type input, Type outPut> return type output
		
	> Consumer:
		- Foreach uses behind the scene the consumer, which is type void, it take input and display it
		- So it consume the input and it might send it to utilities or display on screen (println), etc..
		
		Consumer<Type> no output void. Display or sending value to other function.. etc
		
	> Binary Operator:
		- Like sum of two long or integer, square of the number.. etc and result is also same type. 
		- Represents an operation upon two operands of the same type, producing a result of the same type as the
		  operands.  This is a specialization of for the case where the operands and the result are all of the same
		  type.
		  
		 BinaryOperator<Integer> output the same type.
	
	Note: each functional interface has one abstract method. that method called the functional descriptor. same as lambda expression is also functional descriptor.
	

 	> Behavior Parameterization:

		- So passing behavior/predicate/lambda expression as an argument to the static method called Behavioral
	  	  Parameterization.
	  
		- So predicate is like filter, so you can pass the strategy, algorithms as parameter to the function
	
	
	Note: 
		> So now it allows in Java to pass behavior/function as part of the function argument.
		> Also Functional Interface can be return from the function.
		> Now it allows store method to variable like create variable and assign lambda to it and use that variable
		  as an argument in function.
	
	
	> Supplier:
		- It is used for where no input and return something.
		- () -> {return the value or write any logic and return something};
		- () -> 2; direct return
		
	> UnaryOperator
		- Represents an operation on a single operand that produces a result of the same type as its operand. 
		
	> So far all Wrapper classes such as Integer for int etc. But if we know that we are working with primitive, its
	  better to use primitive functions directly. like 
	  IntBinaryOperator, IntConsumer, IntPredicate, IntFunction, IntToDoubleFunction, IntToLongFunction, IntUnary etc.
	
	
	
Streams:
--------------------

Primitive Type:
-------------


(1) Direct stream creation:
	Stream.of(12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15)
	
(2) Stream.of or list.of are always use instance of Wrapper Classes not the primitive, Integer instead of int.
	> Boxing and unboxing happen which not the efficient 

		jshell> List<Integer> intList = List.of(12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15);
		intList ==> [12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15]

		jshell> intList.stream().count()
		$2 ==> 11

		jshell> 

		jshell> intList
		intList ==> [12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15]

		jshell> intList.stream()
		$4 ==> java.util.stream.ReferencePipeline$Head@724af044

		jshell> Stream.of(12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15)
		$5 ==> java.util.stream.ReferencePipeline$Head@1d057a39
	
		jshell> intList.stream().reduce(0, Integer::sum)
		$6 ==> 102
	
		Note: java.util.stream.ReferencePipeline (reference instance created in both case, list and Stream)
		
	
	> Create Array which is faster and then we can perform operation directly
	
		jshell> int[] intArray = {12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15};
		intArray ==> int[11] { 12, 5, 9, 13, 4, 6, 8, 7, 11, 12, 15 }
		
		jshell> Arrays.stream(intArray)
		$10 ==> java.util.stream.IntPipeline$Head@ae45eb6
		
		jshell> Arrays.stream(intArray).sum()
		$11 ==> 102

		jshell> Arrays.stream(intArray).average()
		$12 ==> OptionalDouble[9.272727272727273]

		jshell> Arrays.stream(intArray).min()
		$13 ==> OptionalInt[4]

		jshell> Arrays.stream(intArray).max()
		$14 ==> OptionalInt[15]
		
		Note: java.util.stream.IntPipeline (primitive instance)
		
		
(3) Iterate, range, limit

	Range:
	-----
	jshell> IntStream.range(1,10).sum()
	$26 ==> 45

	jshell> IntStream.rangeClosed(1,10).sum()
	$27 ==> 55
	
	
	
	Iterate and limit:
	-------------------
	
	IntStream.iterate(2, num -> num+2).limit(10).peek(System.out::println).sum()
	
	
(4) Converting Primitive stream to list, require boxed()

	jshell> IntStream.iterate(2, num -> num +2).limit(11).collect(Collectors.toList())
	|  Error:
	|  method collect in interface java.util.stream.IntStream cannot be applied to given types;
	|    required: java.util.function.Supplier<R>,java.util.function.ObjIntConsumer<R>,java.util.function.BiConsumer<R,R>
	|    found: java.util.stream.Collector<java.lang.Object,capture#2 of ?,java.util.List<java.lang.Object>>
	|    reason: cannot infer type-variable(s) R
	|      (actual and formal argument lists differ in length)
	|  IntStream.iterate(2, num -> num +2).limit(11).collect(Collectors.toList())
	|  ^---------------------------------------------------^

	jshell> IntStream.iterate(2, num -> num +2).limit(11).boxed().collect(Collectors.toList())
	$30 ==> [2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22]


(5) Map to appropriate object to the larger number:

	jshell> LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)
	$31 ==> 30414093201713378043612608166064768844377641568960512000000000000
	
	
	
	
String Stream operation:
-------------------------

(1) Collector creating coma separated list or space sepated list

	jshell> courses.stream().collect(Collectors.joining(","))
	$2 ==> "Spring,Spring boot,Spring Batch,API,Microservices,AWS,PCF,Azure,Docker,Kubernetes,GCP"

	jshell> courses.stream().collect(Collectors.joining(" "))
	$3 ==> "Spring Spring boot Spring Batch API Microservices AWS PCF Azure Docker Kubernetes GCP"

(2) Append the string:
	
	jshell> courses.stream().map(c -> c + " Test").collect(Collectors.toList())
	$4 ==> [Spring Test, Spring boot Test, Spring Batch Test, API Test, Microservices Test, AWS Test, PCF Test, Azure Test, Docker Test, Kubernetes Test, GCP Test]
	
	
(3) FlatMap:

	jshell> "Spring".split("")
	$8 ==> String[6] { "S", "p", "r", "i", "n", "g" }
	

	jshell> courses.stream().map(c -> c.split("")).collect(Collectors.toList())
	$5 ==> [[Ljava.lang.String;@5622fdf, [Ljava.lang.String;@4883b407, [Ljava.lang.String;@7d9d1a19, [Ljava.lang.String;@39c0f4a, [Ljava.lang.String;@1794d431, [Ljava.lang.String;@42e26948, [Ljava.lang.String;@57baeedf, [Ljava.lang.String;@343f4d3d, [Ljava.lang.String;@53b32d7, [Ljava.lang.String;@5442a311, [Ljava.lang.String;@548e7350]
	
	Result of the operation was the Arrays of the characted, from split the string: Use Flat map to flatten the Arrays of streams.
	
	jshell> courses.stream().map(c -> c.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
	$6 ==> [S, p, r, i, n, g, S, p, r, i, n, g,  , b, o, o, t, S, p, r, i, n, g,  , B, a, t, c, h, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s, G, C, P]


	Distinct characters.

	jshell> courses.stream().map(c -> c.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
	$7 ==> [S, p, r, i, n, g,  , b, o, t, B, a, c, h, A, P, I, M, s, e, v, W, C, F, z, u, D, k, K, G]
	
	
	
	jshell> courses.stream().flatMap(course -> courses1.stream().map(course1 -> Arrays.asList(course, course1))).collect(Collectors.toList())
	$3 ==> [[Spring, Spring], [Spring, Spring boot], [Spring, Spring Batch], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], [Spring, GCP], [Spring boot, Spring], [Spring boot, Spring boot], [Spring boot, Spring Batch], [Spring boot, API], [Spring boot, Microservices], [Spring boot, AWS], [Spring boot, PCF], [Spring boot, Azure], [Spring boot, Docker], [Spring boot, Kubernetes], [Spring boot, GCP], [Spring Batch, Spring], [Spring Batch, Spring boot], [Spring Batch, Spring Batch], [Spring Batch, API], [Spring Batch, Microservices], [Spring Batch, AWS], [Spring Batch, PCF], [Spring Batch,  ... PI], [Kubernetes, Microservices], [Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker], [Kubernetes, Kubernetes], [Kubernetes, GCP], [GCP, Spring], [GCP, Spring boot], [GCP, Spring Batch], [GCP, API], [GCP, Microservices], [GCP, AWS], [GCP, PCF], [GCP, Azure], [GCP, Docker], [GCP, Kubernetes], [GCP, GCP]]
	
	
	
	Matching Both List Elements:
	
	

	jshell> courses.stream().flatMap(course -> courses1.stream().map(course1 -> List.of(course, course1))).filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList())
	$7 ==> [[Spring, Spring], [Spring boot, Spring boot], [Spring Batch, Spring Batch], [API, API], [Microservices, Microservices], [AWS, AWS], [PCF, PCF], [Azure, Azure], [Docker, Docker], [Kubernetes, Kubernetes], [GCP, GCP]]


	Not Matchin List Elements:
	

	jshell> courses.stream().flatMap(course -> courses1.stream().map(course1 -> List.of(course, course1))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())
	$8 ==> [[Spring, Spring boot], [Spring, Spring Batch], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], [Spring, GCP], [Spring boot, Spring], [Spring boot, Spring Batch], [Spring boot, API], [Spring boot, Microservices], [Spring boot, AWS], [Spring boot, PCF], [Spring boot, Azure], [Spring boot, Docker], [Spring boot, Kubernetes], [Spring boot, GCP], [Spring Batch, Spring], [Spring Batch, Spring boot], [Spring Batch, API], [Spring Batch, Microservices], [Spring Batch, AWS], [Spring Batch, PCF], [Spring Batch, Azure], [Spring Batch, Docker], [Spring Batch, Kubernetes], [Spring Batch, G ... ernetes, Spring Batch], [Kubernetes, API], [Kubernetes, Microservices], [Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker], [Kubernetes, GCP], [GCP, Spring], [GCP, Spring boot], [GCP, Spring Batch], [GCP, API], [GCP, Microservices], [GCP, AWS], [GCP, PCF], [GCP, Azure], [GCP, Docker], [GCP, Kubernetes]]
	
	
	Only matching the same length of the both element in the list:
	
	courses.stream().flatMap(course -> courses1.stream().filter(course1 -> course.length()==course1.length()).map(course1 -> List.of(course, course1))).filter(l -> !l.get(0).equals(l.get(1))).collect(Collectors.toList())
	$11 ==> [[Spring, Docker], [API, AWS], [API, PCF], [API, GCP], [AWS, API], [AWS, PCF], [AWS, GCP], [PCF, API], [PCF, AWS], [PCF, GCP], [Docker, Spring], [GCP, API], [GCP, AWS], [GCP, PCF]]
	
	
	


Intermediate Opearations are all Lazy in Streams:
----------------------------------------------


jshell> courses.stream().peek(System.out::println).filter(course -> course.length()>11).map(String::toUpperCase).peek(System.out::println)
$2 ==> java.util.stream.ReferencePipeline$11@29ee9faa

note all peek, filter, map are intermediate operation

jshell> $2.findFirst()
Spring
Spring boot
Spring Batch
SPRING BATCH
$3 ==> Optional[SPRING BATCH]


Functional Programming is efficient/fast in multicore environment, since it did not traverse whole list, it knows the more than 11 is the one we are looking for..

It's only when the terminal operation is executed, the intermediate operations are executed in Java. And
that helps Java to be efficient. When it's executing the terminal operation it knows what is the result


Modifying List:
---------------

(1) ArrayList with replaceAll, removeIf

	
	List<String> coursesArrayList = new ArrayList(courses);
	coursesArrayList ==> [Spring, Spring boot, Spring Batch, API, Microser ... , Docker, Kubernetes, GCP]
	
	jshell> coursesArrayList.replaceAll(s -> s.toUpperCase())

	jshell> coursesArrayList
	coursesArrayList ==> [SPRING, SPRING BOOT, SPRING BATCH, API, MICROSERVICES, AWS, PCF, AZURE, DOCKER, KUBERNETES, GCP]
	
	
	jshell> coursesArrayList.removeIf(str -> str.length() < 6)
	$7 ==> true

	jshell> coursesArrayList
	coursesArrayList ==> [SPRING, SPRING BOOT, SPRING BATCH, MICROSERVICES, DOCKER, KUBERNETES]
	
	











































