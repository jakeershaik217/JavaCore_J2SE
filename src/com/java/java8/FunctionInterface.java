package com.java.java8;

import java.util.function.Function;

public class FunctionInterface {

	public static void main(String[] args) {
		
		Function<Object[], String> function= intArray -> {
			int i=0;
			String sum="";
			intArray=(intArray instanceof Integer[])?(Integer[])intArray:(Character[])intArray;
			while(i<intArray.length) {
				int count=1;
				int index=i;
				int j=i+1;
				while(j<intArray.length) {
					if(intArray[i]==intArray[j]) {
						count++;
						j++;
					}else {
						break;
					}
				}
				i=j;
			
				sum=sum+count+intArray[index];
			}
			
			return sum;
		};
		
		System.out.println(function.apply(new Integer[] {1,1,1,2,2,3,3,3}));
		System.out.println(function.apply(new Character[] {'A','A','A','B','B'}));

	}

}
