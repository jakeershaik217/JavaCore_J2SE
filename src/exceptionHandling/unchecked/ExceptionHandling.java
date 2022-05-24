package exceptionHandling.unchecked;

import java.io.FileInputStream;

//unchecked exception(Not checked By compiler-runtime exception)
public class ExceptionHandling {
	
	public static void main(String []args) {
		try {
			
			//un checked
		int i=50/0;                  /* Exception in thread "main" java.lang.ArithmeticException: / by zero
		                                at com.Test.ExceptionHandling.main(ExceptionHandling.java:9)*/
		
		
		}catch(ArithmeticException e) {
		
			e.printStackTrace();       //Prints complete stack information
			System.out.println(e);
			
		}
		
	   try{
		   

			String s1="jakeer";
			//un checked
			s1.charAt(7);  /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 7
		                                       at java.lang.String.charAt(Unknown Source)
		                                       at com.Test.ExceptionHandling.main(ExceptionHandling.java:16)*/
		   
		   
	   }   
		   catch(StringIndexOutOfBoundsException e) {
	  
		
		e.printStackTrace();                //Prints complete stack information
		System.out.println(e);
		
	  }
		
	   try{
		   

			int a[]= {1,2,3};
			//un checked
			System.out.println(a[4]);  /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 7
		                                       at java.lang.String.charAt(Unknown Source)
		                                       at com.Test.ExceptionHandling.main(ExceptionHandling.java:16)*/
		   
		   
	   }   
		   catch(ArrayIndexOutOfBoundsException e) {
	  
		
		e.printStackTrace();                //Prints complete stack information
		System.out.println("\n"+e);         //Print only exception line
		
	  }
	
	
	   
	 
	
	}
	
	
	

}
