package interview;

import java.util.Arrays;

public class SortingTechniques {
	
	static String SortedString=getSortedStringUsingArrays_Sort("jakeerhussainshaik");
	static Object SortedObject=getSortedObjectUsingArrays_Sort(12345698);
	
	static String getSortedStringUsingArrays_Sort(String string) {
		char[] chr=string.toCharArray();
		String Sd="";
		Arrays.sort(chr);
		for(char c:chr)
		   Sd+=String.valueOf(c);
		System.out.println(Sd);
		return Sd;
	}
	
	static Object getSortedObjectUsingArrays_Sort(Object obj) {
		
		if(obj instanceof String) {
			String Str=(String)obj;
			char chr[]=Str.toCharArray();
		String Sd="";
		Arrays.sort(chr);
		for(char c:chr)
		   Sd+=String.valueOf(c);
		System.out.println(Sd);
		return Sd;    
			
		}else if(obj instanceof Number) {
			
			String Str=obj+"";
			char chr[]=Str.toCharArray();
			
			int[] inr=new int[chr.length];
			for(int i=0;i<chr.length;i++)
			{
				
				inr[i]=Character.getNumericValue(chr[i]);
			}
			
			Arrays.sort(inr);
			String Sd="";
			for(int i:inr)
				Sd+=i;
			System.out.println(Sd);
			return Integer.parseInt(Sd);
		}else {
			
			return obj;
		}
		
		
		
		
	}
	
	public static void main(String[] args) {

	}

}
