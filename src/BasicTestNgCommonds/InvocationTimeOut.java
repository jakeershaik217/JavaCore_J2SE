package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class InvocationTimeOut {
	@Test(invocationCount=3000000,invocationTimeOut=1000)//the time  taken to run the test cases 
	public static void Timeout(){
		
	System.out.println("INvocationCount");	
		
		
	}

}
