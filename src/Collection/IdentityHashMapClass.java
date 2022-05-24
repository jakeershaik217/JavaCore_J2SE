package Collection;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapClass {

	public static void main(String[] args) {
		IdentityHashMap ih1=new IdentityHashMap();
//Constructs a new, empty identity hash map with a default expected maximum size (21).
		IdentityHashMap  ih2=new IdentityHashMap(25);
//Constructs a new, empty identity hash map with a maximum size of 25.
		IdentityHashMap  ih3=new IdentityHashMap(ih2);
//Constructs a new, identity hash map with a  size of ih3.
		
		ih2.put(1, 1000);
		IdentityHashMap  ih4=new IdentityHashMap(ih2);//Creates and copies the Entry's of ih2 in ih4
		System.out.println(ih4);
		
// Main Usage of IdentityHaspMap
		
		/*where the haspMap uses .equals method(content check) for Key value checking where IdentityHashMap do reference compare for the Key values
		 * 
		 */
		System.out.println("*****************IdentityHashMap example***************");
		ih2.clear();
		ih2.put(1, "Jakeer");
		ih2.put(2, "Hussain");
		ih2.put(1, "Shaik");
		System.out.println(ih2);
		
		
		ih1.clear();
		String s1=new String("one");
		String s2=new String("one");
		ih1.put(s1, "add one");         //Create Two reference for s1 and s2
		ih1.put(s2, "add two");
		System.out.println(ih1);
		
		ih1.clear();
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		ih1.put(i1, "add one");         //Create Two reference for i1 and i2
		ih1.put(i2, "add two");
		System.out.println(ih1);
		
		ih1.clear();
		String Str1="Jakeer";
		String Str2="Jakeer";
		ih1.put(Str1, "add one");       //Create Same reference for Str1 and Str2
		ih1.put(Str2, "add two");
		System.out.println(ih1);
		
		ih1.clear();
		Integer it1=10;
		Integer it2=10;
		ih1.put(it1, "add one");       //Create Same reference for it1 and it2
		ih1.put(it2, "add two");
		System.out.println(ih1);
		
		//Same examples with HashMap
		System.gc();
		HashMap h1=new HashMap();
		String S1=new String("one");
		String S2=new String("one");      
		h1.put(S1, "add one");           //Create Two reference for S1 and S2 but content is same.
		h1.put(S2, "add two");
		System.out.println(h1);
		
		h1.clear();
		Integer I1=new Integer(10);
		Integer I2=new Integer(10);      //Create Two reference for I1 and I2 but content is same.
		h1.put(I1, "add one");
		h1.put(I2, "add two");
		System.out.println(h1);
		
		
		
		
	}

}
