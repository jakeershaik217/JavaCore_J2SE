package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {

		HashMap hm1=new HashMap();//creates the hashmap with default capacity 16 and fill ratio 0.75
		HashMap hm2=new HashMap(15);//Create The HashMap with intialCapacity
		HashMap hm3=new HashMap(15, 0.9f);//Create The HashMap with intialCapacity and fill ration is Load Factor
		HashMap hm4=new HashMap(hm1);//Create HashMap with Map hm1 Capacity
		ArrayList a1=new ArrayList();
		//HashMap hm5=new HashMap(a1);  only allow Map as a parameter for constructor
		System.out.println("******************Heterogenious and null insertion**************");
	
	   hm1.put(null, null);	
	   hm1.put("1", "Jakeer");
	   hm1.put("2", "hussain");
	   hm1.put("7",new MapClass());
	   hm1.put("3", "Shaik");          //Heterogeneous and null insertion
	   hm1.put("4", null);
	   hm1.put("5", 12);
	   hm1.put("6",new StringBuffer("Jak"));
	
	   System.out.println(hm1);
	   for(Object o:hm1.keySet()) {
		   
		   
		   System.out.println(hm1.get(o));
	   }
	   
	 System.out.println("*************Duplicate Keys and values**************");
	 System.out.println( hm2.put("a", "Jakeer") ); 
	 hm2.put("b", "hussain") ;  
	 System.out.println(hm2.put("b", "shaik") ); //duplicate Key 
	 hm2.put("c", null) ;  
	 System.out.println(hm2.put("c", "Jak")) ; 
	 hm2.put("d", "Jakeer");//duplicate Value
	 System.out.println(hm2);
	 
	 System.out.println("*************Null Key insertion**************");
	 hm2.put(null, null);// null key is allowed
	 System.out.println(hm2); 
	 
	 System.out.println("*******************Methods**********************");
	System.out.println(hm1.containsKey("1"));
	System.out.println(hm1.containsValue("Jakeer"));
	System.out.println("*****************All Values in Collection******************");
	Collection C=hm1.values();
	System.out.println(C);
	System.out.println("*****************get method******************");
	System.out.println(hm1.get("1"));
	System.out.println("*****************Object Cloning******************");
	Object hs6=hm1.clone(); 
	System.out.println(hs6);
	System.out.println("*****************Equals Method******************");
	hm3.clear();
	hm3.put(1, 'a');
	hm3.put(2, 'b');
	hm3.put(3, 'c');
	hm4.clear();
	hm4.put(1, 'a');
	hm4.put(3, 'c');
	hm4.put(2, 'b');
	//hm4.put(4, 'd'); equals method check or entry(Key Value)Pairs
	System.out.println("*******************equals Methods check:::"+hm3.equals(hm4));
	System.out.println("*****************Entry Interface******************");
	Set s=hm4.entrySet();
	Iterator it=s.iterator();
	while(it.hasNext()) {
		
		Map.Entry m =(Map.Entry)it.next();
		System.out.println(m.getValue());
		System.out.println(m.getKey());
		System.out.println(m.setValue("Jak"));//replace the current Value of the entry
		System.out.println(m.getClass());
		
	}
	Iterator it1=s.iterator();
	while(it1.hasNext()) {
		
		Map.Entry m =(Map.Entry)it1.next();
		System.out.println(m.getValue());
		System.out.println(m.getKey());
		
		
	}
	 
	//*******************Java 8 Featured Methods*************************
	System.out.println("*******************Computing method*************************");
	hm4.clear();
	hm4.put(1, 2);
	hm4.put(2, 3);
	hm4.put(3, 4);
	System.out.println("Before Computing"+hm4);
	hm4.compute(1, (k, v) -> v == (Integer)10 ? 42 :  48);
	hm4.compute(4, (k,v) -> v==(Object)(10*1) ? 25:5);
	hm4.compute(1, (k,v) -> (k == (Integer)(6/5)) ? 225 :201);
	hm4.compute(4, (k,v) -> (v  == (Integer)(21/5)) ? 225 :201);
	System.out.println("After Computing"+hm4);
	System.out.println("*******************For Each*************************");
	hm4.forEach((k,v)-> System.out.println("k:"+k+"**"+"V:"+v));
	hm4.forEach((k,v) -> hm4.compute(k, (l,m) -> (Integer)m%2==(Integer)0  ? 222 : 333));
	System.out.println(hm4); 
	System.out.println("**********************Merge method********************");
	hm4.clear();
	hm4.put(1, 100);
	hm4.put(2, 200);
	hm4.put(3, 300);
	hm4.put(4, 300);
	hm4.merge(4, 500, (k,v) -> 400);/*replace 300 with 400 if Key '4' is present and add new entry {4=500} if Key '4' is not present in Map
	        null is not allowed here*/
	 
	System.out.println(hm4);
	System.out.println("**********************getOrDefault Method********************");
	System.out.println(hm4.getOrDefault(5, "Null returned"));//Returns Value associated with Key if Key is available else return DefaultValue("Null returned") in this case
	System.out.println(hm4.getOrDefault(4, "Null returned"));
	System.out.println(hm4);
	System.out.println("**********************Putif Method********************");
	System.out.println(hm4.putIfAbsent(2, 2000));
	System.out.println(hm4.putIfAbsent(3, 3000));//insert new Key and Value if Key is missed and returns null or return the Value of the Key if Key is present
	System.out.println(hm4.putIfAbsent(5, 300));
	System.out.println(hm4.putIfAbsent(6, 600));
	System.out.println(hm4);
	System.out.println("**********************remove(key ,value) Method********************");
	hm4.remove(6, 600);    //Removes the entry if and only if both Key is mapped to specified Value
	System.out.println(hm4);//will remove Entry
	hm4.remove(4, 100);
	System.out.println(hm4); //willn't remove Entry
	 System.out.println("**********************replaceall Method********************");
	 hm4.replaceAll((k,v) -> v==(Integer)200 ? 2000 : 1000);//Replace all Values with the new Value coming from the condition
	 System.out.println(hm4);
	 System.out.println("*******************replace(Key,OldValue,NewValue) methods");
	 hm4.replace(5, 1000, 5000);//Replace OldValue with NewValue if the Key is mapped to OldValue
	 System.out.println(hm4);//will replace
	 hm4.replace(6, 1000, 5000);
	 System.out.println(hm4);//willn't replace
	 System.out.println("*************ComputeifAbsent method");
	 hm4.computeIfAbsent(7, key -> "Esperanto at " + key);// adds the Key and Value if the Key is missed or Value of the Key is null
	 System.out.println(hm4);
	hm4.put(8, null);
	hm4.computeIfAbsent(8, key -> "null is updated ");
	System.out.println(hm4);
	System.out.println("*************ComputeifPresent method");
	 Map<Integer,String> nameForId = new HashMap<>();
	 
     // Adding new value:
     nameForId.computeIfPresent(1, (key, oldVal) -> {
         System.out.printf("BiFunction(%d,%s) for new%n",
                 key, oldVal);
         return "Java";
     });
     System.out.println("After add new: " + nameForId);

     // Updating:
     nameForId.put(1, "Java");
     nameForId.computeIfPresent(1, (key, oldVal) -> {
         System.out.printf("BiFunction(%d,%s) update%n",
                 key, oldVal);
         return oldVal.concat("Script");
     });
     System.out.println("After update: " + nameForId);

     // null removes:
     nameForId.computeIfPresent(1, (key, oldVal) -> {
         System.out.printf("BiFunction(%d,%s) -> null%n",
                 key, oldVal);
         return null;
     });
     System.out.println("After null: " + nameForId);
	}

}
