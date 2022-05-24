package com.java.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorImplementation {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> array=new ArrayList<>();
		array.add(101);
		array.add(100);
		array.add(20);
		array.add(110);
		
		array.add(1110);
		array.add(010);
		array.add(105);
		
		array.add(1044);
		array.add(1054);
		
		array.add(1015);
		
		Comparator<Integer> cp=(Integer i1,Integer i2) ->{
			
		if(i1<i2)
			return -1;
		else if(i1>i2)
			return 1;
		else
			return 0;
			
		};
		
		Comparator<Integer> cp2=(Integer i1,Integer i2) ->{
			
			return (i1<i2)?1:(i1>i2)?-1:0;
				
			};
			
		Comparator<Integer> cp3=new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer i1=(Integer)o1;
				Integer i2=(Integer)o2;
				return (i1%2==0 && i2%2==0)?0:(i1%2==0 && i2%2!=0)?1:(i1%2!=0 && i2%2==0)?-1:0;
				
			}
			
			
			
		};
		
			
		Collections.sort(array,cp);
		System.out.println("--------------Ascending Order----------");
		array.forEach(k -> System.out.println(k));
		
		
		Collections.sort(array,cp2);
		System.out.println("--------------Descending Order----------");
		array.forEach(k -> System.out.println(k));
		
		Collections.sort(array,cp3);
		System.out.println("--------------Even Odd Group------Ascending Order----------");
		array.forEach(k -> System.out.println(k));
		
	}

}
