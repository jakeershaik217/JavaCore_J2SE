package Variables;

public class InstanceVariableClass extends InstanceVariableBaseClass {
	static void m1(){
		
		InstanceVariableBaseClass ins=new InstanceVariableBaseClass();
	}
   
  public static void m5(){
		
		System.out.println("this");
		
	}
	public static void main(String[] args) {
		InstanceVariableBaseClass ins1=new InstanceVariableBaseClass(2564);
		InstanceVariableBaseClass ins2=new InstanceVariableBaseClass();
		System.out.println("ins2"+ins2.k);
		m1();
		ins1.m3();
		m5();
		
	}

}
class InstanceVariableBaseClass{
	
	
	static int iti=15;
	int i=15;
	public int k;
	String Str;
	protected float f;
	private final double it=50;//Constant variable need to initialize
	
	InstanceVariableBaseClass(){
		
		/*System.out.println(i);
		System.out.println(this.i);*/
		
		
	}
	public static void m2(){
		
		//ins.k=15;  Cannot make a static reference to the non-static field ins
		
		
	}
	 protected void m3(){
		
		k=50;
		System.out.println(k);
		
		
	}
	public static void m5(){
		
		System.out.println("super");
		
	}
	InstanceVariableBaseClass(int k){
		
		this.k=k;
		
	}
}