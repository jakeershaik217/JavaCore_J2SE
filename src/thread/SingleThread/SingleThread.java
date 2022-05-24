package thread.SingleThread;

public class SingleThread implements Runnable{

	
	public static void main(String[] args) {//main thread
		
		System.out.println("jakeer");
		SingleThread S=new SingleThread();
		S.start();

	}
	
	public void start(){
		
		
		
		run();
		for(int i=0;i<=10;i++ ){
		System.out.println("Start Method Call");
		}
	}
	
	

	public void run() {
		
		for(int i=0;i<=10;i++ ){
		System.out.println("Run Method");
		}
	}
	

	
	
}
