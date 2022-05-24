package com.Test;

public class Variable extends Object {
	
	 int $_a=10;
	 float f_$= 10.5121212154165161f;
	 int []a;
	 String s1="jakeer";
	 String []jakeer= {"jak"};
     long lng;
	void m1() {
		int f_$=123456;
		System.out.println(f_$);
		
	}
	void m2() {
		
		m1();
		System.out.println(f_$);	
	}
	public static void main(String []jakeer) {
		Variable v=new Variable();
		v.m2();
	}
	
	
	
	
}
