package regularExpressions;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealTimeExample {

	public static void main(String[] args) {
		// This is to verify given number is a valid phone number

		out.println(PattrenMacher.getExactMatch(
				PattrenMacher.setPattern("[789][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"), "8978308918"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[7-9][0-9]{9}"), "8978308918"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[7-9][0-9]{9}"), "89783089181"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[7-9][0-9]{9}"), "19783089181"));

		// This is to verify given number is a valid phone number with length 10 or 11
		// or 12 if 11 then it should be zero if 12 then then it should be 91
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[0]?[7-9][0-9]{9}"), "08978308918"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[0]?[7-9][0-9]{9}"), "18978308918"));

		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("(0|91)?[7-9][0-9]{9}"), "918978308918"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("(0|91)?[7-9][0-9]{9}"), "8978308918"));

		// This is simple program to replace all Vowels in a given string
		String Name = "JakeerHussainShAik".replaceAll("[aeiou|AEIOU]", "\\@");
		System.out.println(Name);
		
		//This program is to verify given String is a valid email or not
		out.println("-----------This program is to verify given String is a valid email or not-------");
		
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[a-z A-Z 0-9][a-z A-Z 0-9 _ .]*@[a-z A-Z 0-9]+ ([.][a-z A-Z]+)+"),
				"jakeershaik@gmail.com"));

		// This program is to verify given String is a valid Identifier or Not

		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[a-z A-Z _ $][a-z A-Z 0-9 _ $]*"),
				"Jakeer_Name"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[a-z A-Z _ $][a-z A-Z 0-9 _ $]*"),
				"Jakeer_Name$"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[a-z A-Z _ $][a-z A-Z 0-9 _ $]*"),
				"0Jakeer_Name"));
		out.println(PattrenMacher.getExactMatch(PattrenMacher.setPattern("[a-z A-Z _ $][a-z A-Z 0-9 _ $]*"),
				"Jakeer_Name$#"));

		// This is to write a program to extract Alphabets from a given String

		out.println(
				PattrenMacher.getTheMatchingString(PattrenMacher.setPattern("[a-zA-Z]"), "Jakeer_Hussain$#1233Shaik"));

		// This is to write a program to extract Alphanumeric from a given String

		out.println(PattrenMacher.getTheMatchingString(PattrenMacher.setPattern("[a-zA-Z0-9]"),
				"Jakeer_Hussain$#1233Shaik"));
		// This is to write a program to find the PatternFor A String AAABBCCC to 3A2B3C
		String Given="AAABBCCC";
		
		List<Character> Charlist=new ArrayList<>();
		for(char c:Given.toCharArray())
			Charlist.add(c);
		Set<Character> set=new HashSet(Charlist);
		Iterator<Character> itr=set.iterator();
		
		String NumberofsequenceChar="";
		
		while(itr.hasNext()) {
			String string="";
			List<String> sequenceList=new ArrayList<>();
			Character ch=itr.next();
			String New=String.valueOf(ch);
			Pattern p=Pattern.compile("["+New+"]+");
			Matcher m=p.matcher(Given);
			while(m.find()) {
				sequenceList.add(m.group());
			}
			for(String s:sequenceList)
				string=string+s.length()+s;
				
			NumberofsequenceChar=NumberofsequenceChar+string;
		}

		System.out.println(NumberofsequenceChar);
		
		
		Pattern p=Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher m=p.matcher("897830891812");
		while(m.find())
			out.println(m.start()+"  ---  "+m.end()+"  ----  "+m.group());

	}

}
