package exceptionHandling.Finally;


public class Workspace2 {
	

	void m1() throws Exception {
		
		System.out.println("jakeer");
		int a=10/0;
		
		System.out.println("jakeer");
	}
	

	public static void main(String []args) {
		
		System.out.println("before try-catch block");
		Workspace2 w=new Workspace2();
		try {
		w.m1();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("after try-catch block");
		
		
	}

}


	
	
	
