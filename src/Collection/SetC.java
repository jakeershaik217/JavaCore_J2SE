package Collection;

import java.util.*;

public class SetC {
	
	
	public static void main(String[] args) {
		
		Set<Object> set=new HashSet<Object>();
		set.add(new Integer(10));
		set.add(new Integer(12));
		set.add(new Integer(13));
		set.add(new Integer(10));
		System.out.println(set);
		
	}

}
