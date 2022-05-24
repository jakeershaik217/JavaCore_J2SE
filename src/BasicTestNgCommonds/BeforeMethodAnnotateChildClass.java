package BasicTestNgCommonds;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BeforeMethodAnnotateChildClass extends BeforeMethodAnnotateParentClass {
  @Test
  public void f() {
	  System.out.println("f");
  }
 /* @BeforeMethod
  public void beforeMethodChild() {
	  System.out.println("beforeMethodChild");
  }

  @AfterMethod
  public void afterMethodChild() {
	  System.out.println("afterMethodChild");
  }*/

}


class BeforeMethodAnnotateParentClass {
	  @Test
	  public void g() {
		  
		  System.out.println("g");
	  }
	  @BeforeMethod
	  public void beforeMethodparent() {
		  
		  System.out.println("beforeMethodparent");
	  }

	  @AfterMethod
	  public void afterMethodparent() {
		  
		  System.out.println("afterMethodparent");
	  }

	}
