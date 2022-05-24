package privateclass;

class PrivateAccessModifier extends  Mainclass{
	
PrivateAccessModifier(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
private void m2() {
	
System.out.println("PrivateAccessModifier  m2");	
	
}
public static void main(String[] jak) {
		
	// Mainclass pf1=new Mainclass();  not able to instantiation object since the constructor is Private
	//	m2();  not able to run the private static method since it is private modified
	   Mainclass pf2=new Mainclass(5);
	//   pf2.i=25;   //not able to set the private variable since it is private modified
	//   pf2.c=12;  //not able to set the private static variable since it is private modified
	  
	   pf2.m3(22222222);  //this is the way to access the private variable
	  
	   PrivateAccessModifier ac=new PrivateAccessModifier(1);
	   ac.m2();
	   
	   
	}
}
class Mainclass{
	
	

	private int i=65536;
	private static char c='J';
	private static int m1() {
		
		return 5;
	}

	private void m2() {
		
		
		System.out.println(i);
		
	}
	
	private Mainclass() {
		
		
		System.out.println("PrivateAccessModifier");
		
		
	}
	Mainclass(int i){
		
		System.out.println("parameter constructor"+"--->PrivateAccessModifier");
		
		
	}
	void m3(int i) {
		
		this.i=i;
		System.out.println("After changeing i value::::"+i);
		
		
	}
	
}