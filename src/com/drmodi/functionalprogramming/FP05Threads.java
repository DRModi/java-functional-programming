package com.drmodi.functionalprogramming;

import java.util.stream.IntStream;

public class FP05Threads {

	public static void main(String[] args) {
		
	
	
	//imperative way
	 Runnable runnableEx = new Runnable() {
	  
	 @Override public void run() { for(int i = 0; i<100; i++) 
	 	{
	  
		 	System.out.println(Thread.currentThread().getId() + " : "+i); 
	 	}
	 }
	  
};
	 


/*
 * Thread thread = new Thread(runnableEx); thread.start();
 * 
 * Thread thread1 = new Thread(runnableEx); thread1.start();
 * 
 * Thread thread2 = new Thread(runnableEx); thread2.start();
 */

	
	
	System.out.println("**** Functional Way");
	
	//Functional way, since Runnable is functional interface, and has only one abstract method
	Runnable runnable = () -> {
		IntStream.range(0, 100)
			.forEach(i->System.out.println(Thread.currentThread().getId()+ " : " + i));
	};
		
	
	Thread thread = new Thread(runnable);
	thread.start();

	Thread thread1 = new Thread(runnable);
	thread1.start();

	Thread thread2 = new Thread(runnable);
	thread2.start();


	}

}
