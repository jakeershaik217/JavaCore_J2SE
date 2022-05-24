package ArrayListClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Converting_ArrayList_to_Array {

	public static void main(String[] args) {
		ArrayList<String> a1=new ArrayList(2);
		int i=2147483647;
		a1.add("11");
		a1.add("22");
		a1.add("09");
		a1.add("jakeer");
		Object[] obj=new Object[a1.size()];
		a1.toArray(obj);
		System.out.println("After converting arraylist to array");
		for(Object O: obj){
			
			System.out.println(O);
		}
	//a1.add(new Converting_ArrayList_to_Array());// before comp
		Collections.sort(a1);
		ListIterator<String> Str=a1.listIterator();
		while(Str.hasNext()) {
			
			System.out.println(Str.next());
			
		}
		ArrayList<Long> a2=new ArrayList<Long>(2);
		for(long l=0;l<Math.pow(2, 20);l++) {
			
			a2.add(l);
			
		}
		
		a2.add((int)Math.pow(2, 10), 45664L);
		
		ListIterator Sr=a2.listIterator();
		while(Sr.hasNext()) {
			
			System.out.println(Sr.next());
			
		}
		
		
		/*LinkedList<Long> a3=new LinkedList<Long>();
		for(long l=0;l<Math.pow(2, 20);l++) {
			
			a3.add(l);
			
		}
		ListIterator S=a3.listIterator();
		while(S.hasNext()) {
			
			System.out.println(S.next());
			
		}*/
	}

}
