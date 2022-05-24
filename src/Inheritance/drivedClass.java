package Inheritance;

public class drivedClass extends BaseClassID{

	
	public static void main(String[] args) {
		BaseClassID bs1=new BaseClassID();
		bs1.a=20;
		//bs1.b=10;//will not allow since it has private access modifier(Private modifier will stop inheritance for variable and methods)
		//bs1.fn=45;//final variable is refer to constant so it can't be altered
		bs1.fnl();
		bs1.c=30;
		bs1.d=40;
		bs1.f();
		//bs1.g()//will not allow since it has private modifier
		bs1.h();
		bs1.i();
		bs1.hg();
		System.out.println(bs1.toString());
		
		

	}

}

class BaseClassID {//if we declare this as final we can't inherit this class(final keyword will not allow inheritance
	
	public int a;
	private int b;
	int c;
	protected int d;
	private static char e;
	public final int fn=20;
	public final void fnl() {
		
		System.out.println("fnl");
	}
	public void f() {
		
		System.out.println("public void f");
	}
	
	private void g() {
		
		System.out.println("private void g");
		
	}
	protected void h() {
		
		
		System.out.println("protected void h");
	}
protected void hg() {
		
		
		System.out.println("protected void hg");
	}
	void i() {
		
		System.out.println("void i");
	}
	private static void j() {
		
		System.out.println("private static void j");
	}
	public BaseClassID() {
		
		System.out.println("BaseClassID no parameter");
	}
public BaseClassID(int i) {
		
		System.out.println("BaseClassID one parameter constructor");
	}

public String toString() {
	return "jak";
	
}

}


