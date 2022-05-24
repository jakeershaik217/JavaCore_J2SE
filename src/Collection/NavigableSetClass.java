package Collection;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class NavigableSetClass {

	public static void main(String[] args) {
		
		NavigableSet<Object> NS=new TreeSet<Object>();
		String[] Str= {"Jakeer","Hussain","Shaik","JSK","JakeerHussain","HussainShaik"};
		NS.addAll(Arrays.asList(Str));
		System.out.println(NS.ceiling("JSK"));
		System.out.println(NS.floor("JSK"));
		System.out.println(NS.higher("JSK"));
		System.out.println(NS.lower("JSK"));
		
		NavigableSet<Object> NS1=new TreeSet<Object>();
		Integer[] ints= {1,5,6,7,9,4,6,8,10};
		NS1.addAll(Arrays.asList(ints));
		System.out.println(NS1);
		System.out.println(NS1.ceiling(5));
		System.out.println(NS1.floor(5));
		System.out.println(NS1.higher(5));
		System.out.println(NS1.lower(5));

	}

}
