package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class TestMethodReturnvalue {
	
	@Test(groups = { "fast" })
	public String m1(){
		
		return "m1";
		
	}
	
	@Test(groups = { "slow" })
	public void m2(){
		
		System.out.println(m1());
		
	}

}
