package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableInterface {
	
	static {
		
	}

	
	public static void main(String[] args) {
		//Comparator Not generic
		System.out.println("*******Comparator Not generic*********");
		ArrayList a1=new ArrayList();
		a1.add(new EmployeeClass(111,"Jaker"));
		a1.add(new EmployeeClass(100,"Shaik"));
		for(Object o:a1) {
			EmployeeClass e=(EmployeeClass)o;
			System.out.println(e.EmpID+"  "+e.EmpName);
		}
       Collections.sort(a1);
       for(Object o:a1) {
			EmployeeClass e=(EmployeeClass)o;
			System.out.println(e.EmpID+"  "+e.EmpName);
		}
     //Comparator Generic
		System.out.println("*******Comparator Generic*********");
       ArrayList<EmployeeClass_GenericComparable> a2=new ArrayList<EmployeeClass_GenericComparable>();
		a2.add(new EmployeeClass_GenericComparable(99,"Shaik"));
		a2.add(new EmployeeClass_GenericComparable(100,"Hussain"));
		for(EmployeeClass_GenericComparable o:a2) {
			
			System.out.println(o.EmpID+"  "+o.EmpName);
		}
      Collections.sort(a2);
      for(EmployeeClass_GenericComparable o:a2) {
			
			System.out.println(o.EmpID+"  "+o.EmpName);
		}
       
       
	}

}
