package BasicTestNgCommonds;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class ThreadedAndMulithread {
	
	
	
	@Test
	public static void m1(){
		
		assertTrue(false);
		
	}
	
	@Test
	public static void m2(){
		
		assertTrue(true);
		
	}
	@Test
	public static void m3(){
		
		assertTrue(true);
		
	}
	@Test(singleThreaded=false)
	public static void m4(){
		
		assertTrue(true);
		
	}
	@Test(singleThreaded=true)//always run method is used when there is dependent methods are present
	public static void m5(){
		
		assertTrue(true);
		
	}

}
