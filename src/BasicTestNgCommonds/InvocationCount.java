package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount=3)//it will run test cases depends on invocationCount
	public static void Count(){
		
	System.out.println("INvocationCount");	
		
		
	}

}
