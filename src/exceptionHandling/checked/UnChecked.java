package exceptionHandling.checked;

public class UnChecked {

	public static void main(String[] args) {

		int a=Integer.MAX_VALUE;
		try{
		float f=a/0;/*Exception in thread "main" java.lang.ArithmeticException: / by zero
	                  at exceptionHandling.checked.UnChecked.main(UnChecked.java:8)*/
		Object b=null;
		b.toString();
		}catch(ArithmeticException e){
			
			System.out.println("Arithmetic Exception caught");
			
		}
		
		
		try{
			Object b=null;
			b.toString();/*Exception in thread "main" java.lang.NullPointerException
	                       at exceptionHandling.checked.UnChecked.main(UnChecked.java:12)*/
			}catch(NullPointerException e){
				
				System.out.println("Nullpointer caught");
				
			}
			
		try{
		
		int[] ar= new int[2];
		ar[2]=10;
		
		}catch(ArrayIndexOutOfBoundsException e){
			
			System.out.println("ArrayIndexOutOfBounds  Exception caught");
			 
		}
		
		
		try{
			
			String ar= new String("jak");
			ar.charAt(3);
			
			}catch(StringIndexOutOfBoundsException e){
				
				System.out.println("StringIndexOutOfBounds Exception   caught");
				
			}
	}

}
