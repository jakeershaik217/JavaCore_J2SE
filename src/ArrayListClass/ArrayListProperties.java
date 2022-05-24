package ArrayListClass;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class ArrayListProperties {
	
	
	public static void main(String []args) {
		
		ArrayList<String> a1=new ArrayList<String>();
		a1.add("jakeer");
		a1.add("Hussain");
		a1.add("shaik");
		ArrayList<String> a2=new ArrayList<String>(a1);
		System.out.println(a1.size());
		System.out.println(a2.size());//Constructor collection as a parameter
		ListIterator lst=a2.listIterator();
			while(lst.hasNext()) {
				
			}
			
		Vector V=new Vector();
		Enumeration n=V.elements();
	
	}

}
