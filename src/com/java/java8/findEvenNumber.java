package com.java.java8;

import java.util.function.Predicate;

public class findEvenNumber {
	public static void main(String[] args) {
		Predicate<Integer> p=i-> i%2==0;
		int[] a= {1,2,4,5,6,45,5};
		for(int i:a)
			System.out.println(p.test(i));

	}
	
	/*public void m1() {
		
		System.out.println("this is m1 method");
	}*/
	//the above code can be written in lambda expression as follows
	
	/*() -> System.out.println("this is m1 method");*/
	//------------------------------------------------------------------
	
	/*public int add(int a,int b) {
		
		
		return (a+b);
	}*/

	//the above code can be written in lambda expression as follows
	/*(a,b) -> a+b;*/
	
	//------------------------------------------------------------------
	
	
	/*public int sqrt(int n) {
		
		return n*n;
	}*/
	
	//the above code can be written in lambda expression as follows
	
	/* n -> n*n;*/
}

