package ComparatorClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class NaturalSorting {
	
	public String toString(){
		
		
		return getClass().getName();
		
	}

	public static void main(String[] args) {
		TreeSet tr=new TreeSet();
		tr.add("Jakeer");
		tr.add("Hussain");
		tr.add("Shaik");
		tr.add("Hussain");
		System.out.println(tr);
		
		ArrayList ar=new ArrayList();
		ar.add("Jakeer");
		ar.add("Hussain");
		ar.add("Shaik");
		ar.add("Hussain");
		Collections.sort(ar);
		System.out.println(ar);
		
	}

}
