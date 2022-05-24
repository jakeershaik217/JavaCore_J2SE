package BasicTestNgCommonds;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.util.*;

public class DataProviderClass {
 
	public static List<Object> Lst;
	@DataProvider(name="List")
	public static Object[][] List(){
		
	
		return new HdfcBank().getNameandCode(102102, 101);
	}
	
	@Test(dataProvider="List",priority=0)
	public static void provide(Integer S,Integer I){
		
		System.out.println(S+"    "+I);
		
		
		
	}
	
	
	@DataProvider(name="Name")
	public Object[][] Dp(){
		
		Object[][]  Obj={{1,"Name"},{2,"D"}};
		return Obj;
		
		
		
		
	}
	
	@Test(dataProvider="Name",priority=1)
	public void dd(Integer I,String S){
		
		System.out.println(I+"   "+S);
		
		
	}
	
	
}

class HdfcBank {
	
	private int AccNumner;
	private String AccName;
	public static String BankName;
	public int IFSCCode;
	
	public Object[][] getNameandCode(int AccNumner,int IFSCCode){
		
		
		Object[][]  Obj={{AccNumner,IFSCCode}};
		return Obj;
		
		
		
	}
	
	
	
	
	
	
	
	
}
