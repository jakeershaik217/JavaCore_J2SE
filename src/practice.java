import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.jsoup.select.Collector;

public class practice {
	
	
	static boolean check(String string) {
		int len=string.length();
		for(int i=0;i<len/2;i++) {
			if(string.charAt(i)!=string.charAt(len-1-i)) {
				return false;
			}
			
		}
		return true;
		
		
	}

	public static void main(String[] args) {
		Object Name=new ArrayList(Arrays.asList(new Character[] {'j','k'})).stream().collect(Collectors.toList());
		System.out.println(Name);
		int[] array=new int[256];
		char[] ch="My name is Guarav Kukade!".toCharArray();
		for(char c:ch)
			array[c]++;
		
		for(int i=0;i<array.length;i++)
			if(array[i]>=2 && (char)i!=' ')
				System.out.println((char)i+"******"+array[i]);
			String[] Str="Jakeer Hussain Shaik".split("\\s+");
			Arrays.asList(Str).forEach(k -> System.out.println(k));
			StringTokenizer Strd=new StringTokenizer("Jakeer Hussain Shaik");
			while(Strd.hasMoreTokens())

				System.out.println(Strd.nextToken());
			
			String S1="Jakeer";
			String S2="Hussain";
			S1=S1+S2;
			S2=S1.substring(0,S1.length()-S2.length());
			S1=S1.substring(S2.length());
			System.out.println(S1+"---"+S2);
			StringBuilder sb=new StringBuilder();
			System.out.println(sb.toString());
			
			 
			 Pattern pat=Pattern.compile("[^a-z0-9]",Pattern.CASE_INSENSITIVE);
			 Matcher m=pat.matcher("GeeksForGeeks@");
			 System.out.println(m.find());
			 
			 String Words="My Name is Jakeer Shaik is My Name Jakeer";
			 Map<String,Integer> map=new HashMap<>();
			 String[] Sd=Words.split("\\s");
			 for(String S:Sd)
				 if(map.containsKey(S)) 
					 map.put(S, map.get(S)+1);
			     else
			    	 map.put(S, 1);
						 
			Set<Entry<String,Integer>> maps=map.entrySet();
			for(Entry e:maps)
				if((Integer)e.getValue()==1)
				System.out.println(e.getKey());
			
			 String[] words = Words.split("\\W");
			 new ArrayList<>(Arrays.asList(words)).forEach(k -> System.out.println(k));
			 
			 int[] ints= {1,2,3,5,6,6,6,4,4,5,8,9,9};
			 Integer[] Ints=Arrays.stream(ints).boxed().toArray(Integer[]::new);
			Set<Integer> set=new HashSet(Arrays.asList(Ints));
			Object[] objs=set.toArray();
			Arrays.asList(objs).forEach(k -> System.out.println(k));
			
			int count=0;
			String SDR="BRB";
			for(int i=0;i<SDR.length();i++)
				for(int j=i;j<SDR.length();j++)
					if(check(SDR.substring(i,j+1)))
						System.out.println(SDR.substring(i,j+1));
			
			String SS1="Hello this is the GFG user";
			String[] SS1array=SS1.split("\\W");
			for(int j=0;j<SS1array.length/2;j++) {
			String temp=SS1array[j];
			SS1array[j]=SS1array[SS1array.length-1-j];
			SS1array[SS1array.length-1-j]=temp;
			}
			for(int i=1;i<SS1array.length-1;i++) {
				String SSD="";
				for(char c:SS1array[i].toCharArray())
					SSD =c+SSD;
				SS1array[i]=SSD;
			}
			String temps="";
			for(String S:SS1array) {
				temps=temps+S+" ";
			}
			
			System.out.println(temps.trim());
			
			
			String SMS="Hello";
			m=Pattern.compile("[^A-Z]").matcher(SMS);
			temps="";
          while(m.find())
				
				temps+=m.group();
			m=Pattern.compile("[A-Z]").matcher(SMS);
			
			while(m.find())
				
				temps+=m.group();
			
			System.out.println(temps);
			
			String SSDS="d a b a";
					
			m=Pattern.compile("'.+'").matcher(SSDS);
			temps="";
	          while(m.find())
					
					temps+=m.group();
	          System.out.println(temps);
			
	          
	          SMS="GeeksForGeeks";
	          m=Pattern.compile("[aeiou]",Pattern.CASE_INSENSITIVE).matcher(SMS);
	          temps="";
	          count=0;
	          while(m.find())
					
					count++;
	          
	          System.out.println(count);
	          String Na="";
	          String[] collects=SSDS.split("\\W");
	          for(int i=0;i<collects.length;i++) {
	        	  for(int j=i+1;j<collects.length;j++) {
	        		  
	        		  if(collects[i].compareTo(collects[j])<0) {
	        			 Na+=1;
	        		  }else if(collects[i].compareTo(collects[j])>0) {
	        			  Na+=2;
	        			  
	        		  }
	        		  
	        	  }
	        	  
	        	  
	          }
	          
	          int[] arrays= {1,5,6,4,5,4,3,2};
	          int[] newone=new int[arrays.length];
	          int cpi=0;
	          for(int i=0;i<arrays.length;i++) {
	        	  for(int j=i+1;j<arrays.length;j++) {
	        		  if(arrays[i]==arrays[j]) {
	        			  
	        			  newone[cpi++]= arrays[i];
	        			  break;
	        			  
	        		  }
	          
	        	  }
	        	  newone[cpi++]=arrays[i];
	          }
	          
	          
	          
			
	}

}
