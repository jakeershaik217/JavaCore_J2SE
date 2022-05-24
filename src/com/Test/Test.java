package com.Test;

 class New{
	
	private static int i=500;
	New(){
		m1();
		System.out.println("Constructor");
		int i=50;
		System.out.println(i);
		m2();
	}
	
   private void  m1() {
	   System.out.println(i);
	   System.out.println("Method"); 
   }
	
   static void  m2() {
	   System.out.println(i); 
	   System.out.println("Method"); 
   }
 }
public  class Test extends New{
	
	public static void main(String[] args) {
		
		
		Test t=new Test();         //Child has indirect access to Parent attributes when they are declared as Private
		/*t.m1(); */               //Child don't have direct access to parent attributes when they are declared as private
		int a[]=new int[5];
		
	}
}