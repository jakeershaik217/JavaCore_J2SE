package Collection;

import java.util.TreeMap;

public class NavigableMap {

	public static void main(String[] args) {
		java.util.NavigableMap<Object, Object> navmap=new TreeMap<>();
		navmap.put(2, 'j');
		navmap.put(1, 'k');
		navmap.put(5, 'l');
		navmap.put(7, 'm');
		navmap.put(9, 'n');
		navmap.put(3, 'o');
		navmap.put(11, 'p');
		navmap.put(6, 'q');
		
		System.out.println(navmap);
		System.out.println(navmap.ceilingKey(7));
		System.out.println(navmap.floorKey(7));
		System.out.println(navmap.lowerKey(7));
		System.out.println(navmap.higherKey(7));
		

	}

}
