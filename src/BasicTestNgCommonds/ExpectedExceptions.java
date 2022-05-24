package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class ExpectedExceptions {

	
		
		@Test(expectedExceptions=ArithmeticException.class,priority=0)//it will make the TestCase as "Pass" even the method caught exception since we declared the exceptions
		public static void ArException(){
			
			int i=1/0;
			
		

	}
		@Test(expectedExceptions=ArithmeticException.class,priority=1)//it will make the TestCase as "Fail" even the method caught exception since we declared the different exceptions
		public static void ArrayException(){
			
			int[] i=new int[10];
			i[10]=15;
			
		

	}
		@Test(expectedExceptions=Exception.class,priority=2)//it will make the TestCase as "Pass" since the method caught exception since we declared the  exceptions
		public static void Exception(){
			
			int[] i=new int[10];
			i[10]=15;
			
		

	}

}
