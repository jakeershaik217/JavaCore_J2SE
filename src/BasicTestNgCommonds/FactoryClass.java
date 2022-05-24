package BasicTestNgCommonds;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

class SimpleTestFactory
{
	int ID;
   
    
	public SimpleTestFactory(int i) {
		this.ID=i;
	}

	
    
    @Test
    public void implement(){
    	
    	
    	System.out.println("ID is :::"+"    "+ID);
    }
    
}
 
public class   FactoryClass
{
    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new SimpleTestFactory(10), new SimpleTestFactory(20) };
    }
}
