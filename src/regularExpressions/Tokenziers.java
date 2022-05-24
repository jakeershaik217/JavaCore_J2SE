package regularExpressions;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Tokenziers {
	
	static String[] getTokensFromGivenString(String pattern,String Target) {
		
		return Pattern.compile(pattern).split(Target);
		
	}

	public static void main(String[] args) {
		
		String[] Names=getTokensFromGivenString(CharacterInRegEX.Space, "Jakeer Hussain Shaik");
		for(String Str: Names)
			System.out.println(Str);
		
		StringTokenizer Strd=new StringTokenizer("Jakeer Hussain Shaik");//default regular exp for stringtokenzier is space \\s 
		while(Strd.hasMoreTokens())
			System.out.println(Strd.nextToken());
		
		Strd=new StringTokenizer("29-05-1121","-"); 
		while(Strd.hasMoreTokens())
			System.out.println(Strd.nextToken());

	}

}
