package BasicTestNgCommonds;

import org.testng.annotations.*;

public class TestNG2 extends TestNG1{

	
@BeforeSuite
void beforeSuite2(){
	
	System.out.println("BasicTestNgCommonds:::@BeforeSuite:::TestNG2");
	
	
}
@BeforeTest
void beforetest2(){
	
	System.out.println("BasicTestNgCommonds:::@BeforeTest:::TestNG2");
	
}
@Test(groups = { "windows.functest", "windows.checkintest" })
void Test1_2(){
	
	System.out.println("BasicTestNgCommonds:::@Test1:::TestNG2");
	//Assert.assertTrue(false);
}
@Test(groups = "windows.functest")
void Test2_2(){
	
	System.out.println("BasicTestNgCommonds:::@Test2:::TestNG2");
	
}
@Test(groups = "windows.checkintest")
void Test3_2(){
	
	System.out.println("BasicTestNgCommonds:::@Test3:::TestNG2");
	
}
@AfterTest
void Aftertest2(){
	
	System.out.println("BasicTestNgCommonds:::@AfterTest:::TestNG2");
	
}
@AfterSuite
void AfterSuite2(){
	
	System.out.println("BasicTestNgCommonds:::@AfterSuite:::TestNG2");
	
}

}
