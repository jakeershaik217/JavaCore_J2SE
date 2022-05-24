package ObjectClass;

public class Parentclass {
	
	Parentclass(){
		
		System.out.println("jakeer");
		
	}
void m2(){
		
		System.out.println("Parentclass m2");
		
	}
	
public static void main(String[] args) {
	
	
	Object o=new ChildClass();
	ChildClass cs=new ChildClass();
	Parentclass ps=new ChildClass();
	ps.m2();
	
		

	}
}


class ChildClass extends Parentclass{
	
	
	void m1(){
		
		System.out.println("m1");
		
	}
protected void m2(){
		
		System.out.println("Parentclass m1");
		
	}


	
	
	
	
	
}