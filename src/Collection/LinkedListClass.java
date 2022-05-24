package Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListClass {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		LinkedList l1=new LinkedList();
		BasicList b=new BasicList();
		//Adding Objects to LinkedList
		System.out.println("**************Adding Objects to LinkedList**********************");
		l.add(500);//wrapper int
		l.add("Jakeer");
		l.add("Hussain");
		l.add('g');//wrapper Char
		ListIterator it=l.listIterator();
		while(it.hasNext()) {
			
			System.out.println(it.next());
			
		}
	
		//Retrieving First element
		System.out.println("**********Retrieving First element*******************");
		Object o=l.getFirst();
		System.out.println(o);
		
		
		//Retrieving First element after  Deleting First element
				System.out.println("**********Retrieving First element after  Deleting First element*******************");
				l.removeFirst();
				System.out.println(l.getFirst());
		
		
				//Retrieving Last element 
				System.out.println("*********Retrieving Last element **********");
		       System.out.println(l.getLast());
		       
		       
		       //adding List at a specific index
		       
		       System.out.println("*********adding List at a specific index**********");
	           l1.add("e")	;
	           l1.add(b);
	           l1.addAll(1, l);//adding List at a specific index
	           for(Object ob:l1) {
	        	   System.out.println(ob);
	        	   System.out.println(ob.toString());
	        	   
	           }
		
	           System.out.println("*********Object Cloning***************");
	           //Object Cloning
		       Object on=l1.clone();
		       l1.clear();
		       l1.addFirst(on);
		       l1.add("one");
		       l1.add(123);
		       System.out.println(l1.size());
		       ListIterator itr=l1.listIterator();
		       while(itr.hasNext()) {
		    	  
		    	  System.out.println(itr.next());		    	   
		    	   
		       }
		
		       
		      //descendingIterator print the list in reverse order
		       System.out.println("******************descendingIterator*******************");
		      Iterator ir=l1.descendingIterator();
		      while(ir.hasNext()) {
		    	  
		    	  System.out.println(ir.next());
		      }
		       
		    //Retrieves the first element
		      System.out.println("*******//Retrieves the first element********");
		      l1.removeFirst();
		    Object oj=  l1.element();//Retrieves the first element
		      System.out.println(oj);
		      
		      //retain all
		      System.out.println("***********retain all***************");
		      l1.clear();
		      l1.add("jakeer");
		      l1.add("hussain");
		      l.clear();
		      l.add("Shaik");
		      l1.addAll(l);
		     l1.retainAll(l);
		     ListIterator itrd=l1.listIterator();
		       while(itrd.hasNext()) {
		    	  
		    	  System.out.println(itrd.next());		    	   
		    	   
		       }
		       
		      Object[] oh= l1.toArray();
		      System.out.println(oh.length);
		      
		      
		    
		       
	}
	
	
	
	

}


class BasicList{
	static int i;
	
	public BasicList(){
		
		System.out.println(this.i);
		
		
	}
	
	
	
	
	
}