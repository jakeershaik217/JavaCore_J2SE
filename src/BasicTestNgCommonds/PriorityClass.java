package BasicTestNgCommonds;

import org.testng.annotations.Test;

public class PriorityClass {
	/* @Test(priority=0)
	  public void a_() { //only Names are allowed else execution is unpredictable
		  
		  
	  }*/
	
	/* @Test//(priority=1) priority should be given to all methods then only priority will be executed in sequence
	  public void e() {
		  
		  
	  }*/
  @Test(priority = 0)
  public void a() {
	 
	  System.out.println(Integer.MIN_VALUE+"          "+Integer.MAX_VALUE);
	  System.out.println(Byte.MIN_VALUE+"          "+Byte.MAX_VALUE);
	  System.out.println(Double.MIN_VALUE+"          "+Double.MAX_VALUE);
	  System.out.println(Float.MIN_VALUE+"          "+Float.MAX_VALUE);
	 System.out.println( Integer.parseInt("J"));
	 System.out.println(  Byte.parseByte("B"));
  }
  @Test(priority = 1)
  public void b() {
	  
	  
  }
  @Test(priority = 2)
  public void c() {
	  
	  
  }
  
  @Test(priority = 3)               //(priority = 0) same priority will cause selection on alphabetical order
  public void d() {
	  
	  
  }
  
 
 
}
