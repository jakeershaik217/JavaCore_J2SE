package publicClass;

import protectedclass.ProtectedAccessModifier;

public class PublicAccessModifier extends ProtectedAccessModifier {

	public static void main(String[] ar) {
		
		ProtectedAccessModifier mm=new ProtectedAccessModifier();
        mm.m2();
        publicsubclass bg=new publicsubclass();
        bg.m12();
        ProtectedAccessModifier n=new ProtectedAccessModifier();
       // n.m4()//Not available since m4() is default access
		
	}
}

class publicsubclass {
	
	public int pb;
	public static int pc;
	public void m12(){
	
		System.out.println("m12");
		
	}
	public static void m13() {
		
		
		System.out.println("m13");
		

	}
	
    
	
	
}