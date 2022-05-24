package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ComparableClass {

	public static void main(String[] args) {
		
		
		LinkedList ln=new LinkedList();
		ln.add(new ComparableClassPage(12));
		ln.add(new ComparableClassPage(11));
		ln.add(new ComparableClassPage(10));
		ln.add(new ComparableClassPage(9));
		
		Collections.sort(ln);
		System.out.println(ln);
		
		
	}

}


class ComparableClassPage implements Comparable{
	
	
	int ID;
	
	ComparableClassPage(int ID){
		
		this.ID=ID;
		
	}
	
	public int compareTo(Object ob){
		ComparableClassPage cs=(ComparableClassPage)ob;
		
		
		if(ID==cs.ID){
		
		return 0;
		
		}
		else if(ID>cs.ID){
			
			return 1;
		}
		else{
			
			
			return -1;
		}
	}
	
	public int hashCode(){
		
		
		return ID;
	}
	
	
	public String toString(){
		
		return ID+"";
		
	}
	
}

class ComparableClassPageString implements Comparable{
	
	
	String ID;
	
	ComparableClassPageString(String ID){
		
		this.ID=ID;
		
	}
	
	public int compareTo(Object ob){
		ComparableClassPageString cs=(ComparableClassPageString)ob;
		
		
		if(ID.equals(cs.ID)){
		
		return 0;
		
		}
		else {
			
			return 1;
			
		}
	}
	
	public int hashCode(){
		
		
		return super.hashCode();
	}
	
	
	public String toString(){
		
		return ID;
		
	}
	
}