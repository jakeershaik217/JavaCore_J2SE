package multithread;

public class Priority {

	public static void main(String[] args) {
		Thread.currentThread().setPriority(1);
		System.out.println(Thread.currentThread().activeCount());
		Thread t=new Thread(new ChildThread());
		t.start();
		System.out.println(Thread.currentThread().activeCount());
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setName("MainThread");
		
		   for(int i=0;i<10;i++) {
			   
			       
					System.out.println(Thread.currentThread().getName());
					
					
				}
		   System.out.println(Thread.currentThread().getPriority());

	}

}


class ChildThread implements Runnable{
	
	
	public void run() {
		
		
		Thread.currentThread().setName("ChildThread");
		Thread.currentThread().setPriority(10);
   for(int i=0;i<10;i++) {
			
			System.out.println(Thread.currentThread().getName());
			
		}
 
           System.out.println(Thread.currentThread().getPriority());
	}
	
	
	
}