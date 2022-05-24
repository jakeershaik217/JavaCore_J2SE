package BasicTestNgCommonds;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class TestNG3 extends TestNG2{

	@Test(description="name")
	void run(){
		
		System.out.println("TestNG3");
		
	}

}
