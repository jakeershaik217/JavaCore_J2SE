package thread.SingleThread;

public class WhileLoop {

	public static void main(String[] args) {
		
		System.out.println("Entered into Main Thread");
		WhileThread w=new WhileThread();
		System.out.println("Logics");
		w.start();
		System.out.println("Logics Ended");
		
		
	}
	

}



class WhileThread extends  Thread{
	
	
	String S1="Jakeer";
	
	
	public void run() {
		int i=0;
		S1="Shaik";
		System.out.println(S1+"run");
		while(i<=10) {
		
			System.out.println("While THread");
			i=i+1;
			
		}
		
	}
	
	WhileThread(){
		System.out.println("Enter into WhileThread Constructor");
		run();
		System.out.println(S1+"WhileThread");
		System.out.println("Ended WhileThread Constructor");
	}
}