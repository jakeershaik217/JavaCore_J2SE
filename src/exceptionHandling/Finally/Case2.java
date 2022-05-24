package exceptionHandling.Finally;

public class Case2 {

	public static void main(String[] args) {
		

		//Case 2  ArthimeticException
		System.out.println("Case-2");
		try {
			
			int i=5/0;
			System.out.println("jakeer");
		}catch(ArithmeticException e) {
			
			System.out.println("ArithmeticException");
		}
		
		finally{
			
			System.out.println("finally-ArithmeticException");
		}



	}

}
