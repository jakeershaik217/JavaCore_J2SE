package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;

public class FinalComparable {

	public static void main(String[] args) {
		
      TreeSet tr=new TreeSet();
      ArrayList ar=new ArrayList();
      ar.add(new ComparableInteface(123,"jakeer"));
      ar.add(new ComparableInteface(156,"jak"));
      ar.add(new ComparableInteface(100,"j"));
      Collections.sort(ar);
      ar.forEach(ele -> System.out.println(ele));
      
	}

}


class ComparableInteface implements Comparable{
	
	int StudentID;
	String StudentName;
	ComparableInteface(int StudentID,String StudentName){
		
		this.StudentID=StudentID;
		this.StudentName=StudentName;
		
	}
public int compareTo(Object O){
		
		ComparableInteface cf=(ComparableInteface)O;
		Integer it1=new Integer(StudentID);
		Integer it2=new Integer(cf.StudentID);
		return it1.compareTo(it2);
		
		
	}

public String toString(){
	
	
	
	return StudentName;
}
	
}

class extended extends ComparableInteface implements Comparable{//when ever we extends the class that will not effect comparable (I)
	
	
	extended(int StudentID, String StudentName) {
		super(StudentID, StudentName);
		
	}

	public int compareTo(Object O){
		
		ComparableInteface cf=(ComparableInteface)O;
		Integer it1=new Integer(super.StudentID);
		Integer it2=new Integer(cf.StudentID);
		return it1.compareTo(it2);
		
		
	}
	
	
}
