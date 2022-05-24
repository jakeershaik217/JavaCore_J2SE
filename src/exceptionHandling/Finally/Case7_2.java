package exceptionHandling.Finally;

public class Case7_2 {

	public static void main(String[] args) {
		
		
		


		//Case 7-2 finally Block execution will be stopped when the control is not entered into try block
				System.out.println(10/0);
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
