package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorInterface {

	public static void main(String[] args) {
		
		ArrayList a1=new ArrayList();
		a1.add("Jakeer");
		a1.add("Hussain");
		Iterator it=a1.iterator();
		Iterator it1=a1.iterator();
		System.out.println(it.hasNext());//Checks for next element  is present or Not
		it.next();//Prints the current element and move the cursor to next element
		System.out.println(it.hasNext());//Checks for next element  is present or Not
		it.next();//Prints the current element and move the cursor to next element
		System.out.println(it.hasNext());//Checks for next element  is present or Not
		
		
		//Always remove() method should follow next() method
		it1.next();
		it1.remove();
		System.out.println(it1.next());
		for(Object o:a1) {
			
			System.out.println(o);
			
		}
		//it1.next();
		//it1.remove();
		//System.out.println(it1.next()); leads to Exception
		
		
		
		
		//ListIterator
		
		System.out.println("****************ListIterator*********************");
		ArrayList a2=new ArrayList();
		a2.add("Jakeer");
		a2.add("Hussain");
		a2.add("Shaik");
		
		ListIterator itr=a2.listIterator();
		
		System.out.println(itr.hasNext());
		itr.next();
		System.out.println(itr.hasNext());
		itr.next();
		System.out.println(itr.hasNext());
		itr.next();
		
		System.out.println(itr.hasNext( ));
		
		//System.out.println(itr.next());
		
		System.out.println("****************ListIterator printing reverse order*********************");
		ArrayList a3=new ArrayList();
		a3.add("Jakeer");
		a3.add("Hussain");
		a3.add("Shaik");
		
		ListIterator itrev=a3.listIterator();
		while(itrev.hasNext()) {
			
			itrev.next();
			System.out.println("Listiterator nextindex:::"+itrev.nextIndex());
		}
        while(itrev.hasPrevious()) {
			System.out.println(itrev.previous());
			System.out.println(itrev.previousIndex());
		}
		
		
		
		
		
		
	}

}
