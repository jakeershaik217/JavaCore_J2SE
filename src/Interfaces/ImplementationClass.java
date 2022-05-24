package Interfaces;

public class ImplementationClass implements Interface1{
	public void m1() {
		
		
	}
	public void m2() {
		
		System.out.println("m2");
		
	}
public void m3() {
		
		System.out.println("m3");
		
	}

public void m4() {
	
	System.out.println("m4");
	
}
public void m5() {
	
	System.out.println("m5");
	
}
public void m6() {
	
	System.out.println("m6");
	
}

public void Implementation() {
	
	System.out.println("Implementation");
	
}
	
	public static void main(String []args) {
		
		Interface1 imp=new ImplementationClass();
		imp.m2();
		Interface1.me();
		// System.out.println(Interface1.i=20); by default all variables of interface are public final
		// System.out.println(Interface1.i); ambiguous situation
		imp.m6();
		System.out.println(imp.k);
		// Interface1.m7(); m7() is not allowed in Interface1 even it is the sub interface of super  Interface(2,3)
	}

}
