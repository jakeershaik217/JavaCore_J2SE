package com.java.java8;


interface Interface{
	public void m1();
}

interface addNumbers{
	
	public int add(int... x);
	
}
public class FunctionalIntefaceClass {
	public static void main(String[] args) {
		Interface inf=() -> System.out.println("This is Functonal Interface Implementation");
		inf.m1();
		
		addNumbers AddInt=x -> {
			int sum=0;
			for(int i:x)
				sum+=i;
			return sum;
		};
		
		System.out.println(AddInt.add(1,2,7));
		
	}

}
