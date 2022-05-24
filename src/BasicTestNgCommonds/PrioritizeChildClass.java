package BasicTestNgCommonds;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class PrioritizeChildClass extends PrioritizeParentClass {
 /* @Test(priority=0)
  public void a_() { //only Names are allowed else execution is unpredictable
	  
	  
  }*/
 
  @Test//(priority=1) priority should be given to all methods then only priority will be executed in sequence
  public void c() {
	  
		 System.out.println("PrioritizeChildClass");
  
  }
 


}

class PrioritizeParentClass extends  PrioritizeGrandParentClass{
	
	 
	
	 @Test
	  public void a() {
		  
		 System.out.println("PrioritizeParentClass");
  
	  }
	 @Test
	  public void b() {
		  
		 System.out.println("PrioritizeParentClass");
		  
	  }
	
	
}



class PrioritizeGrandParentClass {
	 
	 @Test(priority=1)
	  public void g() {
		  
		 System.out.println("PrioritizeGrandParentClass"); 
	  }
	
	
}


class PrioritizeGGrandParentClass {
	 
	 @Test(priority=0)//if base class and derived class has same priority and child class will come first in alphabetical order even base class test will execute first
	  public void t() {
		 
		 System.out.println("PrioritizeGGrandParentClass");
		  
	  }
	
	
}
