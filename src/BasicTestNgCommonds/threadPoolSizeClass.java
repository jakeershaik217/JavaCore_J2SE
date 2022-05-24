package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class threadPoolSizeClass {
	
	@Test(threadPoolSize=2)
	public static void Pool(){
		
		System.out.println("Jakeer");
		
	}

}
