package BasicTestNgCommonds;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBowserTestingDataProvider {
	
	@DataProvider(name="Sample")
	public static Object[][] mainfunction(){
		
		Object[][] Obj={{"IE"},{"chrome"}};
		return Obj;
		
		
	}
	
	@Test(dataProvider="Sample")
	public static void crossBrowser(String S){
		
		if(S.equals("IE")){
			
			System.out.println("IE function");
		}
		else if(S.equals("chrome")){
			
			System.out.println("chrome function");
		}
		
		
	}

}
