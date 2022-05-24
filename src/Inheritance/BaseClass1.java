package Inheritance;

public class BaseClass1 extends derivedClass1{

	public BaseClass1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
		BaseClass1.d1();// here it is overriding the static method of  derivedClass2
		Integer i[]=new Integer[10];
		System.out.println(i.length);
		BaseClass1 b=new BaseClass1();
		
		
	}
}
