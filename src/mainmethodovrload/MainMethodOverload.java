package mainmethodovrload;

public class MainMethodOverload extends childMethod{

	public static void main(String[] args) {
		System.out.println("Main method started");

	}
	
	public static void main123(int a) {
		
		System.out.println("Overloaded Main method started");

	}

	public void ram(){
		
		
	}
	
	public int ram(int a) {
		
		return a;
	}
}

class childMethod{
	
	public static void main(String[] args) {
		
		System.out.println("Main 123 method started");

	}
	
public static void main(int a) {//static methods cant be override since stati methods are at class level
		
		System.out.println("Overloaded Main method started");

	}
	
public void ram(){
	
	
}
}