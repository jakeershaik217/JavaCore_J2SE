package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorINterface {
	

	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		a1.add(new StudentClass(111,"Jaker"));
		a1.add(new StudentClass(100,"Shaik"));
		a1.add(new StudentClass(90,"Hussain"));
		for(Object o:a1) {
			StudentClass e=(StudentClass)o;
			System.out.println(e.StudentID+"  "+e.StudnetName);
		}
       Collections.sort(a1,new StudentName());
       for(Object o:a1) {
			StudentClass e=(StudentClass)o;
			System.out.println(e.StudentID+"  "+e.StudnetName);
		}

	}

}
