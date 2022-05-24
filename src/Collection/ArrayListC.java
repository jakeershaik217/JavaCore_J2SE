package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Predicate;

import com.graphbuilder.struc.Stack;

class ArrayListC {

	List<Object> arrayList;
	ArrayListC(){
		arrayList=new ArrayList<>()	;
	}
	ArrayListC(int intialCapacity){
		arrayList=new ArrayList<>(intialCapacity);
	}
	ArrayListC(Collection C){
		arrayList=new ArrayList<>(C);
	}
	List<Object> getArrayList(){
		
		return this.arrayList;
	}
	
	
	public static void main(String[] args) {
		
		ArrayListC a1=new ArrayListC();
		Integer[] intss= {1,5,64,7,88,11,65};
		Comparator<Integer> cp=(s1,s2) -> {return -s1.compareTo(s2);};
		System.exit(0);
		ArrayListC a2=new ArrayListC(25);
		ArrayListC a3=new ArrayListC(a2.arrayList);
		a1.getArrayList().add(a1.getArrayList().size()>0?a1.getArrayList().size()-1:a1.getArrayList().size(), "Jakeer");
		a2.getArrayList().add(a1.getArrayList().size()>0?a1.getArrayList().size()-1:a1.getArrayList().size(), "Jakeer");
		a3.getArrayList().addAll(a2.getArrayList());
		Predicate<String> p= i -> i.equals("Jakeer")?true:false;
		System.out.println(a3.getArrayList().remove(p));
		a1.getArrayList().clear();
		a2.getArrayList().clear();
		String[] JSH={"Jakeer","Shaik","Hussain","1"};
		String[] JHS={"Jakeer","Hussain","Shaik"};
		a1.getArrayList().addAll(Arrays.asList(JSH));
		a2.getArrayList().addAll(Arrays.asList(JHS));
		System.out.println(a1.getArrayList().equals(a2.getArrayList()));
		System.out.println(a1.getArrayList().contains("Jakeer"));
		System.out.println(a1.getArrayList().containsAll(a2.getArrayList()));
		a1.getArrayList().retainAll(a2.getArrayList());
		System.out.println(a1.getArrayList());
		
		a1.getArrayList().clear();
		for(long i=0;i<(long)Math.pow(2, 20)-1;i++)
			a1.getArrayList().add(i);
		
		LinkedList<Object> obj1=new LinkedList<>();
		LinkedList<Object> obj2=new LinkedList<>(obj1);
	    Vector<Object> V1=new Vector<>();
	    Vector<Object> V2=new Vector<>(20);
	    Vector<Object> V3=new Vector<>(20,5);
	    Vector<Object> V4=new Vector<>(V3);
	    
	    
	    Stack S1=new Stack();
	    S1.push(1);
	    S1.push(2);
	    S1.push(3);
	    System.out.println(S1);
	    
	    Enumeration<Object> E1=V1.elements();
	   ListIterator<Object> lst= a1.getArrayList().listIterator();
	   while(lst.hasNext()) 
		 lst.next(); 
	   while(lst.hasPrevious()) {
			Long ints=(Long)lst.previous();
			if(ints%2!=0)
				lst.remove();
			
	   }
	  
	   
	   while(lst.hasNext()) 
			lst.next(); 
	   
	   while(lst.hasPrevious()) {
		   System.out.println( lst.previous());
		   
	   }
		
	}
	
	

}
class SetInterface{
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
	}
	
	
}

