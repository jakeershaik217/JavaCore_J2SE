package regularExpressions;

import java.util.regex.*;

import org.eclipse.jetty.util.PatternMatcher;

import static java.lang.System.*;

public class CharacterClasses {

	static String a="[a]";
	static String aORb="[ab]";
	static String aORbORc="[abc]";
	static String AorBorC="[ABC]";
	static String aTOz="[a-z]";
	static String AtoZ="[A-Z]";
	static String AllAlphabets="[a-z A-Z]";
	static String AlphaNumeric="[a-z A-Z 0-9]";
	static String Numeric="[0-9]";
	
	static String Except_a="[^a]";
	static String Except_A="[^A]";
	static String Except_ab="[^ab]";
	static String Except_AB="[^AB]";
	static String Except_abc="[^abc]";
	static String Except_ABC="[^ABC]";
	static String Except_aTOz="[^a-z]";
	static String Except_AtoZ="[^A-Z]";
	static String Except_AllAlphabets="[^a-z A-Z]";
	static String Except_AlphaNumeric="[^a-z A-Z 0-9]";
	static String Except_Numeric="[^0-9]";
	static String AllCharacters="[.]";
	
	static String getMatchingStringFromGivenString(String string,String patteren) {
		
		Matcher m=Pattern.compile(patteren).matcher(string);
		String Name="";
		while(m.find())
			Name=Name+m.group();
			
		if(!Name.isEmpty())
			return Name;
		else
			return string+" is not present";
		
	}
	
	
	
	
	public static void main(String[] args) {
		out.println(getMatchingStringFromGivenString("Jakeer217889@#$Hussain", AllAlphabets));
		out.println(getMatchingStringFromGivenString("jakeer8978308918hussain", Numeric));
		out.println(getMatchingStringFromGivenString("jakeer8978308918hussain$#%^&", AlphaNumeric));
		out.println(getMatchingStringFromGivenString("8988455445sdfe@#$", Except_AlphaNumeric));
		out.println(getMatchingStringFromGivenString("Jakeer217889@#$Hussain",Except_AllAlphabets));
		out.println(getMatchingStringFromGivenString("Jakeer217889@#$Hussain",AllCharacters));
		
		
	}

}
