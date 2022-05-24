package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetClass {//Duplicates are not allowed and Order is not preserved

	public static void main(String[] args) {
		//TreeSet doesn't allow heterogeneous objects
		TreeSet t1=new TreeSet();
		ArrayList a1=new ArrayList();
		a1.add(15);
		a1.add(12);
		//a1.add("jakeer");
		TreeSet t2=new TreeSet(a1);
		  Iterator it= t2.iterator();
		  while(it.hasNext()) {
			  
			  System.out.println(it.next());
		  }

		  
		  //printing in sorting order by default it's sorting order is ascending
		  //internally String implements Comparable interface
		  System.out.println("**printing in sorting order by default it's sorting order is ascending***");
		  t1.clear();
		  t1.add("jakeer");
		  t1.add("abc");
		  t1.add("dca");
		  t1.add("cda");
		  t1.add("shaik");
		  
		  Iterator it1= t1.iterator();
		  while(it1.hasNext()) {
			  
			  System.out.println(it1.next());
		  }
		  
		  //StringBuffer will not implement Comparable or Comparator so it will ns
		  
		  t1.clear();
		  t1.add(new StringBuffer("jakeer"));
		  t1.add(new StringBuffer("hussain"));
	}

}
