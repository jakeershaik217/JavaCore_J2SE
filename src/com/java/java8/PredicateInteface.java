package com.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInteface {
public static void main(String[] args) {
	//Predicate will return boolean after conditional Check and take Integer as Input
	Predicate<Integer> predicate= i -> i%2==0;
	System.out.println(predicate.test(1));
	System.out.println(predicate.test(2));
	List<Integer> list1=new ArrayList<Integer>();
	list1.add(25);
	list1.add(250);
	list1.add(125);
	list1.add(20);
	
	//this is my own Functional Interface
	EvenOddCollection<List<Integer>> evenodd= i -> {
		
	List<Integer> listname1=new ArrayList<>();	
	List<Integer> listname2=new ArrayList<>();
	List<List<Integer>> listname=new ArrayList<List<Integer>>();
	for(int inT:i)
		if(predicate.test(inT))
	     listname1.add(inT);
		else
		 listname2.add(inT);
		
	listname.add(listname1);
	listname.add(listname2);
	return listname;
	};
	
	evenodd.getEvenOddCollection(list1).forEach(k -> System.out.println(k));
}
}
	
	
	

interface EvenOddCollection<T> {

	public List<T> getEvenOddCollection(T t);

}
