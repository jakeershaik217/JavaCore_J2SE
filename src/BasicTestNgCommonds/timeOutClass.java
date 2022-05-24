package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class timeOutClass {
	
	@Test(timeOut=2)
	public static void sample(){//maximum time in milliseconds for executing test case
		
		for(int i=1;i<=2000;i++){
			
			System.out.println(i);
		}
	}

}
