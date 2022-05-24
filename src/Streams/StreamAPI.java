package Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StreamAPI {
	/*
	 * 
	 * here filter method is used to filter something
	 */
	static List<Object> getEvenNumbersinaList(List<Integer> list){
		return list.stream().filter(i -> i%2==0).collect(Collectors.toList());
	}
	
	/**
	 * here i want to do something with each element of a collection then i should use map method of Stream
	 * @param list
	 * @param number
	 * @return
	 */
	
	static List<Object> addsomeNumberToEachElementOfList(List<Integer> list,int number){
		return list.stream().map(i -> i+number).collect(Collectors.toList());
	}
	
	static List<Object> returnSomethingDependsONPredicate(List<Object> list,Predicate<Object> p){
		return list.stream().filter(p).collect(Collectors.toList());
	}
	/**
	 * get Count of the filtered elements
	 * @param list
	 * @param p
	 * @return
	 */
	static long getCountoftheElements(List<Object> list,Predicate<Object> p) {
		return list.stream().filter(p).count();
	}
	
	/**
	 * get Sorted list we have Collections.Sort,Arrays.Sort now this one also sort the elements in list
	 * @param list
	 * @return
	 */
	static List<Object> getSortedList(List<Object> list) {
		return list.stream().sorted().collect(Collectors.toList());
	}
	
	/**
	 * get Sorted list we have Collections.Sort,Arrays.Sort now this one also sort the elements in list
	 * OUR OWN SORTING
	 * @param list
	 * @return
	 */
	static List<Object> getSortedList(List<Object> list,Comparator<Object> cmp) {
		return list.stream().sorted(cmp).collect(Collectors.toList());
	}
	
	/**
	 * to get min and max element of a sorted list
	 * @param list
	 * @param cmp
	 * @param Type
	 * @return
	 */
	static Object getMinORMax(List<Object> list,Comparator<Object> cmp,String Type) {
		if(Type.contains("Min"))
		return list.stream().min(cmp).get();
		else if(Type.contains("Max"))
			return list.stream().max(cmp).get();
		else
			return "";
	}
	
	public static void main(String[] args) {
		Integer ints[]= {1,2,5,8,9,44,6,5,655,6,54,5,44};
		System.out.println(getEvenNumbersinaList(new ArrayList<>(Arrays.asList(ints))));
		System.out.println(addsomeNumberToEachElementOfList(new ArrayList<>(Arrays.asList(ints)),55));
		Predicate<Object> p= i -> {
			
			String str=i.toString();
			Matcher m=Pattern.compile("(0|91)*[7-9][0-9]{9}").matcher(str);
			if(m.find())
				return true;
			else
				return false;
		};
		String[] strs= {"8978308918","918897527699","Jakeer","1234567891"};
		System.out.println(returnSomethingDependsONPredicate(new ArrayList<>(Arrays.asList(strs)),p));
		System.out.println(getCountoftheElements(new ArrayList<>(Arrays.asList(strs)),p));
		
		System.out.println(getSortedList(new ArrayList<>(Arrays.asList(ints))));
		Comparator<Object> cmp=(i1,i2)->Integer.parseInt(i1.toString())>Integer.parseInt(i2.toString())?-1:Integer.parseInt(i1.toString())<Integer.parseInt(i2.toString())?+1:0;
		System.out.println(getSortedList(new ArrayList<>(Arrays.asList(ints)),cmp));
		
		System.out.println(getMinORMax(new ArrayList<>(Arrays.asList(ints)),cmp,"Min"));
		System.out.println(getMinORMax(new ArrayList<>(Arrays.asList(ints)),cmp,"Max"));
		
		
		cmp=(i1,i2)-> -i1.toString().compareTo(i2.toString());
		String[] strings= {"Jakeer","Hussain","Shaik","jakeer","shaik","hussain"};
		System.out.println(getSortedList(new ArrayList<>(Arrays.asList(strings)),cmp));
		
		
		new ArrayList<>(Arrays.asList(ints)).stream().forEach(System.out::println);
		
		
		
	}

}

enum MinMax{
	
	Min,Max;
}
