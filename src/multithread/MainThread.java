 package multithread;

class FirstThread extends Thread{
	
	
	public void run() {
		
		Thread.currentThread().setName("FirstThread");//Setting the Name of the current Thread
		for(int i=0;i<11;i++) {
			
			System.out.println(Thread.currentThread().getName());//Getting the current THREAD Name
			
		}
		
	}
	

}
class SecondThread extends Thread{
	
	public void run() {
		
		
		for(int i=0;i<11;i++) {
			
			
			System.out.println(Thread.currentThread().getName());//Getting the current THREAD Name
		}
	}
	
	
	
}

public class MainThread{
	
	
	public static void main(String []args) { //main Thread
		
		System.out.println(Thread.activeCount());//Main thread only count is 1
		FirstThread fs1=new FirstThread();
		fs1.start();
		System.out.println(Thread.activeCount());//Main thread only count is 2
		Thread.currentThread().setName("MainThread");//Setting the Name of the current Thread
		for(int i=0;i<11;i++) {
			
			System.out.println(Thread.currentThread().getName());//Getting the current THREAD Name
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}