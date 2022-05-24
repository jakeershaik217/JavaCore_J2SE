package exceptionHandling.Finally;


public class Workspace extends  Reference{
	

	Workspace() throws Exception{
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String []args) throws Exception{
		
	
		Workspace w=new Workspace();
		
		System.out.println("after try-catch block");
		
		
	}

}


class Reference{
	
	
	Reference() throws Exception{
		
		
		System.out.println("Reference");
		Thread.sleep(100);
		System.out.println("File");
	}
	
	
	
	
}