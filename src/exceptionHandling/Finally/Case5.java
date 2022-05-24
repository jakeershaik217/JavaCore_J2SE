package exceptionHandling.Finally;

public class Case5 {

	public static void main(String[] args) {
		
		
		
				
				
				//Case 5  ArthimeticException
				System.out.println("Case-5");
				try {
					
					int i=5/0;
					System.out.println("jakeer");
				}catch(ArithmeticException e) {
					
					System.out.println("ArithmeticException");
				}
				finally{
					
					System.out.println("finally-ArithmeticException");
					int i[]= {1,2};
					int j=i[5];
				}
				
				
		
	}

}
