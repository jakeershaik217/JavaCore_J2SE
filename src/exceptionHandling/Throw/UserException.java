package exceptionHandling.Throw;
public class UserException extends Exception{
	
	
	UserException(){
		
		super();
		
		
	}
	
UserException(String Exc){
		
	System.out.println("Getting From"+Exc);	
		
		
	}

public void NullException(String S){
	
	
	System.out.println("SSSSS"+S);
}

}
