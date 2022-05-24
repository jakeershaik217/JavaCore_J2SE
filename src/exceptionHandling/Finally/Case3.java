package exceptionHandling.Finally;

public class Case3 {

	public static void main(String[] args) {
		


		//finally will print before exception
		
		//Case 3  ArthimeticException
				System.out.println("Case-3");
				try {
					
					int i[]= {1,2};
					int j=i[5];
					System.out.println("jakeer");
				}catch(ArithmeticException e) {
					
					System.out.println("ArithmeticException");
				}
				finally{
					
					System.out.println("finally-ArithmeticException");
				}
				
				
				
			
	}

}
