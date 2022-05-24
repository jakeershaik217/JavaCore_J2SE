package com.java.java8;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.*;

public class Function_FunctionalInterface {

	public static void main(String[] args) {
		List<Student> list=new ArrayList<>();
		list.add(new Student("Jakeer",20));
		list.add(new Student("JHak",120));
		list.add(new Student("Hussain",250));
		list.add(new Student("James",4420));
		list.add(new Student("shaik",205));
		
		list.add(new Student("One",1));
		list.add(new Student("onetwo",204));
		
		Function<Student,String> f=s->{
			int RollNumber=s.RollNo;
			String Section="";
			return Section=RollNumber<=100?"A":RollNumber>100 && RollNumber<=500?"B":"C";
		};
		
		

		Function<Student,String> f2=new Function() {

			@Override
			public String apply(Object t) {
				
				Student s=(Student)t;
				int RollNumber=s.RollNo;
				String Section="";
				return Section=RollNumber<=100?"ASection":RollNumber>100 && RollNumber<=500?"BSection":"CSection";
				
			}
			
		};
		list.forEach(k -> System.out.println(f2.apply(k)));
	}

}
class Student{
	
	int RollNo;
	String Name;
	public Student(String Name,int RollNo) {
		this.Name=Name;
		this.RollNo=RollNo;
	}
}

//This is Functional Interface which will tahe a Object and return another object
/*
 * interface Function<T,R>{
 * 
 * public R run(T t);
 * 
 * }
 */
