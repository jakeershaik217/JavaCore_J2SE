package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class integerOperations {
	 
	static void printPattern(int x) {
		char ch[]=(x+"").toCharArray();
		int count=1;
		Integer[] array=new Integer[ch.length+1];
		for(int i=0;i<ch.length;i++) 
			array[i]=Character.getNumericValue(ch[i]);
		for(int i=0;i<array.length;i++) {
			int j=i+1;
			if(j%2!=0) {
				array[i]=count;
				count++;
			}
		}
		new ArrayList<>(Arrays.asList(array)).forEach(k -> System.out.println(k));
	}
	
	public String toString() {
		return "";
		
	}

	public static void main(String[] args) {
		printPattern(1224364858);
	}

}
