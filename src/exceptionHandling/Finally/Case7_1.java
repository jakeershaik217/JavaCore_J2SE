package exceptionHandling.Finally;

public class Case7_1 {

	public static void main(String[] args) {
		
		
		//Case 7-1 finally Block execution will be stop when we shutdown the JVMthat is done by System,exit(0)
		System.out.println("Case-1");
		try {
			
			
			System.out.println("jakeer");
			System.exit(0);
		}catch(Exception e) {
			
			System.out.println("catch block");
		}
		finally{
			
			System.out.println("finally");
		}


	}

}
