package Variable;

public class InstanceVariable extends StaticVariableBlock {
	
	static void m1() {
		
		System.out.println("derived class"); 
		//*********   static methods can't be inherited
		
	}

	static char c=100;//the instance variable can be override(redefine to new value)
	 void l1() {
		
		int c=20;
		System.out.println("Base class variable redefine in l1:::"+super.c);
		System.out.println("derived class variable redefine in l1:::"+this.c);
	}
	 
	 static int it=25;
	 void l2() {
		 
		 
		 System.out.println("Base class variable redefine in l2:::"+this.it);
		 System.out.println("Base class variable redefine in l2:::"+super.it);
		 
		 
	 }
	 static String Str="InstanceVariable";	 
     void l3() {
		 
		 
		 System.out.println("Base class variable redefine in l3:::"+super.Str);
		 System.out.println("Parent class variable redefine in l3:::"+ParentClass.Str);
		 System.out.println("Derived class variable redefine in l3:::"+this.Str);
	 }
	 
	public static void main(String[] args) {
		m1();
		InstanceVariable li=new InstanceVariable();
		ParentClass p=new ParentClass();
		p.p1();
		g2();
		System.out.println(Str);
		m1();
		li.l1();
		li.l2();
		li.l3();
        System.out.println("Base class instance variable redefine in derive class:::"+c);
		
	}

}

class  StaticVariableBlock extends ParentClass{
	
	static int it;
	static String Str="StaticVariableBlock";
	public static final char c=101;
	static void m1() {
		
		System.out.println(c);
		System.out.println(it=10);
		System.out.println(StaticVariableBlock.it=20);
	}
	
	
	
	
}
class ParentClass extends GrandParent{
	
	static int it;
	static String Str="ParentClass";
	String S[]= {"jakeer","hussain"};
	void p1() {
		
	for(String Str:S) {
		
		System.out.println(Str);
		
	}
		
		
	}
	
	
	
	
}




class GrandParent{
	
	
	public int c=200;
	private String Str="GrandParent";
	private static String Sng="GrandParent";
	protected double d=12;
	float f=12.5f;
	public void g1() {
		
	System.out.println("GrandParent(c)::::"+c);	
	System.out.println("GrandParent(Str)::::"+Str);		
	System.out.println("GrandParent(d)::::"+d);	
	System.out.println("GrandParent(f)::::"+f);
	}
	
	static void g2() {
		
		
		System.out.println("GrandParent(c)::::"+Sng);	
		
		
		
	}
	
	
	
	
	
	
	
	
}