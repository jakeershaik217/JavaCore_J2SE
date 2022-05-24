package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

public class PattrenMacher {
	
	static Pattern setPattern(String Patteren) {
		return Pattern.compile(Patteren);
	}
	
	static boolean getMatch(Pattern patteren,String TargetString) {
		return patteren.matcher(TargetString).find();
	}
	
	static boolean getExactMatch(Pattern patteren,String TargetString) {
		Matcher m=patteren.matcher(TargetString);
		return m.find() && m.group().equals(TargetString);
	}
	

	static String getTheMatchingString(Pattern patteren,String TargetString) {
		String string="";
		Matcher m=patteren.matcher(TargetString);
		while(m.find())
			string=string+m.group();
		
		
		return string;
	}
	
	static void getTheMatchingStrings(Pattern patteren,String TargetString) {
		String string="";
		Matcher m=patteren.matcher(TargetString);
		while(m.find())
			System.out.println(m.start()+"  ----- "+m.end()+"*********"+m.group());
		
	}
	
	static int getMatchcount(Pattern patteren,String TargetString) {
		int count=0;
		Matcher m=patteren.matcher(TargetString);
		while(m.find())
             count++;
        return count;     
	
	}
	   
	static Matcher getMatcherObject(Pattern patteren,String TargetString) {
		return   patteren.matcher(TargetString);
	
	}

	public static void main(String[] args) {
		
		//Pattern Class will take pattern/RegEx Matcher call will take the String as input where the Regex would be happening 
		System.out.println(getMatch(setPattern("jak"), "jakeer"));
		System.out.println(getMatch(setPattern("jakr"), "jakeer"));
		
		System.out.println(getMatchcount(setPattern("jak"), "jakeer"));
		System.out.println(getMatchcount(setPattern("jakr"), "jakeer"));
		
		Matcher m=getMatcherObject(setPattern("ab"), "abbabababba");
		out.println("This method will find all available results for the matching pattern");
		while(m.find())//this method will find all available results for the matching pattern
           out.println(m.start()+"    "+m.end()+"    "+m.group());//m.end() results the last Character position + 1
		out.println("This method will find first available results for the matching pattern from given index");
		if(m.find(4))//this method will find first available results for the matching pattern from given index
	           out.println(m.start()+"    "+m.end()+"    "+m.group());
		
		PattrenMacher.getTheMatchingStrings(PattrenMacher.setPattern("[a-z A-Z _ $][a-z A-Z 0-9 _ $]*"),
				"0Jakeer_Name#");

	}

}
