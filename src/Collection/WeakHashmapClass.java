package Collection;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashmapClass {

	public static void main(String[] args) {
		WeakHashMap wm1=new WeakHashMap();
//Constructs a new, empty WeakHashMap with the default initial capacity (16) and load factor (0.75).		
		WeakHashMap wm2=new WeakHashMap(20);
//Constructs a new, empty WeakHashMap with the given initial capacity(20) and the default load factor (0.75).		
		WeakHashMap wm3=new WeakHashMap(20, 0.95f);
//Constructs a new, empty WeakHashMap with the given initial capacity(20) and the given load factor.(0.95)		
		WeakHashMap wm4=new WeakHashMap(wm3);
		
	/*WeakHashMap will loose the Key object if the Key Object is refers to null
	 * 
	 * Where as HaspMap will not loose Key Object even it refers to null*/	
		
		System.out.println("**************Example with WeakHashmap************");
		Temp t=new Temp();
		wm1.put(t, "Jakeer");
		wm1.put(1, "Shaik");
		t=null;
		System.gc();
		System.out.println(wm1);
		
		
		
		
		System.out.println("**************Example with HashMap************");
		HashMap h=new HashMap();
		Demp d=new Demp();
		h.put(d, "Jakeer");
		h.put(1, "Shaik");
		d=null;
		System.gc();
		System.out.println(h);
		
	}
}
		
		class Temp{
			
			public String toString() {
				
				return "Temp";
				
		
				
				
			}
			public void finalize(){    //Any Object before Going to destroy by Garbage Collection then finalize method will be executed before devastation
				
			System.out.println("Finalize Method is executing");	
				
				
				
			}
			
			
			
			
			
		}
		
		
class Demp{
			
			public String toString() {
				
				return "Demp";
				
		
				
				
			}
			public void finalize(){    //Any Object before Going to destroy by Garbage Collection then finalize method will be executed before devastation
				
			System.out.println("Finalize Method is executing");	
				
				
				
			}
			
			
			
			
			
		}
		
		
