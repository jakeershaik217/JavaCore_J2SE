package exceptionHandling.Finally;

public class Case1 {

	public static void main(String[] args) {
		
		
		//Case 1 No exception
		System.out.println("Case-1");
		try {
			
			
			System.out.println("jakeer");
		}catch(Exception e) {
			
			System.out.println("catch block");
		}
		finally{
			
			System.out.println("finally");
		}


	}

}
