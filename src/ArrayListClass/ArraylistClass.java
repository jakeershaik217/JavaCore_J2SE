package ArrayListClass;

import java.util.ArrayList;
import java.util.Arrays;

import com.Test.Emp;



class ArraylistClass {

	public static void main(String[] args) {
		Emp e1=new Emp(111,"Jakeer");
		Emp e2=new Emp(123,"Hussain");
		ArrayList<Emp>  a=new ArrayList<Emp>();
		a.add(e1);
		for(Emp e:a) {
			
			System.out.println(e.Sdr);
			
		}
		ArrayList  a1=new ArrayList();
		a1.add(10);
		a1.add("Jakeer");
		a1.add(12.5);
		System.out.println(a1.size());
		a1.remove(10);//Object
		a1.remove(0);//Index 
		a1.add(25);
		Integer i=new Integer(25);
		a1.remove(i);
		System.out.println(a1.size());
		System.out.println(a1.size());
	}

}
