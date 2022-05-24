package regularExpressions;

import java.util.regex.Pattern;

public class CharacterInRegEX {
	
	static String Space="\\s";
	static String Except_Space="\\S";
	static String numeric="\\d";
	static String Except_numeric="\\D";
	static String word="\\w";
	static String Except_word="\\W";
	

	public static void main(String[] args) {
		String[] str=Pattern.compile(Space).split("Jakeer Hussain Shaik");
		for(String S: str)
			System.out.println(S);
		
		str=Pattern.compile(numeric).split("Jakeer8Hussain9Shaik");
		for(String S: str)
			System.out.println(S);
		
		str=Pattern.compile(Except_Space).split("Jakeer8Hussain9Shaik");
		for(String S: str)
			System.out.println(S);
		
		str=Pattern.compile(Except_numeric).split("Jakeer8Hussain9Shaik");
		for(String S: str)
			System.out.println(S);
		

	}

}
