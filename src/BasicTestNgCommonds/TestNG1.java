package BasicTestNgCommonds;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG1 {

	int a=10;
	int b=20;
	int c;
	
@BeforeSuite
void beforeSuite(){
	
	System.out.println("BasicTestNgCommonds:::@BeforeSuite:::TestNG1");
	
	
}
@BeforeTest
void beforetest(){
	
	System.out.println("BasicTestNgCommonds:::@BeforeTest:::TestNG1");
	
}
@Test(groups = { "functest", "checkintest" })
void Test1(){
	
	System.out.println("BasicTestNgCommonds:::@Test1:::TestNG1");
	//Assert.assertTrue(false);
}
@Test(groups = "functest")
void Test2(){
	
	System.out.println("BasicTestNgCommonds:::@Test2:::TestNG1");
	
}
@Test(groups = "checkintest")
void Test3(){
	
	System.out.println("BasicTestNgCommonds:::@Test3:::TestNG1");
	
}
@AfterTest
void Aftertest(){
	
	System.out.println("BasicTestNgCommonds:::@AfterTest:::TestNG1");
	
}
@AfterSuite
void AfterSuite(){
	
	System.out.println("BasicTestNgCommonds:::@AfterSuite:::TestNG1");
	
}

}
