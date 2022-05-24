package ComparatorClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

class BaseComparatorClass extends ComparatorClass{
	
	
	
	public static void main(String[] args) {
	

		
		System.out.println("*************Comparator is part of the same class***********");
		TreeSet tr=new TreeSet(new ComparatorClass());
		
		tr.add(new ComparatorClass("Jakeer"));
		tr.add(new ComparatorClass("Hussain"));
		tr.add(new ComparatorClass("Jakeer"));
		tr.add(new ComparatorClass("Shaik"));
		System.out.println(tr);
		
		System.out.println("*************Comparator is part of the same class and passing to sort method***********");
		ArrayList ar=new ArrayList();
		ar.add(new ComparatorClass("Jakeer"));
		ar.add(new ComparatorClass("Hussain"));
		ar.add(new ComparatorClass("Jakeer"));
		ar.add(new ComparatorClass("Shaik"));
		
		Collections.sort(ar,new ComparatorClass());
		
		System.out.println(ar);
		System.out.println("***************Comparator is in different class*********************");
        TreeSet tr1=new TreeSet(new myIDComparator());
		
		tr1.add(new IDComparator(12));
		tr1.add(new IDComparator(10));
		tr1.add(new IDComparator(25));
		tr1.add(new IDComparator(67));
		System.out.println(tr1);
	}
	
}

class ComparatorClass  implements Comparator{
	
	String Str;
	int ID;
	
	ComparatorClass(String Str){
		
		
		this.Str=Str;
	}
ComparatorClass(int ID){
		
		this.ID=ID;
		
	}
ComparatorClass(){
	
	
	
}

public int compare(Object O1,Object O2){
	
	ComparatorClass cp1=(ComparatorClass)O1;
	ComparatorClass cp2=(ComparatorClass)O2;
	
	return (cp2.Str.compareTo(cp1.Str));
	
}

public String toString(){
	
	
	
	return Str;
}
	
	
	
	
	
	
}





class IDComparator {
	
	int ID;
	IDComparator(int ID){
		
		this.ID=ID;
		
	}
IDComparator(){
		
		
		
	}

public String toString(){
	return ID+"";
	
	
	
}
	
}
class myIDComparator implements Comparator<IDComparator>{

	
	
	public int compare(IDComparator o1, IDComparator o2) {
		
		
		
		if(o1.ID==o2.ID){
			
			return 0;
			
		}
		else if(o1.ID>o2.ID){
			
			return 1;
			
		}
		else{
			
			
			return -1;
		}
	}

	
	
	
	
	
	
}
