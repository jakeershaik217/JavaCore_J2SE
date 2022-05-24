package Inheritance;

public class MultilevelderivedClass2 extends MultilevelderivedClass1 {

public MultilevelderivedClass2() {
		
		
		System.out.println("MultilevelderivedClass2::constructor");
	}
	public static void main(String[] args) {
		MultilevelBaseClass mb=new MultilevelBaseClass();
		MultilevelderivedClass1 ml=new MultilevelderivedClass1();
		MultilevelderivedClass2 m2=new MultilevelderivedClass2();
		//multilevel inheritance
		ml.Sr1();
		mb.Sr1();
		//normal inheritance
		m2.d1=20;
		m2.d2=15;
		m2.Sr1();
		//static method inheritance
		mb.St();
		ml.St();
		m2.St();
		//ml.Sr2();  //not possible since private modifier
		//mb.Sr2();  //not possible since private modifier
		

	}

}

class MultilevelderivedClass1 extends MultilevelBaseClass{
	private int S1;
	public int S2;
	protected int S3;
	public static int S4;
	int d1;
	public void Sr1() {
		this.S1=1;
		System.out.println(this.S1);
	}
	private void Sr2() {
		this.S2=2;
		System.out.println(this.S2);
		
	}
	protected void Sr3() {
		this.S3=3;
		System.out.println(this.S3);
	}
	public static void Sr4() {
		
		System.out.println(S4);
	}
public MultilevelderivedClass1() {
		
		
		System.out.println("MultilevelderivedClass1::constructor");
	}
public  static void  St() {
	
	System.out.println("MultilevelderivedClass1::static Method");	
	}
}

class MultilevelBaseClass{

	private String S1;
	public String S2;
	protected String S3;
	public static String S4;
	int d2;
	public void Sr1() {
		this.S1="Sr1";
		System.out.println(this.S1);
	}
	private void Sr2() {
		this.S2="Sr2";
		System.out.println(this.S2);
		
	}
	protected void Sr3() {
		
		this.S3="Sr3";
		System.out.println(this.S3);
	}
	public static void Sr4() {
		
		System.out.println(S4);
	}
	
	public  MultilevelBaseClass() {
		
		
		System.out.println("MultilevelBaseClass::constructor");
	}
	public  static void  St() {
		
	System.out.println("MultilevelBaseClass::static Method");	
	}
}