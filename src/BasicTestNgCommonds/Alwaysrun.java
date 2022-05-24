package BasicTestNgCommonds;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Alwaysrun {
	
	
	
	@Test(groups={"first"})
	public static void m1(){
		
		assertTrue(false);
		
	}
	
	@Test(groups={"second"})
	public static void m2(){
		
		assertTrue(true);
		
	}
	@Test(groups={"second"})
	public static void m3(){
		
		assertTrue(true);
		
	}
	@Test(groups={"four"})
	public static void m4(){
		
		assertTrue(true);
		
	}
	@Test(dependsOnGroups={"first","second"},groups={"five"})//always run method is used when there is dependent methods are present
	public static void m5(){
		
		assertTrue(true);
		
	}

}
