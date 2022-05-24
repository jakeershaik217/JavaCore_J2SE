package Collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;


public class QueueClasss {

	Queue q=new LinkedList<>();//LinkedList also implements Queue
	public static void main(String[] args) {
		PriorityQueue<Object> pq1=new PriorityQueue<Object>();
//Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.		
		PriorityQueue pq2=new PriorityQueue(25, new ComparatorClass() );
//Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
		PriorityQueue pq3=new PriorityQueue(new ComparatorClass());
//Creates a PriorityQueue with the  specified comparator.
		PriorityQueue pq4=new PriorityQueue(pq1);
//Creates a PriorityQueue with the  specified Collection.
		PriorityQueue pq5=new PriorityQueue(25);
//Creates a PriorityQueue with the default initial capacity (25)
		PriorityQueue pq6=new PriorityQueue(pq2);
//Creates a PriorityQueue with specified Queue
		//PriorityQueue pq7=new PriorityQueue(new AdaptorClass());
//	Creates a PriorityQueue with given SortedSet
	
		
		
		pq1.add("jakeer");
		pq1.add("hussain");
		pq1.add("shaik");
		pq5.addAll(pq1);
		System.out.println("**************Natural Sorting queue*********************");
		for(Object oe:pq5) {
			
			System.out.println(oe);
		}
		System.out.println("**************custmize Sorting queue*********************");
         for(Object oe:pq1) {
			
			System.out.println(oe);
		}
		
         Comparator cq=pq2.comparator();//Returns Comparator Object
         System.out.println("**************Converting to Array*********************");
        Object[] obj= pq5.toArray();
        for(int i=0;i<obj.length;i++) {
        	
        	System.out.println(obj[i]);
        	
        }
        pq3.offer(1);
        pq3.offer(2);
        pq3.offer(3);
        System.out.println("**************offer method*********************");
        Iterator it=pq3.iterator();
        while(it.hasNext()) {
        	
        	System.out.println(it.next());
        }
        System.out.println("**************After poll method*********************");
        pq3.poll();//removes the head element in Queue
        
        Iterator it1=pq3.iterator();
        while(it1.hasNext()) {
        	
        	System.out.println(it1.next());
        }
        System.out.println("**************After peek method*********************");
        pq3.peek();//retrieve the top element of Queue
        Iterator it2=pq3.iterator();
        while(it2.hasNext()) {
        	
        	System.out.println(it2.next());
        }
        System.out.println("**************************Lambda expression***********************************");
        pq3.forEach(s -> System.out.println(s));
        
        System.out.println(pq3.element());//same as peek  but throws null pointer exception if queue is empty
        pq3.clear();
       // System.out.println(pq3.element());
        pq3.poll();// will not null point exception even the QUEUE IS EMPTY
        pq3.peek();// will not null point exception even the QUEUE IS EMPTY
        
     
	}

}


class ComparatorClass implements Comparator<Integer>{
	
	
	public int compare(Integer o1,Integer o2) {
		return o2.compareTo(o1);
		
		
	}

	public int hashCode() {
		
		
		
		System.out.println(super.hashCode());
		return super.hashCode();
		
	}
	
}	
class Setclass implements SortedSet{

	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet headSet(Object toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet subSet(Object fromElement, Object toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet tailSet(Object fromElement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
class AdaptorClass extends Setclass{
	
	
	
	
}
	
	
