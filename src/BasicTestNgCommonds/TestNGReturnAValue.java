package BasicTestNgCommonds;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestNGReturnAValue {
	
	
	
	@Test
	public static String m1(){
		
		return "Jakeer";
		
	}
	
	@Test
	public static void m2(){
		
		m1();
		assertTrue(true);
		
	}
	

}
