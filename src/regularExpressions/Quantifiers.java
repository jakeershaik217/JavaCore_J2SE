package regularExpressions;

import java.util.regex.Matcher;

import org.eclipse.jetty.util.PatternMatcher;

public class Quantifiers {
	
	static String one_a="[a]";
	static String atleast_one_a="[a]+";
	static String atleast_one_a_including_zero_a="[a]*";
	static String atmost_one_a_including_zero_a="[a]?";

	public static void main(String[] args) {
		Matcher m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern(one_a), "abaabaaabbabbbacdaasaaa");
		while(m.find())
			System.out.println(m.group());
		
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern(atleast_one_a), "aaaaaaabaabaaabaaaaa");
		while(m.find())
			System.out.println(m.group());
		
		System.out.println("-----more than one a----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern(atleast_one_a), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		System.out.println("-----more than one a or b----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern("[ab]+"), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		System.out.println("-----more than one a or b or c----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern("[abc]+"), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		
		System.out.println("-----**********************************************************----------------");
		
		System.out.println("-----more than one a including zero times----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern(atleast_one_a_including_zero_a), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		System.out.println("-----more than one a or b  including zero times----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern("[ab]*"), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		System.out.println("-----more than one a or b or c including zero times----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern("[abc]*"), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		
		
       System.out.println("-----**********************************************************----------------");
		
		System.out.println("-----at most one a including zero times----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern(atmost_one_a_including_zero_a), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		System.out.println("-----at most  one a or b  including zero times----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern("[ab]?"), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		System.out.println("-----at most  one a or b or c including zero times----------------");
		m=PattrenMacher.getMatcherObject(PattrenMacher.setPattern("[abc]?"), "abaabaaabbabbbacdaada");
		while(m.find())
			System.out.println(m.group());
		
		
		
		

	}

}
