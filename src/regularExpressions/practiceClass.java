package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.util.*;

public class practiceClass {
	
	static void findconsectiveNumbers() {
		
				String TargetString="AAABBCCCDDDDC";
				char []ary=TargetString.toCharArray();
				Character[] chars=new Character[ary.length];
				for(int i=0;i<ary.length;i++)
					chars[i]=ary[i];
				Set<Character> sets=new LinkedHashSet<>(Arrays.asList(chars));
				String result="";
				for(char c:sets) {
					Pattern p=Pattern.compile("["+c+"]+");
					Matcher m=p.matcher(TargetString);
					while(m.find()) {
						int len=m.group().length();
						result=result+len+c;
					
					}
				}
				System.out.println(result);
	}
	
static void findNumberOfOccurencesOfgiveAiphaNumeric() {
		
				String TargetString="Jakeer123Hussain226ShaikName";
				Map<Object,Number> maps=new HashMap<>();
				char []ary=TargetString.toCharArray();
				Character[] chars=new Character[ary.length];
				for(int i=0;i<ary.length;i++)
					chars[i]=ary[i];
				Set<Character> sets=new LinkedHashSet<>(Arrays.asList(chars));
				String result="";
				for(char c:sets) {
					Pattern p=Pattern.compile("["+c+"]");
					Matcher m=p.matcher(TargetString);
					int count=0;
					while(m.find()) {
						m.group();
						count++;
					
					}
					
					maps.put(c, count);
				}
			System.out.println(maps);	
	}

static void findNumberOfOccurencesOfword() {
	
	String TargetString="Jakeer Hussain Shaik Jakeer Hussain Name is Shaik";
	String[] StringArray=TargetString.split("\\W");
	Map<Object,Number> maps=new HashMap<>();
	Set<String> sets=new LinkedHashSet<>(Arrays.asList(StringArray));
	for(String c:sets) {
		Pattern p=Pattern.compile("("+c+")");
		Matcher m=p.matcher(TargetString);
		int count=0;
		while(m.find()) {
			System.out.println(m.group());
			count++;
		
		}
		
		maps.put(c, count);
	}
System.out.println(maps);	
}

	public static void main(String[] args) {
		findNumberOfOccurencesOfword();
		
		

	}

}
