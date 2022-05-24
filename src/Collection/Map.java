package Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import regularExpressions.PattrenMacher;

public class Map {

	public static void main(String[] args) {

		Map m=new Map();
		m.HashMap();
		
		java.util.Map<Object, Object> map=new HashMap<>();
		/**
		  map.put returns old value/Previous Value of the key if the key is inserted for
		  the first time then it returns null
		 */
		System.out.println(map.put(1, "Jakeer"));
		System.out.println(map.put(2, "Hussain"));
		System.out.println(map.put(3, "Shaik"));
		System.out.println(map.put(4, "JakeerHussainShaik"));
		/**
		  map.put returns old value/Previous Value of the key if the key is inserted for
		  the first time then it returns null else if key is already present then it returns oldValue here the value is Jakeer for key 1
		 */
		System.out.println(map.put(1, "JKS"));
		
		java.util.Map<Object, Object> map1=new HashMap<>();
		map1.putAll(map);
		map1.replace(4, "Jak");
		map1.remove(2);
		map1.remove(3, "Shaik");
		System.out.println(map1.size());
		System.out.println(map1.get(1));
		System.out.println(map1.containsKey(4));
		System.out.println(map1.containsValue("Jak"));
		Set<Object> keyset=map1.keySet();
		for(Object o:keyset)
			System.out.println(o+"---******-----"+map1.get(o));
		
		Collection<Object> valueSet=map1.values();
		for(Object o:valueSet)
			System.out.println(o);
		
		Set<Entry<Object, Object>> mapEntry=map1.entrySet();
		for(Entry<Object, Object> entrys:mapEntry)
			System.out.println(entrys);
		Iterator<Entry<Object, Object>> itr=mapEntry.iterator();
		while(itr.hasNext()) {
			Entry<Object, Object> entry=itr.next();
			if(Long.parseLong(entry.getKey().toString())%2==0) {
				entry.setValue("NewValueSet1");
				System.out.println(entry.getKey()+"********************"+entry.getValue());
			} 
			Matcher matm=Pattern.compile("[A-Z a-z][K][A-Z a-z]").matcher(entry.getValue().toString());
					
			if(matm.find()) {
				entry.setValue("NewValueSet2");
			    System.out.println(entry.getKey()+"********************"+entry.getValue());
			}
		}
		
		java.util.Map<Object,Object> syncMap=Collections.synchronizedMap(map1);//This is to make Map as Synchronized bcz HashMap is not a Synchronized 
		map1.clear();
		System.out.println(map1.isEmpty());
		
		
		
		
	}
	
	public void HashMap(){
		
		
		HashMap<String,String> hm1=new HashMap<String,String>();
		
		hm1.put("Jak", "1");
		hm1.put("Hu", "2");
		hm1.put("Shaik", "3");
		System.out.println(hm1);
		
	}
	
	
	public int hashCode(){
		
		int i=super.hashCode();
		System.out.println(i);
		return i;
		
		
	}

}
