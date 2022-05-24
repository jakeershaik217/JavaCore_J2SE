package exceptionHandling.Finally;

public class Finally {

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
				
				
		
				//Case 6
				System.out.println("Case-6");
				try {
					
					int i=5/0;
					System.out.println("jakeer");
				}
				finally{
					
					System.out.println("finally-ArithmeticException");
					
				}
	}

}
