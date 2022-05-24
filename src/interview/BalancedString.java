package interview;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import regularExpressions.PattrenMacher;


class BalancedString{
	
 	
	public static boolean balanceStringinterface=main();
	static Map<String,Integer> map=new HashMap<String,Integer>();
	static {
		
		map.put("Jakker", 1);
		map.put("Hussain", 3);
		map.put("Shaik", 2);
		map.put("ghj", 5);
	}
	public static boolean sortaGivenMapAccrodingtoValues=SortaGivenMapAccrodingtoValues(map);
	static boolean getAlphabetsFromGivenString=getAlphabetsFromGivenString("JakeerHussai123Shaik@#$");
	static boolean main() {
		
		Predicate<String> bal=s->{
			Stack<Character> stack=new Stack<>();
			for(char c:s.toCharArray()) {
				String prefix="{[(";
				if(prefix.contains(String.valueOf(c))) {
					stack.add(c);
					continue;
				}
				
				String sufix="}])";
				if(sufix.contains(String.valueOf(c))){
					if(stack.isEmpty())
						return false;
				char ch=stack.pop();
				switch(ch) {
				
				case '{':if(c==']' || c==')')
					     return false;
				         break;
				case '[':if(c=='}' || c==')')
				     return false;
			         break;
				case '(':if(c==']' || c=='}')
				     return false;
			         break;
				
				}
				
				}
			
			}
			
			return stack.isEmpty();
		};
		
		System.out.println(bal.test("jak{(ku)}kzl{jak}{}"));
		return (bal.test("jak{(ku)}kzl{jak}{}"));
	}
	
	static boolean SortaGivenMapAccrodingtoValues(Map<String,Integer> map) {
		
		Set<Map.Entry<String,Integer>> maps=map.entrySet();
		List<Map.Entry<String,Integer>> lists=new ArrayList<>(maps);
		Comparator<Map.Entry<String,Integer>> c=(s1,s2) -> {
			Integer i1=s1.getValue();
			Integer i2=s2.getValue();
			if(i1>i2)
				return +1;
			else if(i1<i2)
				return -1;
			else
				return 0;
			
			
			
			
		};
		Collections.sort(lists, c);
		lists.forEach(k -> System.out.println(k));
		System.out.println(lists);
		return true;
		
	}
	
	static boolean getAlphabetsFromGivenString(String Str) {
		
		Pattern p=Pattern.compile("[a-z A-Z]");
		Matcher m=p.matcher(Str);
		String string="";
		while(m.find())
			string+=m.group();
		
		System.out.println(string);
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		String S="https://secure.splitwise.com/?code=4/0AX4XfWjZTtlSd9AcEutZi-JLkWZgdDXOeikHl6k5TNvSZ1s-pG-DsFMQ-yKfBxLuU-fvuw&scope=https://www.googleapis.com/auth/gmail.send";
		Matcher m=Pattern.compile("[0-9]/[a-z A-Z 0-9 _ -]+").matcher(S);
		while(m.find())
			System.out.println(m.group());
		
	}
	
}


