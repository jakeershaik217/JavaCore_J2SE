package protectedclass;

public class ProtectedAccessModifier extends  protecdsubclass{
	
protected  void m3() {
	
	System.out.println("ProtectedAccessModifier");
}
void m4() {
	
	System.out.println("ProtectedAccessModifier:::public method");
	
}
	public static void main(String[] jak) {
		
		m2();
		protecdsubclass mn=new protecdsubclass();
		mn.m1();
		
		
	}
	
}


class protecdsubclass{
	
	
	protected int p=0;
	protected static int q=20;
	protected void m1() {
		
		
		this.p=10;
		System.out.println(p);
	}

	static protected void m2() {
		
		
		q=20;
		System.out.println(q);
	}
	
	protected protecdsubclass() {
		
		
		System.out.println("protecdsubclass");
	}
	
}