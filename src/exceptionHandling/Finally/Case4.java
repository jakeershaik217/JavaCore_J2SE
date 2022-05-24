package exceptionHandling.Finally;

public class Case4 {

	public static void main(String[] args) {
		
		
		
				
				
				//Case 4  ArthimeticException
				System.out.println("Case-4");
				try {
					
					int i=5/0;
					System.out.println("jakeer");
				}catch(ArithmeticException e) {
					
					System.out.println("ArithmeticException");
					int i[]= {1,2};
					int j=i[5];
				}
				finally{
					
					System.out.println("finally-ArithmeticException");
				}		

	}

}
